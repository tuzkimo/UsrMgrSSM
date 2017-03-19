package net.tuzkimo.service;

import net.tuzkimo.model.User;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-16.
 */
public interface UserService {

    User getUserById(int id);

    List<User> getAllUsers();

}
