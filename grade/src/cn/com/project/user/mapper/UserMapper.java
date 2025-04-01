package cn.com.project.user.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.project.user.domain.Admin;
import cn.com.project.user.domain.User;
@Repository("userMapper")
public interface UserMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(User record);

    void insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> selectUserList(User u);
    public User login(Map<String , String> map) throws Exception;

    void updateByPrimaryKeySelective(User record);

    void updateByPrimaryKeyWithBLOBs(User record);

    void updateByPrimaryKey(User record);
    void agree(User u);
    void updatePassword(User record);
}