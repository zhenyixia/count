package com.lyp.count.common.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 自定义拦截器
 * @Author: Administrator
 * @Date: 2021/6/22 7:41
 **/
public class MyInterceptor implements HandlerInterceptor{
  private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    if(handler instanceof HandlerMethod){
      HandlerMethod handlerMethod = (HandlerMethod)handler;
      Method method = handlerMethod.getMethod();
      // 这里的方法是controller中对应uri下的方法名
      String methodName = method.getName();
      logger.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);
    }

    // 返回true才会继续执行，返回false则取消当前请求
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
      throws Exception{
    logger.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲 染");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception{
    logger.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可 以做一些清理的工作了");
  }
}