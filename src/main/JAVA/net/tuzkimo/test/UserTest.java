package net.tuzkimo.test;

import net.tuzkimo.model.User;
import net.tuzkimo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis-spring.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
    }

}
