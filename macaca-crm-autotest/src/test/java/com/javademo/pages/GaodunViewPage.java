package com.javademo.pages;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.javademo.pageuis.GaodunViewPageUI;
import com.javademo.utils.CommonUtil;
import com.javademo.utils.Config;
import jdk.nashorn.internal.ir.IdentNode;
import org.bytedeco.javacpp.presets.opencv_core;

import javax.xml.bind.Element;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.WeakHashMap;

public class GaodunViewPage extends BasePages {
    CommonUtil commonUtil = new CommonUtil();
    String tel;
    public GaodunViewPage(String pageDesc) { super(pageDesc); }
    String firstday, lastday;

    public boolean view_1(String status,String type,String value)throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsTableManage);
        commonUtil.refresh(webDriver);
        webDriver.sleep(5000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_BUILT).click();//新建视图
        String tel = commonUtil.getTel();
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VIEWNAME).sendKeys("视图测试" + tel);//视图名称
        System.out.println("======视图测试" + tel + "=========");
        deployClueId();
        webDriver.sleep(2000);
        if (status.equals("9")||status.equals("11")){
            deployOrderId();//配置订单id
        }
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONDITION).sendKeys(type);//条件
        commonUtil.nextOneLine(webDriver);
        if (status.equals("1") || status.equals("2")|| status.equals("9")) {
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE).sendKeys(value);//值
            if (status.equals("2")){
                value = value.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");//转换手机号加密
            }else if (status.equals("9")){
                commonUtil.nextOneLine( webDriver);
            }
        } else if (status.equals("3")) {
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUECLICK).click();//值
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUETEMA).click();//关键字
            webDriver.waitForElementByCss(GaodunViewPageUI.VIEW_VALUEINPUT).sendKeys(value);//关键字
            char[] enter = {'\uE007'};
            webDriver.keys(new String(enter));
            webDriver.sleep(1000);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUEINPUTCLICK).click();//选择关键字
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUECONFIG).click();//配置
//            webDriver.sleep(2000);
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUEPLAN).click();//
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUEPLANSAVE).click();//保存配置
        } else if (status.equals("4")) {
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUECLICK).click();//条件
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUEAUTO).click();//值
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUEAUTO9).click();//选择auto9
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUECONFIG).click();//配置
//            webDriver.sleep(2000);
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ASSOCIATES).click();
//            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ASSOCIATESSAVE).click();//保存配置
        }else if (status.equals("11")){
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_TIME1).sendKeys(firstday);
            char[] tab = {'\uE004'};
            webDriver.keys(new String(tab));
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_TIME2).sendKeys(lastday);
            webDriver.keys(new String(tab));
        }
       save(tel);
        webDriver.sleep(2000);
        JSONArray array = null;
       /* if (status.equals("1")) {
             array = commonUtil.getElementByClassName("contact_name", webDriver);
            System.out.print(array + "===============================");
        } else if (status.equals("2")) {
             array = commonUtil.getElementByClassName("view-phone-number", webDriver);
            System.out.print(array + "===============================");
        }else if (status.equals("3")) {
             array = commonUtil.getElementByClassName("beyond-hidden-2", webDriver);
            System.out.print(array + "===============================");
        }else if (status.equals("4")) {
             array = commonUtil.getElementByClassName("beyond-hidden-2", webDriver);
            System.out.print(array + "===============================");
        }else if (status.equals("9")||status.equals("11")) {
             array = commonUtil.getElementByClassName("datagrid-cell-c4-OrderNo", webDriver);
            System.out.print(array + "===============================");
        }
*/
       if (status.equals("1")||status.equals("2")||status.equals("3")||status.equals("4")){
           array = commonUtil.getElementByClassName("datagrid-cell-c4-ClueNo", webDriver);
           System.out.print(array + "===============================");
       }else if (status.equals("9")||status.equals("11")) {
           array = commonUtil.getElementByClassName("datagrid-cell-c4-OrderNo", webDriver);
           System.out.print(array + "===============================");
       }
        return flag;

    }
    public boolean view_13(String status)throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsTableManage);
        commonUtil.refresh(webDriver);
        webDriver.sleep(5000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CHANGEVIEW).click();//修改视图
        String tel = commonUtil.getTel();
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VIEWNAME).sendKeys("视图测试" + tel);//视图名称
        System.out.println("======视图测试" + tel + "=========");
        if (status.equals("21")){
            deployOrderId();
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONDITION).sendKeys("业绩所属人");//条件
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUECLICK).click();//值
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_PLAN).click();//部门
        }else if (status.equals("13")){
            deployClueId();
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ADD1).click();//点击+
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ADD2).click();//点击+
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONDITION).sendKeys("下次沟通时间");//条件
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_TIME1).sendKeys(firstday);//开始时间
            char[] tab = {'\uE004'};
            webDriver.keys(new String(tab));
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_TIME2).sendKeys(lastday);//结束时间
            webDriver.keys(new String(tab));
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CHOUSE1).sendKeys("感兴趣的项目");//条件
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE1).sendKeys("毕马威");//值
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE2).sendKeys("阿米巴");//值
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CHOUSE2).sendKeys("职业状态");//条件
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE3).sendKeys("在校");//值
            commonUtil.nextOneLine(webDriver);
        }else if (status.equals("24")){
            deployOrderId();
            webDriver.sleep(2000);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ADD1).click();
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ADD2).click();
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONDITION).sendKeys("订单来源");//条件
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE).sendKeys("ERP订单");
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CHOUSE11).sendKeys("订单来源");
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE11).sendKeys("网校订单");
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE1).sendKeys("订单来源");
            commonUtil.nextOneLine(webDriver);
            webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VALUE12).sendKeys("代理订单");
            commonUtil.nextOneLine(webDriver);
        }
        save(tel);
        webDriver.sleep(2000);
        JSONArray array = null;
        if (status.equals("13")) {
             array = commonUtil.getElementByClassName("datagrid-cell-c4-ClueNo", webDriver);//获取线索id
            System.out.print(array + "===============================");
        }else if (status.equals("21")){
            array = commonUtil.getElementByClassName("datagrid-cell-c4-OrderNo", webDriver);//获取订单id
            System.out.print(array + "===============================");
        }

        return flag;

    }
    public boolean share()throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsTableManage);
        commonUtil.refresh(webDriver);
        webDriver.sleep(5000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VIEW).click();//视图管理
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARE).click();//分享
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARE1).click();//分享的input框
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARE2).click();//输入关键字
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARE3).sendKeys("autotest9");//输入关键字
        char[] enter = {'\uE007'};
        webDriver.keys(new String(enter));
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARE4).click();//选择auto9
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SHARESAVE).click();//确定
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss("p.el-message__content").getText();//提示信息
        System.out.print(values+"---------------======-----------------");
        if (values.equals("共享成功")){
            flag=true;
        }
        return flag;

    }
    public boolean stopAndStart()throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsTableManage);
        commonUtil.refresh(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VIEW).click();//视图管理
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_START).click();//停用
        String value1 = webDriver.elementsByClassName("el-button--small").get(1).getText();//操作按钮
        String value2 = webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_START1).getText();//状态
        System.out.println(value1+"===============================");
        System.out.println(value2+"===============================");
        webDriver.sleep(1000) ;
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_START).click();//启用
        String value3 = webDriver.elementsByClassName("el-button--small").get(1).getText();//操作按钮
        String value4 = webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_START1).getText();//状态
        System.out.println(value3+"===============================");
        System.out.println(value4+"===============================");
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss("p.el-message__content").getText();//提示信息
        System.out.print(values+"---------------======-----------------");
        if (values.equals("操作成功")&&value1.equals(value4)&&value1.equals("启用")&&value2.equals(value3)&&value3.equals("停用")){
            flag=true;
        }
        return flag;
    }
    public boolean delete()throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsTableManage);
        commonUtil.refresh(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_VIEW).click();//视图管理
        webDriver.sleep(2000);
        String value1 =webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_DELETE1).getText();//获取第一条名字
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_DELETE).click();//删除
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss("p.el-message__content").getText();//提示信息
        System.out.print(values+"---------------======-----------------");
        String value2 =webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_DELETE1).getText();//获取第一条名字
        System.out.println(value1+"===============================");
        System.out.println(value2+"===============================");

        System.out.print(values+"---------------======-----------------");
        if (values.equals("操作成功")&&!value1.equals(value2)){
            flag=true;
        }
        return flag;
    }

    public boolean product()throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsClass);
        commonUtil.refresh(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADD).click();//新增
        tel =commonUtil.getTel();
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDNAME).sendKeys("产品测试-新增"+tel);//名称
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDPROJECT).sendKeys("毕马威");//所属项目
        commonUtil.nextOneLine(webDriver);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDTYPE).click();//产品类型
        commonUtil.nextOneLine(webDriver);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_BEGINTIME).sendKeys(firstday);//时间
        char[] tab = {'\uE004'};
        webDriver.keys(new String(tab));
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ENDTIME).sendKeys(lastday);//时间
        webDriver.keys(new String(tab));
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDPRO).click();//产品模块
        commonUtil.nextOneLine(webDriver);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDHOUR).sendKeys("1");//课时
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDPRICE).sendKeys("1");//价格
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDPERIOD).sendKeys("1");//周期
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDCOURSE).click();//课程性质
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDCOURSE).sendKeys("网络");//课程性质
        commonUtil.nextOneLine(webDriver);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_ADDSAVE).click();//保存
        webDriver.sleep(2000);
        String value1 =webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_FIRSTNAME).getText();//获取第一个产品名称
        System.out.println(value1+"===============================");
        if (value1.equals("产品测试-新增"+tel)){
            flag=true;
        }
        return flag;
    }/*product的新增,停用,删除一起*/
    public boolean productStop(String action)throws Exception {
        boolean flag = false;
        webDriver.get(Config.cmsClass);
        commonUtil.refresh(webDriver);
        webDriver.sleep(2000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCH).sendKeys("产品测试-新增"+tel);//搜索
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCHBTN).click();//搜索
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCHFIRST).click();//勾选
        if (action.equals("停用")){
            webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCHSTOP).click();//停用
        }else if (action.equals("删除")){
            webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCHDELETE).click();//删除
        }
        webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_SEARCHSTOPSAVE).click();//提示确定
        webDriver.sleep(2000);
        String values =  webDriver.waitForElementByXPath(GaodunViewPageUI.PROD_STATE).getText();
        System.out.print(values+"---------------======-----------------");
        if (values.equals("已停用")||action.equals("停用")){
            flag=true;
        }else if (values.equals("已失效")||action.equals("删除")){
            flag=true;
        }
        return flag;
    }/*product的新增,停用,删除一起*/
    public void getTime()throws Exception {
// 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的第一天
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);
    }

    public void save(String tel)throws Exception{
        webDriver.sleep(1000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SAVE).click();//保存
        webDriver.sleep(1000);
        String values = webDriver.waitForElementByCss("p.el-message__content").getText();//提示信息
        System.out.print(values+"---------------======-----------------");
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CHIOCE).sendKeys("视图测试" + tel);
        commonUtil.nextOneLine(webDriver);
        webDriver.sleep(3000);
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_PAGE).click();
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_PAGE1).click();
    }//配置线索id
    public void deployClueId()throws Exception{
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONFIG).click();
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_ID).click();
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_IDSAVE).click();
    }//配置线索id
    public void deployOrderId()throws Exception{
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SEARCHPEOJECT).click();//查询对象
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SEARCHPEOJECT1).click();//订单
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_CONFIG).click();//配置
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SEARCHPEOJECT2).click();//查询对象
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_SEARCHPEOJECT3).click();//订单
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_PLANID).click();//id
        webDriver.waitForElementByXPath(GaodunViewPageUI.VIEW_PLANIDSAVE).click();//id保存
    }//配置为订单id
}
