package com.qf.service;

import com.qf.entity.Course;

import java.util.List;

/**
 * @Description: 课程业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/08/9:43
 */
public interface CourseService {
    //全部课程信息
    List<Course> courseList(Integer page, Integer limit);

    //添加
    void addCourse(Course course);

    //删除数据
    void delSpeaker(Integer id);
    //根据id查询
    Course speakerById(Integer id);
    //修改数据
    void updateById(Course course);




}
