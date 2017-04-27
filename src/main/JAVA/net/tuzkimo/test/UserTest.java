package net.tuzkimo.test;

import net.tuzkimo.model.User;
import net.tuzkimo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户测试类
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

    @Test
    public void testGetUsersPaper() throws Exception {
        Integer pageNo = 1;
        Integer size = 2;
        List<User> users = userService.getUsersPaper(pageNo, size);
        System.out.println(users);
    }

    @Test
    public void testGetUsersCount() throws Exception {
        Assert.assertTrue(userService.getUsersCount() == 5);
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User("Steve Curry", "sc123456", "PG");
        Assert.assertTrue(userService.addUser(user) > 0);
    }

    @Test
    public void testEditUser() throws Exception {
        User user = new User("Steve Curry", "sc123456", "Kid");
        user.setId(6);
        Assert.assertTrue(userService.editUser(user) > 0);
    }

    @Test
    public void testDeleteUserById() throws Exception {
        Assert.assertTrue(userService.deleteUserById(7) > 0);
    }

    @Test
    public void testDeleteUsersByIds() throws Exception {
        Assert.assertTrue(userService.deleteUsersByIds(new Integer[]{6, 7}) > 0);
    }

}
