package com.lyp.count.run.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import com.lyp.count.run.dao.RunCountDao;
import com.lyp.count.run.service.RunCountService;
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
}
