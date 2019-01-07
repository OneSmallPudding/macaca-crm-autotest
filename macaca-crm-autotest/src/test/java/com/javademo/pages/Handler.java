package com.javademo.pages;

import com.alibaba.fastjson.JSONObject;
import macaca.client.common.DriverCommand;
import macaca.client.common.MacacaDriver;
import macaca.client.common.Utils;

public class Handler {
    private MacacaDriver driver;
    private Utils utils;
    public Handler(MacacaDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }
    public static final String SESSION = "session/:sessionId";
    public static final String WINDOW = SESSION+"/window";

    public Object takeHandler() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sessionId", driver.getSessionId());
        return utils.request("GET", DriverCommand. WINDOW_HANDLES , jsonObject);
    }

    public Object switchWindow(JSONObject jsonObject) throws Exception {
        jsonObject.put("sessionId", driver.getSessionId());
        return   utils.request("POST", WINDOW, jsonObject);
    }


    public Object takeCurrentHandler() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sessionId", driver.getSessionId());
        return utils.request("GET", DriverCommand. WINDOW_HANDLE , jsonObject);
    }
}
