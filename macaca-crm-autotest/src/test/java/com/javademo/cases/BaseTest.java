package com.javademo.cases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import macaca.client.MacacaClient;
import macaca.client.common.MacacaDriver;
import macaca.java.biz.BaseErrorType;
import macaca.java.biz.BaseMacacaClient;
import macaca.java.biz.ResultGenerator;
import macaca.java.biz.BaseMacacaClient.PlatformType;
import com.javademo.utils.Config;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class BaseTest {

    // 屏幕截图的数目，为了实现递增的顺序
    //private int screenNum = 1;
    MacacaClient webDriver = new MacacaClient();
/*
    @Parameters({ "elementTimeout", "elementTimeInterval" })
*/
    @BeforeClass(groups = {"important","A","AllClue","Green","AllClueSearch","AllOrder","AllOrder1","AllOrder2","AllOrder3","AllOrder4"})
    public void setUp() throws Exception {
        getDriver();
   }
    
    @AfterClass(groups = {"important","A","AllClue","Green","AllClueSearch","AllOrder","AllOrder1","AllOrder2","AllOrder3","AllOrder4"})
    public void tearDown() throws Exception {

        try {
             webDriver.quit();
             webDriver.execute("window.close()");
        } catch (Exception e) {
            // TODO: handle exception
            ResultGenerator.fail("quit fail", "", BaseErrorType.FUNCTION_FAILED);
        }
    }
    @AfterMethod(groups = {"important"})
    public void savecrmcut()throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("======"+df.format(new Date())+"=======");// new Date()为获取当前系统时间
        saveScreen("crm-截图",df.format(new Date()));
    }
    /**
     * 保存当前屏幕截图-生成的截图会按照截图的先后顺序生成有序的名称
     *
     * @param fileName 图片名称，默认为.png格式,图片默认保存在screenShot目录下
     */
    public void saveScreen(String fileName,String screenNum) {
        try {
            // 判断是否存在对应目录，不存在的话则创建
//            File file = new File(Config.SCREEN_SHOT_PATH);
            File file = new File("D:\\CrmCutPng");
            if (!file.exists() || !file.isDirectory()) {
                // 没有目录 创建截屏目录
                System.out.println("没有screenshot目录，创建目录");
                boolean isMkdirSucc = file.mkdir();
                if (isMkdirSucc) {
                    System.out.println("创建screenshot目录成功");
                } else {
                    System.out.println("创建screenshot目录失败");
                }
            } else {
                System.out.println("存在screenshot目录");
            }

           // webDriver.saveScreenshot(Config.SCREEN_SHOT_PATH + File.separator + screenNum + "_" + fileName + ".png");
            webDriver.saveScreenshot("D:\\CrmCutPng"+ File.separator + screenNum + "_" + fileName + ".png");
          //  screenNum++;
        } catch (Exception e) {
            // TODO: handle exception
            ResultGenerator.fail("截屏异常", "", BaseErrorType.FUNCTION_FAILED);
        }
    }

    //删除screenshot目录下旧的截图
    public void deleteOldScreen(File oldScreen) {
        if (oldScreen.exists() && oldScreen.isDirectory()) {
            File[] files = oldScreen.listFiles();
            for (File file : files) {
                deleteOldScreen(file);
            }
        } else {
            oldScreen.delete();
        }

    }


    public static void cutJPG(InputStream input, OutputStream out, int x,
                              int y, int width, int height) throws IOException {
        ImageInputStream imageStream = null;
        try {
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = readers.next();
            imageStream = ImageIO.createImageInputStream(input);
            reader.setInput(imageStream, true);
            ImageReadParam param = reader.getDefaultReadParam();

            System.out.println(reader.getWidth(0));
            System.out.println(reader.getHeight(0));
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            ImageIO.write(bi, "jpg", out);
        } finally {
            imageStream.close();
        }
    }


    public static ThreadLocal<MacacaClient> ThreadDriver=new ThreadLocal<MacacaClient>();

    MacacaClient getDriver() throws  Exception{
        MacacaClient driver=ThreadDriver.get();
        if(driver==null){//如果当前线程没有绑定driver，则根据.xml配置文件创建driver并使用ThreadDriver.set()方法绑定到线程中。
            JSONObject  prefs = new JSONObject();
            // 设置提醒的设置，2表示block
            prefs.put("profile.default_content_setting_values.notifications", 2);
            JSONObject  prefs1 = new JSONObject();
            prefs1.put("prefs",prefs);

            JSONObject porps = new JSONObject();
            porps.put("browserName", "chrome");
            porps.put("platformName", "desktop");
            porps.put("chromeOptions",prefs1);

            JSONObject desiredCapabilities = new JSONObject();
            desiredCapabilities.put("desiredCapabilities", porps);
            webDriver.initDriver(desiredCapabilities).maximize().get(Config.cmsUrl);
            webDriver.sleep(2000);
            webDriver.elementsByClassName("el-input__inner").get(0).sendKeys(Config.cmsUserName);
            webDriver.elementsByClassName("el-input__inner").get(1).sendKeys(Config.cmsUserPwd);
            webDriver.elementByClassName("el-button").click();
            webDriver.sleep(3000);
            ThreadDriver.set(driver);
        }
        return driver;
    }

}
