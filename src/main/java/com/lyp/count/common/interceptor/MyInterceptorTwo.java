package com.lyp.count.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2021/6/23 7:58
 **/
public class MyInterceptorTwo implements HandlerInterceptor{

  private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
      throws Exception{
    LOG.info("执行拦截器2的preHandle方法");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
      ModelAndView modelAndView) throws Exception{
    LOG.info("执行拦截器2的postHandle方法");
  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
      Exception e) throws Exception{
    LOG.info("执行拦截器2的afterCompletion方法");
  }
}