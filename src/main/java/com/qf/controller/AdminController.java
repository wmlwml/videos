package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description: 管理员控制器
 * @Author: leilei
 * @Date: 2020/01/11/14:17
 */
@Controller
@ResponseBody
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 功能描述: <分页查询所有>
     *
     * @Param: [page, limit]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 14:57
     */
    @RequestMapping("/warrantyList.do")
    public Map<String, Object> adminList(Integer page, Integer limit) {
        Map<String, Object> list = adminService.adminList(page, limit);
        return list;
    }

    /**
     * 功能描述: <添加管理员>
     *
     * @Param: [speaker]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 16:09
     */
    @RequestMapping("/addAdmin.do")
    public JsonResult addAdmin(Admin admin){
        adminService.addAdmin(admin);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }


    /**
     * 功能描述: <删除管理员>
     *
     * @Param: [admin]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 15:00
     */
    @RequestMapping("/delAdmin.do")
    public JsonResult delAdmin(Admin admin) {
        adminService.delAdmin(admin);
        return new JsonResult(1, null);
    }

    /**
     * 功能描述: <根据id查询>
     *
     * @Param: [id]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 15:16
     */
    @RequestMapping("/adminById.do")
    public JsonResult adminById(Integer id){
        Admin admin = adminService.adminById(id);
        return new JsonResult(1, admin);
    }

    /**
     * 功能描述: <更新管理员数据>
     *
     * @Param: [admin]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 15:26
     */
    @RequestMapping("/updateAdmin.do")
    public JsonResult updateAdmin(Admin admin) {
        adminService.updateById(admin);
        return new JsonResult(1, null);

    }




}
