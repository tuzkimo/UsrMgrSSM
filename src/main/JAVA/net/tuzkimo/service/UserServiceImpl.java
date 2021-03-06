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

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    // 获取用户信息并分页
    public List<User> getUsersPaper(Integer pageNo, Integer size) {
        Integer skip = (pageNo - 1) * size;
        return userMapper.getUsersPaper(skip, size);
    }

    // 获取用户数量
    public Integer getUsersCount() {
        return userMapper.getUsersCount();
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

    public Integer deleteUsersByIds(Integer[] ids) {
        int effectRows = 0;
        for (int id : ids) {
            effectRows += userMapper.deleteUserById(id);
        }
        return effectRows;
    }

}
