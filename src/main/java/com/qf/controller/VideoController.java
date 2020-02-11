package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.Course;
import com.qf.entity.Speaker;
import com.qf.entity.Video;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.VideoService;
import com.qf.vo.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 视频管理控制器
 * @Author: leilei
 * @Date: 2020/01/09/1:20
 */
@Controller
@ResponseBody
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;


    /**
     * 功能描述: <分页查询全部数据 动态匹配查询数据>
     *
     * @Param: [session, page, limit, searchInfo, courseId, speakerId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 9:04
     */
    @RequestMapping("/videoAll.do")
    public Map<String,Object> videoAll(HttpSession session, Integer page, Integer limit, String searchInfo, Integer courseId,
                                       Integer speakerId) {
        Map<String, Object> all = videoService.findAll(page, limit,searchInfo, courseId,speakerId);
        return all;
    }

    @RequestMapping("/findSpeakerAll.do")
    public JsonResult findSpeakerAll() {

        List<Speaker> speakerList = videoService.findSpeakerAll();

        return new JsonResult(1,speakerList);
    }

    @RequestMapping("/findCourseAll.do")
    public JsonResult findCourseAll() {
        List<Course> courseAll = videoService.findCourseAll();
        return new JsonResult(1, courseAll);
    }


    /**
     * 功能描述: <条件查询>
     *
     * @Param: []
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 10:12
     */
    @RequestMapping("/criteriaInfo.do")
    public Map<String,Object> criteriaInfo () {
        List<Speaker> speakerAll = videoService.findSpeakerAll();
        List<Course> courseAll = videoService.findCourseAll();
        //添加数据
        HashMap<String, Object> criteriaMap = new HashMap<>();
        criteriaMap.put("speakerAll", speakerAll);
        criteriaMap.put("courseAll", courseAll);

        return criteriaMap;

    }


    /**
     * 功能描述: <添加数据>
     *
     * @Param: [video]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:23
     */
    @RequestMapping("/addVideo")
    public JsonResult addVideo(Video video) {
        videoService.addVideo(video);
        return new JsonResult(1, null);
    }

    /**
     * 功能描述: <根据id进行查询>
     *
     * @Param: [id]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-10 9:38
     */
    @RequestMapping("/findVideoById.do")
    public JsonResult findVideoById(Integer id) {
        Video video = videoService.findVideoById(id);
        return new JsonResult(1, video);
    }

    /**
     * 功能描述: <根据id进行修改数据>
     *
     * @Param: [video]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-10 9:37
     */
    @RequestMapping("/updateVideoById.do")
    public JsonResult updateVideoById(Video video) {
        videoService.updateVideoById(video);
        return new JsonResult(1, null);

    }

    /**
     * 功能描述: <根据id删除数据>
     *
     * @Param: [id]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 15:55
     */
    @RequestMapping("/deleteVideoById.do")
    public JsonResult deleteVideoById(Integer id){
        videoService.deleteVideoById(id);
        return new JsonResult(1, null);
    }

    /**
     * 功能描述: <批量删除>
     *
     * @Param: [string]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-9 17:00
     */
    @RequestMapping("/deleteVideoByIds.do")
    public JsonResult deleteVideoByIds(String string){
        String[] array = string.split(",");

        videoService.deleteVideoByIds(array);
        return new JsonResult(1, null);
    }






}
