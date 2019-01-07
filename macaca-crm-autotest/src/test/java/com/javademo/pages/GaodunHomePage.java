package com.javademo.pages;
import ImageDeal.ImageDeal;
import com.javademo.dao.TestDao;
import com.javademo.pageuis.GaodunHomePageUI;
import com.javademo.utils.CommonUtil;
import macaca.client.commands.Element;
import macaca.java.biz.BasePage;
import macaca.java.biz.CommonUIBean;
import org.testng.Assert;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GaodunHomePage  extends BasePage {
    CommonUtil commonUtil = new CommonUtil();
    TestDao testDao = new TestDao();
    boolean flag = false;
    ImageDeal imageDeal;

    public GaodunHomePage(String pageDesc) {
        super(pageDesc);
    }
    //点击首页
    public void  login() throws Exception {
       // driver.waitForElement(GaodunHomePageUI.LOGIN_BTN_1).click();
        driver.waitForElement(GaodunHomePageUI.ACCOUNT_BTN).sendKeys("15655103835");
        driver.waitForElement(GaodunHomePageUI.PWD_BTN).sendKeys("123456");
        driver.waitForElement(GaodunHomePageUI.LOGIN_SUBMIT_1).click();
    }
    //点击首页
    public void clickHomePage(CommonUIBean uiBean) throws Exception {
        Element el = driver.waitForElement(uiBean);
        el.click();
    }

    // 测试导航栏的内容和排序
    public int getNavCount() throws Exception {
        String sql = "SELECT count(*) totalCount FROM  gd_superapp.skr_advertises WHERE project_id = 1";
        ResultSet su = testDao.query(sql);
        su.next();
        int totalCount = su.getInt("totalCount");
        return totalCount;
    }

    public void getNavPic() throws Exception {
        String sql = "SELECT image  FROM  gd_superapp.skr_advertises WHERE project_id = 1  ORDER BY display_sequence DESC";
        ResultSet su = testDao.query(sql);
        int i = 1;
        while (su.next()) {
            String image = su.getString("image");
            String imageUrl = "http:" + image;
            //获取网络上的图片，并缩放。
            imageDeal = new ImageDeal(imageUrl, "d://", i + "_home_web", "png");
/*            imageDeal.zoom(670, 320);
            imageDeal.cutImage(i + "_home_web", i + "_home_web_after", 0, 10, 670, 240);
            //切割手机屏幕截图到合适大小
            imageDeal.cutImage(i + "_home", i + "_home_after", 35, 150, 670, 240);*/
            imageDeal.zoom(920, 400);
            imageDeal.cutImage(i + "_home_web", i + "_home_web_after", 0, 40, 920, 360);
            //切割手机屏幕截图到合适大小
            imageDeal.cutImage(i + "_home", i + "_home_after", 80, 250, 920, 360);
            // imageDeal.getPicDissimilarity(i+"_home_web_after",i+"_home_after");
            i++;
        }
    }

    public Double diffrent(int i) throws Exception {
        String diffrentDegreeStr = imageDeal.getPicDissimilarity(i + "_home_after", i + "_home_web");
        Double diffrentDegree = new Double(diffrentDegreeStr);
        return diffrentDegree;
    }

    //查看首页入口组是否正确
    public  Map<String,List<String>>  checkPortalGroup(String sql) throws Exception {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        ResultSet su = testDao.query(sql);
        boolean teacherFlag = false;
        int i = 1;
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> categoryList = new ArrayList<String>();
        while (su.next()) {
            String name = su.getString("name");
            String category = su.getString("category");
            nameList.add(name);
            categoryList.add(category);
            i++;
        }
        map.put("nameList",nameList);
        map.put("categoryList",categoryList);
        return map;
    }

    public boolean getPraise() throws Exception {
        Boolean flag = false;
        String praiseCountStr     = driver.waitForElement(GaodunHomePageUI.PRAISE_COUNT_BTN).getText();
        Integer    praiseCount    = Integer.parseInt(praiseCountStr);
        Element   el              = driver.waitForElement(GaodunHomePageUI.PRAISE_BTN);
        if(el!=null){
            el.click();
        }else {
            commonUtil.verticalScroll(driver);
            driver.waitForElement(GaodunHomePageUI.PRAISE_BTN).click();
        }
        praiseCount   = praiseCount +1;
        praiseCountStr = praiseCount.toString();

        Element  praiseElement = driver.waitForElement("name",praiseCountStr);
        if(praiseElement != null){
            flag = true;
        }
        return  flag;
    }

    public boolean checkElementExit(CommonUIBean PRAISE_NUM_BTN) throws Exception {
        boolean flag = false;
        Element el = driver.waitForElement(PRAISE_NUM_BTN);
        if (el != null) {
            flag = true;
        }
        return  flag;
    }

    public void  articleComment() throws Exception {
        driver.waitForElement(GaodunHomePageUI.DISCUSS_BTN).click();
        driver.waitForElement(GaodunHomePageUI.ENTERDIS_BTN).sendKeys("这篇文章写的很好");
        driver.sleep(2000);
        driver.waitForElement(GaodunHomePageUI.SEND_BTN).click();
        driver.sleep(5000);
    }

    //返回按钮
    public void  articleBack() throws Exception {
        driver.waitForElement(GaodunHomePageUI.ARTICLEBACK_BTN).click();
    }

    //点击banner 图
    public boolean clickBanner() throws Exception {
        driver.waitForElement(GaodunHomePageUI.BANNER_BTN).click();
        boolean flag = false;
        Element bannerBackBtn  =  driver.waitForElement(GaodunHomePageUI.BANNER_BACK_BTN);
        Element bannerBackBtn1 =  driver.waitForElement(GaodunHomePageUI.BACK_BTN_1);
        Element bannerBackBtn2 =  driver.waitForElement(GaodunHomePageUI.BANNER_BACK_BTN_1);

        if(bannerBackBtn == null && bannerBackBtn1 == null && bannerBackBtn2 == null){
            driver.tap(50,80);
        }

        if(bannerBackBtn != null){
            bannerBackBtn.click();
            flag = true;

        }else if(bannerBackBtn1 != null){
            bannerBackBtn1.click();
            flag = true;

        }else if(bannerBackBtn2 != null){
            bannerBackBtn2.click();
            flag = true;
        }

        return flag;
    }


    //点击入口组 直播按钮
    public boolean checkHomePortal(Element element) throws Exception {
        Boolean flag = false;
        element.click();
        CommonUIBean   uiBean  = GaodunHomePageUI.LIVE_BACK_BTN;
        CommonUIBean   uiBean1 = GaodunHomePageUI.BACK_BTN;
        CommonUIBean   uiBean2 = GaodunHomePageUI.BACK_BTN_1;
        CommonUIBean   uiBean3 = GaodunHomePageUI.TIKU_BACK_BTN;

        if(checkElementExit(uiBean)){
            flag = true;
        }else if(checkElementExit(uiBean1)){
            uiBean = uiBean1;
            flag = true;
        }else if(checkElementExit(uiBean2)){
            uiBean = uiBean2;
            flag = true;
        }else if(checkElementExit(uiBean3)){
            uiBean = uiBean3;
            flag = true;
        }

        if(flag){
            driver.waitForElement(uiBean).click();
        }
        return flag;
    }


    //验证入口组点击。 查看元素是否存在，如果存在则点击，查看返回按钮是否存在
    public boolean clickHomePortal(Map<String,List<String>> map) throws Exception {
        boolean flag = false;
        List nameList = map.get("nameList");
        for (int i = 0; i < nameList.size(); i++) {
            if(!nameList.get(i).equals("新人礼包") && !nameList.get(i).equals("邀请好友")){
                Element el = driver.waitForElement("name", nameList.get(i).toString());
                if (el != null){
                    flag = checkHomePortal(el);
                } else {
                    flag = false;
                    break;
                }
            }
        }

        return  flag;
    }
}
