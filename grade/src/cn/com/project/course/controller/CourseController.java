package cn.com.project.course.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.project.course.domain.Course;
import cn.com.project.course.domain.Grade;
import cn.com.project.course.service.CourseService;
import cn.com.project.user.domain.User;
import cn.com.project.user.service.UserService;
import cn.com.project.util.Comm;
import cn.com.project.util.ExcelExport;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @描述:添加课程信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping("/addCou")
	public String addCou(Course record,HttpServletRequest request){
		Integer id = Comm.getUserInfoId(request);
		record.setaId(id);
		courseService.insert(record);
		
		return "redirect:/course/selCou";
	}
	
	/**
	 * 
	 * @描述:查看课程信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selCou")
	public ModelAndView selCou(Integer page,Course c)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Course> courseList = courseService.selectCouList(c);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<Course> pageInfo = new PageInfo<Course>(courseList); 
	  
		mav.addObject("courseList",courseList);
		mav.addObject("page", new PageInfo(courseList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("huoche/course/selCou");
		return mav;
	}
	/**
	 * 
	 * @描述:学生查看课程信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selCou1")
	public ModelAndView selCou1(Integer page,Course c)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Course> courseList = courseService.selectCouList(c);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<Course> pageInfo = new PageInfo<Course>(courseList); 
	  
		mav.addObject("courseList",courseList);
		mav.addObject("page", new PageInfo(courseList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("huoche/course/selCou1");
		return mav;
	}
	/**
	 * 
	 * @描述:跳转到添加成绩信息页面
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/tz")
	public ModelAndView tz(Course c,User u)throws Exception{
		ModelAndView mav = new ModelAndView();
		u.setRole("2");
		List<Course> courseList = courseService.selectCouList(c);
		List<User> stuList = userService.selectUserList(u);
	  
		mav.addObject("courseList",courseList);
		mav.addObject("stuList",stuList);
		mav.setViewName("huoche/grade/addGra");
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
	@RequestMapping(value="/showCou")
	public ModelAndView showCou(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		Course c  = courseService.selectByPrimaryKey(id);
		mav.addObject("c", c);
		mav.setViewName("huoche/course/updateCou");
		return mav;
	}
	/**
	 * 
	 * @描述:保存更新课程信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/updateCou")
	public String updateCou(Course c,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		c.setaId(id);
		courseService.updateByPrimaryKey(c);
		
		return "redirect:/course/selCou";
	}
	/**
	 * 
	 * @描述:删除课程信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteCou")
	public String deleteCou(Integer id)throws Exception{
		
		courseService.deleteByPrimaryKey(id);
		
		return "redirect:/course/selCou";
	}
	/**
	 * 
	 * @描述:添加成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping("/addGra")
	public String addGra(Grade record){
		courseService.insertGra(record);
		
		return "redirect:/course/selGra";
	}
	
	/**
	 * 
	 * @描述:查看成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selGra")
	public ModelAndView selGra(Integer page,Grade g)throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Grade> graList = courseService.selectGraList(g);
		//分页
		if (page == null) {
			page = 1;
		}
		//分页		
		PageHelper.startPage(page,10,true);
		PageInfo<Grade> pageInfo = new PageInfo<Grade>(graList); 
	  
		mav.addObject("graList",graList);
		mav.addObject("page", new PageInfo(graList));
		mav.addObject("count", pageInfo.getTotal());
		mav.addObject("countPage", pageInfo.getPages());
		mav.addObject("lastPage", pageInfo.getLastPage());
		mav.setViewName("huoche/grade/selGra");
		return mav;
	}
	
	/**
	 * 
	 * @描述:学生查看个人成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/selMyGra")
	public ModelAndView selMyGra(Grade g ,HttpServletRequest request)throws Exception{
		Integer id = Comm.getUserInfoId(request);
		g.setaId(id);
		ModelAndView mav = new ModelAndView();
		List<Grade> graList = courseService.selectGraList(g);
	  
		mav.addObject("graList",graList);
		mav.setViewName("huoche/grade/selMyGra");
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
	@RequestMapping(value="/showGra")
	public ModelAndView showGra(Integer id)throws Exception{
		ModelAndView mav = new ModelAndView();
		Grade g  = courseService.selectGra(id);
		mav.addObject("g",g);
		mav.setViewName("huoche/grade/updateGra");
		return mav;
	}
	/**
	 * 
	 * @描述:保存更新成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/updateGra")
	public String updateGra(Grade g)throws Exception{
		courseService.updateGra(g);
		
		return "redirect:/course/selGra";
	}
	/**
	 * 
	 * @描述:删除成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/deleteGra")
	public String deleteGra(Integer id)throws Exception{
		
		courseService.deleteGra(id);
		
		return "redirect:/course/selGra";
	}
	/**
	 * 
	 * @描述:打印成绩信息
	 * @作者:
	 * @时间 2018年3月15日 下午5:39:37
	 * @获取一个: toadd
	 * @返回值:ModelAndView
	 */
	@RequestMapping(value="/dayinCj")
	public String dayinCj(Integer id,Grade record)throws Exception{
		try
		   {
			List<Grade> graList = courseService.selectGraList(record);
		   File fileWrite = new File("D:/Write.xls");
		   fileWrite.createNewFile();
		   OutputStream os = new FileOutputStream(fileWrite);
		   ExcelExport export  = new ExcelExport(); 
		   export.excelExport(os,graList);
		   }
		   catch(Exception e)
		   {
		   e.printStackTrace();
		   }
		   return "redirect:/course/selGra";
	}
}
