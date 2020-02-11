package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.dao.SpeakerDao;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 实现类
 * @Author: leilei
 * @Date: 2020/01/08/13:04
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {
    //依赖注入
    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public Map<String,Object> speakerList(Integer page, Integer limit) {
        //设置页码
        PageHelper.startPage(page, limit);
        //调研查询
        List<Speaker> list = speakerDao.findAll();

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        //int pages = ((Page) list).getPages();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    //添加
    @Override
    public void addSpeaker(Speaker speaker) {

        speakerDao.add(speaker);
    }

    //删除
    @Override
    public void delSpeaker(Speaker speaker) {
        speakerDao.delete(speaker.getId());

    }

    @Override
    public Speaker speakerById(Integer id) {
        Speaker speaker = speakerDao.findById(id);
        return speaker;
    }

    @Override
    public void updateById(Speaker speaker) {
        speakerDao.updateById(speaker);
    }
}
