package net.tuzkimo.service;

import net.tuzkimo.dao.UserMapper;
import net.tuzkimo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * Created by tuzkimo on 2017-03-16.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    public Integer editUser(User user) {
        return userMapper.updateUser(user);
    }

    public Integer deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
}
