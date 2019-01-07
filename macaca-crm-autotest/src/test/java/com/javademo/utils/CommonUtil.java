package com.javademo.utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javademo.dao.TestDao;
import macaca.client.MacacaClient;
import macaca.client.commands.Element;
import macaca.client.common.DriverCommand;
import macaca.client.common.GetElementWay;
import macaca.client.common.Utils;
import macaca.java.biz.BaseMacacaClient;
import sun.security.pkcs11.Secmod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonUtil {
    TestDao testDao      = new TestDao();
    TestDao testDao1     = new TestDao();

    boolean flag         = false;
    //获取考试倒计时元素，获取其 content-desc,并与数据库中比较。
    public boolean  getExamTime(BaseMacacaClient driver, String sql) throws Exception {
        driver.sleep(5000);
        ResultSet su                =   testDao.query(sql);
        if(su.next()){
            Date nowDate            = new Date();
            Date  examDate          = su.getDate(3);
            long  dayVer            = 1+(examDate.getTime()-nowDate.getTime())/(24*60*60*1000);
            if(dayVer  <= 0){
                flag = true;
            }else if(dayVer > 0){
                String dayStr       = String.valueOf(dayVer);
                Element el          = driver.waitForElement("name"," "+dayStr+" ");
                if(el != null){
                    flag            = true;
                }else {
                    flag            = false;
                }
            }
        }
        return flag;
    }

    //获取用户总积分
    public int getTotalScore()  throws Exception  {
        //根据手机号，获取用户id
        String  sql       =   "SELECT user_id from user_center.uc_users WHERE phone = '15655103835'";
        ResultSet su      =   testDao.query(sql);
        int user_id       = 0;
         int totalScore   = 0;
        while (su.next()){
             user_id      = su.getInt("user_id");
        }

        // 根据id 获取用户的积分
        sql               =   "SELECT total from gd_integral.up_integrals_total WHERE student_id ="+ user_id;
        ResultSet su1     =   testDao1.query(sql);
        while (su1.next()){
            totalScore    = su1.getInt("total");

        }
         return  totalScore;
    }

    //窗口垂直滚动(从下往上)
    public void verticalScroll(BaseMacacaClient driver) throws Exception {
        JSONObject windowSize = driver.getWindowSize();
        int windowWidth       = windowSize.getIntValue("width");
        int windowHeight      = windowSize.getIntValue("height");
        driver.drag(windowWidth-200,windowHeight-400,windowWidth-200,400,0.5);
    }


    //窗口垂直滚动(从上往下)
    public void verticalScrollDown(BaseMacacaClient driver) throws Exception {
        JSONObject windowSize = driver.getWindowSize();
        int windowWidth       = windowSize.getIntValue("width");
        int windowHeight      = windowSize.getIntValue("height");
        driver.drag(windowWidth-200,200,windowWidth-200,windowHeight-200,0.5);
    }


    //元素垂直滚动(从下往上)
    public void verticalScroll(BaseMacacaClient driver,Element el) throws Exception {
        JSONObject windowSize     = driver.getWindowSize();
        int windowHeight          = windowSize.getIntValue("height");
        double elementWidth       = el.getCenterX();
        driver.drag(elementWidth+100,windowHeight-100,elementWidth+100,400 ,0.5);
    }


   //元素垂直滚动(从上往下)
    public void verticalScrollDown(BaseMacacaClient driver,Element el) throws Exception {
        JSONObject windowSize = driver.getWindowSize();
        double centerX       = el.getCenterX();
        double originY       = el.getOriginY();
        int windowHeight      = windowSize.getIntValue("height");
        driver.drag(centerX,originY+100,centerX,windowHeight-100,0.5);
    };

    /**
     * 返回手机号码
     */
    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static String[] telFirst="104,105,106,107,108,109,100,101,102,107,108,109,100,101,102,105,106,103,103".split(",");
    public  String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }
    public static String[] telFirstNotFound="111,122".split(",");
    public  String getTelNotFound() {
        int index=getNum(0,telFirstNotFound.length-1);
        String first=telFirstNotFound[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }
    public JSONArray getDataBySql(String sql, int columns, String  lable) throws  Exception{
        JSONArray dataArray = new JSONArray();
        ResultSet rs = testDao.query(sql);
        int i = 0;
        while(rs.next()){
            if(i<20){
                dataArray.set(i,rs.getString("ClueNo"));
                i++;
            }else{
                break;
            }
        }
        return  dataArray;
    }
    public JSONArray  getElementByClassName(String  className, MacacaClient webDriver) throws Exception {
        webDriver.sleep(3000);
        JSONObject object = webDriver.execute("var x = document.getElementsByClassName('" + className + "');var arrayObj = new Array();for(var i=0;i<x.length;i++){arrayObj.push(x[i].innerText)};console.log(arrayObj);return arrayObj;");
        JSONArray valArray = (JSONArray) object.get("value");
        return valArray;
    }
    public  void getRefresh(MacacaClient webDriver)throws Exception{
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_R);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_R);
        webDriver.sleep(2000);
    }//刷新网页
    public  void  nextLine(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }
    public  void clear(MacacaClient webDriver)throws Exception{
        webDriver.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);

        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        webDriver.sleep(2000);
    }//关闭页面
    //按下右边箭头，按下enter 键
    public  void  rightLine(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        webDriver.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        webDriver.sleep(2000);
    }
    public void refresh(MacacaClient webDriver) throws Exception {
        Utils utils = new Utils(webDriver.contexts);;
        webDriver.sleep(2000);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sessionId", webDriver.contexts.getSessionId());
        utils.request("POST", DriverCommand.REFRESH , jsonObject);
    }
    public void close(MacacaClient webDriver) throws Exception {
        String SESSION = "session/:sessionId";
        String WINDOW = SESSION+"/window";
        Utils utils = new Utils(webDriver.contexts);;
        webDriver.sleep(2000);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sessionId", webDriver.contexts.getSessionId());
        utils.request("DELETE", WINDOW , jsonObject);
    }
}
