package cn.com.project.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import cn.com.project.user.domain.Admin;
import cn.com.project.user.domain.User;
import cn.com.project.user.service.LoginService;
import cn.com.project.user.service.UserService;
import cn.com.project.util.Comm;

/**
 * 
 * @描述:登陆操作
 * @作者:
 * @时间 2018年3月14日 下午1:42:56
 * @获取一个: login
 * @返回值:ModelAndView
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @描述:后台管理员登陆
	 * @作者:
	 * @时间 2018年3月14日 下午1:42:56
	 * @获取一个: login
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(String account,String password,String role,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		User u = loginService.login(account, password);
		//获取session
		HttpSession session = request.getSession();
		if(u == null){//登陆失败
			mav.addObject("message","用户名或密码错误");
			mav.setViewName("admin/login");
		}else if("0".equals(u.getRole())&&"0".equals(role)){//系统管理员
			session.setAttribute("id",u.getId());
			session.setAttribute("account", u.getAccount());
			session.setAttribute("password", u.getPassword());
			mav.setViewName("admin/index");
		}else if("1".equals(u.getRole())&&"1".equals(role) ){//老师
			if ("0".equals(u.getState())) {
				request.setAttribute("message", "审批未通过，请等待");
				mav.setViewName("admin/login");
			} else {
				session.setAttribute("id",u.getId());
				session.setAttribute("account", u.getAccount());
				session.setAttribute("password", u.getPassword());
				mav.setViewName("huoche/index");
			}
		}else if("2".equals(u.getRole())&&"2".equals(role)){//学生
			if ("0".equals(u.getState())) {
				request.setAttribute("message", "审批未通过，请等待");
				mav.setViewName("admin/login");
			} else {
				session.setAttribute("id",u.getId());
				session.setAttribute("account", u.getAccount());
				session.setAttribute("password", u.getPassword());
				mav.setViewName("huozhu/index");
			}
		}else{
			request.setAttribute("message", "用户所属角色不统一");
			mav.setViewName("admin/login");
		}
		return mav;
	}
	
	/**
	 * 
	 * @描述:修改密码
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest request,String gpassword)throws Exception{
		ModelAndView mav = new ModelAndView();
		Integer id = Comm.getUserInfoId(request) ;
		User a = new User();
		a.setId(id);
		a.setPassword(gpassword);
		userService.updatePassword(a);
		mav.setViewName("admin/password/updatePassword");
		return mav;
	}
}