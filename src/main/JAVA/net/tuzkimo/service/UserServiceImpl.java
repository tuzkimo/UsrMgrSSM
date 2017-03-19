package net.tuzkimo.service;

import net.tuzkimo.dao.UserMapper;
import net.tuzkimo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

}
