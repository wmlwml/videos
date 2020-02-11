package com.qf.dao;

import com.qf.entity.Speaker;

import java.util.List;

/**
 * @Description: 主讲人数据访问接口
 * @Author: leilei
 * @Date: 2020/01/08/11:55
 */

public interface SpeakerDao {

    //查询所有
    List<Speaker> findAll();

    //添加数据
    void add(Speaker speaker);

    //删除数据
    void delete(Integer id);

    //根据id查询
    Speaker findById(Integer id);

    //修改数据
    void updateById(Speaker speaker);
}
