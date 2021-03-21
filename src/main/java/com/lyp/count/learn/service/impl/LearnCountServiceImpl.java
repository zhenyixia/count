package com.lyp.count.learn.service.impl;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.common.exception.MyException;
import com.lyp.count.learn.bean.LearnCountDetail;
import com.lyp.count.learn.bean.QueryLearnVO;
import com.lyp.count.learn.dao.LearnCountDao;
import com.lyp.count.learn.service.LearnCountService;
import com.lyp.count.learn.util.LearnUtils;
import com.lyp.count.common.bean.CountVO;
import com.lyp.count.common.bean.YearMonthScopeVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class LearnCountServiceImpl implements LearnCountService{

  @Autowired
  LearnCountDao learnCountDao;

  @Override
  public JsonResult add(List<LearnCountDetail> countVOs){
    log.info("Begin to add run data.");
    if(CollectionUtils.isEmpty(countVOs)){
      log.warn("Input entry data is null.");
      return JsonResult.fail("录入数据不能为空");
    }

    for(LearnCountDetail runCountVO : countVOs){
      LearnUtils.setTimeInfo(runCountVO, runCountVO.getLearnDate());
    }
    int num = learnCountDao.batchInsert(countVOs);
    return JsonResult.success("成功添加条数为：" + num);
  }

  @Override
  public JsonResult getList(QueryLearnVO queryVO){
    int beginIndex = (queryVO.getPageNum() - 1) * queryVO.getPageSize();
    queryVO.setBeginIndex(beginIndex);

    List<LearnCountDetail> runCountDetails = learnCountDao.selectByCondition(queryVO);
    int total = learnCountDao.countByCondition(queryVO);

    Map<String, Object> result = new HashMap<>();
    result.put("list", runCountDetails);
    result.put("total", total);

    log.info("Page total:{}.", total);
    return JsonResult.success("查询成功", result);
  }

  @Override
  public JsonResult countWeek(int weekIndex){
    return null;
  }

  @Override
  public JsonResult countInOneMonth(QueryLearnVO queryVO){
    if(queryVO == null){
      return JsonResult.validFail("传参不能为空");
    }

    Integer year = queryVO.getYear();
    Integer month = queryVO.getMonth();
    if(year == null || month == null){
      return JsonResult.validFail("年份和月份居必传");
    }

    List<LearnCountDetail> countVOS = learnCountDao.countByMonth(year, month);
    try{
      CountVO countVO = LearnUtils.processMonthCount(countVOS);
      int totalTime = learnCountDao.selectTotalLearnTime(year, month);
      countVO.setTotalTimes(totalTime);
      return JsonResult.success("按月统计成功！", countVO);
    }catch(MyException e){
      return JsonResult.fail(e.getMessage());
    }
  }

  @Override
  public JsonResult countInOneYear(QueryLearnVO queryVO){
    log.info("Begin to count by year.");
    if(queryVO == null || queryVO.getYear() == 0){
      return JsonResult.validFail("没有传年份");
    }

    List<LearnCountDetail> runCountDetails = learnCountDao.selectAllMonthByYear(queryVO);
    try{
      CountVO countVO = LearnUtils.processYearCount(runCountDetails);
      int totalTime = learnCountDao.selectTotalLearnTime(queryVO.getYear(), null);
      countVO.setTotalTimes(totalTime);

      log.info("Count all month in one year successfully.");
      return JsonResult.success("按月统计成功！", countVO);
    }catch(MyException e){
      return JsonResult.fail(e.getMessage());
    }
  }

  @Override
  public JsonResult countAllYears(){
    List<LearnCountDetail> runCountDetails = learnCountDao.selectAlYearsData();
    CountVO countVO = LearnUtils.processAllYears(runCountDetails);

    log.info("Count all years successfully.");
    return JsonResult.success("统计所有年成功！", countVO);
  }

  @Override
  public JsonResult getYearMonthScope(){
    log.info("Begin to select year month scope.");
    YearMonthScopeVO scopeVO = learnCountDao.selectYearMonthScope();

    log.info("Query successfully.");
    return JsonResult.success("查询年月范围成功", scopeVO);
  }

  @Override
  public JsonResult getExistedContent(){
    log.info("Begin to select existed content.");
    List<String> scopeVO = learnCountDao.selectContent();

    log.info("Query successfully.");
    return JsonResult.success("查询年月范围成功", scopeVO);
  }
}