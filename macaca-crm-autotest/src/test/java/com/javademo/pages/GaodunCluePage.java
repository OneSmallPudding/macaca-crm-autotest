package com.javademo.pages;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javademo.dao.TestDao;
import com.javademo.pageuis.GaodunCluePageUI;
import com.javademo.utils.CommonUtil;
import com.javademo.utils.Config;
import com.sun.jmx.snmp.InetAddressAcl;
import com.sun.nio.sctp.PeerAddressChangeNotification;

import macaca.client.commands.Element;
import macaca.client.commands.Url;
import macaca.client.common.MacacaDriver;
import org.bytedeco.javacpp.presets.opencv_core;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.Date;

public class GaodunCluePage extends BasePages {
    CommonUtil commonUtil = new CommonUtil();
    private Robot robot;
    public GaodunCluePage(String pageDesc) {
        super(pageDesc);
    }
    TestDao testDao     = new   TestDao();
    String repeatTel1;//测试数据1 -单一项目
    String repeatTel2;//测试数据2 -单一项目
    String repeatTelACCA;

    public void addTest(String tel,String project,String action) throws Exception{
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(5000);
        addClueRequire(project);
        addClueCommunication(tel);
        addClueAction(action);
    };
    public void addTest() throws Exception{
        repeatTel1 = commonUtil.getTel();//测试数据1 -单一项目
        repeatTel2 = commonUtil.getTel();//测试数据2 -单一项目
        repeatTelACCA = commonUtil.getTel();//测试数据3 -单一ACCA项目
        System.out.print(repeatTel1+"repeatTel1===================");
        System.out.print(repeatTel2+"repeatTel2===========================");
        System.out.print(repeatTelACCA+"repeatTelACCA");
        addTest(repeatTel1,"毕马威","确认");
        addTest(repeatTel2,"毕马威","确认");
        addTest(repeatTelACCA,"阿米巴","确认");
    }
    public  boolean addClue()  throws  Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(0).sendKeys("汪蕾");// 姓名
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_LAB).get(2).click();// 性别
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).click();// 感兴趣项目
        nextLine();
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_PHONE).sendKeys(commonUtil.getTel());// 手机号
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(3).click();// 国际电话
       nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(4).sendKeys(commonUtil.getTel());// 国际电话
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(5).sendKeys(commonUtil.getTel());// QQ
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(6).sendKeys(commonUtil.getTel());// 微信
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(7).sendKeys(commonUtil.getTel()+"@qq.com");// 私人邮箱
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(8).click();// 职业状态
        nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(9).click();// 省市
        nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(10).click();// 省市
        nextLine();
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_SOURCE).click();// 客户来源
        nextLine();
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_NOTES).sendKeys("1881234123418812341234");// 备注
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(0).click();// 确认自动分配
        // webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(1).click();// 保存不自动分配
        webDriver.sleep(2000);
        JSONObject object =   webDriver.execute("var x = document.getElementsByClassName('el-input__inner');return x[0].value;");
        String name  = (String) object.get("value");
        System.out.println("============================"+name);
        if(name.equals("") || name == null){
            flag = true;
        }
        return flag;
    };
    public  boolean addClue_xsgl_1(String action)  throws  Exception {
        boolean flag = true;
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        String repeatTel=commonUtil.getTel();
        addClueCommunication(repeatTel);
        addClueAction(action);
        webDriver.sleep(2000);
        String phone  = getPthonByJs();
        if(phone.equals("") || phone == null){
            flag = false;
        }
        System.out.print("====================================================="+phone);
        System.out.print("====================================================="+repeatTel);
        commonUtil.refresh(webDriver);;
        return flag;
    };
    public  boolean addClue_xsgl_2(String action)  throws  Exception {
        boolean flag = true;
        webDriver.maximize().get(Config.cmsCommentUrl);
        addClueRequire("毕马威");
        addClueAction(action);
        webDriver.sleep(2000);
        String name = getNameByJs();
        if(name.equals("") || name == null){
            flag = false;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    };
    public  boolean addClue_xsgl_3(String action,String tel)  throws  Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        addClueRequire("毕马威");
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_PHONE).sendKeys(tel);// 手机号
        addClueAction(action);
        webDriver.sleep(2000);
        String name  = getNameByJs();
        System.out.print("====================================================="+name);
        if(name.equals("") || name == null){
            flag = true;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    };
    public  boolean addClue_xsgl_4(String action,String tel)  throws  Exception {
        boolean flag = true;
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        addClueRequire("毕马威");
        addClueCommunication(tel);
        addClueAction(action);
        webDriver.sleep(2000);
        String phone  = getPthonByJs();
        System.out.print("====================================================="+tel);
        int count = getRestart(tel);
        webDriver.sleep(1000);
        System.out.print("====================================================="+count);
        if(phone.equals("") || phone == null||count ==0){
            flag = false;
        };
        commonUtil.refresh(webDriver);;
        return flag;
    };
    public  boolean addClue_xsgl_5(String action,String tel)  throws  Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        addClueRequire("阿米巴");
        addClueCommunication(tel);
        addClueAction(action);
        webDriver.sleep(2000);
        String phone  = getPthonByJs();
        System.out.print(phone+"===============================");
        if(phone.equals("") || phone == null){
            flag = true;
        }
        return flag;
    };
    public  boolean addClue_xsgl_11()  throws  Exception {
        boolean flag = false;
        webDriver.get(Config.cmsCluesUrl);
        webDriver.sleep(1000);
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(2000);
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_ADD).click();//新增客户
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String      str1 =  (String) obj.get(1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);
        try {
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(2).click();// 关闭
            flag = true;
        }catch (Exception e){
        }
        return flag;
    }; //关闭
    public boolean queryOwner_xsgl_12() throws  Exception{
        boolean flag ;
        //切回window
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String      str1 =  (String) obj.get(0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);

        searchPthone(repeatTel1);
        webDriver.sleep(1000);
        try {
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    };// 根据是否可以勾选
    public boolean queryOwner_xsgl_13() throws  Exception{
        boolean flag ;
//        String repeatTel13 = "10505973503";//crm项目别人名下的手机号，最后写入config
        searchPthone(Config.repeatTel13);
        webDriver.sleep(1000);
        try {
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    };// 根据是否可以勾选
    public boolean queryOwner_xsgl_14() throws  Exception{
        boolean flag;
        String  repeatTel14=commonUtil.getTelNotFound();
        searchPthone(repeatTel14);
        webDriver.sleep(1000);
        try {
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag = false;
        }catch (Exception e){
            flag = true;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    };//
    public boolean backPoll_xsgl_15() throws  Exception{
        boolean flag = false;
        searchByPthone(repeatTel1);
        webDriver.sleep(1000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(9).click();//踢回公池
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(2000);
        String user = webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BELONGERS).get(1).getText();
        System.out.print(user+"===============================");
        if(user.contains("客户池")){
            flag = true;
            commonUtil.refresh(webDriver);
        };
        commonUtil.refresh(webDriver);;
        return flag;
    }; //只踢回第一条数据
    public boolean backPoll_xsgl_16() throws  Exception{
        boolean flag = false;
        searchByPthone(repeatTel2);
        webDriver.sleep(2000);
        webDriver.elementByLinkText("跟进").click();//跟进
        webDriver.sleep(1000);
        webDriver.acceptAlert().elementByXPath(GaodunCluePageUI.CLUE_CHAT).sendKeys("沟通");//踢回公池
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SETBACK).click();//踢回公池
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(1000);
        String user = webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BELONGERS).get(1).getText();
        System.out.print(user+"===============================");

        if(user.contains("客户池")){
                flag = true;
        };
        commonUtil.refresh(webDriver);;
        return flag;
    }; //只踢回第一条数据
    public boolean receive_xsgl_17() throws  Exception{
        boolean flag = false;
        getBackByPthone(repeatTel1);
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GET).click();//领取
        webDriver.sleep(1000);
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_CLOSEWINDOWS).click();;//关闭弹窗
        webDriver.sleep(3000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).sendKeys(repeatTel1);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(2000);
        String user = webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BELONGERS).get(1).getText();
        System.out.println("====="+user+"=====");
        if(user.equals("管理员")){
                flag = true;
            };
        commonUtil.refresh(webDriver);;
        return flag;
    }; //只领取出来的第一条
    public boolean receive_xsgl_18() throws  Exception{
        boolean flag = false;
        getBackByPthone(repeatTel1);
        webDriver.sleep(2000);
        try{
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_GET).click();//领取
        } catch (Exception e){
            flag = true;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    }; //只管第一条
    public boolean relevance_xsgl_19() throws  Exception{
        boolean flag = false;
       searchByPthone(repeatTel1);
        //       searchByPthone("10606992007");
        String SQL = "SELECT Tpo_Base_SourceDetails.FullName FROM crm_base.Tpo_Base_SourceDetails WHERE CreateTime>DATE_FORMAT( date_add( curdate( ), INTERVAL - 3 MONTH ), '%Y-%m-%d 23:59:59' ) ORDER BY CreateTime DESC;";
        String  project =searchPlan(SQL);
        String[] projectList=project.split("=");
        String  project1=projectList[0];
        String  project2=projectList[1];
        if (!project1.equals("")||!project2.equals("")){
            flag =true;
        }
        return flag;
    };
    public boolean relevance_xsgl_20() throws  Exception{
        boolean flag = false;
       searchByPthone(repeatTel2);
        //      searchByPthone("10508832589");
        //  searchByPthone("18812341234");
        String SQL = "SELECT Tpo_Base_SourceDetails.FullName FROM crm_base.Tpo_Base_SourceDetails WHERE CreateTime<DATE_FORMAT( date_add( curdate( ), INTERVAL - 3 MONTH ), '%Y-%m-%d 23:59:59' ) ORDER BY CreateTime DESC;";
        String  project =searchPlan(SQL);
        String[] projectList=project.split("=");
        String  project1=projectList[0];
        String  project2=projectList[1];
        if (!project1.equals("")&&project2.equals("不可以显示")){
            flag =true;
        }
        return flag;
    };
    public boolean addLabel_xsgl_21() throws Exception{
        boolean flag = false;
        searchByPthone(repeatTel1);// 备用 18811113333
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_ADDLABEL).click();//添加标签
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_ALERTCLK).click();//点击框
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_ALERTXM).click();//勾选小马学长标签
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_ALERTADD).click();//添加按钮
        webDriver.sleep(1000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(1000);
        String labels = webDriver.elementByXPath(GaodunCluePageUI.CLUE_LISTLABEL).getText();//获取列表页里面关联标签内容
        if (!labels.equals("")){
            flag=true;
        }
        return flag;
    }//添加标签
    public boolean changeProject_xsgl_24()throws Exception{
        boolean flag = changeProject(repeatTel1,"毕马威","转项目完成，0条成功，1条未成功。");
        return flag;
    }
    public boolean changeProject_xsgl_25()throws Exception{
        boolean flag = changeProject(repeatTelACCA,"毕马威","转项目完成，1条成功，0条未成功。");
        return flag;
    }
    //TODO:26 通过函数执行了
    public boolean follow_xsgl_42(String action)throws Exception{
        boolean flag = false;
        String tel = commonUtil.getTel();
        followBase(tel,action);
        System.out.print(tel+"====================================================");
        webDriver.sleep(3000);
        webDriver.elementByCss(GaodunCluePageUI.CLUE_CITYPHONE).click();//点击列表页的国际电话
        webDriver.sleep(3000);
        String num = webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETCITYPHONE).getText();//获取列表页的国际电话
        if (num.endsWith(tel)){
            flag =true;
            System.out.print(num+"====================================================");
        }
        return flag;
    }//通过列表显示内容判断是否修改成功
    public boolean follow_xsgl_43(String action)throws Exception{
        boolean flag = false;
        String tel = commonUtil.getTel();
        followBase(tel,action);
        System.out.print(tel+"====================================================");
        String num = webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETPTONE).getText();//获取列表页的国际电话
        if (num.equals("--")){
            flag =true;
            System.out.print(num+"====================================================");
        }
        return flag;
    }
    public boolean follow_xsgl_44()throws Exception{
        boolean flag = false;
        String values=followAddRelevance(repeatTel2,repeatTel1);
       // String values=followAddRelevance("10706530322","18812341234");//test
        if (values.contains("手机已存在,请勿重复添加")){
            flag=true;
        }
        return flag;
    } //通过提示信息判断是否添加成功
    public boolean follow_xsgl_45()throws Exception{
        boolean flag = false;
        String  repeatTel14=commonUtil.getTelNotFound();
        String values=followAddRelevance(repeatTel2,repeatTel14);
        //String values=followAddRelevance("10706530322",repeatTel14);//test
        if (values.equals("添加成功")){
            flag=true;
        }
        return flag;
    }
    public boolean follow_xsgl_47()throws Exception{
        boolean flag;
        webDriver.maximize().get(Config.cmsCluesUrl);
        searchByPthone(repeatTel1);
        //searchByPthone("10706530322");
        webDriver.elementByLinkText("跟进").click();//跟进
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWSAVE).click();//保存或关闭
        webDriver.sleep(1000);
        try {
            webDriver.elementByLinkText(">>").click();//点击》》
            flag =true;
        }catch (Exception e){
            flag =false;
        }
        return flag;
    }
    public boolean follow_xsgl_48()throws Exception{
        boolean flag;
        followInformation(repeatTel1,"销售新线索","沟通时间当前或之后");
        //followInformation("10706530322","销售新线索","沟通时间当前或之后");
        webDriver.sleep(1000);
        try {
            webDriver.elementByLinkText(">>").click();//点击》》
            flag =true;
        }catch (Exception e){
            flag =false;
        }
        return flag;
    }
    public boolean follow_xsgl_49()throws Exception{
        boolean flag;
        followInformation(repeatTel1,"失效客户","沟通时间之前");
       // followInformation("10806671681","失效客户","沟通时间之前");
        webDriver.sleep(1000);
        try {
            webDriver.elementByLinkText(">>").click();//点击》》
            flag =true;
        }catch (Exception e){
            flag =false;
        }
        return flag;
    }
    public boolean follow_xsgl_50()throws Exception{
        boolean flag;
       followInformation(repeatTel2,"失效客户","沟通时间当前或之后");
        // followInformation("18812341111","失效客户","沟通时间当前或之后");
        webDriver.sleep(3000);
        try {
            webDriver.elementByLinkText(">>").click();//点击》》
            flag =false;
        }catch (Exception e){
            flag =true;
        }
        return flag;
    }
    public boolean follow_xsgl_51()throws Exception{
        boolean flag;
        webDriver.maximize().get(Config.cmsCluesUrl);//searchByPthone(repeatTel1);
        searchByPthone(repeatTel1);
        // searchByPthone("10706530322");
        webDriver.elementByLinkText("跟进").click();//跟进
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWAPPLY).click();//报名
        webDriver.sleep(3000);
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String      str1 =  (String) obj.get(3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);
        String title = webDriver.title();
        if (title.contains("创建订单")){
            flag =true;
            System.out.print(title);
        }else {
            flag=false;
        };
        return flag;
    }

    public  boolean search_merge_clue(int i)  throws  Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BOX).get(0).click();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BOX).get(1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MERGE_1).click();
        if(i ==1 ){
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_CHANGE).click();
        }
        JSONObject object =   webDriver.execute("var el = document.querySelector('.el-col:nth-child(2)>.el-input>.el-input__inner');return el.value;");
        String name  = (String) object.get("value");
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MERGE_2).click();
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_SEARCH_INPUT).sendKeys(name);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ID).click();
        JSONObject object1 =  webDriver.execute("var el = document.getElementsByClassName('datagrid-body'); console.log(el);return el[1].innerText;");
        name  = (String) object1.get("value");
        if(name.equals("没有相关数据")){
            flag = true;
        }
        commonUtil.getRefresh(webDriver);
        return flag;
    };

    // 选择 1 条 或 3条线索合并。
    public  boolean addClue_merge(int i)  throws  Exception {
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);
        boolean flag = false;
        for(int j = 0;j<i;j++){
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BOX).get(j).click();
        }
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MERGE_1).click();
        Element  el = webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MERGE_1);
        if(el != null){
            flag = true;
        }
        commonUtil.getRefresh(webDriver);
        return flag;
    }


    //批量分配线索，分配给自己，分配给他人，批量分配给自己，p
    public boolean  allotClue_xsgl(int isBatch,String allotPerson) throws  Exception {
        //打开新增线索页面
        boolean flag = false;
        webDriver.maximize().get(Config.cmsAddClientUrl);
        webDriver.sleep(2000);

        //新增线索
        Date date = new Date();
        String dateStr = String.valueOf(date.getTime());
        // String dateStr = "1544663415157";
        if(isBatch == 0) {
            addClues(dateStr,1);
        }else{
            addClues(dateStr,3);
        }

        webDriver.sleep(2000);
        //回到线索列表页面
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);

        //选择线索复选框
        if(isBatch == 0) {
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BOX).get(0).click();
        }else{
            for (int i = 0; i < 3; i++) {
                webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BOX).get(i).click();
            }
        }

        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT).click();
        webDriver.elementByCss(GaodunCluePageUI.CLUE_ALLOT_SELECT).click();

        if(allotPerson.equals("myself")){
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT_MYSELF).click();

        }else if(allotPerson.equals("other")){
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT_OPEN).click();
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT_OTHER).click();

        }else{
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT_TEAM).click();
        }

        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_ALLOT_SURE).click();


        String sql = "";
        if(isBatch == 0){
            String dateStr0 = dateStr+"0";
/*            //pre
           // sql = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName ="+dateStr0;
            //prod
            sql = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.tpo_sys_users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName ="+dateStr0;*/
            sql = Config.batchAllotSingle+dateStr0;

        }else{
            String dateStr0 = dateStr+"0";
            String dateStr1 = dateStr+"1";
            String dateStr2 = dateStr+"2";
/*            //pre
         //   sql = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName in ("+dateStr0+","+dateStr1+","+dateStr2+")"
        //prod
            sql = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.tpo_sys_users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName in ("+dateStr0+","+dateStr1+","+dateStr2+")";*/
            sql = Config.batchAllotMany+dateStr0+","+dateStr1+","+dateStr2+")";

        }

        System.out.println(sql);
        ResultSet su = testDao.query(sql);
        su.next();
        Object TrueName = su.getString("TrueName");

        System.out.println(TrueName);
        if(allotPerson.equals("myself") && TrueName.equals("autotest5")){
            flag = true;
        }else if(allotPerson.equals("other") && TrueName.equals("autotest9")){
            flag = true;
        }else if(allotPerson.equals("team")){
            su.next();
            TrueName = su.getString("TrueName");
            if(TrueName.equals("autotest5") || TrueName.equals("autotest9") || TrueName.equals("autotest8")){
                flag = true;
            }
        }

        return  flag;
    }

    public boolean  book() throws  Exception{
        boolean flag = false;
        tel = commonUtil.getTel();
        webDriver.sleep(2000);
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(3000);
        webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_MORE_BTN).click();
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_BTN).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_START).click();
        commonUtil.rightLine(webDriver);
        commonUtil.rightLine(webDriver);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_END).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_NEXT_MONTH).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_DAY_CHOOSE).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.CURRENT).click();
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.BOOK_LIVE).sendKeys(tel);
        webDriver.waitForElementByXPath(GaodunCluePageUI.LIVE_SURE).click();
        String values = webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        if(values.equals("创建邀约成功")){
            flag = true;
        }
        return flag;
    }
    //新增线索
    public  void addClues(String dateStr,int j)  throws  Exception {
        for (int i=0;i<j;i++){
            boolean flag = false;
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(0).sendKeys(dateStr+i);// 姓名
            webDriver.sleep(1000);
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_LAB).get(2).click();// 性别
            char[] enter = {'\uE007'};
            char[] allow = {'\uE015'};
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).click();// 感兴趣项目
            webDriver.sleep(1000);
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).sendKeys("毕马威");// 感兴趣项目
            webDriver.sleep(1000);
            webDriver.keys(new String(allow));
            webDriver.keys(new String(enter));
            tel = commonUtil.getTel();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_PHONE).sendKeys(tel);// 手机号
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(8).click();// 职业状态
            commonUtil.nextLine(webDriver);
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(9).click();// 省市
            commonUtil.nextLine(webDriver);
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(10).click();// 省市
            commonUtil.nextLine(webDriver);
            webDriver.elementByClassName(GaodunCluePageUI.CLUE_SOURCE).click();// 客户来源
            webDriver.elementByClassName(GaodunCluePageUI.CLUE_SOURCE).click();// 客户来源
            webDriver.sleep(1000);
            webDriver.waitForElementByXPath(GaodunCluePageUI.SOURCE_OTHER).click();//选择其他客户来源
            webDriver.elementByClassName(GaodunCluePageUI.CLUE_NOTES).sendKeys("1881234123418812341234");// 备注
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(1).click();// 保存
            webDriver.sleep(2000);
            commonUtil.getRefresh(webDriver);
            webDriver.sleep(2000);
        }
    }

    public boolean convertRecommend()throws Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);
        webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_MORE_BTN).click();
        webDriver.elementByXPath(GaodunCluePageUI.RECOMMEND).click();
        webDriver.elementByXPath(GaodunCluePageUI.RECOMMEND_PROJECT).click();
        webDriver.elementByXPath(GaodunCluePageUI.RECOMMEND_PROJECT).sendKeys("阿米巴");
        commonUtil.nextLine(webDriver);
        webDriver.elementByXPath(GaodunCluePageUI.RECOMMEND_SURE).click();
        return  flag;
    }


    String  dStr;
    String   tel;
    //测试预约试听
    public  void xsgl_52()  throws  Exception {
        //打开新增线索页面
        boolean flag = false;
        webDriver.maximize().get(Config.cmsAddClientUrl);
        webDriver.sleep(2000);
        Date date    = new Date();
        dStr  = String.valueOf(date.getTime());
        addClues(dStr,1);
        //回到线索列表页面
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);
        webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_MORE_BTN).click();
        //选择预约试听
        webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_AUDITION_BTN).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_BEGINGTIME).click();
        webDriver.waitForElementByCss(GaodunCluePageUI.AUDIT_SNEXT_TIME).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_SCHOOSE_TIME).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_SURE_BTN).click();

        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_ENDTIME).click();
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_ENEXT_TIME).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_ENEXT_TIME).click();
        webDriver.sleep(2000);
        webDriver.elementsByXPath(GaodunCluePageUI.AUDIT_SCHOOSE_TIME).get(1).click();
        webDriver.elementsByXPath(GaodunCluePageUI.AUDIT_SURE_BTN).get(1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_LIVE).sendKeys(dStr);
        webDriver.waitForElementByXPath(GaodunCluePageUI.AUDIT_MEET).click();
    }


    public boolean xsgl_45()throws Exception {
        boolean flag = false;
        webDriver.maximize().get(Config.cmsAddClientUrl);
        webDriver.sleep(2000);
        Date date    = new Date();
        dStr  = String.valueOf(date.getTime());
        addClues(dStr,1);
        //回到线索列表页面
        webDriver.maximize().get(Config.cmsClueUrl);
        webDriver.sleep(5000);
        tel = commonUtil.getTel();
        webDriver.elementsByLinkText("跟进").get(0).click();//跟进
        webDriver.elementByCss(GaodunCluePageUI.CLUE_ADDRELEVANCE).click();//新增关联
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCENAME).clearText();//关联客户名
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCENAME).sendKeys("关联客户");
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).click();//关联客户手机号
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).clearText();
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).sendKeys(tel);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_RELEVANCEACC).click();//确认
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        if(values.equals("添加成功")){
            flag = true;
        }
        webDriver.waitForElementByLinkText(">>").click();
        return flag;
    }

    String  repeatTel;

    //测试更多下的修改联系方式。status 为 0 ，修改联系人信息以及修改关联联系人， status 为 1  删除所有联系方式,以及删除关联联系人
    public  void xsgl_54(int status)  throws  Exception {
        webDriver.get(Config.cmsCluesIndexUrl);
        Date date    = new Date();
        dStr  = String.valueOf(date.getTime());
        commonUtil.getRefresh(webDriver);
        webDriver.sleep(5000);

        if(status == 0){
            webDriver.sleep(3000);
            webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_MORE_BTN).click();
            webDriver.sleep(3000);
            webDriver.waitForElementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='共享查询'])[1]/following::div[1]").click();
            webDriver.sleep(3000);
            //修改联系方式
            tel  = commonUtil.getTel();
            repeatTel = tel;
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_NAME_INPUNT).click();
            commonUtil.clear(webDriver);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_NAME_INPUNT).sendKeys(dStr);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_TEL_INPUT).click();
            commonUtil.clear(webDriver);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_TEL_INPUT).sendKeys(tel);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_INTERTEL_BTN).click();
            webDriver.sleep(2000);
            webDriver.elementsByXPath(GaodunCluePageUI.CLUE_CANADA_BTN).get(0).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_INTERTEL_INPUT).sendKeys(dStr);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_LINE_INPUT).sendKeys("0660-"+dStr);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MAIL_INPUT).sendKeys(dStr+"@qq.com");
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_QQ_INPUT).sendKeys(tel);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_WECHAT_INPUT).sendKeys(tel);

            //修改联系人联系方式
            tel = commonUtil.getTel();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_NAME_INPUNT).click();
            commonUtil.clear(webDriver);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_NAME_INPUNT).sendKeys(dStr);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_TEL_INPUT).click();
            commonUtil.clear(webDriver);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_TEL_INPUT).sendKeys(tel);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_QQ_INPUT).sendKeys(tel);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_NAME_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_TEL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_INTERTEL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_LINE_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MAIL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_WECHAT_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_QQ_SAVE).click();

            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_NAME_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_TEL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_QQ_SAVE).click();
        }else if((status == 1)){
            webDriver.sleep(3000);
            searchByPthone(repeatTel);
            webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_MORE_BTN).click();
            webDriver.waitForElementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='共享查询'])[1]/following::div[1]").click();
            //清空所有联系方式，以及删除联系人
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_TEL_INPUT).click();
            commonUtil.clear(webDriver);
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_LINE_INPUT).click();
            commonUtil.clear(webDriver);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MAIL_INPUT).click();
            commonUtil.clear(webDriver);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_QQ_INPUT).click();
            commonUtil.clear(webDriver);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_WECHAT_INPUT).click();
            commonUtil.clear(webDriver);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_INTERTEL_INPUT).click();
            commonUtil.clear(webDriver);

            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_TEL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_INTERTEL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_LINE_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_MAIL_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_WECHAT_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_QQ_SAVE).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_DEL_BTN).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.CONTECT_SURE_BTN).click();
        }
        webDriver.sleep(2000);
        commonUtil.getRefresh(webDriver);
        webDriver.sleep(2000);

    }




    public boolean changeProject(String tel,String project,String action) throws  Exception{
        boolean flag = false;
        searchByPthone(tel);// 备用 18811113333
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_CHANGEPROJECT).click();//转项目按钮
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_CHANGEPROJECTGET).click();//选择项目框
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_CHANGEPROJECTGET).sendKeys(project);//输入项目框
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.sleep(1000);
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_CHANGEPROJECTBTN).click();//确认
        webDriver.sleep(2000);
        String values =webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_CHANGEPROJECTCON) .getText();
        System.out.println(values+"+++++++++提示信息");
        if (values.equals(action)){
            flag=true;
        }
        commonUtil.refresh(webDriver);;
        return flag;
    }//转项目 24-26

    String sql4 ="SELECT\n" +
            "\tCI.ClueNo\n" +
            "FROM\n" +
            "\tcrm.ClueInfo CI\n" +
            "JOIN crm.Clue_Status CS ON CI.ClueNo = CS.ClueNo\n" +
            "JOIN gd_permission." +Config.Table+" TSU ON CS.ClueOwner = TSU.UserID\n" +
            "WHERE\n" +
            "\t TSU.TrueName = 'autotest5'\n" +
            "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
            "ORDER BY\n" +
            "\tCI.Create_Time DESC;";

    public boolean cluesearch_1_4(String status,String action)throws Exception{
        String sql1 = "SELECT CI.ClueNo  FROM crm.ClueInfo CI JOIN crm.Clue_Status CS ON CI.ClueNo = CS.ClueNo JOIN gd_permission." +Config.Table+" TSU ON CS.ClueOwner = TSU.UserID\n" +
                "WHERE DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CI.Create_Time  AND TSU.TrueName = 'autotest5' AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time ORDER BY CI.Create_Time DESC;";
        String sql2 ="SELECT\n" +
                "\tCI.ClueNo\n" +
                "FROM\n" +
                "\tcrm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN gd_permission." +Config.Table1+" TSDU ON TSDU.UserId = CS.ClueOwner\n" +
                "JOIN gd_permission." +Config.Table2+" TSD ON TSD.DeparentId = TSDU.DeparentId\n" +
                "WHERE\n" +
                "\tDATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CI.Create_Time\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "AND TSD.`Name` = '自动化测试专用'\n" +
                "ORDER BY\n" +
                "\tCI.Create_Time DESC;";
        String sql3 ="SELECT\n" +
                "CI.ClueNo\n" +
                "FROM\n" +
                "crm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN gd_permission." +Config.Table1+" TSDU ON TSDU.UserId = CS.ClueOwner\n" +
                "JOIN gd_permission." +Config.Table2+" TSD ON TSD.DeparentId = TSDU.DeparentId\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "WHERE\n" +
                "DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CI.Create_Time\n" +
                "AND TSD.`Name` = '自动化测试专用'\n" +
                "AND date_format(\n" +
                "CD.NextCommunicateTime,\n" +
                "\t'%Y-%m'\n" +
                ") = date_format(now(), '%Y-%m')\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "ORDER BY\n" +
                "\tCI.Create_Time DESC;" ;
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
       commonUtil.refresh(webDriver);;
//        webDriver.forward();
//        webDriver.back();

//        webDriver.contexts.refresh("");
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(2000);
        if (status.equals("1")||status.equals("2")||status.equals("3")||status.equals("4")){
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATETIME).click();//时间
            webDriver.sleep(1000);
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATETIMEONE).click();//一个月
        }//创建时间最近一月
        if (status.equals("2")||status.equals("3")||status.equals("4")){
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAUTHOR).click();
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAUTHORTEMA).click();
        }//线索所属人
        if (status.equals("3")||status.equals("4")){
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAFTERTIME).click();//下次沟通时间
            webDriver.sleep(3000);
            webDriver.elementsByClassName(GaodunCluePageUI.SEARCH_RETIME1).get(7).click();
        }//下次沟通时间
        //下移窗口
        webDriver.sleep(3000);
        Robot robot = new Robot();
        robot.mouseWheel(10);
        webDriver.sleep(4000)   ;
        String sql = "";
        if (status.equals("1")){
            sql = sql1;
        }else if (status.equals("2")){
            sql = sql2;
            System.out.print("===="+sql+"===");
        }else if (status.equals("3")){
            sql = sql3;
        }else if (status.equals("4")){
            sql = sql4;
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CLEAR).click();//清除
            webDriver.sleep(2000);
        }
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_5_6(String action)throws Exception{
        boolean flag;
        String sql5="SELECT\n" +
                "\tCI.ClueNo\n" +
                "FROM\n" +
                "\tcrm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "JOIN gd_permission." +Config.Table+" TSU ON TSU.UserID = CS.ClueOwner\n" +
                "JOIN crm_base.Tpo_Base_Dictionary TBD ON TBD.id = CI.CourseType\n" +
                "JOIN crm.CustomInfo CUI ON CS.CustomNo = CUI.CustomNo\n" +
                "JOIN crm_base.Tpo_Base_Dictionary TBD1 ON CUI.Profession = TBD.id\n" +
                "WHERE\n" +
                "\tDATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CI.Create_Time\n" +
                "AND TSU.TrueName = 'autotest5'\n" +
                "AND date_format(\n" +
                "\tCD.NextCommunicateTime,\n" +
                "\t'%Y-%m'\n" +
                ") = date_format(now(), '%Y-%m')\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "AND TBD.`Name` IN ('毕马威', '阿米巴')\n" +
                "AND TBD1.`Name` = '在校'\n" +
                "ORDER BY\n" +
                "\tCI.Create_Time DESC;";
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAFTERTIME).click();//下次沟通时间
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAFTERTIME1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("毕马威");//项目
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("阿米巴");//项目
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROFESSIONAL).click();//职业
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROFESSIONALSCHOOL).click();//在校
        //下移窗口
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(10);
        String sql = "";
        webDriver.sleep(2000);
        if (action.equals("查询")){
            sql = sql5;
        }else if (action.equals("清除条件")){
            sql = sql4;
            webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CLEAR).click();//清除
            webDriver.sleep(2000);
        }
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_7()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunCluePageUI.SEARCH_REMAN).click();//重复咨询人
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_REMANTEMA).click();
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RETIME).click();//重复咨询时间
        webDriver.sleep(2000);
        webDriver.elementsByClassName(GaodunCluePageUI.SEARCH_RETIME1).get(1).click();//昨天
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("毕马威");//项目
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("阿米巴");//项目
        nextOneLine();
        //下移窗口
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(10);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        String sql ="SELECT\n" +
                " CI.ClueNo,\n" +
                " TSU.TrueName\n" +
                "FROM\n" +
                " crm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "JOIN gd_permission." +Config.Table+" TSU ON TSU.UserID = CS.RepeatConsultationOwner\n" +
                "JOIN crm_base.Tpo_Base_Dictionary TBD ON TBD.id = CI.CourseType\n" +
                "JOIN gd_permission." +Config.Table1+" TSDU ON TSDU.UserId = CS.RepeatConsultationOwner\n" +
                "JOIN gd_permission." +Config.Table2+" TSD ON TSD.DeparentId = TSDU.DeparentId\n" +
                "JOIN gd_permission." +Config.Table+" TSU1 ON TSU1.UserID = CS.ClueOwner\n" +
                "WHERE\n" +
                " DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CI.Create_Time\n" +
                "AND TSD.`Name` = '自动化测试专用'\n" +
                "AND TSU1.TrueName = 'autotest5'\n" +
                "AND TO_DAYS(NOW()) - TO_DAYS(CS.RepeatConsultationTime) <= 1\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "AND TBD.`Name` IN ('毕马威', '阿米巴')\n" +
                "ORDER BY\n" +
                " CI.Create_Time DESC;";
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        System.out.print(sql+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_8()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RETIME).click();//重复咨询时间
        webDriver.sleep(1000);
        webDriver.elementsByClassName(GaodunCluePageUI.SEARCH_RETIME1).get(3).click();//一个月
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESOURE).click();//重复咨询渠道
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESOURE1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESOURE2).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESOURENOT).click();//末次沟通时间
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESOURENOTONE).click();//一个月
        //下移窗口
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(10);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        String sql = "SELECT\n" +
                "\tCI.ClueNo\n" +
                "FROM\n" +
                "\tcrm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "JOIN crm_base.Tpo_Base_Dictionary TBD ON CS.RepeatConsultationChannel = TBD.id\n" +
                "JOIN gd_permission." +Config.Table+" TSU ON CS.ClueOwner = TSU.UserID\n" +
                "WHERE\n" +
                "\tTSU.TrueName = 'autotest5'\n" +
                "AND TBD.`Name` IN ('面访', '在线咨询')\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.RepeatConsultationTime\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CD.LastCommunicateTime\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "ORDER BY\n" +
                "\tCI.Create_Time DESC;";
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_9()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        //下移窗口
        webDriver.sleep(3000);
        Robot robot = new Robot();
        robot.mouseWheel(3);
        webDriver.sleep(4000);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESCHOOLTIME).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESCHOOLTIME1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_RESCHOOL1).sendKeys("计算机");
        webDriver.elementByXPath(GaodunCluePageUI.SEARCH_RESCHOOL).sendKeys("上海大学");
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        String sql = "SELECT\n" +
                "\tCI.ClueNo\n" +
                "FROM\n" +
                "\tcrm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "JOIN crm.CustomInfo CUI ON CI.CustomNo = CUI.CustomNo\n" +
                "JOIN gd_permission." +Config.Table+" TSU ON CS.ClueOwner = TSU.UserID\n" +
                "JOIN crm_base.Tpo_Base_School TBS ON TBS.IdentityGuid = CUI.School\n" +
                "WHERE\n" +
                "\tTSU.TrueName = 'autotest5'\n" +
                "AND CUI.Major='计算机'\n" +
                "AND TBS.Name='上海大学'\n" +
                "AND CUI.EnrollmentYear >='2016-01-01 00:00:00'\n" +
                "AND CUI.EnrollmentYear <'2017-01-01 00:00:00'\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "ORDER BY\n" +
                "\tCI.Create_Time DESC;";
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_10()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(1);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("毕马威");//项目
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PROJECT).sendKeys("阿米巴");//项目
        nextOneLine();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_YESORNOTEL).click();//是否有号码
        webDriver.sleep(2000);
        robot.mouseWheel(8);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql4,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_11()throws Exception{
        String sql = "SELECT\n" +
                " DISTINCT(CI.ClueNo)\n" +
                "FROM\n" +
                " crm.ClueInfo CI\n" +
                "JOIN crm.Clue_Status CS ON CS.ClueNo = CI.ClueNo\n" +
                "JOIN crm.ClueDescribe CD ON CD.ClueNo = CS.ClueNo\n" +
                "JOIN gd_permission." +Config.Table+" TSU ON CS.ClueOwner = TSU.UserID\n" +
                "JOIN crm_base.Tpo_Base_CustomerSource TBSS ON TBSS.id = CI.FirstChannelCode\n" +
                "JOIN crm_base.Tpo_Base_CustomerSource TBSS1 ON TBSS1.id = CI.EffectivelyChannelCode\n" +
                "WHERE\n" +
                " TSU.TrueName = 'autotest5'\n" +
                "AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= CS.Update_Time\n" +
                "AND TBSS.SourceName='来电'\n" +
                "AND TBSS1.SourceName='来电'\n" +
                "ORDER BY\n" +
                " CI.Create_Time DESC;";
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(6);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORE).click();//更多
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCE).click();//首次客户来源
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCE1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCE2).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCE3).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCEEND).click();//末次客户来源
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCEEND1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORESOUCEEND2).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_12()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(6);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORE).click();//更多
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_PLAN).sendKeys("测试");
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_TEMA).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_TEMA1).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql4,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_13()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        webDriver.sleep(2000);
        commonUtil.refresh(webDriver);;
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_HIGHSEARCH).click();//高级搜索
        //下移窗口
        webDriver.sleep(2000);
        Robot robot = new Robot();
        robot.mouseWheel(6);
        webDriver.sleep(4000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCHMORE).click();//更多
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAUTHOR).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATEAUTHORTEMA).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATETIME).click();//时间
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_CREATETIMEONE).click();//一个月
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_FOLLOW).click();
        webDriver.waitForElementByXPath(GaodunCluePageUI.SEARCH_SEARCH).click();//查询
        JSONArray array = commonUtil.getElementByClassName("clue-id-text",webDriver);
        JSONArray sqlArray = commonUtil.getDataBySql(sql4,20,"ClueNo");
        System.out.print(array+"===============================");
        System.out.print(sqlArray+"===============================");
        flag =  array.equals(sqlArray);
        return  flag;
    }
    public boolean cluesearch_15()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        searchPthone("2313213@dew！！");
        webDriver.sleep(3000);
        try{
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag =false;
        }catch (Exception E){
            flag=true;
        }
        return  flag;
    }
    public boolean cluesearch_16()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        searchPthone(Config.cmsUserTel);
        webDriver.sleep(3000);
        try{
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag =true;
        }catch (Exception E){
            flag=false;
        }
        return  flag;
    }
    public boolean cluesearch_17()throws Exception{
        boolean flag;
        webDriver.get(Config.cmsCluesIndexUrl);
        commonUtil.refresh(webDriver);;
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBYPHONE).sendKeys(Config.cmsUserInternationalTel);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.SEARCH_SEARCHTEL).click();
        webDriver.sleep(3000);
        try{
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
            flag =true;
        }catch (Exception E){
            flag=false;
        }
        return  flag;
    }


    public String searchPlan(String sql) throws Exception{
        ResultSet su = testDao.query(sql);
        webDriver.sleep(2000);
        su.next();
        String FullName = su.getString("FullName");
        webDriver.sleep(1000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCE).click();//点击关联
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEINP).click();//点击然后输入项目
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEINPUT).sendKeys(FullName);//输入项目
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.sleep(1000);
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEBTN).click();//关联按钮
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(2000);
        String project1 = webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCELIST).getText();
        webDriver.elementByLinkText("详情").click();//点击详情
        webDriver.sleep(2000);
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String  str1;
        if (sql.equals("SELECT Tpo_Base_SourceDetails.FullName FROM crm_base.Tpo_Base_SourceDetails WHERE CreateTime>DATE_FORMAT( date_add( curdate( ), INTERVAL - 3 MONTH ), '%Y-%m-%d 23:59:59' ) ORDER BY CreateTime DESC;")){
            str1 =  (String) obj.get(1);
        } else {
            str1 =  (String) obj.get(2);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);
        webDriver.sleep(4000);
        String project2 = webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEDETAILS).getText();
        System.out.print(project2+"========================");
        webDriver.sleep(1000);
        if (project2.equals("")){
            project2 = "不可以显示";
        }
        return project1+"="+project2;
    }//返回project1是列表页获取的营销计划project2是详情页的显示
    public void getBackByPthone(String tel) throws  Exception{
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(1000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(1).click();//自动领取
        webDriver.sleep(3000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBACK).clearText();//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBACK).sendKeys(tel);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBACKCLICK).click();
    }//通过手机号查询数据
    public void searchPthone(String repeat) throws  Exception{
        webDriver.get(Config.cmsCluesUrl);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(2000);
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(500);

        webDriver.elementByXPath(GaodunCluePageUI.CLUE_GETBYPHONE).sendKeys(repeat);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(3000);
    }
    public void searchByPthone(String repeat) throws  Exception{
        webDriver.get(Config.cmsCluesUrl);
        webDriver.sleep(2000);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(3000);
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_GETBYPHONE).sendKeys(repeat);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(4000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BACK).get(0).click();//勾选
       // webDriver.elementsByCss("input[name=\"ck\"]").get(0).click();//勾选
    }
    public void addClueCommunication(String repeatTel1) throws  Exception{
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_PHONE).sendKeys(repeatTel1);// 手机号
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(3).click();// 国际电话
        nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(4).sendKeys(repeatTel1);// 国际电话
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(5).sendKeys(repeatTel1);// QQ
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(6).sendKeys(repeatTel1);// 微信
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(7).sendKeys(repeatTel1+"@qq.com");// 私人邮箱
    }//5个联系方式
    public void addClueRequire(String project) throws  Exception{
        webDriver.maximize().get(Config.cmsCommentUrl);
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(0).sendKeys("测试数据");// 姓名
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_LAB).get(2).click();// 性别
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).click();// 感兴趣项目
        webDriver.sleep(2000);
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(1).sendKeys(project);// 感兴趣项目
        webDriver.sleep(1000);
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(8).click();// 职业状态
        webDriver.sleep(1000);
        nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(9).click();// 省市
        nextLine();
        webDriver.elementsByClassName(GaodunCluePageUI.CLUE_INPUT).get(10).click();// 省市
        nextLine();
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_SOURCE).click();// 客户来源
        webDriver.sleep(1000);
        webDriver.elementByXPath("(.//*[normalize-space(text()) and normalize-space(.)='网校用户'])[1]/following::li[1]").click();
        webDriver.elementByClassName(GaodunCluePageUI.CLUE_NOTES).sendKeys("1881234123418812341234");// 备注
    }//必填项
    public void addClueAction(String action) throws  Exception{
        if (action.equals("确认")){
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(0).click();// 确认自动分配
        }else if (action.equals("保存")){
            webDriver.elementsByClassName(GaodunCluePageUI.CLUE_BTN).get(1).click();// 保存不自动分配
        }else { };
    }//确认or保存
    public String getPthonByJs() throws  Exception{
        JSONObject object1 =   webDriver.execute("var x = document.getElementsByClassName('el-input__inner');return x[2].value;");
        String phone  = (String) object1.get("value");
        return phone;
    }
    public String getNameByJs() throws  Exception{
        JSONObject object =   webDriver.execute("var x = document.getElementsByClassName('el-input__inner');return x[0].value;");
        String name  = (String) object.get("value");
        return name;
    }

    public int  getRestart(String tel) throws Exception {
        String Tel =tel.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
//        String sql = "SELECT CD.RepeatConsultationCount 'count' FROM crm.CustomInfo CUI JOIN crm.ClueDescribe CD ON CD.CustomGuid = CUI.Guid WHERE CUI.MainPhone = '"+Tel+"';";
        String sql = "SELECT CD.RepeatConsultationCount 'count' FROM crm.CustomInfo CUI JOIN crm.ClueDescribe CD ON CD.CustomGuid = CUI.Guid WHERE CUI.MainPhone = '"+Tel+"';";
        ResultSet su = testDao.query(sql);
        webDriver.sleep(2000);
        su.next();
        int count = su.getInt("count");
        return count;
    }//通过手机号查激活数
    public  void  nextLine() throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }//选择下两行
    public void followBase(String tel,String action)throws Exception{
        addClue_xsgl_3("确认",tel);
        webDriver.maximize().get(Config.cmsCluesUrl);
        searchByPthone(tel);
        webDriver.elementByLinkText("跟进").click();//跟进
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWBASE).click();//编辑基本信息
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWNAME).clearText();
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWNAME).sendKeys("编辑基本信息");//姓名
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWSGX).click();//性别
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOECITY).click();//国家
        nextLine();
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWPHONE).clearText();
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWPHONE).sendKeys(tel);//手机号
        if (action.equals("确定")){
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWACCEPT).click();//点击确定
        }else if (action.equals("取消")){
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWDIS).click();//点击取消
        }
        webDriver.elementByLinkText(">>").click();//点击》》
        webDriver.sleep(1000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(1000);
    }//跟进>>修改基础信息
    public String followAddRelevance(String tel,String tel1)throws Exception {
        webDriver.maximize().get(Config.cmsCluesUrl);
        searchByPthone(tel);
        webDriver.elementByLinkText("跟进").click();//跟进
        webDriver.elementByCss(GaodunCluePageUI.CLUE_ADDRELEVANCE).click();//新增关联
        webDriver.sleep(2000);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCENAME).clearText();//关联客户名
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCENAME).sendKeys("关联客户");
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).click();//关联客户手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).clearText();
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEPHONE).sendKeys(tel1);
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_RELEVANCEACC).click();//确认
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss(GaodunCluePageUI.CLUE_RELEVANCEHINT).getText();//提示信息
        System.out.print(values+"-------------------------------------");
        return values;
    }//跟进>>关联客户
    public void followInformation(String tel, String action,String time)throws Exception {
        webDriver.maximize().get(Config.cmsCluesUrl);
        webDriver.sleep(2000);
        commonUtil.refresh(webDriver);;
        webDriver.sleep(3000);
        webDriver.elementById(GaodunCluePageUI.CLUE_CLUE).click();//点击线索管理
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_GETBYPHONE).sendKeys(tel);//输入已存在的手机号
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_SEARCH).click();//查询
        webDriver.sleep(4000);
        webDriver.elementByLinkText("跟进").click();//跟进
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        if (!action.equals("销售新线索")){
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWINFOSTATUS).click();//线索状态
            webDriver.sleep(1000);
            webDriver.keys(new String(allow));
            webDriver.keys(new String(enter));
        }
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWUSER).click();//客户意向度
        webDriver.sleep(1000);
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWTELSTATUS).click();//话务状态
        webDriver.sleep(1000);
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
        webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWAGAINTIME).click();//下次沟通时间
        webDriver.sleep(3000);
        if (time.equals("沟通时间当前或之后")){
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWAFFTER).click();//之后
        }else {
            webDriver.elementByXPath(GaodunCluePageUI.CLUE_FOLLOWBEFORE).click();//之前
        }
        webDriver.sleep(2000);
        webDriver.keys(new String(enter));
       // webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_CHAT).clearText();//沟通记录
//        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_CHAT).sendKeys("沟通记录-跟进");

        webDriver.sleep(3000);
        webDriver.acceptAlert().elementByXPath(GaodunCluePageUI.CLUE_CHAT).sendKeys("沟通");
        webDriver.waitForElementByXPath(GaodunCluePageUI.CLUE_FOLLOWSAVE).click();//保存或关闭
    }//跟进信息 48-50
    public  void  nextOneLine() throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }//选择下一行

    //添加线索： 0 为相同线索，1为不同线索
    public void addClue(int i ) throws Exception{
        repeatTel1 = commonUtil.getTel();//测试数据1 -单一项目
        repeatTel2 = commonUtil.getTel();//测试数据2 -单一项目
        String repeatTel3 = commonUtil.getTel();//测试数据3
        String repeatTel4 = commonUtil.getTel();//测试数据3 -单一ACCA项目

        System.out.print(repeatTel1+"repeatTel1===================");
        System.out.print(repeatTel2+"repeatTel2===========================");
        System.out.print(repeatTelACCA+"repeatTelACCA");
        if(i == 0){
            addTest(repeatTel1,"毕马威","确认");
            addTest(repeatTel2,"毕马威","确认");
        }else if(i == 1){
            addTest(repeatTel3,"毕马威","确认");
            addTest(repeatTel4,"阿米巴","确认");
        }
    }

}
