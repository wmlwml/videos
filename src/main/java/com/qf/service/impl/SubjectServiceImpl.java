package com.qf.service.impl;

import com.qf.dao.SubjectDao;
import com.qf.entity.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 课程分类数据实现类
 * @Author: leilei
 * @Date: 2020/01/07/20:40
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    //依赖注入
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> subjectList() {
        List<Subject> subjects = subjectDao.findAll();
        return subjects;
    }
}
