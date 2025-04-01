package cn.com.project.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.user.domain.Admin;
import cn.com.project.user.domain.User;
import cn.com.project.user.mapper.UserMapper;
import cn.com.project.user.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserMapper userMapper;
	
	public User login(String account,String password)   {
		Map<String , String> map = new HashMap<String,String>();
		map.put("account", account);
		map.put("password", password);
		User u = null;
		try {
			u = userMapper.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
