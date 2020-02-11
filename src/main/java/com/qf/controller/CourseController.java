package com.qf.controller;

import com.github.pagehelper.Page;
import com.qf.common.JsonResult;
import com.qf.entity.Course;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 课程管理控制器
 * @Author: leilei
 * @Date: 2020/01/08/9:34
 */
@Controller
@ResponseBody
public class CourseController {
    //依赖注入
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseList.do")
    public Map<String,Object> courseList(Integer page, Integer limit){
        List<Course> list = courseService.courseList(page, limit);
        //数据总条数
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;

    }


    /**
     * 功能描述: <添加数据>
     *
     * @Param: [course]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 18:47
     */
    @RequestMapping("/addCourse.do")
    public JsonResult addCourse(Course course){
        courseService.addCourse(course);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }


    /**
     * 功能描述: <删除数据>
     *
     * @Param: [course]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 18:50
     */
    @RequestMapping("/delCourse.do")
    public JsonResult delCourse(Integer id){
        courseService.delSpeaker(id);
        return new JsonResult(1, null);
    }


    /**
     * 功能描述: <根据id查询>
     *
     * @Param: [id]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 20:39
     */
    @RequestMapping("/courseById.do")
    public JsonResult courseById(Integer id){
        Course course = courseService.speakerById(id);
        return new JsonResult(1, course);

    }


    /**
     * 功能描述: <更新数据>
     *
     * @Param: [course]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 20:38
     */
    @RequestMapping("/updateCourse.do")
    public JsonResult updateCourse(Course course) {

        courseService.updateById(course);
        return new JsonResult(1, null);


    }



}
