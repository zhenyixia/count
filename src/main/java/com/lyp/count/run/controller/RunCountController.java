package com.lyp.count.run.controller;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.service.RunCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/run", produces = "application/json; charset=utf-8")
public class RunCountController {
  @Autowired
  RunCountService runCountService;

  @PostMapping(value = "list")
  public JsonResult list(@RequestBody QueryRunVO queryVO) {

    return runCountService.getList(queryVO);
  }
}
