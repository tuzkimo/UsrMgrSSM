package net.tuzkimo.dao;

import net.tuzkimo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户 DAO
 * Created by tuzkimo on 2017-03-16.
 */
public interface UserMapper {

    @Select("SELECT id, name, description FROM user")
    List<User> getAllUsers();

    @Select("SELECT id, name, description FROM user WHERE id = #{id}")
    User getUserById(int id);

    @Insert("INSERT INTO user (name, password, description) VALUES (#{name}, #{password}, #{description})")
    Integer addUser(User user);

    @Update("UPDATE user SET name = #{name}, password = #{password}, description = #{description} WHERE id = #{id}")
    Integer updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    Integer deleteUserById(int id);

}
