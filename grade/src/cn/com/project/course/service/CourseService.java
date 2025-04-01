package cn.com.project.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.project.course.domain.Course;
import cn.com.project.course.domain.Grade;

public interface CourseService {
	void deleteByPrimaryKey(Integer id);

    void insert(Course record);

    Course selectByPrimaryKey(Integer id);
    
    List<Course> selectCouList(Course record);

    void updateByPrimaryKey(Course record);
    
    void deleteGra(Integer id);

    void insertGra(Grade record);

    Grade selectGra(Integer id);
    
    List<Grade> selectGraList(Grade record);

    void updateGra(Grade record);
}
