package com.javademo.cases;


import com.javademo.pages.GaodunViewPage;
import com.javademo.utils.CommonUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testView extends BaseTest {
    GaodunViewPage gaodunViewPage =    new GaodunViewPage("视图页面");


    @Test(priority = 1,groups = {"important"})
    public void view_1() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_1("1","联系人姓名","汪蕾");
        assertTrue(flag);
    };
   /* @Test(priority = 2,groups = {"important"})
    public void view_2() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_1("2","手机","13636534632");
        assertTrue(flag);
    };*/
    @Test(priority = 3,groups = {"important"})
    public void view_3() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_1("3","营销计划","测试高级视图0108");
        assertTrue(flag);
    };
    @Test(priority = 4,groups = {"important"})
    public void view_4() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_1("4","协作人","autotest9");
        assertTrue(flag);
    };
    @Test(priority = 9,groups = {"important"})
    public void view_9() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_1("9","产品名称","毕马威自动化测试");
        assertTrue(flag);
    };
    @Test(priority = 11,groups = {"important"})
    public void view_11() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        gaodunViewPage.getTime();
        boolean flag =gaodunViewPage.view_1("11","订单创建时间","");
        assertTrue(flag);
    };
//    @Test(priority = 13,groups = {"important"})
//    public void view_13() throws Exception{
//        gaodunViewPage.setDriver(webDriver);
//        gaodunViewPage.getTime();
//        boolean flag =gaodunViewPage.view_13("13");
//        assertTrue(flag);
//    };
    @Test(priority = 21,groups = {"important"})
    public void view_21() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.view_13("21");
        assertTrue(flag);
    };
//    @Test(priority = 24,groups = {"important"})
//    public void view_24() throws Exception{
//        gaodunViewPage.setDriver(webDriver);
//        boolean flag =gaodunViewPage.view_13("24");
//        assertTrue(flag);
//    };
    @Test(priority = 25,groups = {"important"})
    public void view_25() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.share();
        assertTrue(flag);
    };
    @Test(priority = 26,groups = {"important"})
    public void view_26_27() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.stopAndStart();
        assertTrue(flag);
    };
    @Test(priority = 28,groups = {"important"})
    public void view_28() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.delete();
        assertTrue(flag);
    };
    @Test(priority = 29,groups = {"important"})
    public void prod_1() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        gaodunViewPage.getTime();
        boolean flag =gaodunViewPage.product();
        assertTrue(flag);
    };
    @Test(priority = 30,groups = {"important"})
    public void prod_3() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.productStop("停用");
        assertTrue(flag);
    };
    @Test(priority = 40,groups = {"important"})
    public void prod_10() throws Exception{
        gaodunViewPage.setDriver(webDriver);
        boolean flag =gaodunViewPage.productStop("删除");
        assertTrue(flag);
    };




}
