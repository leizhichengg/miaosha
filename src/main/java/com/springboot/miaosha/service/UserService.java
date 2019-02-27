package com.springboot.miaosha.service;

import com.springboot.miaosha.dao.UserDao;
import com.springboot.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 10:34
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(int id) {
        return userDao.getById(id);
    }


    @Transactional
    public boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("2222");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("1111");
        userDao.insert(u2);

        return true;
    }

}
