package cn.com.project.user.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.user.domain.User;
import cn.com.project.user.service.UserService;
import cn.com.project.util.Comm;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUser")
	public ModelAndView showUser(String role){
		ModelAndView mav = new ModelAndView();
		mav.addObject("role", role);
		if("1".equals(role)){
			mav.setViewName("huoche/myinfo/addUser");
		}else{
			mav.setViewName("huozhu/myinfo/addHz");	
		}
		return mav;
	}
	/**
	 * 
	 * @描述:保存添加学生用户
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveHz")
	public ModelAndView saveHz(MultipartFile photo,
			String account,
			String password,
			String age,
			String role,
			String address,
			String tel,
			String chexing,
			String jsnumber,
			String idk
	)throws Exception{
			User u = new User();
		//第一步：判断文件是否为空 ,MultipartFile photo
		if(photo!= null){
			InputStream is = photo.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int length = -1;
			while ((length=is.read(b))!=-1){
				os.write(b,0,length);
			}
			u.setPhoto(os.toByteArray());
			u.setAccount(account);
			u.setAddress(address);
			u.setAge(age);
			u.setChexing(chexing);
			u.setIdk(idk);
			u.setJsnumber(jsnumber);
			u.setPassword(password);
			u.setRole(role);
			u.setTel(tel);
			u.setState("0");
			//优化
			userService.insert(u);
			is.close();
			os.flush();
			os.close();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("huozhu/myinfo/success");
		return mav;
	}
	/**
	 * 
	 * @描述:保存用户
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveUser")
	public ModelAndView saveUser(MultipartFile photo,
			String account,
			String password,
			String age,
			String role,
			String address,
			String tel,
			String chexing,
			String jsnumber,
			String idk
	)throws Exception{
			User u = new User();
		//第一步：判断文件是否为空 ,MultipartFile photo
		if(photo!= null){
			InputStream is = photo.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int length = -1;
			while ((length=is.read(b))!=-1){
				os.write(b,0,length);
			}
			u.setPhoto(os.toByteArray());
			u.setAccount(account);
			u.setAddress(address);
			u.setAge(age);
			u.setChexing(chexing);
			u.setIdk(idk);
			u.setJsnumber(jsnumber);
			u.setPassword(password);
			u.setRole(role);
			u.setTel(tel);
			u.setState("0");
			//优化
			userService.insert(u);
			is.close();
			os.flush();
			os.close();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("huoche/myinfo/success");
		return mav;
	}
	/**
	 * 
	 * @throws Exception 
	 * @描述:显示头像信息
	 * @作者:
	 * @时间 2015年11月28日 上午10:42:02
	 * @获取一个: role
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/show/{id}",method=RequestMethod.GET)
	@ResponseBody
	public void toShowPhoto(@PathVariable Integer id,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();//获取输出流
			//读取用户信息
			User u  = userService.selectByPrimaryKey(id);//映射文件中需要查询该条信息
			if(u.getPhoto()!=null){
				is = new ByteArrayInputStream(u.getPhoto());//字节数转换为输入流
				byte[] bytes = new byte[1024];//设置缓存区
				int length = -1;
				while ((length=is.read(bytes))!=-1){//读
					os.write(bytes,0,length);//写
				}
			}
			//关闭操作
			if(is!=null){
				is.close();
			}
			if(os!=null){
				os.flush();
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @描述:查看
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selHc")
	public ModelAndView selHc(Integer page,User u)throws Exception{
		ModelAndView mav = new ModelAndView();
		u.setRole("1");
		List<User> userList = userService.selectUserList(u);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<User> pageInfo = new PageInfo<User>(userList); 
	  
		mav.addObject("userList",userList);
		mav.addObject("page", new PageInfo(userList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/user/selUser");
		return mav;
	}
	
	/**
	 * 
	 * @描述:查看
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selHz")
	public ModelAndView selHz(Integer page,User u)throws Exception{
		ModelAndView mav = new ModelAndView();
		u.setRole("2");
		List<User> userList = userService.selectUserList(u);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<User> pageInfo = new PageInfo<User>(userList); 
	  
		mav.addObject("userList",userList);
		mav.addObject("page", new PageInfo(userList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("admin/user/selHz");
		return mav;
	}
	/**
	 * 
	 * @描述:根据id显示
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/showHc")
	public ModelAndView showHc(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		User u  = userService.selectByPrimaryKey(id);
		mav.addObject("user", u);
		mav.setViewName("huoche/myinfo/updateUser");
		return mav;
	}
	/**
	 * 
	 * @描述:根据id显示
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/showHz")
	public ModelAndView showHz(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		User u  = userService.selectByPrimaryKey(id);
		mav.addObject("user", u);
		mav.setViewName("huozhu/myinfo/updateHz");
		return mav;
	}
	/**
	 * 
	 * @描述:删除
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteHc")
	public String deleteUser(Integer id)throws Exception{
		
		userService.deleteByPrimaryKey(id);
		
		return "redirect:/user/selHc";
	}
	/**
	 * 
	 * @描述:删除
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteHz")
	public String deleteHz(Integer id)throws Exception{
		
		userService.deleteByPrimaryKey(id);
		
		return "redirect:/user/selHz";
	}
	/**
	 * 
	 * @描述:查看个人信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selHcXx")
	public ModelAndView selHcXx(User u ,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		u.setId(id);
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.selectUserList(u);
		mav.addObject("u", userList);
		mav.setViewName("huoche/myinfo/selUser");
		return mav;
	}
	/**
	 * 
	 * @描述:查看个人信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selHzXx")
	public ModelAndView selHzXx(User u ,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		ModelAndView mav = new ModelAndView();
		u.setId(id);
		List<User> userList = userService.selectUserList(u);
		mav.addObject("u", userList);
		mav.setViewName("huozhu/myinfo/selHz");
		return mav;
	}
	/**
	 * 
	 * @描述:保存更新个人信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveUpdateUser")
	public String saveUser(User u)throws Exception{
		userService.updateByPrimaryKey(u);
		
		return "redirect:/user/selHcXx";
	}
	/**
	 * 
	 * @描述:保存更新个人信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/saveUpdateHz")
	public String saveUpdateHz(User u)throws Exception{
		userService.updateByPrimaryKey(u);
		
		return "redirect:/user/selHzXx";
	}
	/**
	 * 
	 * @描述:通过审核
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/agreeHc")
	public String agreeHc(Integer id,User u)throws Exception{
		u.setState("1");
		userService.agree(u);
		
		return "redirect:/user/selHc";
	}
	/**
	 * 
	 * @描述:通过审核
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/agreeHz")
	public String agreeHz(Integer id,User u)throws Exception{
		u.setState("1");
		userService.agree(u);
		
		return "redirect:/user/selHz";
	}
}
