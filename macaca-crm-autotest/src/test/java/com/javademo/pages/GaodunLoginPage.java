package com.javademo.pages;

import com.alibaba.fastjson.JSONObject;
import com.javademo.pageuis.GaodunLoginPageUI;
import macaca.java.biz.BasePage;

public class GaodunLoginPage extends BasePage {

    public GaodunLoginPage(String pageDesc) {
        super(pageDesc);
        // TODO Auto-generated constructor stub
    }

    // 登录操作
    public void login(String username, String password) throws Exception {
        driver.onclickBean(GaodunLoginPageUI.LOGIN_FRIST);
        driver.onclickBean(GaodunLoginPageUI.login_switch);
        driver.inputBean(GaodunLoginPageUI.USER_NAME, username);
        driver.inputBean(GaodunLoginPageUI.PASSWORD, password);

        double x = driver.elementById("com.xbcx.gdwx3:id/btn_email_login").getOriginX();
        double y = driver.elementById("com.xbcx.gdwx3:id/btn_email_login").getOriginY();

        JSONObject obj = new JSONObject();
        obj.put("x",x);
        obj.put("y",y);

        driver.touch("tap",obj);
        driver.sleep(5000);

        for(int i = 0 ; i< 5; i++){
            driver.touch("tap",obj);
            driver.sleep(3000);
        }

    }
}
