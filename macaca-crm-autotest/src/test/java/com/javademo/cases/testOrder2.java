package com.javademo.cases;

import com.javademo.pages.GaodunOrderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testOrder2 extends BaseTest {
    GaodunOrderPage gaodunOrderPage =    new GaodunOrderPage("订单页面");

    @Test(priority = 1,groups = {"AllOrder","Green"})
    public void order_8() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 2,groups = {"AllOrder","Green"})
    public void order_27() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.5,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 4,groups = {"AllOrder","Green"})
    public void order_105() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款账号不能为空.","保存","","");
        assertTrue(flag);
    }
    @Test(priority = 5,groups = {"AllOrder"})
    public void order_106() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款账号不能为空.","保存并提交审核","","");
        assertTrue(flag);
    }

    @Test(priority = 6,groups = {"AllOrder"})
    public void order_107() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","","取消","","");
        assertTrue(flag);
    }

    @Test(priority = 9,groups = {"AllOrder","Green"})
    public void order_109() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款申请保存成功.","保存","","111");
        assertTrue(flag);
    }

    @Test(priority = 10,groups = {"AllOrder","Green"})
    public void order_110() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款申请保存成功，已提交审核.","保存并提交审核","","111");
        assertTrue(flag);
    }

    @Test(priority = 11,groups = {"AllOrder","Green"})
    public void order_111() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款申请保存成功.","保存","-0.1","111");
        assertTrue(flag);
    }

    @Test(priority = 12,groups = {"AllOrder","Green"})
    public void order_112() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("订金","退款申请保存成功，已提交审核.","保存并提交审核","-0.1","111");
        assertTrue(flag);
    }
    @Test(priority = 30,groups = {"AllOrder","Green"})
    public void order_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    };

    @Test(priority = 31,groups = {"AllOrder"})
    public void order_113() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("未付款","已收金额为0，不能退款","","","");
        assertTrue(flag);
    }
    @Test(priority = 32,groups = {"AllOrder"})
    public void order_38_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(0.4);
        assertTrue(flag);
    };

    @Test(priority = 33,groups = {"AllOrder"})
    public void order_114() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("未完款","退款申请保存成功.","保存","0.1","111");
        assertTrue(flag);
    }

    @Test(priority = 34,groups = {"AllOrder"})
    public void order_115() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("未完款","退款申请保存成功，已提交审核.","保存并提交审核","0.1","111");
        assertTrue(flag);
    }
    @Test(priority = 35,groups = {"AllOrder","Green"})
    public void order_38_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
//        boolean flag = gaodunOrderPage.orderPay_38(99999);
        boolean flag = gaodunOrderPage.orderPay_38(1);
        assertTrue(flag);
    };
    @Test(priority = 36,groups = {"AllOrder"})
    public void order_116() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("已完款","退款申请保存成功.","保存","0.1","111");
        assertTrue(flag);
    }

    @Test(priority = 36,groups = {"AllOrder"})
    public void order_117() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("已完款","退款申请保存成功，已提交审核.","保存并提交审核","0.1","111");
        assertTrue(flag);
    }
    @Test(priority = 37,groups = {"AllOrder","Green"})
    public void order_46() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 38,groups = {"AllOrder","Green"})
    public void order_118() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("待审核","待审核订单不允许退款","保存","","111");
        assertTrue(flag);
    }

    @Test(priority = 39,groups = {"AllOrder"})
    public void order_119() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("待审核","待审核订单不允许退款","保存并提交审核","","111");
        assertTrue(flag);
    }
    @Test(priority = 40,groups = {"AllOrder"})
    public void order_61() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_61();
        assertTrue(flag);
    };
    @Test(priority = 41,groups = {"AllOrder"})
    public void order_122() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("审核退回","退款申请保存成功.","保存","","111");
        assertTrue(flag);
    }

    @Test(priority = 42,groups = {"AllOrder"})
    public void order_123() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("审核退回","退款申请保存成功，已提交审核.","保存并提交审核","","111");
        assertTrue(flag);
    }
    @Test(priority = 43,groups = {"AllOrder"})
    public void order_50() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 44,groups = {"AllOrder","Green"})
    public void order_58() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_58();
        assertTrue(flag);
    };
    @Test(priority = 45,groups = {"AllOrder","Green"})
    public void order_120() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("完成","完成订单不允许退款","保存","","111");
        assertTrue(flag);
    }
      @Test(priority = 46,groups = {"AllOrder"})
    public void order_121() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRefund_105("完成","完成订单不允许退款","保存并提交审核","","111");
        assertTrue(flag);
    }

    @Test(priority = 50,groups = {"AllOrder"})
    public void order_1_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    };
    @Test(priority = 51,groups = {"AllOrder"})
    public void order_38_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
//        boolean flag = gaodunOrderPage.orderPay_38(99999);
        boolean flag = gaodunOrderPage.orderPay_38(1);
        assertTrue(flag);
    };
    @Test(priority = 52,groups = {"AllOrder"})
    public void order_46_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };

    @Test(priority = 53,groups = {"AllOrder"})
    public void order_124() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","待审核");
        assertTrue(flag);
    }
    @Test(priority = 54,groups = {"AllOrder"})
    public void order_126() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","已完款");
        assertTrue(flag);
    }
    @Test(priority = 55,groups = {"AllOrder"})
    public void order_46_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 56,groups = {"AllOrder"})
    public void order_125() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","未完款");
        assertTrue(flag);
    }
    @Test(priority = 57,groups = {"AllOrder"})
    public void order_38_4() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(0.1);
        assertTrue(flag);
    };

    @Test(priority = 58,groups = {"AllOrder"})
    public void order_46_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };

    @Test(priority = 59,groups = {"AllOrder"})
    public void order_127() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","审核退回");
        assertTrue(flag);
    }

    @Test(priority = 60,groups = {"AllOrder"})
    public void order_46_4() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 61,groups = {"AllOrder"})
    public void order_128() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("待审核","完成");
        assertTrue(flag);
    }

    @Test(priority = 62,groups = {"AllOrder"})
    public void order_129() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","完成");
        assertTrue(flag);
    }

    @Test(priority = 63,groups = {"AllOrder"})
    public void order_131() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","已完款");
        assertTrue(flag);
    }

    @Test(priority = 64,groups = {"AllOrder"})
    public void order_46_5() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 65,groups = {"AllOrder"})
    public void order_58_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_58();
        assertTrue(flag);
    };

    @Test(priority = 66,groups = {"AllOrder"})
    public void order_132() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","审核退回");
        assertTrue(flag);
    }


    @Test(priority = 67,groups = {"AllOrder"})
    public void order_46_6() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 68,groups = {"AllOrder"})
    public void order_58_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_58();
        assertTrue(flag);
    };
    @Test(priority = 70,groups = {"AllOrder"})
    public void order_133() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","待审核");
        assertTrue(flag);
    }
    @Test(priority = 71,groups = {"AllOrder"})
    public void order_58_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_58();
        assertTrue(flag);
    };
    @Test(priority = 73,groups = {"AllOrder"})
    public void order_134() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRecommend("","");
        assertTrue(flag);
    }
    @Test(priority = 74,groups = {"AllOrder"})
    public void order_135() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRecommend("111","否");
        assertTrue(flag);
    }
    @Test(priority = 75,groups = {"AllOrder"})
    public void order_136() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderRecommend("111","是");
        assertTrue(flag);
    }

    @Test(priority = 173,groups = {"AllOrder"})
    public void order_130() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.orderAbnormal_124("完成","未完款");
        assertTrue(flag);
    }


}
