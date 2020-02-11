package com.qf.entity;

/**
 * @Description: 视频
 * @Author: leilei
 * @Date: 2020/01/07/16:36
 */
public class Video {
    private Integer id;
    //标题
    private String title;
    //简介
    private String detail;
    //时长
    private Integer time;
    //关联主讲人
    private Integer spearkerId;
    //关联课程
    private Integer courseId;
    //视频播放地址
    private String videoUrl;
    //封面地址
    private String imageUrl;
    //播放次数
    private Integer playNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getSpearkerId() {
        return spearkerId;
    }

    public void setSpearkerId(Integer spearkerId) {
        this.spearkerId = spearkerId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                ", spearkerId=" + spearkerId +
                ", courseId=" + courseId +
                ", videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", playNum=" + playNum +
                '}';
    }
}
