package com.example.gratuity;

public class getdata
{
    private  String did;
    private  String dname;
    private  String drollno;
    private  String dbloodgroup;
    private  String ddob;
    private  String dphone;
    private  String ddepart;
    private String dweight;
public getdata()
    {

    }
    public getdata(String did,String dname,String drollno,String dbloodgroup,String ddob,String dphone,String ddepart,String dweight)
    {
        this.did=did;
        this.dname=dname;
        this.drollno=drollno;
        this.dbloodgroup=dbloodgroup;
        this.ddob=ddob;
        this.dphone=dphone;
        this.ddepart=ddepart;
        this.dweight=dweight;
    }

    public String getDid() {
        return did;
    }

    public String getDname() {
        return dname;
    }


    public String getDrollno() {
        return drollno;
    }

    public String getDbloodgroup() {
        return dbloodgroup;
    }

    public String getDdob() {
        return ddob;
    }

    public String getDphone() {
        return dphone;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

  public void setDrollno(String drollno) {
        this.drollno = drollno;
    }

    public void setDbloodgroup(String dbloodgroup) {
        this.dbloodgroup = dbloodgroup;
    }

    public void setDdob(String ddob) {
        this.ddob = ddob;
    }

    public void setDphone(String dphone) {
        this.dphone = dphone;
    }

    public String getDdepart() {
        return ddepart;
    }

    public String getDweight() {
        return dweight;
    }

    public void setDdepart(String ddepart) {
        this.ddepart = ddepart;
    }

    public void setDweight(String dweight) {
        this.dweight = dweight;
    }
}

