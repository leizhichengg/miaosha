package com.springboot.miaosha.dao;

import com.springboot.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 10:31
 */

@Mapper
public interface UserDao {

    /**
     * get User by id
     * @param id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);

    @Insert("insert into user(id, name)value(#{id}, #{name})")
    public int insert(User user);

}
