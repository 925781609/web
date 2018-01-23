package com.liuil.web.service.impl;

import com.liuil.web.controller.UserController;
import com.liuil.web.domain.RegisterForm;
import com.liuil.web.domain.User;
import com.liuil.web.mapper.UserDao;
import com.liuil.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserServiceImpl implements UserService {
  public static Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  private UserDao userDao;

  // 暂时login使用最简单的方式实现
  public boolean login(String username, String password){
    if("username".equals(username) && "password".equals(password)){
      logger.debug("true In UserServiceImpl:"+ "username -" + username + " " + "password - " + password);
      return true;
    }
    else{
      logger.debug("false In UserServiceImpl:"+ "username -" + username + " " + "password - " + password);
      return false;
    }
  }
  public void register(RegisterForm registerForm, BindingResult result){
    logger.debug("In register ");
    //User existing = userService.findByEmail(registerForm.getEmail());
    String existing = "test";
    if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
    }
  }

  public User findByEmail(String email){
    return userDao.findByEmail(email);
  }

  public void save(RegisterForm registerForm) {};
}
