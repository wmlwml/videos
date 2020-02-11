package com.qf.dao;

import com.qf.entity.Subject;

import java.util.List;

/**
 * @Description: 类别数据访问接口
 * @Author: leilei
 * @Date: 2020/01/07/20:20
 */
public interface SubjectDao {
    //查询所有类别
    List<Subject> findAll();
}
