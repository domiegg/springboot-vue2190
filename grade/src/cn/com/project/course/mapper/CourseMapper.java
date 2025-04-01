package cn.com.project.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.course.domain.Course;
@Repository("courseMapper")
public interface CourseMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Course record);


    Course selectByPrimaryKey(Integer id);
    
    List<Course> selectCouList(Course record);


    void updateByPrimaryKey(Course record);
}