package cn.com.project.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.com.project.course.domain.Course;
import cn.com.project.course.domain.Grade;
import cn.com.project.course.mapper.CourseMapper;
import cn.com.project.course.mapper.GradeMapper;
import cn.com.project.course.service.CourseService;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private GradeMapper gradeMapper;
	
	public void deleteByPrimaryKey(Integer id) {
		courseMapper.deleteByPrimaryKey(id);
	}

	public void insert(Course record) {
		courseMapper.insert(record);
	}

	public Course selectByPrimaryKey(Integer id) {
		Course cou = courseMapper.selectByPrimaryKey(id);
		return cou;
	}

	public List<Course> selectCouList(Course record) {
		List<Course> selectCouList = courseMapper.selectCouList(record);
		return selectCouList;
	}

	public void updateByPrimaryKey(Course record) {
		courseMapper.updateByPrimaryKey(record);
	}

	public void deleteGra(Integer id) {
		gradeMapper.deleteByPrimaryKey(id);
	}

	public void insertGra(Grade record) {
		gradeMapper.insert(record);
		
	}

	public Grade selectGra(Integer id) {
		Grade g = gradeMapper.selectByPrimaryKey(id);
		return g;
	}

	public List<Grade> selectGraList(Grade record) {
		List<Grade> selectGraList = gradeMapper.selectGraList(record);
		return selectGraList;
	}

	public void updateGra(Grade record) {
		gradeMapper.updateByPrimaryKey(record);
	}

}
