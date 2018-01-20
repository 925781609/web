package com.liuil.web.controller;

import com.liuil.web.service.UserService;
import com.liuil.web.util.UserContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
  // 定义一些模板常量
  public final static String LOGIN = "welcome1";

  @Autowired
  private UserService userService;

  @RequestMapping(value = "login", method = RequestMethod.PUT)
  public String login(@RequestParam ("username") String username,
                       @RequestParam("pasword") String password,
                       HttpSession session){
    try{
      if(userService.login(username, password)){
        System.out.println(username+ " " + password);
        session.setAttribute(UserContext.USER_NAME, username);
        return "redirect:userInfo/showInfo";
      }
      else{
        return LOGIN;
      }
    } catch (Exception e){
      return LOGIN;
    }
  }
  // 显示登入用的表单
  @RequestMapping(value="login", method=RequestMethod.GET)
  public String loginPage(HttpSession session){
    if(session.getAttribute(UserContext.USER_NAME) != null){
      return "redirect:/" ;
    }
    return "login";
  }


}
