package com.javademo.pages;
import com.javademo.pages.BasePages;
import com.javademo.pageuis.GaodunMarketPageUI;
import com.javademo.utils.CommonUtil;
import com.javademo.utils.Config;

public class GaodunMarketPage extends BasePages {
    public GaodunMarketPage(String pageDesc) {
        super(pageDesc);
    }
    GaodunMarketPageUI gaodunMarketPageUI =new GaodunMarketPageUI();
    CommonUtil commonUtil=new CommonUtil();
        //1新建彩信模板
        public boolean addMms() throws Exception{
            boolean flag=false;
            webDriver.get(Config.addMms);
            String msgName = "test彩信"+commonUtil.getTel();
            webDriver.sleep(3000);
            webDriver.elementByXPath(gaodunMarketPageUI.MMS_NAME).click();//彩信名称
            webDriver.elementByXPath(gaodunMarketPageUI.MMS_NAME).clearText();
            webDriver.elementByXPath(gaodunMarketPageUI.MMS_NAME).sendKeys(msgName);
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_RAESON).click();//申请原因
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_RAESON).clearText();
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_RAESON).sendKeys("111");
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_SCREEN).click();//添加新分屏
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_WORD).click();//文字内容
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_WORD).clearText();
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_WORD).sendKeys("111");
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_CONFIRM).click();//确定
            webDriver.sleep(3000);
            webDriver.elementByXPath(GaodunMarketPageUI.MMS_SAVE).click();//保存
            String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
            if (values.contains("创建彩信模板成功")){
                flag =true;
            }else
                flag=false;

            return flag;

        }

        //2新建短信模板
    public boolean addMessage() throws Exception{
        boolean flag = false;
        String MessageName = "test短信"+commonUtil.getTel();
        webDriver.get(Config.addMessage);
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_NAME).click();//模板标题
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_NAME).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_NAME).sendKeys(MessageName);
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_WORD).click();//短信内容
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_WORD).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_WORD).sendKeys("222");
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_APPLICATION).click();//申请说明
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_APPLICATION).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_APPLICATION).sendKeys("222");
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_DOWN).click();//点击出来
        //页面下滑
        commonUtil.pageEnd(webDriver);
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGE_SAVE).click();//保存
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("保存成功")){
            flag =true;
        }else {
            flag=false;
        }
        return flag;

    }


    //3新建市场营销活动
    String marketAct ="";
    public boolean addMarketactivity() throws Exception {
            boolean flag=false;
         marketAct = "测试营销"+commonUtil.getTel();
        commonUtil.refresh(webDriver);
            webDriver.get(Config.addMarketactivity);
            webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).click();//名称
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).sendKeys(marketAct);
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.PRICIPAL).click();//负责人
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.PRICIPAL1).click();//自动化专用
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.PRICIPAL2).click();//8
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).click();//点出来点到名称
        webDriver.elementByXPath(GaodunMarketPageUI.PROJECT).click();//所属项目
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.PROJECT1).click();//中级职称
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).click();//点出来点到名称
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.PROVINCE).click();//省
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.PROVINCE1).click();
        webDriver.elementByXPath(GaodunMarketPageUI.CITY).click();//市
        webDriver.sleep(2000);
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.TEACHER).click();//讲师
        webDriver.elementByXPath(GaodunMarketPageUI.TEACHER).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.TEACHER).sendKeys("dd");
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME).click();//课时
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME).sendKeys("4");
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME).click();//活动时间
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME1).click();
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME2).click();
        webDriver.elementByXPath(GaodunMarketPageUI.CONFIRM).click();//确定
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL).click();//学校
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL).sendKeys("ee");
        webDriver.sleep(3000);
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.BUGET).click();//预算金额
        webDriver.elementByXPath(GaodunMarketPageUI.BUGET).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.BUGET).sendKeys("4");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTYPE).click();//活动类型
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.TV).click();//图书
        webDriver.sleep(3000);
        commonUtil.pageEnd(webDriver);//下滑
        webDriver.sleep(5000);
        webDriver.elementByXPath(GaodunMarketPageUI.STATMENT).click();//说明
        webDriver.elementByXPath(GaodunMarketPageUI.STATMENT).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.STATMENT).sendKeys("sssss");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE).click();//活动主页
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE).sendKeys("ssssss");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYSAVE).click();//立即提交

        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("新增成功")){
            flag =true;
        }else
            flag=false;

           return flag;

    }


    //4修改市场营销活动
    public boolean modifyActivity() throws Exception {
        String  modifyName="修改营销"+commonUtil.getTel();
            boolean flag=false;
        webDriver.sleep(3000);
        webDriver.get(Config.marketList);
         commonUtil.refresh(webDriver);
        webDriver.sleep(5000);
        webDriver.elementByXPath (GaodunMarketPageUI.INPUT).sendKeys(marketAct);//输入活动名称
        webDriver.elementByXPath(GaodunMarketPageUI.SEARCH).click();//查询
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.DATALINE).click();//修改
        webDriver.sleep(5000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//名称
        commonUtil.clear(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).sendKeys(modifyName);//修改为
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.DELPRINCIPAL).click();//删除原有负责人
        webDriver.elementByXPath(GaodunMarketPageUI.CLICKPRICIPAL).click();//点击负责人
        webDriver.elementByXPath(GaodunMarketPageUI.PRICIPAL1_4).click();//+号
        webDriver.sleep(5000);
        webDriver.elementByXPath(GaodunMarketPageUI.PRICIPAL2_4).click();//选择负责人
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//点回名称
        webDriver.elementByXPath(GaodunMarketPageUI.PROJECT4).click();//删原所属项目
        webDriver.elementByXPath(GaodunMarketPageUI.PROJECT1_4).click();//点
        webDriver.sleep(3000);
        commonUtil.nextLine(webDriver);//选
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//点回名称
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.PROVINCE4).click();//省
        commonUtil.nextLine(webDriver);
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.CITY4).click();//市
        webDriver.sleep(2000);
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.TEACHER4).click();//讲师
        commonUtil.clear(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.TEACHER4).sendKeys("5555");
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME4).click();//课时
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME4).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.CLASSTIME4).sendKeys("6");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME_4).click();//活动时间
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME1_4).click();
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTIME2_4).click();
        webDriver.elementByXPath(GaodunMarketPageUI.CONFIRM4).click();//确定
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL4).click();//学校
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL4).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.SCHOOL4).sendKeys("dd");
        webDriver.sleep(3000);
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.BUGET4).clearText();//预算金额
        webDriver.elementByXPath(GaodunMarketPageUI.BUGET4).sendKeys("6");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYTYPE4).click();//活动类型
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunMarketPageUI.IFSHOW).click();//是否显示
        commonUtil.pageEnd(webDriver);//下滑
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.STATMENT4).clearText();//说明
        webDriver.elementByXPath(GaodunMarketPageUI.STATMENT4).sendKeys("修改营销活动");
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE4).click();//活动主页
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE4).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYPAGE4).sendKeys("hhhhhhh");
        webDriver.elementByXPath(GaodunMarketPageUI.ACTIVITYSAVE4).click();//保存
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("修改成功")){
            flag =true;
        }else {
            flag=false;
        }
            return  flag;

    }

    //5发短信
    public boolean sendMessage() throws Exception {
        String messageName="短信任务名称"+commonUtil.getTel();
        boolean flag=false;
        webDriver.get(Config.marketList);
        commonUtil.refresh(webDriver);
            webDriver.sleep(5000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SENDMESSAGE).click();//发短信给第一行
        webDriver.elementByXPath(GaodunMarketPageUI.TASKNAME).click();//任务名称
        webDriver.elementByXPath(GaodunMarketPageUI.TASKNAME).clearText();
        webDriver.elementByXPath(GaodunMarketPageUI.TASKNAME).sendKeys(messageName);
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.SELECTMEESAGE).click();//选择短信 第一条
        webDriver.elementByXPath(GaodunMarketPageUI.SENDTIME).click();//发送时间
        webDriver.sleep(5000);
        webDriver.elementByXPath(GaodunMarketPageUI.SELECTTIME).click();
        webDriver.elementByXPath(GaodunMarketPageUI.TIMECONFIRM).click();//确定
        webDriver.elementByXPath(GaodunMarketPageUI.MESSAGESAVE).click();//保存
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("保存成功")){
            flag =true;
        }else {
            flag=false;
        }
            return flag;


    }

    //6发彩信
    public  boolean sendMms() throws Exception {
            boolean flag=false;
        webDriver.get(Config.marketList);
        commonUtil.refresh(webDriver);
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.SENDMMS).click();//发彩信给第一行
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunMarketPageUI.SELECTMMS).click();//选择模板 第一条
        webDriver.elementByXPath(GaodunMarketPageUI.MMSSENDTIME).click();//点击发送时间
        webDriver.sleep(5000);
        webDriver.elementByXPath(GaodunMarketPageUI.SELECTMMSTIME).click();//选择时间
        webDriver.elementByXPath(GaodunMarketPageUI.MMSCONFIRM).click();//确定
        webDriver.elementByXPath(GaodunMarketPageUI.MMSSAVE).click();//发送
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("发送成功")){
            flag =true;
        }else {
            flag=false;
        }
            return flag;

    }
    }



