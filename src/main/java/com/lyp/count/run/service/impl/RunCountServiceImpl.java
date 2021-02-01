package com.lyp.count.run.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.common.exception.MyException;
import com.lyp.count.common.util.ExcelUtils;
import com.lyp.count.run.bean.CountVO;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import com.lyp.count.run.bean.RunDetailVO;
import com.lyp.count.run.constant.Common;
import com.lyp.count.run.dao.RunCountDao;
import com.lyp.count.run.service.RunCountService;
import com.lyp.count.run.util.SportUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class RunCountServiceImpl implements RunCountService{
  @Autowired
  RunCountDao runCountDao;

  @Override
  public JsonResult getList(QueryRunVO queryVO){
    Page pages = PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
    List<RunCountDetail> runCountDetails = runCountDao.selectByCondition();
    log.info("Page totalKms:{}.", pages.getTotal());
    return JsonResult.success("查询成功", new PageInfo<>(runCountDetails));
  }

  @Override
  public JsonResult add(List<RunCountDetail> runCountVOs){
    for(RunCountDetail runCountVO : runCountVOs){
      SportUtils.setTimeInfo(runCountVO, runCountVO.getRunDate());
    }
    int num = runCountDao.batchInsert(runCountVOs);
    return JsonResult.success("成功添加条数为：" + num);
  }

  @Override
  public JsonResult importData(MultipartFile file){
    if(Objects.isNull(file) || file.isEmpty()){
      return JsonResult.validFail("导入文件不能为空");
    }

    try{
      List<RunDetailVO> detailVOS = ExcelUtils.readList(file, 1, RunDetailVO.class, Common.RUN_HEADS, Common.RUN_HEAD_ATTRS);
      List<RunCountDetail> runDetails = SportUtils.convertRunCountDetail(detailVOS);

      int insertNum = runCountDao.batchInsert(runDetails);
      return JsonResult.success("成功导入，条数为：" + insertNum);
    }catch(MyException e){
      return JsonResult.fail(e.getMessage());
    }
  }

  @Override
  public JsonResult count(QueryRunVO queryVO){
    return null;
  }

  @Override
  public JsonResult countWeek(int weekIndex){
    if(weekIndex < 0){
      return JsonResult.validFail("参数非法");
    }

    // 获取当前周的周一的日期
    LocalDate currentWeekStartDay = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);

    // 获取上一周或几周的周一的日期
    LocalDate specialMonday = currentWeekStartDay.minusWeeks(weekIndex);
    LocalDate specialSunday = specialMonday.plusDays(6);
    List<String> oneWeekCount = runCountDao.selectSpecialWeek(specialMonday.toString(), specialSunday.toString());

    return JsonResult.success("查询成功", oneWeekCount);
  }

  @Override
  public JsonResult countByMonth(QueryRunVO queryRunVO){
    if(queryRunVO == null){
      return JsonResult.validFail("传参不能为空");
    }

    Integer year = queryRunVO.getYear();
    Integer month = queryRunVO.getMonth();
    if(year == null || month == null){
      return JsonResult.validFail("年份和月份居必传");
    }

    List<RunCountDetail> countVOS = runCountDao.countByMonth(year, month);
    try{
      CountVO countVO = SportUtils.processMonthCount(countVOS);
      return JsonResult.success("按月统计成功！", countVO);
    }catch(MyException e){
      return JsonResult.fail(e.getMessage());
    }
  }
}
