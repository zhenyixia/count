package com.lyp.count.run.controller;

import com.lyp.count.common.bean.JsonResult;
import com.lyp.count.run.bean.QueryRunVO;
import com.lyp.count.run.bean.RunCountDetail;
import com.lyp.count.run.service.RunCountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/run", produces = "application/json; charset=utf-8")
public class RunCountController {
  @Autowired
  RunCountService runCountService;

  @GetMapping(value = "hello")
  public JsonResult hello() {
    return JsonResult.success("Hello World!");
  }

  @PostMapping(value = "list")
  public JsonResult list(@RequestBody QueryRunVO queryVO) {
    return runCountService.getList(queryVO);
  }

  @PostMapping(value = "add")
  public JsonResult add(@RequestBody List<RunCountDetail> runCountVOs) {
    return runCountService.add(runCountVOs);
  }
}
