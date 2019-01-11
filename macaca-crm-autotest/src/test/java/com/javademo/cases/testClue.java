package com.javademo.cases;
import com.javademo.pages.GaodunCluePage;
import com.javademo.utils.CommonUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({com.javademo.utils.AssertionListener.class})
public class testClue extends BaseTest {
    GaodunCluePage gaodunCluePage =    new GaodunCluePage("线索页面");
    GaodunCluePage cluePage =    new GaodunCluePage("线索页面");
    String  repeatTel3;
    String  repeatTel8;
    CommonUtil commonUtil = new CommonUtil();


    @Test(priority = 1,groups = {"AllClue"})
    public void test() throws Exception{
        gaodunCluePage.setDriver(webDriver);
        gaodunCluePage.addTest();
    };
    @Test(priority = 1,groups = {"Green"})
    public void test1() throws Exception{
        gaodunCluePage.setDriver(webDriver);
        gaodunCluePage.addTest1();
    };

   // 必须项为空，其他正常输入
   @Test(priority = 2,groups = {"AllClue"})
    public void xsgl_1() throws Exception{
        gaodunCluePage.setDriver(webDriver);
        boolean flag  =gaodunCluePage.addClue_xsgl_1("确认");
        assertTrue(flag);
    };
    // 5个联系方式为空
    @Test(priority = 3,groups = {"AllClue"})
    public void xsgl_2() throws Exception{
        gaodunCluePage.setDriver(webDriver);
        boolean flag  =gaodunCluePage.addClue_xsgl_2("确认");
        assertTrue(flag);
    };
    // 联系方式只填手机号/国际号码/QQ微信/邮箱的一种；其他正常输入
    @Test(priority = 4,groups = {"AllClue","Green"})
    public void xsgl_3() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        repeatTel3 =commonUtil.getTel();
        System.out.print(repeatTel3+"repeatTel3===========================");
        boolean flag = gaodunCluePage.addClue_xsgl_3("确认",repeatTel3);
        assertTrue(flag);
    };
    @Test(priority = 5,groups = {"AllClue"})
    public void xsgl_4() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_4("确认",repeatTel3);
        assertTrue(flag);
    };
    @Test(priority = 6,groups = {"AllClue"})
    public void xsgl_5() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_5("确认",repeatTel3);
        assertTrue(flag);
    };
    @Test(priority = 7,groups = {"AllClue"})
    public void xsgl_6() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_1("保存");
        assertTrue(flag);
    };
    @Test(priority = 8,groups = {"AllClue"})
    public void xsgl_7() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_2("保存");
        assertTrue(flag);
    };
    @Test(priority = 9,groups = {"AllClue","Green"})
    public void xsgl_8() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        repeatTel8 =commonUtil.getTel();
        System.out.print(repeatTel8+"repeatTel8==========================");
        boolean flag = gaodunCluePage.addClue_xsgl_3("保存",repeatTel8);
        assertTrue(flag);
    };
    @Test(priority = 10,groups = {"AllClue"})
    public void xsgl_9() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_4("保存",repeatTel8);
        assertTrue(flag);
    };
    @Test(priority = 11,groups = {"AllClue"})
    public void xsgl_10() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_5("保存",repeatTel8);
        assertTrue(flag);
    };
    @Test(priority = 12,groups = {"AllClue"})
    public void xsgl_11() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addClue_xsgl_11();
        assertTrue(flag);
    };
    @Test(priority = 13,groups = {"AllClue","Green"})
    public void xsgl_12() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.queryOwner_xsgl_12();
        assertTrue(flag);
    };
    @Test(priority = 14,groups = {"AllClue","Green"})
    public void xsgl_13() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.queryOwner_xsgl_13();
        assertTrue(flag);
    };
    @Test(priority = 15,groups = {"AllClue"})
    public void xsgl_14() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.queryOwner_xsgl_14();
        assertTrue(flag);
    };
    @Test(priority = 16,groups = {"AllClue","Green"})
    public void xsgl_15() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.backPoll_xsgl_15();
        assertTrue(flag);
    };
    @Test(priority = 17,groups = {"AllClue"})
    public void xsgl_16() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.backPoll_xsgl_16();
        assertTrue(flag);
    };
    @Test(priority = 18,groups = {"AllClue","Green"})
    public void xsgl_17() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.receive_xsgl_17();
        assertTrue(flag);
    };
    @Test(priority = 19,groups = {"AllClue","Green"})
    public void xsgl_18() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.receive_xsgl_18();
        assertTrue(flag);
    };
       @Test(priority = 20,groups = {"AllClue"})
    public void xsgl_19() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.relevance_xsgl_19();
        assertTrue(flag);
    };
    @Test(priority = 21,groups = {"AllClue"})
    public void xsgl_20() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.relevance_xsgl_20();
        assertTrue(flag);
    };
    @Test(priority = 22,groups = {"AllClue"})
    public void xsgl_21() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.addLabel_xsgl_21();
        assertTrue(flag);
    };

    @Test(priority = 23,groups = {"AllClue"})
    public void xsgl_24() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.changeProject_xsgl_24();
        assertTrue(flag);
    };
    @Test(priority = 24,groups = {"AllClue"})
    public void xsgl_25() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.changeProject_xsgl_25();//   转项目完成，1条成功，0条未成功。
        assertTrue(flag);
    };

    @Test(priority = 25,groups = {"AllClue"})
    public void xsgl_26() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.changeProject(repeatTel3,"毕马威","转项目完成，0条成功，1条未成功。");
        assertTrue(flag);
    };
   @Test(priority = 26,groups = {"AllClue"})
   public void xsgl_42() throws Exception {
       gaodunCluePage.setDriver(webDriver);
       boolean flag = gaodunCluePage.follow_xsgl_42("确定");
       assertTrue(flag);
   };
   @Test(priority = 27,groups = {"AllClue"})
   public void xsgl_43() throws Exception {
       gaodunCluePage.setDriver(webDriver);
       boolean flag = gaodunCluePage.follow_xsgl_43("取消");
       assertTrue(flag);
   };
    @Test(priority = 28,groups = {"AllClue"})
    public void xsgl_44() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.follow_xsgl_44();
        assertTrue(flag);
    };
    @Test(priority = 29,groups = {"AllClue"})
    public void xsgl_45() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.follow_xsgl_45();
        assertTrue(flag);
    };
   @Test(priority = 30,groups = {"AllClue"})
   public void xsgl_47() throws Exception {
       gaodunCluePage.setDriver(webDriver);
       boolean flag = gaodunCluePage.follow_xsgl_47();
       assertTrue(flag);
   };
    @Test(priority = 31,groups = {"AllClue"})
    public void xsgl_48() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.follow_xsgl_48();
        assertTrue(flag);
    };
    @Test(priority = 32,groups = {"AllClue"})
    public void xsgl_49() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.follow_xsgl_49();
        assertTrue(flag);
    };
    @Test(priority = 33,groups = {"AllClue"})
    public void xsgl_50() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.follow_xsgl_50();
        assertTrue(flag);
    };
   @Test(priority = 34,groups = {"AllClue","Green"})
   public void xsgl_51() throws Exception {
       gaodunCluePage.setDriver(webDriver);
       boolean flag = gaodunCluePage.follow_xsgl_51();
       assertTrue(flag);
   };


    //合并一条
    @Test(priority = 35,groups = {"AllClue"})
    public void xsgl_27() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.addClue_merge(1);
    }
    //合并三条
    @Test(priority = 36,groups = {"AllClue"})
    public void xsgl_27_1() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.addClue_merge(3);
    }

    //合并两条同项目的
    @Test(priority = 37,groups = {"AllClue"})
    public void xsgl_28() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.addClue(0);
        cluePage.search_merge_clue(0);
    }
    //交换之后合并
    @Test(priority = 38,groups = {"AllClue"})
    public void xsgl_29() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.addClue(0);
        cluePage.search_merge_clue(1);
    }
    //合并不同项目
    @Test(priority = 39,groups = {"AllClue"})
    public void xsgl_30() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.addClue(1);
        cluePage.search_merge_clue(0);
    }
    //交换后合并不同项目
    @Test(priority = 40,groups = {"AllClue"})
    public void xsgl_31() throws Exception {
        cluePage.setDriver(webDriver);
        //选择其他项目
        cluePage.addClue(1);
        cluePage.search_merge_clue(1);
}

    //分配
    @Test(priority = 41,groups = {"AllClue","Green"})
    public void xsgl_32() throws Exception {
        cluePage.setDriver(webDriver);

        webDriver.sleep(3000);
        cluePage.allotClue_xsgl(0,"myself");
    }

    @Test(priority = 42,groups = {"AllClue","Green"})
    public void xsgl_36() throws Exception {
        cluePage.setDriver(webDriver);
        boolean flag = cluePage.allotClue_xsgl(1,"myself");
    }

    @Test(priority = 43,groups = {"AllClue","Green"})
    public void xsgl_34() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.allotClue_xsgl(0,"other");
    }

    @Test(priority = 44,groups = {"AllClue","Green"})
    public void xsgl_38() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.allotClue_xsgl(1,"other");
    }


    @Test(priority = 45,groups = {"AllClue"})
    public void xsgl_35() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.allotClue_xsgl(0,"other");
    }


    @Test(priority = 46,groups = {"AllClue"})
    public void xsgl_39() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.allotClue_xsgl(1,"team");
    }


    @Test(priority = 47,groups = {"AllClue"})
    public void xsgl_45_1() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.xsgl_45();
    }

    @Test(priority = 48,groups = {"AllClue"})
    public void xsgl_55_57() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.xsgl_54(0);
    }

    @Test(priority = 49,groups = {"AllClue"})
    public void xsgl_54_56() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.xsgl_54(1);
    }

    @Test(priority = 50,groups = {"AllClue"})
    public void xsgl_59() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.convertRecommend();
    }

    @Test(priority = 51,groups = {"AllClue"})
    public void xsgl_58() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.convertRecommend();
    }

    @Test(priority = 52,groups = {"AllClue"})
    public void xsgl_53() throws Exception {
        cluePage.setDriver(webDriver);
        cluePage.book();
    }


}

