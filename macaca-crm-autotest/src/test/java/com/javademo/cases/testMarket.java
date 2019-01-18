package com.javademo.cases;
import com.javademo.pages.GaodunMarketPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class testMarket extends BaseTest{
    GaodunMarketPage gaodunMarketingPage =    new GaodunMarketPage("营销管理页面");
    @Test(priority = 1) //新建彩信模板
    public void marketing_1() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag=gaodunMarketingPage.addMms();
        assertTrue(flag);
    }
    @Test(priority = 2) //新建短信模板
    public void marketing_2() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag = gaodunMarketingPage.addMessage();
        assertTrue(flag);

    }
    @Test(priority = 3) //新建市场营销活动
    public void marketing_3() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag=gaodunMarketingPage.addMarketactivity();
        assertTrue(flag);
    }
    @Test(priority = 4) //修改市场营销活动
    public void marketing_4() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag=gaodunMarketingPage.modifyActivity();
        assertTrue(flag);
    }
    @Test(priority = 5) //发短信
    public void marketing_5() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag=gaodunMarketingPage.sendMessage();
        assertTrue(flag);
    }
    @Test(priority = 6) //发彩信
    public void marketing_6() throws Exception {
        gaodunMarketingPage.setDriver(webDriver);
        boolean flag=gaodunMarketingPage.sendMms();
        assertTrue(flag);
    }
}
