package com.javademo.pages;
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
            //彩信名称
            webDriver.waitForElementByXPath(gaodunMarketPageUI.MMS_NAME).sendKeys(msgName);
            //申请原因
            webDriver.waitForElementByXPath(GaodunMarketPageUI.MMS_RAESON).sendKeys("111");
            webDriver.waitForElementByXPath(GaodunMarketPageUI.MMS_SCREEN).click();//添加新分屏
            //文字内容
            webDriver.waitForElementByXPath(GaodunMarketPageUI.MMS_WORD).sendKeys("111");
            webDriver.waitForElementByXPath(GaodunMarketPageUI.MMS_CONFIRM).click();//确定
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunMarketPageUI.MMS_SAVE).click();//保存
            webDriver.sleep(1000);
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
       webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGE_NAME).sendKeys(MessageName);//模板标题
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGE_WORD).sendKeys("222");//短信内容
        webDriver.waitForElementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='营销短信任务列表'])[1]/following::div[2]").click();
        //页面下滑
        commonUtil.pageEnd(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGE_APPLICATION).sendKeys("222");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGE_DOWN).click();//点击出来

        webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGE_SAVE).click();//保存
        webDriver.sleep(1000);
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
        //名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).sendKeys(marketAct);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PRICIPAL).click();//负责人
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PRICIPAL1).click();//自动化专用
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PRICIPAL2).click();//8
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).click();//点出来点到名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROJECT).sendKeys("毕马威");//所属项目
        commonUtil.nextOneLine(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME).click();//点出来点到名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROVINCE).click();//省
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROVINCE1).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CITY).click();//市
        commonUtil.nextLine(webDriver);
        //讲师
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TEACHER).sendKeys("dd");
        //课时
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CLASSTIME).sendKeys("4");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME).click();//活动时间
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME1).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME2).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CONFIRM).click();//确定
        //学校
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SCHOOL).sendKeys("ee");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.BUDGET).sendKeys("4");//预算金额
        webDriver.waitForElementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='营销短信任务列表'])[1]/following::div[2]").click();
        commonUtil.nextLine(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTYPE).click();//活动类型
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TV).click();//图书
        //说明
        webDriver.waitForElementByXPath(GaodunMarketPageUI.STATMENT).sendKeys("sssss");
        //活动主页
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYPAGE).sendKeys("ssssss");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYSAVE).click();//立即提交
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        System.out.println(values+"===========================");
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
        webDriver.get(Config.marketList);
        commonUtil.refresh(webDriver);
        webDriver.sleep(3000);
        System.out.println(marketAct+"=============================");
        webDriver.waitForElementByXPath (GaodunMarketPageUI.INPUT).sendKeys(marketAct);//输入活动名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SEARCH).click();//查询
       webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.DATALINE).click();//修改
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//名称
        commonUtil.clear(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).sendKeys(modifyName);//修改为
        webDriver.waitForElementByXPath(GaodunMarketPageUI.DELPRINCIPAL).click();//删除原有负责人
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CLICKPRICIPAL).click();//点击负责人
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PRICIPAL1_4).click();//+号
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PRICIPAL2_4).click();//选择负责人
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//点回名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROJECT4).click();//删原所属项目
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROJECT1_4).sendKeys("阿米巴");//点
        commonUtil.nextOneLine(webDriver);//选
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITY_NAME4).click();//点回名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.PROVINCE4).click();//省
        commonUtil.nextLine(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CITY4).click();//市
        commonUtil.nextLine(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TEACHER4).click();//讲师
        commonUtil.clear(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TEACHER4).sendKeys("5555");
        //课时
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CLASSTIME4).sendKeys("6");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME_4).click();//活动时间
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME1_4).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTIME2_4).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.CONFIRM4).click();//确定
        //学校
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SCHOOL4).sendKeys("dd");
        commonUtil.nextLine(webDriver);//预算金额
        webDriver.waitForElementByXPath(GaodunMarketPageUI.BUGET4).sendKeys("6");
        webDriver.waitForElementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='营销短信任务列表'])[1]/following::div[2]").click();
        commonUtil.pageEnd(webDriver);//下滑
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYTYPE4).click();//活动类型
        commonUtil.nextLine(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.IFSHOW).click();//是否显示
        //说明
        webDriver.waitForElementByXPath(GaodunMarketPageUI.STATMENT4).click();//活动主页
        commonUtil.clear(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.STATMENT4).sendKeys("修改营销活动");//活动主页
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYPAGE4).click();
        commonUtil.clear(webDriver);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYPAGE4).sendKeys("hhhhhhh");
        webDriver.waitForElementByXPath(GaodunMarketPageUI.ACTIVITYSAVE4).click();//保存
        webDriver.sleep(1000);
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
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SENDMESSAGE).click();//发短信给第一行
        //任务名称
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TASKNAME).sendKeys(messageName);
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SELECTMEESAGE).click();//选择短信 第一条
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SENDTIME).click();//发送时间
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SELECTTIME).click();
        webDriver.waitForElementByXPath(GaodunMarketPageUI.TIMECONFIRM).click();//确定
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MESSAGESAVE).click();//保存
        webDriver.sleep(1000);
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
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SENDMMS).click();//发彩信给第一行
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SELECTMMS).click();//选择模板 第一条
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MMSSENDTIME).click();//点击发送时间
        webDriver.waitForElementByXPath(GaodunMarketPageUI.SELECTMMSTIME).click();//选择时间
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MMSCONFIRM).click();//确定
        webDriver.waitForElementByXPath(GaodunMarketPageUI.MMSSAVE).click();//发送
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunMarketPageUI.MARKET_TIP).getText();//提示信息
        if (values.contains("发送成功")){
            flag =true;
        }else {
            flag=false;
        }
            return flag;
    }
}



