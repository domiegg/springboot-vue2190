package cn.com.project.user.service;

import org.springframework.stereotype.Service;

import cn.com.project.user.domain.Admin;
import cn.com.project.user.domain.User;


public interface LoginService {
   public User login(String account,String password) throws Exception;
}
