package com.qf.service;

import com.qf.entity.Speaker;

import java.util.List;
import java.util.Map;

/**
 * @Description: 主讲人业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/08/13:02
 */
public interface SpeakerService {

    //分页查询
    Map<String,Object> speakerList(Integer page, Integer limit);

    //添加数据
    void addSpeaker(Speaker speaker);

    //删除数据
    void delSpeaker(Speaker speaker);


    //根据id查询
    Speaker speakerById(Integer id);
    //修改数据
    void updateById(Speaker speaker);

}
