package com.qf.dao;

import com.qf.entity.Course;

import java.util.List;

/**
 * @Description: 课程接口
 * @Author: leilei
 * @Date: 2020/01/08/9:15
 */
public interface CourseDao {
    //添加
    void add(Course course);

    //更新课程信息
    void update(Course course);

    //查询全部课程信息
    List<Course> findAll();


    //删除数据
    void deleteById(Integer id);

    //根据id查询
    Course findById(Integer id);

    //修改数据
    void updateById(Course course);

}
