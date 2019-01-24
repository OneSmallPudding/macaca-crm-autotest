package com.javademo.cases;

import com.javademo.pages.GaodunOrderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testOrderImportantFirst extends BaseTest {
    GaodunOrderPage gaodunOrderPage =    new GaodunOrderPage("订单页面");

    @Test(priority = 2,groups = {"important"})
    public void order_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(1,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 7,groups = {"important"})
    public void order_7() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(6,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 8,groups = {"important"})
    public void order_8() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 9,groups = {"important"})
    public void order_40() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是定金状态的订单才能推送审核","提交");
        assertTrue(flag);
    };
    @Test(priority = 12,groups = {"important"})
    public void order_27() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 16,groups = {"important"})
    public void order_19() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_19();
        assertTrue(flag);
    };
    @Test(priority = 17,groups = {"important"})
    public void order_21() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_21();
        assertTrue(flag);
    };
    @Test(priority = 18,groups = {"important"})
    public void order_70() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("未完成订单","订单金额未对冲为0，不能取消订单");
        assertTrue(flag);
    };
    @Test(priority = 25,groups = {"important"})
    public void order_44() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是定金状态的订单才能推送审核","提交");
        assertTrue(flag);
    };
    @Test(priority = 27,groups = {"important"})
    public void order_8_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 33,groups = {"important"})
    public void order_68() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("我的定金","取消成功");
        assertTrue(flag);
    };
    @Test(priority = 34,groups = {"important"})
    public void order_52() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是定金状态的订单才能推送审核","提交");
        assertTrue(flag);
    };
    @Test(priority = 35,groups = {"important"})
    public void order_8_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 36,groups = {"important"})
    public void order_27_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 37,groups = {"important"})
    public void order_74() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 48 ,groups = {"important"})
    public void order_19_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_19();
        assertTrue(flag);
    };
    @Test(priority = 55,groups = {"important"})
    public void order_78() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 56,groups = {"important"})
    public void order_35() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(-0.1,"未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 57,groups = {"important"})
    public void order_72() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("未完成订单","取消成功");
        assertTrue(flag);
    };
    @Test(priority = 58,groups = {"important"})
    public void order_8_4() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 59,groups = {"important"})
    public void order_27_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 60,groups = {"important"})
    public void order_105() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("定金","退款账号不能为空.","保存","","");
        assertTrue(flag);
    }
    @Test(priority = 69,groups = {"important"})
    public void order_109() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("定金","退款金额必须大于0.","保存","0","111");
        assertTrue(flag);
    }
    @Test(priority = 72,groups = {"important"})
    public void order_112() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("定金","退款金额必须大于0.","保存并提交审核","-0.1","111");
        assertTrue(flag);
    }
}
