package com.qf.dao;

import com.qf.entity.Course;
import com.qf.entity.Speaker;
import com.qf.entity.Video;
import com.qf.vo.VideoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 视频管理数据访问接口
 * @Author: leilei
 * @Date: 2020/01/07/19:40
 */
public interface VideoDao {

    //查询所有视频信息
    List<VideoModel> findAll(@Param("searchInfo")String searchInfo,
                             @Param("courseId")Integer courseId,
                             @Param("speakerId")Integer speakerId);


    //插入数据
    void addVideo(Video video);

    //根据id进行查询
    Video findVideoById(Integer id);

    //根据id进行查询 VideoModel版本
    VideoModel videoAndSpeaker(Integer id);

    //修改数据
    void updateVideoById(Video video);

    //删除单条数据
    void deleteVideoById(Integer id);

    //删除多条数据
    void deleteVideoByIds(String[] arr);








}
