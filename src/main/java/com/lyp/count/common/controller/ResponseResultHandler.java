package com.lyp.count.common.controller;

import com.alibaba.fastjson.JSON;
import com.lyp.count.common.annotation.ResponseResult;
import com.lyp.count.common.bean.JsonResult;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 增加的响应体处理
 *
 * @author Administrator
 * @since 2021/6/27 8:32
 **/
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object>{
  /**
   * 标记位，标记请求的controller类或方法上使用了到了自定义注解，返回数据需要被包装
   */
  public static final String RESPONSE_ANNOTATION = "RESPONSE_ANNOTATION";

  /**
   * 请求中是否包含了响应体需要被包装的标记位，如果没有则直接返回，不需要处理响应体
   */
  @Override
  public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass){
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = requestAttributes.getRequest();
    ResponseResult attribute = (ResponseResult)request.getAttribute(RESPONSE_ANNOTATION);
    return attribute != null;
  }

  @Override
  public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
      Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse){
    if(o instanceof JsonResult){
      return o;
    }else{
      JsonResult result = JsonResult.success("执行成功", o);
      //处理返回值是String的情况
      if(o instanceof String){
        return JSON.toJSONString(result);
      }
      return result;
    }
  }
}