package com.javademo.pages;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javademo.dao.TestDao;
import com.javademo.pageuis.GaodunCluePageUI;
import com.javademo.pageuis.GaodunOrderPageUI;
import com.javademo.utils.CommonUtil;
import com.javademo.utils.Config;
import macaca.client.commands.Element;
import macaca.client.commands.Url;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

public class GaodunOrderPage extends BasePages{
    private Robot robot;
    CommonUtil commonUtil = new CommonUtil();
    String repeatName8;//测试数据8
    public GaodunOrderPage(String pageDesc) { super(pageDesc); }
    TestDao testDao    = new TestDao();
    public static String     bookOrderName    = "";
    public static String     normalOrderName  = "";
    //status 为 0 正常保存、为1身份证号码重复、为2为军官证重复，为3快递地址为空, 为4学校为空,为5 职业状态为待业，职业为空
    //为6是切换项目、为7 定金
    public  boolean addOrder(int status,String hint)  throws  Exception{
        boolean flag = false;
        String tel = commonUtil.getTel();
        webDriver.get(Config.cmsCluesUrl);
        webDriver.sleep(2000);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(1000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBYPHONE).sendKeys(Config.cmsUserTel);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(4000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
        webDriver.waitForElementByLinkText("跟进").click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.BOOK_BTN).click();
        switchToWindows(1);
        webDriver.sleep(3000);
        normalOrderName ="t"+tel;
//       webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_NAME).click();
//        clear();

        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_NAME).click();
        commonUtil.clear(webDriver);
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_NAME).sendKeys(normalOrderName);
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EMERGE_CONTECT).sendKeys("ZHANGSAN");
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EMERGE_CONTECT_TEL).sendKeys(tel);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EMAIL).sendKeys(tel+"@qq.com");
        String sql = "";

        if(status ==1){
            sql = "SELECT  MAX(TBD.Name) name, SI.CertificateNo certificateNo FROM crm_order_center.Student_Info SI JOIN crm_base.Tpo_Base_Dictionary TBD ON SI.CertificateType = TBD.id WHERE TBD.`Name`='身份证';";
            testDao.query(sql);
            ResultSet su = testDao.query(sql);
            su.next();
            String certificateNo = su.getString("certificateNo");
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CERTIFICATE_NO).sendKeys(certificateNo);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.EMERGE_CONTECT).click();
            Element el = webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_CONS);
            if(el != null){
                el.click();
                flag = true;
            }
            webDriver.sleep(2000);
        }else if(status ==2) {
            sql = "SELECT  MAX(TBD.Name) name, SI.CertificateNo certificateNo FROM crm_order_center.Student_Info SI JOIN crm_base.Tpo_Base_Dictionary TBD ON SI.CertificateType = TBD.id WHERE TBD.`Name`='军官证';";
            testDao.query(sql);
            ResultSet su = testDao.query(sql);
            su.next();
            String certificateNo = su.getString("certificateNo");
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CERTIFICATETYPE).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.OFFICERS).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CERTIFICATE_NO).sendKeys(certificateNo);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.EMERGE_CONTECT).click();
            Element el = webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_CONS);
            if (el != null) {
                el.click();
                flag = true;
            }
            webDriver.sleep(2000);
        }else{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CERTIFICATE_NO).sendKeys("3410211"+tel);
            flag = true;
        }

        webDriver.waitForElementByXPath(GaodunOrderPageUI.OPENCLASS_SHOOL).click();
        webDriver.sleep(1000);
//        webDriver.waitForElementByXPath(GaodunOrderPageUI.OPENCLASS_SHOOLCHOOSE).click();
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.BOOK_SCHOOL).click();
//        webDriver.waitForElementByXPath(GaodunOrderPageUI.BOOK_SCHOOLCHOOSE).click();
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EXPECT_CLASSTIME).click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EXPECT_CLASSTIME1).click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.EXPECT_CLASSTIME2).click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.OPEM_CLASSCOUNT).sendKeys(tel);
        if(status == 4){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_STATESWORK).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_WORK).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDSCHOOL).sendKeys("");
        }else if(status == 5){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_STATESWORK).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_WAITWORK).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDSCHOOL).sendKeys("");
        }else{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDSCHOOL).sendKeys("6666666666");
        }
        if(status == 6){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGEPROJECT).clearText();

            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGEPROJECT).sendKeys("阿米巴");
            nextLine();
            webDriver.sleep(2000);
//            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTACCA).click();
        }
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ENROLLMENT_YEAR).click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ENROLLMENT_YEAR_CHOOSE).click();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.MAJOR).sendKeys(tel);
        if(status == 3){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ADDRESS).sendKeys("");
        }else{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ADDRESS).sendKeys(tel);
        }
        if(status == 7){
            repeatName8=normalOrderName;
            System.out.print("====================="+repeatName8);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDMONEY1).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDMONEY).sendKeys("1");
        }else if(status == 0){
            repeatName8=normalOrderName;
            System.out.print("====================="+repeatName8);
        }
        //添加课程
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDCLASS).click();
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.COURSE_CHOOSE).click();
        webDriver.sleep(1000);
        Element el  = webDriver.elementByClassName(GaodunOrderPageUI.ORDER_ADDPROJECT1);
        if(el ==null){
            el  = webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_ADDPROJECT);
        }
        el.click();
        if(status == 6){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_CHANGEPROJECT).click();
            nextLine();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_CHANGEPROJECT1).click();
            nextLine();
        }
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_SAVE).click();
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"================");
        System.out.print(hint+"================");
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        if (values.equals(hint)){
            flag =true;
        }else {
            flag=false;
        };
        return  flag;
    }
    public boolean orderPay_19()throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,"我的定金");
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGEPAY).click();//点击修改
       switchToWindows(1);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGETYPE).click();//订单类型
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESTU).click();//学员复购
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGENO).click();//定金选择否
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESCHOOL).sendKeys("学校");//学校
        try{
            webDriver.elementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTGETPRO).click();//选择课程
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTGETPEOJ).click();//选择课程
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTACC).click();//确认
        }catch (Exception e){
            System.out.print("已经选有课程");
        }
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESAVE).click();//保存
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        webDriver.sleep(1000);
        commonUtil.close(webDriver);
        webDriver.sleep(1000);
        switchToWindows(0);
        if (values.contains("成功")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_20()throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,"未完成订单");//19901120003
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGE).click();//点击修改
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGEPROJECT).click();//报名项目
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGEPROJECT).sendKeys("阿米巴");
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESCHOOL).sendKeys("学校");//学校
        webDriver.sleep(4000);
         webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTGETPRO).click();//选择课程
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTGETPEOJ).click();//选择课程
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCEHINTACC).click();//确认
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESAVE).click();//保存
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        webDriver.sleep(1000);
        commonUtil.close(webDriver);
        webDriver.sleep(1000);
        switchToWindows(0);
        if (values.equals("保存修改成功！")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_21()throws Exception{
        boolean flag;
//        repeatName8="t10905605706";
        getOrderByPhone(repeatName8,"所有订单");
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath("(//a[contains(text(),'修改')])[3]").click();//点击修改
        switchToWindows(1);
        webDriver.sleep(6000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESCHOOL).sendKeys("学校");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLPAPER).click();//早报优惠
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLPROJECT).click();//项目优惠
        nextLine();
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCHANGESAVE).click();//保存
        webDriver.sleep(2000);
        String values = webDriver.elementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        webDriver.sleep(1000);
        commonUtil.close(webDriver);
        webDriver.sleep(1000);
        switchToWindows(0);
        if (values.equals("保存修改成功！")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_24(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(1000);
        String values = webDriver.elementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains("请选择支付方式")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_25(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(1000);
        String values = webDriver.elementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains("请输入合法的金额")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_26(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYNUM).sendKeys("0");//支付金额
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYPTHONE).sendKeys(commonUtil.getTel());//支付流水
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIME).click();//支付时间
        webDriver.sleep(3000);
        char[] enter = {'\uE007'};
        char[] LEFT = {'\uE012'};
        webDriver.keys(new String(LEFT));
        webDriver.keys(new String(enter));
//        webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIMEBTN).click();//此刻
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(1000);
        String values = webDriver.elementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains("请输入合法的金额")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_27(double num,String action)throws Exception{
        boolean flag;
//        repeatName8 = "t10307701318";
        getOrderByPhone(repeatName8,action);
        String beforePay = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYNUM).sendKeys(num+"");//支付金额
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYPTHONE).sendKeys(commonUtil.getTel());//支付流水
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIME).click();//支付时间
        webDriver.sleep(1000);
        char[] LEFT = {'\uE012'}; //选择前一天
        webDriver.keys(new String(LEFT));
        char[] enter = {'\uE007'};
        webDriver.keys(new String(enter));
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(2500);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        webDriver.sleep(2000);
        String afterPay = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
        System.out.print("----------="+beforePay+"=-----------------------------------="+afterPay+"=----------");
        System.out.print(beforePay.split("¥")[1]+"------------------1-");
        System.out.print(afterPay.split("¥")[1]+"------------------1-");
        Double beforePay1 =  Double.parseDouble(beforePay.split("¥")[1]);
        Double afterPay1 = Double.parseDouble(afterPay.split("¥")[1]);
        Double pay = beforePay1-afterPay1;
        System.out.print("----------=");
        System.out.print(pay);
        System.out.print("=----------");
        if (values.contains("保存成功")&&pay==-num){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_29(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYNUM).sendKeys("0.1");//支付金额
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYPTHONE).sendKeys("1111");//支付流水
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIME).click();//支付时间
        webDriver.sleep(2000);
        char[] enter = {'\uE007'};
        char[] LEFT = {'\uE012'};
        webDriver.keys(new String(LEFT));
        webDriver.keys(new String(enter));
        // webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIMEBTN).click();//此时
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains("支付流水重复")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_30(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        String beforePay = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERPAYED).getText();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYNUM).sendKeys("0.1");//支付金额
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYPTHONE).sendKeys(commonUtil.getTel());//支付流水
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIME).click();//支付时间
        webDriver.sleep(1000);
        char[] LEFT = {'\uE012'}; //选择前一天
        webDriver.keys(new String(LEFT));
        char[] enter = {'\uE007'};
        webDriver.keys(new String(enter));
        // webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIMEBTN).click();//此刻
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        String afterPay = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERPAYED).getText();
        System.out.print("----------="+beforePay+"=-----------------------------------="+afterPay+"=----------");
        if (values.contains("保存成功")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_38(double num)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,"所有订单");
       // getOrderByPhone("18811113333","未完成订单");//19901120003
        webDriver.sleep(2000);
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYALLORDERGETPAY).click();//点击支付
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTYPE).click();//支付方式
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYNUM).sendKeys(num+"");//支付金额
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYPTHONE).sendKeys(commonUtil.getTel());//支付流水
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIME).click();//支付时间
        webDriver.sleep(1000);
        char[] LEFT = {'\uE012'}; //选择前一天
        webDriver.keys(new String(LEFT));
        char[] enter = {'\uE007'};
        webDriver.keys(new String(enter));
        // webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERGETPAYTIMEBTN).click();//此刻
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGETPAYBTN).click();//点击支付框的确认
        webDriver.sleep(3000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.equals("保存成功")){
            flag =true;
        }else {
            flag=false;
        };
        return flag;
    }
    public boolean orderPay_40(String action,String hint,String BTN)throws Exception{
        boolean flag;
//        repeatName8="t10800550360";
        getOrderByPhone(repeatName8,"所有订单");
        webDriver.sleep(2000);
        if (BTN.equals("提交")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERCOMMIT).click();//提交
        }else if (BTN.equals("更多-取消")){
            webDriver.sleep(3000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORECON).click();
        }
        if (action.equals("确定")){
            webDriver.sleep(1000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_BTN).click();//确定
            webDriver.sleep(2000);
            String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
            System.out.print(values+"-------------------------------------");
            if (values.contains(hint)){
                flag =true;
            }else {
                flag=false;
            };
            webDriver.sleep(2000);
            if (hint.equals("订单已成功提交")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_DIS).click();
                webDriver.sleep(2000);
                String type = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
                System.out.print(type+"==============================");
                if (type.equals("待审核")){
                    flag=true;
                }else{
                    flag=false;
                }
            }
        }else {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_BTNTN).click();//取消
            webDriver.sleep(1000);
            try {
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_BTN).click();//确定
                flag = false;
            }catch (Exception e){
                flag =true;
            }
        }
        return flag;
    }
    public boolean orderPay_54()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERAUDITDETAILS).click();//详情
        switchToWindows(1);
        String window = webDriver.title();
        if (window.contains("订单详情")){
            flag=true;
        }else{
            flag=false;
        }
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_55()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        //webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        //nextLine();
        // webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("yijian");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(2000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
            flag =true;
        }catch (Exception E){
            flag=false;
        }
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_56()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(2000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
            flag =true;
        }catch (Exception E){
            flag=false;
        }
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_57()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("yijian");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(2000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
            flag =true;
        }catch (Exception E){
            flag=false;
        }
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_58()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("yijian");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(1000);
        String remark= getRemark(repeatName8);
        System.out.print(remark+"====================---------------------");
        if (remark.contains("yijian")){
            try{
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
                flag =true;
            }catch (Exception e){
                flag=false;
            }
        }else {
            flag=false;
        };
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_59()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("yijian");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITDIS).click();//取消
        webDriver.sleep(2000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
            flag =false;
        }catch (Exception E){
            flag=true;
        }
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }//如果关闭不能再次点击取消
    public boolean orderPay_60()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextTwoLines();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains("退回原因不能为空")){
            flag =true;
        }else {
            flag=false;
        };
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_61()throws Exception{
        boolean flag;
//        repeatName8="t10503984951";
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        webDriver.sleep(1000);
        switchToWindows(1);
        webDriver.sleep(3000);

        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextTwoLines();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBACKCAUSE).click();//退回原因
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        String remark= getRemark(repeatName8);
        System.out.print("========"+remark+"====================---------------------");
        if (remark.contains("注册表金额和订单金额不符合")){
            try{
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
                flag =true;
            }catch (Exception e){
                flag=false;
            }
        }else {
            flag=false;
        };
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_62()throws Exception{
        boolean flag;
//        repeatName8="t10900176419";
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextTwoLines();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBACKCAUSE).click();//退回原因
        nextLine();
        webDriver.execute("var x =document.getElementsByTagName('textarea');x[0].value = '';");
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("pls");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBTN).click();//确定
        webDriver.sleep(1000);
        String remark= getRemark(repeatName8);
        System.out.print(remark+"====================---------------------");
        if (remark.contains("pls")){
            try{
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校
                flag =true;
            }catch (Exception e){
                flag=false;
            }
        }else {
            flag=false;
        };
        webDriver.sleep(2000);
        commonUtil.close(webDriver);
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }
    public boolean orderPay_63()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextTwoLines();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITDIS).click();//取消
        webDriver.sleep(1000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校;
            flag =false;
        }catch (Exception e){
            flag=true;
        }
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }//如果关闭不能再次点击取消
    public boolean orderPay_64()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextTwoLines();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITBACKCAUSE).click();//退回原因
        nextLine();
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITDIS).click();//取消
        webDriver.sleep(1000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校;
            flag =false;
        }catch (Exception e){
            flag=true;
        }
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }//如果关闭不能再次点击取消
    public boolean orderPay_65()throws Exception{
        boolean flag;
        audit(repeatName8);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDIT).click();//审核
        switchToWindows(1);
        webDriver.sleep(3000);

        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITRESULT).click();//审核结果
        nextLine();
        webDriver.execute("var x =document.getElementsByTagName('textarea');x[0].value = '';");
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITIDEA).sendKeys("pls");//审核意见
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITDIS).click();//取消
        webDriver.sleep(1000);
        try{
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("yanzheng");//学校;
            flag =false;
        }catch (Exception e){
            flag=true;
        }
        webDriver.sleep(2000);
        switchToWindows(0);
        return flag;
    }//如果关闭不能再次点击取消
    public boolean orderPay_68(String action,String hint)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERPAYDIS).click();//取消
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERPAYDISBTN).click();//确定
        webDriver.sleep(3000);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        if (values.contains(hint)){
            flag=true;
        }else{
            flag =false;
        }
        return flag;
    }
    public boolean orderPay_69(String action)throws Exception{
        boolean flag;
        getOrderByPhone(repeatName8,action);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERPAYDIS).click();//取消
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERPAYDISDIS).click();//取消
        webDriver.sleep(1000);
        try {
            webDriver.elementByXPath(GaodunOrderPageUI.CLUE_ORDERPAYDISBTN).click();//确定
            flag = false;
        }catch (Exception e){
            flag =true;
        }
        return flag;
    }

    public boolean orderRefund_105(String action,String hint,String BTN,String num,String order)throws Exception {
        boolean flag = false;
//        repeatName8 = "t10202976801";
        getOrderByPhone(repeatName8, "所有订单");
        String type = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
        System.out.print(type+"==============================");
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();//更多
        webDriver.sleep(2000);
        if (action.equals(type)&&(type.equals("订金")||type.equals("未完款")||type.equals("已完款")||type.equals("待审核")||type.equals("审核退回")||type.equals("完成"))) {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUND).click();//退款
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDORDER).sendKeys(order );//退款账号
            if (!num.equals("")&&num!=null){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDMONEY).clearText();//退款金额

                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDMONEY).sendKeys(num);//退款金额
            }
            if (BTN.equals("保存")) {
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDSAVE).click();//保存
            } else if (BTN.equals("保存并提交审核")) {
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDSAVEANDCOMMIT).click();//保存并提交审核
                webDriver.sleep(2000);
                if (order!=""){
                    webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDSAVEANDCOMMITBTN).click();//保存并提交审核-确定
                }
            } else {
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUNDDIS).click();//取消
            }
            webDriver.sleep(1000);

            if (BTN.equals("取消")) {
                try {
                    webDriver.sleep(2000);
                    webDriver.elementByXPath(GaodunOrderPageUI.ORDER_REFUNDSAVE).click();//保存
                } catch (Exception e) {
                    flag = true;
                }
            }else {
                String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
                System.out.print(values + "-------------------------------------");
                if (values.equals(hint)) {
                    flag = true;
                }
            }
        }
        else  if (action.equals(type)&&type.equals("未付款")){
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_REFUND).click();//退款
            String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
            System.out.print(values + "-------------------------------------");
            if (values.equals(hint)) {
                flag = true;
            }
        }
        return flag;
    };
    public boolean orderAbnormal_124(String action,String change)throws Exception {
        boolean flag = false;
//        repeatName8 = "t12701695646";
        getOrderByPhone(repeatName8, "所有订单");
        String type = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
        System.out.print(type+"==============================");
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();//更多
        webDriver.sleep(2000);
        if (action.equals(type)&&(type.equals("待审核")||type.equals("完成"))) {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_EXCEPT).click();
            switchToWindows(1);
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_EXCEPTTYPE).click();//订单状态
            webDriver.sleep(1000);
            if (change.equals("待审核")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPE1).click();//审核
            }else if (change.equals("已完款")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPE2).click();//已完款
            }else if (change.equals("未完款")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPE3).click();//未完款
            }else if (change.equals("审核退回")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPE4).click();//审核退回
            }else if (change.equals("完成")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPE5).click();//完成
            }
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_AUDITSCHOOL).sendKeys("xuexiao");//学校
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_SAVE).click();
            webDriver.sleep(2000);
            String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
            System.out.print(values+"----------========-----------------");
            webDriver.sleep(2000);
            commonUtil.close(webDriver);
            webDriver.sleep(2000);
            switchToWindows(0);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_TYPESEARCH).click();//搜索
            webDriver.sleep(2000);
            String typeAfterChange = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
            System.out.print(typeAfterChange+"==============================");
            if (values.equals("保存修改成功！")&&typeAfterChange.equals(change)){
                flag =true;
            }else {
                flag=false;
            };
        }
        return flag;
    };
    public  boolean orderRecommend(String author,String timeOut)throws Exception{
        boolean flag = false;
//        repeatName8 = "t12701695646";
        getOrderByPhone(repeatName8, "所有订单");
        String type = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
        System.out.print(type+"==============================");
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();//更多
        webDriver.sleep(2000);
        if (type.equals("完成")) {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_RECOMMEND).click();//推荐
            if (timeOut.equals("是")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_RECOMMENDYES).click();//是
            }else if (timeOut.equals("否")){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_RECOMMENDNO).click();//否

            }
            if (author!=""){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_RECOMMENDAUTHOR).sendKeys(author);//推荐人
            }
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_RECOMMENDSAVE).click();//保存
            webDriver.sleep(2000);
            String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
            System.out.print(values+"----------========-----------------");
            webDriver.sleep(2000);
            String typeAfterChange = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_MYORDERALPAY).getText();
            System.out.print(typeAfterChange+"==============================");
            if (values.equals("推荐认定成功！")){
                flag =true;
            }else {
                flag=false;
            };
        }
        return flag;
    }






    public void switchToWindows(int num)throws Exception{
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String      str1 =  (String) obj.get(num);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);
    }//切换窗口

    public  void  nextLine() throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }//选择下一行
    public  void  nextTwoLines() throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }//选择下两行
    public void getOrderByPhone(String tel,String action)throws Exception{
        webDriver.get(Config.cmsOrderUrl);
        webDriver.sleep(2000);
        commonUtil.refresh(webDriver);;
//        webDriver.sleep(2000);
//        webDriver.waitForElementById(GaodunOrderPageUI.CLUE_MYORDER  ).click();//我的订单
        webDriver.sleep(1000);
        if (action.equals("我的定金")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAY).click();//我的定金
        }else if (action.equals("未完成订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERNOTACC).click();//未完成订单
        }else if (action.equals("所有订单")){

            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALL).click();
        }else if (action.equals("退回订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERBACK).click();
        }
        webDriver.sleep(2000);
        if (action.equals("所有订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLSEARCH).sendKeys(tel);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ALLORDERSEARCHBYNAME).click();
            // webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLSEARCHPHONE).click();//点击联系方式
            webDriver.sleep(2000);
            //webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERFRIST).click();//选择第一个
        }else {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).click();//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).clearText();//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).sendKeys(tel);//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERSEARCHBYNAME).click();
//            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGET).click();//点击联系方式
            webDriver.sleep(2000);
            //webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERFRIST).click();//选择第一个
        }
    }//通过手机号查询勾选中第一个
    public  void audit(String name)throws Exception{
        commonUtil.refresh(webDriver);;
        webDriver.get(Config.cmsCluesUrl);
        webDriver.sleep(1000);
        webDriver.waitForElementById(GaodunOrderPageUI.CLUE_MYORDER  ).click();//我的订单
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERAUDIT).click();//订单审核
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERAUDITWAIT).click();//待审核
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERAUDITSEARCH).sendKeys(name);//搜索
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERSEARCHBYNAME).click();
//        webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ORDERAUDITSEARCHBYPHONE).click();//通过手机号搜索
    }//审核通过手机号查找

//    public  void clear()throws Exception{
//        webDriver.sleep(1000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        webDriver.sleep(2000);
//        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//        webDriver.sleep(1000);
//    }//清空
    public String getRemark(String name) throws Exception{
        String sql = "SELECT ORW.Remark FROM crm_order_center.Student_Info SI JOIN crm_order_center.Order_Clue_Custom_Student_Relation OCCSR ON SI.StudentGuid = OCCSR.StudentGuid JOIN crm_order_center.Order_Review ORW ON OCCSR.OrderNo = ORW.OrderNo WHERE SI.TrueName = '"+name+"' AND ORW.Create_Time > date_add(NOW(), interval -20 minute);";
        ResultSet su = testDao.query(sql);
        System.out.print("========="+sql+"============================================");
        webDriver.sleep(2000);
        su.last();
        String remark = su.getString("Remark");
        return remark;
    }//获取审核意见




    //订单分单 status 为 0 是，打开后直接保存，status 为1 是打开后直接取消，status 为 3 点击+保存
    //status 为4 是 点击+号后选择本人，status 为5 是点击+号后 选择本人，输入比例点击保存，status 为6 为大于100
    //status为7 输入特殊字符 status 为 8 正常保存
    public boolean  orderSplit(int status,int isFresh) throws Exception {
        boolean flag = false;
        if(isFresh == 0 ){
            getOrderByName(normalOrderName,"所有订单",isFresh);
        }
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();//更多
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_SPLIT_BTN).click();
        if(status != 0 &&  status != 1 ){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.ADD_SPLIT_BTN).click();
            if(status == 4 || status == 5){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_PERSION).click();
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CHOOSE_SPLIT_MYSEFT).click();
            }
            if(status == 6 || status == 7 || status == 8){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_PERSION).click();
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CHOOSE_SPLIT_GROUP).click();
                webDriver.waitForElementByXPath(GaodunOrderPageUI.CHOOSE_SPLIT_PERSON).click();
            }
            if(status != 4 && status != 3){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_RATIO).click();
                commonUtil.clear(webDriver);
            }
            if(status == 5 || status == 8){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_RATIO).sendKeys("20");
            }else if(status == 6){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_RATIO).sendKeys("105");
            }else if(status == 7){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_RATIO).sendKeys("#$$");
            }
        }
        if(status == 1 ){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CANCEL_SPLIT_BTN).click();
            webDriver.sleep(2000);
            Element el =  webDriver.elementByXPath(GaodunOrderPageUI.ORDER_MORE);
            if(el != null){
                return  true;
            }
        }else {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.SAVE_SPLIT_BTN).click();
        }
        if(status == 0 || status == 5 || status == 8){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.SPLIT_SURE_BTN).click();
        }
        webDriver.sleep(500);
        String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        webDriver.sleep(1000);

        if((status==0 || status == 8) && values.equals("分单已保存")){
            flag = true;
        }else if(status == 3 && values.equals("分单销售不能为空!")){
            flag = true;
        }else if(status == 4 && values.equals("分单比例必须大于0!")){
            flag = true;
        }else if(status == 5 && values.equals("分单销售不能重复.")){
            flag = true;
        }else if(status == 6 && values.equals("分单销售不能重复.")){
            flag = true;
        }else if(status == 7 && values.equals("比例数字必须为数字，可精确到两位小数，最大值为100%")){
            flag = true;
        }
        return  flag;
    }
    // i 为 0 刷新页面，i为 1 不刷新页面
    public void getOrderByName(String tel,String action,int i)throws Exception{
        if(i == 0){
            commonUtil.refresh(webDriver);
            webDriver.get(Config.cmsOrderUrl);
         /*   webDriver.sleep(2000);
            webDriver.waitForElementById(GaodunOrderPageUI.CLUE_MYORDER).click();//我的订单*/
            webDriver.sleep(1000);
        }

        if (action.equals("我的定金")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAY).click();//我的定金
        }else if (action.equals("未完成订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERNOTACC).click();//未完成订单
        }else if (action.equals("所有订单")){

            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALL).click();
        }else if (action.equals("退回订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERBACK).click();
        }
        webDriver.sleep(2000);
        if (action.equals("所有订单")){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLSEARCH).sendKeys(tel);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_ALLORDERSEARCHBYNAME).click();
            // webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERALLSEARCHPHONE).click();//点击联系方式
            webDriver.sleep(2000);
            //webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERFRIST).click();//选择第一个
        }else {
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).click();//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).clearText();//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERPAYSERACH).sendKeys(tel);//搜索框
            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERSEARCHBYNAME).click();
//            webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERGET).click();//点击联系方式
            webDriver.sleep(2000);
            //webDriver.waitForElementByXPath(GaodunOrderPageUI.CLUE_MYORDERFRIST).click();//选择第一个
        }
    }//通过手机号查询勾选中第一个
    //订单奖励  status 为0 直接点击保存，status 为1 直接关闭，status 为2 物品奖励 正常保存
    //status 为3 物品奖励，重复保存，status 为4 现金奖励，奖励内容输入汉字
    //status 为5 现金奖励，奖励内容输入数字保持成功，status 为6 点击清空
    public  boolean  orderAward(int status) throws Exception{
        boolean flag = false;
        getOrderByName(normalOrderName,"所有订单",0);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_MORE).click();//更多
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunOrderPageUI.ORDER_AWARD).click();
        if(status != 0 && status !=1){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_SENDTIME).click();
            commonUtil.rightLine(webDriver);
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_STATUS).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_ALREADY_GRANT).click();
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_STYLE).click();
            if (status == 4 || status == 5){
                commonUtil.nextLine(webDriver);
            }else {
                commonUtil.nextOneLine(webDriver);
            }
            if(status == 4){
                webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_INPUT).sendKeys("汉字");
            }else{
                webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_INPUT).sendKeys("324234");
            }
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_REMARKS).sendKeys("备注");
        }

        if(status !=1  &&  status  != 6){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_SAVE).click();
            webDriver.sleep(500);
            String values = webDriver.waitForElementByCss(GaodunOrderPageUI.CLUE_RELEVANCEHINT).getText();//提示信息
            webDriver.sleep(1000);

            if((status==2 || status == 5) && values.equals("添加订单奖励成功")){
                flag = true;
            }else if(status == 3 && values.equals("添加奖励信息异常:同类型奖励不能重复添加！")){
                flag = true;
            }else if(status == 4 && values.equals("添加奖励信息异常:奖励现金类型请填写数字")){
                flag = true;
            }else if(status == 0  && values.equals("请填写完奖励信息")){
                flag = true;
            }

        }else if(status == 1){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_CANCLE).click();
            flag = true;
        }else if(status == 6){
            webDriver.waitForElementByXPath(GaodunOrderPageUI.AWARD_CLEAR).click();
            flag = true;
        }
        return  flag;
    }
}
