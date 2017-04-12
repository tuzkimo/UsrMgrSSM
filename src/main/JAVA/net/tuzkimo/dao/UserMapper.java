package net.tuzkimo.dao;

import net.tuzkimo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户 DAO
 * Created by tuzkimo on 2017-03-16.
 */
public interface UserMapper {

    @Select("SELECT id, name, password, description, photo FROM user")
    List<User> getAllUsers();

    // 获取用户信息并分页
    @Select("SELECT id, name, password, description, photo FROM user LIMIT #{skip}, #{size}")
    List<User> getUsersPaper(@Param("skip") Integer skip, @Param("size") Integer size);

    // 获取用户总数
    @Select("SELECT COUNT(id) FROM user")
    Integer getUsersCount();

    @Select("SELECT id, name, password, description, photo FROM user WHERE id = #{id}")
    User getUserById(int id);

    @Insert("INSERT INTO user (name, password, description) VALUES (#{name}, #{password}, #{description})")
    Integer addUser(User user);

    @Update("UPDATE user SET name = #{name}, password = #{password}, description = #{description}, photo = #{photo} WHERE id = #{id}")
    Integer updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    Integer deleteUserById(int id);

}
