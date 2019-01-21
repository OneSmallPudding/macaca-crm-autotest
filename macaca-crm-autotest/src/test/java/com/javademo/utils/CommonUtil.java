package com.javademo.utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javademo.dao.TestDao;
import com.javademo.pages.Handler;
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
    public  void  pageEnd(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(500);
        char[] end = {'\ue010'};
        char[] enter = {'\uE007'};
        webDriver.keys(new String(end));
        webDriver.keys(new String(enter));
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
    public static String[] telFirst="134,135,136,137,138,139,133,131,132,137,138,139,133,131,132,135,136,133".split(",");
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
    public JSONArray getDatasBySql(String sql, String  lable) throws  Exception{
        JSONArray dataArray = new JSONArray();
        ResultSet rs = testDao.query(sql);
        int i =1;
        String first;
        if (lable.equals("线索编号")){
             first="线索ID";
        }else if (lable.equals("订单编号")){
             first = "订单ID";
        }else{
            System.out.println("查询数据库======");
            return null ;
        }
        dataArray.set(0,first);
        while(rs.next()){
            if(i<21){
                dataArray.set(i,rs.getString(lable));
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
    public  void  nextLine(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }
    public  void  nextOneLine(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(1000);
        char[] enter = {'\uE007'};
        char[] allow = {'\uE015'};
        webDriver.keys(new String(allow));
        webDriver.keys(new String(enter));
    }
    public  void clear(MacacaClient webDriver)throws Exception{
        webDriver.sleep(500);
        webDriver.execute("document.execCommand('selectAll')");
        char[] back = {'\ue003'};
        webDriver.keys(new String(back));
        webDriver.sleep(2000);
    }//关闭页面
    //按下右边箭头，按下enter 键
    public  void  rightLine(MacacaClient webDriver) throws  Exception{
        webDriver.sleep(500);
        char[] right = {'\ue014'};
        char[] enter = {'\uE007'};
        webDriver.keys(new String(right));
        webDriver.keys(new String(enter));
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

    public void switchToWindows(MacacaClient webDriver,int num)throws Exception{
        Handler handler   = new Handler(webDriver.contexts);
        JSONArray obj = (JSONArray) handler.takeHandler();
        obj = (JSONArray) handler.takeHandler();
        String      str1 =  (String) obj.get(num);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",str1);
        handler.switchWindow(jsonObject);
    }//切换窗口





    //sql
    //view_1 联系人姓名包含：测试es
    public static final  String  sql_view_1=" SELECT 	CII.ClueNo '线索编号' FROM 	crm.ClueInfo CII JOIN crm.CustomInfo CUI ON CII.CustomGuid = CUI.Guid JOIN crm.Clue_Status CS ON CS.ClueNo = CII.ClueNo JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE 	CUI.TrueName LIKE '%汪蕾%' AND FIND_IN_SET( 	CII.CourseType, 	TSU.CourseTypes ) > 0 AND TSU.TrueName = 'autotest5'  ORDER BY CII.Create_Time DESC;";

    //view_2 手机号码等于13636534632

    //view_3 营销计划为：测试高级视图0108
    public static final  String sql_view_3=" SELECT 	CII.ClueNo '线索编号' FROM 	crm.ClueInfo CII JOIN crm.ClueMarketingPaln CMP ON CII.Guid = CMP.ClueGuid JOIN crm_base.Tpo_Base_SourceDetails TBSD ON TBSD.id = CMP.PalnId  JOIN crm.Clue_Status CS ON CS.ClueNo = CII.ClueNo JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE 	TBSD.FullName='测试高级视图0108' AND FIND_IN_SET( 	CII.CourseType, 	TSU.CourseTypes ) > 0 AND TSU.TrueName = 'autotest5'  ORDER BY CII.Create_Time DESC;";

   // view_4 协作人：autotest8
   public static final  String sql_view_4=" SELECT 	CII.ClueNo '线索编号' FROM 	crm.ClueInfo CII  JOIN crm.Clue_Status CS ON CS.ClueGuid = CII.Guid  JOIN gd_permission.Tpo_Sys_Users TSU ON CS.Associates = TSU.UserID WHERE TSU.TrueName = 'autotest8' ORDER BY CII.Create_Time DESC;";

    //view_9 产品名称为：测试
    public static final  String sql_view_9 ="SELECT OI.OrderNo '订单编号' FROM crm_order_center.Order_Info OI JOIN crm_order_center.Order_Product COP ON COP.OrderNo = OI.OrderNo JOIN gd_permission.Tpo_Sys_Users TSU ON OI.`Owner` = TSU.UserID JOIN crm_order_center.Order_Clue_Custom_Student_Relation OCCSR ON OCCSR.OrderNo = OI.OrderNo JOIN crm.ClueInfo CII ON OCCSR.ClueNo = CII.ClueNo JOIN crm.CustomInfo CUI ON CII.CustomGuid = CUI.Guid WHERE COP.ProductName = '毕马威自动化测试' AND FIND_IN_SET( CII.CourseType, TSU.CourseTypes ) > 0 AND TSU.TrueName = 'autotest5' GROUP BY OI.OrderNo ORDER BY OI.Create_Time DESC;";

   // view_11 订单创建时间为本月
   public static final String sql_view_11=" SELECT 	OI.OrderNo '订单编号' FROM 	crm_order_center.Order_Info OI JOIN gd_permission.Tpo_Sys_Users TSU ON OI.`Owner` = TSU.UserID JOIN crm_order_center.Order_Clue_Custom_Student_Relation OCCSR ON OCCSR.OrderNo = OI.OrderNo JOIN crm.ClueInfo CII ON OCCSR.ClueNo = CII.ClueNo JOIN crm.CustomInfo CUI ON CII.CustomGuid = CUI.Guid WHERE 	DATE_FORMAT(OI.Create_Time, '%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m')  AND FIND_IN_SET( 	CII.CourseType, 	TSU.CourseTypes ) > 0 AND TSU.TrueName = 'autotest5' GROUP BY 	OI.OrderNo ORDER BY 	OI.Create_Time DESC;";

    //view_13 条件修改为：下次沟通时间：当月；感兴趣的项目：毕马威和阿米巴；职业状态：在校
    public static final  String sql_view_13=" SELECT 	CII.ClueNo '线索编号'  FROM 	crm.ClueInfo CII JOIN crm.CustomInfo CUI ON CII.CustomGuid = CUI.Guid JOIN crm.Clue_Status CS ON CS.ClueNo = CII.ClueNo JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID JOIN crm_base.Tpo_Base_Dictionary TBD ON CII.CourseType = TBD.id JOIN crm.ClueDescribe CD ON CII.Guid = CD.ClueGuid JOIN crm_base.Tpo_Base_Dictionary TBD1 ON CUI.Profession = TBD1.id WHERE 	FIND_IN_SET( 		CII.CourseType, 		TSU.CourseTypes 	) > 0 AND TSU.TrueName = 'autotest5' AND TBD.`Name` IN ('毕马威', '阿米巴') AND CD.NextCommunicateTime BETWEEN DATE_ADD( 	CURDATE(), 	INTERVAL - DAY (curdate()) + 1 DAY ) AND CURDATE() AND TBD1.`Name` = '在校' ORDER BY 	CII.Create_Time DESC;";

    //view_21 条件修改为业绩所属人为某部门
    public static final  String sql_view_21=" SELECT 	OI.OrderNo '订单编号' FROM 	crm_order_center.Order_Info OI JOIN crm_order_center.Order_Clue_Custom_Student_Relation OCCSR ON OCCSR.OrderNo = OI.OrderNo JOIN crm.ClueInfo CII ON OCCSR.ClueNo = CII.ClueNo JOIN crm.CustomInfo CUI ON CII.CustomGuid = CUI.Guid JOIN gd_permission.Tpo_Sys_Department_User TSDU ON OI.`Owner` = TSDU.UserId JOIN gd_permission.Tpo_Sys_Departments TSD ON TSD.DeparentId = TSDU.DeparentId WHERE 	TSD.`Name` = '自动化测试' GROUP BY 	OI.OrderNo ORDER BY 	OI.Create_Time DESC;  ";



}
