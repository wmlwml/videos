package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 普通用户业务逻辑实现类
 * @Author: leilei
 * @Date: 2020/01/10/20:24
 */
@Service
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        User user = userDao.findByName(email);
        //基本判断
        if (user == null) {
            throw new RuntimeException("账户错误");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userDao.findUserById(id);

        return user;
    }

    @Override
    public int addUser(User user) {
        int isOk = userDao.addUser(user);
        return isOk;
    }
}
