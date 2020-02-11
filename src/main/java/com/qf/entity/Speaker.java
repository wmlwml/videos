package com.qf.entity;

/**
 * @Description: 主讲人实体类
 * @Author: leilei
 * @Date: 2020/01/07/16:04
 */
public class Speaker {
    private Integer id;
    //主讲人姓名
    private String speakerName;
    //主讲人简介
    private String speakerDesc;
    //职位
    private String speakerJob;
    //头像
    private String headImgUrl;

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", speakerName='" + speakerName + '\'' +
                ", speakerDesc='" + speakerDesc + '\'' +
                ", speakerJob='" + speakerJob + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerDesc() {
        return speakerDesc;
    }

    public void setSpeakerDesc(String speakerDesc) {
        this.speakerDesc = speakerDesc;
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
