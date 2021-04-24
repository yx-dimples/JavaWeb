package com.news.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * 新闻实体类
 */
public class News {
    private int nid;
    private int ntid;
    private String ntitle;
    private String nauthor;
    private Timestamp ncreateDate;
    private String npicPath;
    private String ncontent;
    private Timestamp nmodifyDate;
    private String nsummary;

    //添加一个新闻评论



    public News() {
    }

    public News(int nid, int ntid, String ntitle, String nauthor, Timestamp ncreateDate, String npicPath, String ncontent, Timestamp nmodifyDate, String nsummary) {
        this.nid = nid;
        this.ntid = ntid;
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncreateDate = ncreateDate;
        this.npicPath = npicPath;
        this.ncontent = ncontent;
        this.nmodifyDate = nmodifyDate;
        this.nsummary = nsummary;
    }
    //private List comments;
    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", ntid=" + ntid +
                ", ntitle='" + ntitle + '\'' +
                ", nauthor='" + nauthor + '\'' +
                ", ncreateDate=" + ncreateDate +
                ", npicPath='" + npicPath + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", nmodifyDate=" + nmodifyDate +
                ", nsummary='" + nsummary + '\'' +
                '}';
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getNtid() {
        return ntid;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Timestamp getNcreateDate() {
        return ncreateDate;
    }

    public void setNcreateDate(Timestamp ncreateDate) {
        this.ncreateDate = ncreateDate;
    }

    public String getNpicPath() {
        return npicPath;
    }

    public void setNpicPath(String npicPath) {
        this.npicPath = npicPath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Timestamp getNmodifyDate() {
        return nmodifyDate;
    }

    public void setNmodifyDate(Timestamp nmodifyDate) {
        this.nmodifyDate = nmodifyDate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }
}
