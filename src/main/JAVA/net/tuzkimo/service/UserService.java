package net.tuzkimo.service;

import net.tuzkimo.model.User;

import java.util.List;

/**
 * 用户服务接口
 * Created by tuzkimo on 2017-03-16.
 */
public interface UserService {

    User getUserById(int id);

    List<User> getAllUsers();

    Integer addUser(User user);

    Integer editUser(User user);

    Integer deleteUserById(int id);

}
