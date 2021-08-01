package com.lyp.count.common.interceptor;

import com.lyp.count.common.annotation.ResponseResult;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description: 响应消息体处理拦截器
 * @Author: Administrator
 * @Date: 2021/6/27 8:26
 **/
@Component
public class ResponseResultInterceptor implements HandlerInterceptor{

  /**
   * 标记位，标记请求的controller类或方法上使用了到了自定义注解，返回数据需要被包装
   */
  public static final String RESPONSE_ANNOTATION = "RESPONSE_ANNOTATION";

  /**
   * 在进入action方法前，将注解信息标记到request中
   *
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    if(handler instanceof HandlerMethod){
      HandlerMethod handlerMethod = (HandlerMethod)handler;
      Class<?> clazz = handlerMethod.getBeanType();
      Method method = handlerMethod.getMethod();
      if(clazz.isAnnotationPresent(ResponseResult.class)){
        request.setAttribute(RESPONSE_ANNOTATION, clazz.getDeclaredAnnotation(ResponseResult.class));
      }else if(method.isAnnotationPresent(ResponseResult.class)){
        request.setAttribute(RESPONSE_ANNOTATION, method.getDeclaredAnnotation(ResponseResult.class));
      }
    }
    return true;
  }
}