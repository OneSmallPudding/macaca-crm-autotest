package com.javademo.cases;

import com.javademo.pages.GaodunCluePage;
import com.javademo.pages.GaodunOrderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testOrder extends BaseTest{
    GaodunOrderPage gaodunOrderPage =    new GaodunOrderPage("订单页面");

    @Test(priority = 1)
    public void order_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 2)
    public void order_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(1,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 3)
    public void order_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(2,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 4)
    public void order_4() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(3,"快递寄送地址不能为空");
        assertTrue(flag);
    }
    @Test(priority = 5)
    public void order_5() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(4,"请输入学校");
        assertTrue(flag);
    }
    @Test(priority = 6)
    public void order_6() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(5,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 7)
    public void order_7() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(6,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 8)
    public void order_8() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 9)
    public void order_24() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_24("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 10)
    public void order_25() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_25("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 11)
    public void order_26() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_26("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 12)
    public void order_27() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 13)
    public void order_28() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(-0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 14)
    public void order_29() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_29("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 15)
    public void order_30() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_30("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 16)
    public void order_19() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_19();
        assertTrue(flag);
    };
    @Test(priority = 17)
    public void order_71() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_69("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 18)
    public void order_70() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("未完成订单","订单金额未对冲为0，不能取消订单");
        assertTrue(flag);
    };
    @Test(priority = 19)
    public void order_31() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_24("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 22)
    public void order_32() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_25("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 23)
    public void order_33() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_26("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 24)
    public void order_35() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(-0.1,"未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 25)
    public void order_73() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_69("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 26)
    public void order_72() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("未完成订单","取消成功");
        assertTrue(flag);
    };
    @Test(priority = 27)
    public void order_8_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 28)
    public void order_27_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 29)
    public void order_74() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 30)
    public void order_75() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("","","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 31)
    public void order_28_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(-0.1,"我的定金");
        assertTrue(flag);
    };
    @Test(priority = 32)
    public void order_69() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_69("我的定金");
        assertTrue(flag);
    };
    @Test(priority = 33)
    public void order_68() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_68("我的定金","取消成功");
        assertTrue(flag);
    };
    @Test(priority = 34)
    public void order_52() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是订金状态的订单才能推送审核","提交");
        assertTrue(flag);
    };
    @Test(priority = 35)
    public void order_53() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("","","提交");
        assertTrue(flag);
    };
    @Test(priority = 45)
    public void order_8_3() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(7,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 46)
    public void order_40() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是订金状态的订单才能推送审核","提交");
        assertTrue(flag);
    };
    @Test(priority = 47)
    public void order_41() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("","","提交");
        assertTrue(flag);
    };
    @Test(priority = 48)
    public void order_19_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_19();
        assertTrue(flag);
    };
    @Test(priority = 49)
    public void order_20() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_20();
        assertTrue(flag);
    };
    @Test(priority = 50)
    public void order_21() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_21();
        assertTrue(flag);
    };
    @Test(priority = 51)
    public void order_34() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_27(0.1,"未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 52)
    public void order_36() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_29("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 53)
    public void order_37() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_30("未完成订单");
        assertTrue(flag);
    };
    @Test(priority = 54)
    public void order_38_1() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(0.1);
        assertTrue(flag);
    };
    @Test(priority = 55)
    public void order_78() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 56)
    public void order_79() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("","","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 57)
    public void order_1_2() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 58)
    public void order_77() throws Exception {
            gaodunOrderPage.setDriver(webDriver);
            boolean flag = gaodunOrderPage.orderPay_40("","","更多-取消");
            assertTrue(flag);
        };
    @Test(priority = 59)
    public void order_76() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","取消成功","更多-取消");
        assertTrue(flag);
    };
     @Test(priority = 70)
     public void order_1_3() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
         assertTrue(flag);
     }
     @Test(priority = 71)
     public void order_42() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是订金状态的订单才能推送审核","提交");
         assertTrue(flag);
     };
     @Test(priority = 72)
     public void order_43() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("","","提交");
         assertTrue(flag);
     };
     @Test(priority = 73)
     public void order_38() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_38(0.1);
         assertTrue(flag);
     };
     @Test(priority = 74)
     public void order_44() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","只有完款,且不是订金状态的订单才能推送审核","提交");
         assertTrue(flag);
     };
     @Test(priority = 75)
     public void order_45() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("","","提交");
         assertTrue(flag);
     };
     @Test(priority = 76)
     public void order_38_2() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_38(1);//TODO:1
         assertTrue(flag);
     };
     @Test(priority =77)
     public void order_80() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
         assertTrue(flag);
     };
     @Test(priority = 78)
     public void order_81() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("","","更多-取消");
         assertTrue(flag);
     };
     @Test(priority = 79)
     public void order_47() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("","","提交");
         assertTrue(flag);
     };
     @Test(priority = 80)
     public void order_46() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
         assertTrue(flag);
     };
     @Test(priority = 81)
     public void order_82() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
         assertTrue(flag);
     };
     @Test(priority = 82)
     public void order_49() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("","","提交");
         assertTrue(flag);
     };
     @Test(priority = 83)
     public void order_48() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单已经提交审核，请勿重复提交","提交");
         assertTrue(flag);
     };
     @Test(priority = 84)
     public void order_58() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_58();
         assertTrue(flag);
     };
     @Test(priority = 85)
     public void order_83() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
         assertTrue(flag);
     };
     @Test(priority = 100)
     public void order_1_4() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
         assertTrue(flag);
     }
     @Test(priority = 101)
     public void order_38_4() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_38(1);//TODO:1
         assertTrue(flag);
     };
     @Test(priority = 102)
     public void order_46_1() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
         assertTrue(flag);
     };
     @Test(priority = 103)
     public void order_54() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_54();
         assertTrue(flag);
     };
     @Test(priority = 104)
     public void order_55() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_55();
         assertTrue(flag);
     };
     @Test(priority = 106)
     public void order_56() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_56();
         assertTrue(flag);
     };
     @Test(priority = 107)
     public void order_57() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_57();
         assertTrue(flag);
     };
     @Test(priority = 108)
     public void order_59() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_59();
         assertTrue(flag);
     };
     @Test(priority = 109)
     public void order_62() throws Exception {
         gaodunOrderPage.setDriver(webDriver);
         boolean flag = gaodunOrderPage.orderPay_62();
         assertTrue(flag);
     };
    @Test(priority = 110)
    public void order_1_5() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag =gaodunOrderPage.addOrder(0,"保存成功");
        assertTrue(flag);
    }
    @Test(priority = 111)
    public void order_38_5() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_38(1);//TODO:1
        assertTrue(flag);
    };
    @Test(priority = 112)
    public void order_46_5() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
    @Test(priority = 114)
    public void order_60() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_60();
        assertTrue(flag);
    };
    @Test(priority = 115)
    public void order_63() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_63();
        assertTrue(flag);
    };
    @Test(priority = 116)
    public void order_64() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_64();
        assertTrue(flag);
    };
    @Test(priority = 117)
    public void order_65() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_65();
        assertTrue(flag);
    };
    @Test(priority = 118)
    public void order_61() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_61();
        assertTrue(flag);
    };
    @Test(priority = 119)
    public void order_84() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单金额未对冲为0，不能取消订单","更多-取消");
        assertTrue(flag);
    };
    @Test(priority = 121)
    public void order_51() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("","","提交");
        assertTrue(flag);
    };
    @Test(priority = 122)
    public void order_50() throws Exception {
        gaodunOrderPage.setDriver(webDriver);
        boolean flag = gaodunOrderPage.orderPay_40("确定","订单已成功提交","提交");
        assertTrue(flag);
    };
}
