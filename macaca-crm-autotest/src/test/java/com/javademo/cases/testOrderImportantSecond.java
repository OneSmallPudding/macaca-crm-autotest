package com.javademo.cases;

import com.javademo.pages.GaodunOrderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testOrderImportantSecond extends BaseTest {
    GaodunOrderPage gaodunOrderPage =    new GaodunOrderPage("订单页面");

    @Test(priority = 1,groups = {"important"})
    public void order_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 2,groups = {"important"})
    public void order_76() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","取消成功","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 3,groups = {"important"})
    public void order_1_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 5,groups = {"important"})
    public void order_38_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(1);
        assertTrue(flag);
    };
    @Test(priority = 8,groups = {"important"})
    public void order_46() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 10,groups = {"AllOrder"})
    public void order_125() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","未完款");
        assertTrue(flag);
    }
    @Test(priority = 18,groups = {"AllOrder","AllOrder1"})
    public void order_70() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("未完成订单","订单金额未对冲为0，不能取消订单");
        assertTrue(flag);
    };
    @Test(priority = 19,groups = {"important"})
    public void order_38_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(0.1);
        assertTrue(flag);
    };
    @Test(priority = 21,groups = {"important"})
    public void order_46_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority =22,groups = {"important"})
    public void order_80() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 23,groups = {"AllOrder"})
    public void order_131() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","已完款");
        assertTrue(flag);
    }
    @Test(priority = 24,groups = {"important"})
    public void order_46_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 25,groups = {"important"})
    public void order_48() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已经提交审核，请勿重复提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 26,groups = {"important"})
    public void order_82() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 27,groups = {"important"})
    public void order_61() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_61();
        assertTrue(flag);
    };
    @Test(priority = 31,groups = {"important"})
    public void order_84() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 32,groups = {"important"})
    public void order_50() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 33,groups = {"important"})
    public void order_58() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_58();
        assertTrue(flag);
    };
    @Test(priority = 34,groups = {"important"})
    public void order_83() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 75,groups = {"AllOrder"})
    public void order_136() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRecommend("111","是");
        assertTrue(flag);
    }

}
