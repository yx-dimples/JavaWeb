package com.test;

import java.sql.Timestamp;

public class News {
    Comments comments;
     int nid;
     int ntid;
     String ntitle;
     String nauthor;
     Timestamp ncreateDate;
     String npicPath;
     String ncontent;
     Timestamp nmodifyDate;
     String nsummary;

     public News(Comments comments,int nid, int ntid, String ntitle, String nauthor, Timestamp ncreateDate, String npicPath, String ncontent,
                Timestamp nmodifyDate, String nsummary) {
        this.comments = comments;
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


    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
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

    public News(){

    }
}
