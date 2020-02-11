package com.qf.service;

import com.qf.entity.User;

/**
 * @Description: 用户管理业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/10/20:20
 */
public interface UserService {

    /**
     * 功能描述: <登录方法>
     *
     * @Param: [userName, password]
     * @Return: com.qf.entity.Admin
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 17:03
     */
    User login(String email, String password);


    //根据id进行查询
    User findUserById(Integer id);

    //添加数据
    int addUser(User user);

}
