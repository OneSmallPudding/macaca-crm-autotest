package com.javademo.pageuis;

import macaca.client.common.GetElementWay;
import macaca.java.biz.BasePageUI;
import macaca.java.biz.CommonUIBean;

public class GaodunLoginPageUI extends BasePageUI {

    public static final CommonUIBean LOGIN_FRIST  = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/btn_login", GetElementWay.NAME, "please input username", "登录用户名输入框");
    public static final CommonUIBean login_switch = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/btn_switch", GetElementWay.NAME, "please input username", "登录用户名输入框");
    public static final CommonUIBean USER_NAME    = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/edit_email", GetElementWay.NAME, "please input username", "登录用户名输入框");
    public static final CommonUIBean PASSWORD     = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/edit_password", GetElementWay.NAME, "please input password", "登录密码输入框");
    public static final CommonUIBean LOGIN_BTN    = new CommonUIBean(GetElementWay.XPATH, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]",  GetElementWay.NAME, "please input password", "登录按钮");
    public static final CommonUIBean LOGIN_BTN_byPword    = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/btn_email_login",  GetElementWay.NAME, "", "");
    public static final CommonUIBean LATER_BTN    = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/btn_cancel", GetElementWay.NAME, "please input password", "登录密码输入框");
    //public static final CommonUIBean KEY_BOARD = new CommonUIBean(GetElementWay.NAME, "Done", "键盘完成按钮");
    public static final CommonUIBean Phone_TEXT_scode = new CommonUIBean(GetElementWay.ID, "com.xbcx.gdwx3:id/edit_phone", GetElementWay.NAME, "", "");
}

