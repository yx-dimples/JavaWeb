package com.test;

import java.sql.Timestamp;

public class Comments {
    int cid;
    int cnid;
    String ccontent;
    Timestamp cdate;
    String cip;
    String cauthor;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCnid() {
        return cnid;
    }

    public void setCnid(int cnid) {
        this.cnid = cnid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }

    public Comments(){

    }

    public Comments(int cid, int cnid, String ccontent, Timestamp cdate, String cip, String cauthor) {
        this.cid = cid;
        this.cnid = cnid;
        this.ccontent = ccontent;
        this.cdate = cdate;
        this.cip = cip;
        this.cauthor = cauthor;
    }
}
