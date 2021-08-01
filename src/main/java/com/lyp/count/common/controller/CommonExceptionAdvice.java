package com.lyp.count.common.controller;

import com.lyp.count.common.bean.JsonResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一异常处理
 *
 * @author Administrator
 * @since 2021/6/27 12:36
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice{

  @InitBinder
  public void globalInitBinder(WebDataBinder binder) {
    binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public JsonResult handleException(HttpMessageNotReadableException e){
    log.error("Parse params failed, msg: {}.", e.getMessage());
    return JsonResult.validFail(e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public JsonResult handleException(BindException e){
    log.error("参数验证失败{}.", e.getMessage());
    BindingResult result = e.getBindingResult();
    List<String> errMsgList = new ArrayList<>();
    if(result.hasErrors()){
      List<ObjectError> allErrors = result.getAllErrors();
      for(ObjectError error : allErrors){
        errMsgList.add(error.getDefaultMessage());
      }
    }

    return JsonResult.validFail(errMsgList.toString());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public JsonResult handleException(Exception e){
    log.error("Common exception process, msg: {}.", e.getMessage());
    return JsonResult.fail(e.getMessage());
  }
}