package cn.com.project.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.com.project.user.domain.User;
@Service("userService")
public interface UserService {
	void deleteByPrimaryKey(Integer id);

    void insert(User record);
    void updateByPrimaryKey(User record);
    User selectByPrimaryKey(Integer id);
    List<User> selectUserList(User u);
    void agree(User u);
    void updatePassword(User record);
}
