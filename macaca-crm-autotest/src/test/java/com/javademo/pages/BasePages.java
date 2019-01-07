package com.javademo.pages;

import macaca.client.MacacaClient;
import macaca.java.biz.BaseMacacaClient;
import macaca.java.biz.CommonUIBean;

public class BasePages {
    public MacacaClient webDriver;
    public String pageDesc;

    public  void  BasePages(){}
    public MacacaClient getDriver() {
        return this.webDriver;
    }

    public void setDriver(MacacaClient driver) {
        this.webDriver = driver;
    }

    public BasePages(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    public BasePages(String pageDesc, MacacaClient driver) {
        this.pageDesc = pageDesc;
        this.webDriver = driver;
    };
}
