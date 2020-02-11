package com.qf.dao;

import com.qf.entity.User;

/**
 * @Description: 普通用户管理  接口类
 * @Author: leilei
 * @Date: 2020/01/10/20:15
 */
public interface UserDao {

    /**
     * 功能描述: <根据帐号查询用户数据>
     *
     * @Param: bankCode
     * @Return: User
     * @Author: Soulmate.leilei
     * @Date: 2019-12-24 20:20
     */
    User findByName(String email);


    //根据id进行查询
    User findUserById(Integer id);


    //添加数据
    int addUser(User user);

    public int updateUser(User user);



}
