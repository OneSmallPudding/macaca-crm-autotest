package com.javademo.cases;

import com.javademo.pages.GaodunCluePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testClueSearch extends BaseTest {
    GaodunCluePage gaodunCluePage = new GaodunCluePage("线索搜索");

    @Test(priority = 1)
    public void cluesearch_1() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_1_4("1","查询");
        assertTrue(flag);
    }
    @Test(priority = 2)
    public void cluesearch_2() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_1_4("2","查询");
        assertTrue(flag);
    }
    @Test(priority = 3)
    public void cluesearch_3() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_1_4("3","查询");
        assertTrue(flag);
    }
    @Test(priority =4 )
    public void cluesearch_4() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_1_4("4","清除条件");
        assertTrue(flag);
    }
    @Test(priority =5 )
    public void cluesearch_5() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_5_6("查询");
        assertTrue(flag);
    }
    @Test(priority =6 )
    public void cluesearch_6() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_5_6("清除条件");
        assertTrue(flag);
    }
    @Test(priority =7 )
    public void cluesearch_7() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_7();
        assertTrue(flag);
    }
    @Test(priority =8 )
    public void cluesearch_8() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_8();
        assertTrue(flag);
    }
    @Test(priority =9 )
    public void cluesearch_9() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_9();
        assertTrue(flag);
    }

    @Test(priority =10 )
    public void cluesearch_10() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_10();
        assertTrue(flag);
    }

    @Test(priority =11)
    public void cluesearch_11() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_11();
        assertTrue(flag);
    }

    @Test(priority =12)
    public void cluesearch_12() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_12();
        assertTrue(flag);
    }

    @Test(priority =13)
    public void cluesearch_13() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_13();
        assertTrue(flag);
    }

    @Test(priority =14)
    public void cluesearch_15() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_15();
        assertTrue(flag);
    }

    @Test(priority =15)
    public void cluesearch_16() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_16();
        assertTrue(flag);
    }

    @Test(priority =16)
    public void cluesearch_17() throws Exception {
        gaodunCluePage.setDriver(webDriver);
        boolean flag = gaodunCluePage.cluesearch_17();
        assertTrue(flag);
    }

}