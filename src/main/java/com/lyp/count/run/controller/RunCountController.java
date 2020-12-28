package com.lyp.count.run.controller;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.service.RunCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/run", produces = "application/json; charset=utf-8")
public class RunCountController {
  @Autowired
  RunCountService runCountService;

  @GetMapping(value = "list")
  public JsonResult list() {

    return runCountService.getList();
  }
}
