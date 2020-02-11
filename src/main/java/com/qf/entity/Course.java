package com.qf.entity;

/**
 * @Description: 课程类
 * @Author: leilei
 * @Date: 2020/01/07/15:25
 */
public class Course {
    //数据id
    private Integer id;
    //课程标题
    private String courseTitle;
    //课程简介
    private String courseDesc;
    //课程分类id
    private Integer subjectId;

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
