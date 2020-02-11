package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.dao.CourseDao;
import com.qf.dao.SpeakerDao;
import com.qf.dao.VideoDao;
import com.qf.entity.Course;
import com.qf.entity.Speaker;
import com.qf.entity.Video;
import com.qf.service.SpeakerService;
import com.qf.service.VideoService;
import com.qf.vo.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 视频管理业务逻辑实现类
 * @Author: leilei
 * @Date: 2020/01/09/1:17
 */
@Service
public class VideoServiceImpl implements VideoService {
    //视频持久接口
    @Autowired
    private VideoDao videoDao;
    //主讲人数据持久接口
    @Autowired
    private SpeakerDao speakerDao;
    //课程数据接口
    @Autowired
    private CourseDao courseDao;


    /**
     * 功能描述: <分页查询 动态查询>
     *
     * @Param: [page, limit, searchInfo, courseId, speakerId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 9:03
     */
    @Override
    public Map<String, Object> findAll(Integer page, Integer limit, String searchInfo, Integer courseId, Integer speakerId) {
        //设置页码
        PageHelper.startPage(page, limit);
        //进行查询
        List<VideoModel> list = videoDao.findAll(searchInfo,courseId,speakerId);
        //获取总记录数
        long total = ((Page) list).getTotal();
        HashMap<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }


    /**
     * 功能描述: <所有讲师>
     *
     * @Param: []
     * @Return: java.util.List<com.qf.entity.Speaker>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 9:02
     */
    @Override
    public List<Speaker> findSpeakerAll() {
        List<Speaker> speakerList = speakerDao.findAll();
        return speakerList;
    }

    /**
     * 功能描述: <查询所有课程>
     *
     * @Param: []
     * @Return: java.util.List<com.qf.entity.Course>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 9:02
     */
    @Override
    public List<Course> findCourseAll() {
        List<Course> courseList = courseDao.findAll();
        return courseList;
    }

    /**
     * 功能描述: <添加数据>
     *
     * @Param: [video]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:16
     */
    @Override
    public void addVideo(Video video) {
        videoDao.addVideo(video);
    }

    /**
     * 功能描述: <根据id进行查询>
     *
     * @Param: [id]
     * @Return: com.qf.entity.Video
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:19
     */
    @Override
    public Video findVideoById(Integer id) {
        Video video = videoDao.findVideoById(id);
        return video;
    }
    @Override
    public VideoModel videoAndSpeaker(Integer id) {
        return videoDao.videoAndSpeaker(id);
    }

    /**
     * 功能描述: <更新数据>
     *
     * @Param: [video]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:20
     */
    @Override
    public void updateVideoById(Video video) {
        videoDao.updateVideoById(video);

    }

    /**
     * 功能描述: <删除单挑数据>
     *
     * @Param: [id]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:20
     */
    @Override
    public void deleteVideoById(Integer id) {
        videoDao.deleteVideoById(id);

    }

    /**
     * 功能描述: <删除多条数据>
     *
     * @Param: [ids]
     * @Return: void
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:20
     */
    @Override
    public void deleteVideoByIds(String[] arr) {
        videoDao.deleteVideoByIds(arr);

    }



}
