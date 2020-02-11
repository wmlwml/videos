package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Description: 普通用户管理控制器
 * @Author: leilei
 * @Date: 2020/01/10/20:28
 */
@Controller
@ResponseBody
@RequestMapping("ordinary/")
public class UserController {
    //依赖注入
    @Autowired
    private UserService userService;


    /**
     * 功能描述: <用户登录>
     *
     * @Param: [email, password, session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-10 21:51
     */
    @RequestMapping("login.do")
    public JsonResult login(String email, String password, HttpSession session){

        //进行业务层查询
        User user = userService.login(email, password);
        //把当前用户存入session
        session.setAttribute(StrUtils.con_sumer,user);
        //进行json 转换
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;

    }

    /**
     * 功能描述: <当前登录账户>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 0:53
     */
    @RequestMapping("/onLineUser.do")
    @ResponseBody
    public JsonResult getBalance (HttpSession session) {
        JsonResult jsonResult = null;
        try{
            User user = (User)session.getAttribute(StrUtils.con_sumer);
             jsonResult = new JsonResult(1, user.getNickName());
        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }


    /**
     * 功能描述: <退出登录>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 1:00
     */
    @RequestMapping("exit.do")
    public JsonResult exit(HttpSession session) {
        JsonResult jsonResult = null;
        try {
            session.removeAttribute(StrUtils.con_sumer);
            jsonResult = new JsonResult(1, null);
        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }

    /**
     * 功能描述: <在线用户信息>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 1:00
     */
    @RequestMapping("onLineUserInfo.do")
    public JsonResult onLineUserInfo(HttpSession session) {
        JsonResult jsonResult = null;
        try {
            //通过session 直接获取当前用户（seesion用于获取当前用户id，不能直接返回用户数据，因为
            // 如果用户更新数据 session  不能及时更新）
            User user = (User)session.getAttribute(StrUtils.con_sumer);
            //当前用户id
            Integer id = user.getId();
            //调用查询
            User userById = userService.findUserById(id);
            jsonResult = new JsonResult(1, userById);
        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }


    @RequestMapping("/insertUser.do")
    public JsonResult insertUser(String reEmail, String rePassword, String nickName, HttpSession session) {

        User user = new User();
        user.setEmail(reEmail);
        user.setPassword(rePassword);
        user.setNickName(nickName);

        JsonResult jsonResult = null;
        try {
            userService.addUser(user);
            session.setAttribute(StrUtils.con_sumer, user);
            jsonResult = new JsonResult(1, null);

        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }


        return jsonResult;
    }






}
