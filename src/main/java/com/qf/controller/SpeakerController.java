package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description: 主讲人控制器
 * @Author: leilei
 * @Date: 2020/01/08/11:54
 */
@Controller
@RequestMapping("speaker/")
@ResponseBody
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    /**
     * 功能描述: <查询所有>
     *
     * @Param: [page, limit]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 16:04
     */
    @RequestMapping("list.do")
    public Map<String, Object> speakerList(Integer page, Integer limit) {

        Map<String, Object> list = speakerService.speakerList(page, limit);
        return list;
    }

    /**
     * 功能描述: <添加主讲人>
     *
     * @Param: [speaker]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-8 16:09
     */
    @RequestMapping("addSpeaker.do")
    public JsonResult addSpeaker(Speaker speaker){
        speakerService.addSpeaker(speaker);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }


    //删除
    @RequestMapping("delSpeaker.do")
    public JsonResult delSpeaker(Speaker speaker) {
        speakerService.delSpeaker(speaker);
        return new JsonResult(1, null);
    }

    //根据id查询
    @RequestMapping("speakerById.do")
    public JsonResult speakerById(Integer id){
        Speaker speaker = speakerService.speakerById(id);
        return new JsonResult(1, speaker);
    }

    @RequestMapping("updateSpeaker.do")
    public JsonResult updateSpeaker(Speaker speaker) {
        speakerService.updateById(speaker);
        return new JsonResult(1, null);

    }

}
