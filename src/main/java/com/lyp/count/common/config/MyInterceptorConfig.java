package com.lyp.count.common.config;

import com.lyp.count.common.interceptor.MyInterceptor;
import com.lyp.count.common.interceptor.MyInterceptorTwo;
import com.lyp.count.common.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2021/6/23 7:18
 **/
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport{
  @Override
  protected void addInterceptors(InterceptorRegistry registry){
    // 将上面自定义好的拦截器添加进去。
    registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    registry.addInterceptor(new MyInterceptorTwo()).addPathPatterns("/**");
    registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }

  /**
   * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
   *
   * @param registry
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry){
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    super.addResourceHandlers(registry);
  }
}