package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import com.qf.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Description: 登录控制器
 * @Author: leilei
 * @Date: 2020/01/07/17:46
 */
@Controller
@ResponseBody
@RequestMapping("login/")
public class LoginController {
    //依赖注入
    @Autowired
    private AdminService adminService;

    /**
     * 功能描述: <登录方法>
     *
     * @Param: [userName, password, session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 17:57
     */
    @RequestMapping("admin.do")
    public JsonResult loginAdmin(String userName, String password, HttpSession session){

        JsonResult jsonResult = null;
        try {
            Admin admin = adminService.login(userName, password);
            session.setAttribute(StrUtils.LOGIN_USER, admin);
            //进行json转换
            jsonResult = new JsonResult(1, null);

        } catch (Exception e) {
            jsonResult= new JsonResult(0, null);
        }

        return jsonResult;
    }


    /**
     * 功能描述: <退出登录>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 20:08
     */
    @RequestMapping("exit.do")
    public JsonResult exit(HttpSession session) {
        session.removeAttribute(StrUtils.LOGIN_USER);
        JsonResult jsonResult = new JsonResult(0, null);
        return jsonResult;
    }


    /**
     * 功能描述: <当前用户>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 15:33
     */
    @RequestMapping("activeUser.do")
    public JsonResult activeUser(HttpSession session) {
        Admin admin = (Admin)session.getAttribute(StrUtils.LOGIN_USER);
        String activeUser = admin.getUserName();

        return new JsonResult(1, activeUser);
    }



}
