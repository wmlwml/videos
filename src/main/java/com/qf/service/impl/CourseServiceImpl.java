package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.CourseDao;
import com.qf.entity.Course;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 课程分类实现类
 * @Author: leilei
 * @Date: 2020/01/08/10:19
 */
@Service
public class CourseServiceImpl implements CourseService {
    //依赖注入
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> courseList(Integer page, Integer limit) {
        //数据库的查询所有的数据
        //设置页码数和每页显示的条数, 后面是紧跟着数据库查询相关语句，中间不能加其他代码
        PageHelper.startPage(page, limit);
        List<Course> list = courseDao.findAll();

        return list;
    }

    /**
     * 功能描述: <添加>
     *
     * @Param: [course]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 19:33
     */
    @Override
    public void addCourse(Course course) {
        courseDao.add(course);

    }

    /**
     * 功能描述: <删除数据>
     *
     * @Param: [id]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 20:31
     */
    @Override
    public void delSpeaker(Integer id) {

        courseDao.deleteById(id);
    }

    @Override
    public Course speakerById(Integer id) {
        return courseDao.findById(id);
    }

    @Override
    public void updateById(Course course) {
        courseDao.updateById(course);

    }
}
