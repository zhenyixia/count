package com.lyp.count.run.controller;

import com.lyp.count.common.annotation.ResponseResult;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ResponseResult
@RestController
@RequestMapping(path = "/test", produces = "application/json; charset=utf-8")
public class HelloWorldController{

  @GetMapping(value = "/hello")
  public String hello(){

    System.out.println(5 / 0);
    return "hello world!";
  }

  @GetMapping(value = "/hello2")
  public void hello2(Date date){
    System.out.println(date); // Sat Jun 27 00:00:00 CST 2020
  }
}
