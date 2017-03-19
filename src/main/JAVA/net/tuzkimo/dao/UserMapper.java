package net.tuzkimo.dao;

import net.tuzkimo.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-16.
 */
public interface UserMapper {

    @Select("SELECT id, name, description FROM user")
    List<User> getAllUsers();

    @Select("SELECT id, name, description FROM user WHERE id = #{id}")
    User getUserById(int id);

}
