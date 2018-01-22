package com.liuil.web.interceptor;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
  public static Logger logger = Logger.getLogger(LoginInterceptor.class);

  @Override
  public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception{
    logger.info("preHandler is called");
  }

}
