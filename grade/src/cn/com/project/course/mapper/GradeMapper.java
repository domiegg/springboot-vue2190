package cn.com.project.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.course.domain.Grade;
@Repository("gradeMapper")
public interface GradeMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Grade record);

    Grade selectByPrimaryKey(Integer id);
    
    List<Grade> selectGraList(Grade record);

    void updateByPrimaryKey(Grade record);
}