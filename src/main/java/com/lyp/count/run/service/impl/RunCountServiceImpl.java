package com.lyp.count.run.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import com.lyp.count.run.dao.RunCountDao;
import com.lyp.count.run.service.RunCountService;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RunCountServiceImpl implements RunCountService {
  @Autowired
  RunCountDao runCountDao;

  @Override
  public JsonResult getList(QueryRunVO queryVO) {
    Page pages = PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
    List<RunCountDetail> runCountDetails = runCountDao.selectByCondition();
    log.info("Page total:{}.", pages.getTotal());
    return JsonResult.success("查询成功", new PageInfo<>(runCountDetails));
  }

  @Override
  public JsonResult add(List<RunCountDetail> runCountVOs) {
    int num = runCountDao.batchInsert(runCountVOs);
    return JsonResult.success("成功添加条数为：" + num);
  }

  @Override
  public JsonResult count(QueryRunVO queryVO) {
    return null;
  }

  @Override
  public JsonResult countWeek(int weekIndex) {
    if (weekIndex < 0) {
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
}
