package com.hyxy.entity;

import java.io.Serializable;

public class Banner2 implements Serializable{
    private Integer id;

    private String imgname;

    private Integer order1;

    private String title;

    private Integer start1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStart1() {
        return start1;
    }

    public void setStart1(Integer start1) {
        this.start1 = start1;
    }
}