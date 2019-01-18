package com.javademo.cases;

import com.javademo.pages.GaodunOrderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testAfterOrder extends BaseTest{
    GaodunOrderPage gaodunOrderPage =    new GaodunOrderPage("订单页面");
 @Test(priority = 1,groups = {"AllOrder","AllOrder5"})
    public void order_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
   @Test(priority = 2,groups = {"AllOrder","AllOrder5"})
    public void order_85() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(0,0);
        assertTrue(flag);
    }

    @Test(priority = 3,groups = {"AllOrder","AllOrder5"})
    public void order_86() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(1,1);
        assertTrue(flag);
    }

    @Test(priority = 4,groups = {"AllOrder","AllOrder5"})
    public void order_87() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(3,0);
        assertTrue(flag);
    }
    @Test(priority = 5,groups = {"AllOrder","AllOrder5"})
    public void order_88() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(4,0);
        assertTrue(flag);
    }
    @Test(priority = 6,groups = {"AllOrder","AllOrder5"})
    public void order_89() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(5,0);
        assertTrue(flag);
    }

    @Test(priority = 7,groups = {"AllOrder","AllOrder5"})
    public void order_91() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(6,0);
        assertTrue(flag);
    }

    @Test(priority = 8,groups = {"AllOrder","AllOrder5"})
    public void order_92() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(7,0);
        assertTrue(flag);
    }

    @Test(priority = 9,groups = {"AllOrder","AllOrder5"})
    public void order_90() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderSplit(8,0);
        assertTrue(flag);
    }

    @Test(priority = 10,groups = {"AllOrder","AllOrder5"})
    public void order_97() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(0);
        assertTrue(flag);
    }
    @Test(priority = 11,groups = {"AllOrder","AllOrder5"})
    public void order_98() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(1);
        assertTrue(flag);
    }

    @Test(priority = 12,groups = {"AllOrder","AllOrder5"})
    public void order_99() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(2);
        assertTrue(flag);
    }

    @Test(priority = 13,groups = {"AllOrder","AllOrder5"})
    public void order_100() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(3);
        assertTrue(flag);
    }

    @Test(priority = 14,groups = {"AllOrder","AllOrder5"})
    public void order_101() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(4);
        assertTrue(flag);
    }

    @Test(priority = 15,groups = {"AllOrder","AllOrder5"})
    public void order_102() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(5);
        assertTrue(flag);
    }
    @Test(priority = 16,groups = {"AllOrder","AllOrder5"})
    public void order_103() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAward(6);
        assertTrue(flag);
    }
}
