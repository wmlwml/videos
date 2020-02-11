package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 课程类别控制器
 * @Author: leilei
 * @Date: 2020/01/07/20:54
 */
@Controller
@RequestMapping("subject/")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 功能描述: <查询所有课程分类>
     *
     * @Param: []
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 21:01
     */
    @RequestMapping("list.do")
    @ResponseBody
    public JsonResult subjectAll(){
        List<Subject> subjects = subjectService.subjectList();
        JsonResult jsonResult = new JsonResult(1, subjects);

        return jsonResult;
    }


}
