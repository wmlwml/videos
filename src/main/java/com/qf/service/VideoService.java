package com.qf.service;

import com.qf.entity.Course;
import com.qf.entity.Speaker;
import com.qf.entity.Video;
import com.qf.vo.VideoModel;

import java.util.List;
import java.util.Map;

/**
 * @Description: 视频管理业务逻辑
 * @Author: leilei
 * @Date: 2020/01/09/1:15
 */
public interface VideoService {
    //查询所有
    Map<String,Object> findAll(Integer page, Integer limit, String searchInfo, Integer courseId, Integer speakerId);

    //查询所有讲师
    List<Speaker> findSpeakerAll();

    //查询所有课程
    List<Course> findCourseAll();

    //插入数据
    void addVideo(Video video);

    //根据id进行查询
    Video findVideoById(Integer id);
    VideoModel videoAndSpeaker(Integer id);


    //修改数据
    void updateVideoById(Video video);

    //删除单条数据
    void deleteVideoById(Integer id);

    //删除多条数据
    void deleteVideoByIds(String[] arr);


}
