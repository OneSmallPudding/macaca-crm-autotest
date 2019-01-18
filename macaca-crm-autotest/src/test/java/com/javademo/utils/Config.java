package com.javademo.utils;

import java.io.File;


public class Config {





    public static final String databaseUrl         = ""; //test
    /*   //pre
    public static final String  DATABASE_URL       = "offline.haproxy.gaodunwangxiao.com:13307";
    public static final String  DATABASE_NAME      = "gaodun_beta";
    public static final String  DATABASE_PWD       = "gasb43Fcsg";
    public static final String   batchAllotMany     = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName in (";
    public static final String   batchAllotSingle   = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName =";

    public static final String  cmsUrl             = "https://pre-baiyi.gaodun.com/#/login" ; //test
    public static final String  cmsCommentUrl      = "https://pre-baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ; //test
    public static final String  cmsCluesUrl      = "https://pre-baiyi.gaodun.com/#/Index" ; //test
    public static final String  cmsTableManage      = "https://pre-baiyi.gaodun.com/#/tableManage" ; //test
    public static final String  cmsClass      = "https://pre-baiyi.gaodun.com/#/class" ; //test
    public static final String  cmsOrderUrl        = "https://pre-baiyi.gaodun.com/#/order" ;//test
    public static final String  cmsCluesIndexUrl      = "https://pre-baiyi.gaodun.com/#/cluesIndex" ; //test
    public static final String  cmsUserTel         = "12300475413";//test
        public static final String  cmsUserInternationalTel  = "00119403548675";
    public static final String  Table      = "Tpo_Sys_Users" ; //test
    public static final String  Table1      = "Tpo_Sys_Department_User" ; //test
    public static final String  Table2      = "Tpo_Sys_Departments" ; //test
    public static final String  repeatTel13         = "10505973503";//  crm项目别人名下的手机号
    public static final String  cmsClueUrl         = "https://pre-baiyi.gaodun.com/#/cluesIndex";
    public static final String  cmsAddClientUrl    = "https://pre-baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ;
*/


    /* //test
    public static final String  DATABASE_URL       = "offline.haproxy.gaodunwangxiao.com:3306";
    public static final String  DATABASE_NAME      = "gaodun_test";
    public static final String  DATABASE_PWD       = "414639e58d";
    public static final String   batchAllotMany     = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName in (";
    public static final String   batchAllotSingle   = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName =";
    public static final String  cmsAddClientUrl    = "https://t-baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ;
    public static final String  cmsUrl             = "https://t-baiyi.gaodun.com/#/login" ; //test
    public static final String  cmsCommentUrl      = "https://t-baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ; //test
    public static final String  cmsCluesUrl      = "https://t-baiyi.gaodun.com/#/Index" ; //test
    public static final String  cmsOrderUrl        = "https://t-baiyi.gaodun.com/#/order" ;//test
    public static final String  cmsCluesIndexUrl      = "https://t-baiyi.gaodun.com/#/cluesIndex" ; //test
    public static final String  cmsClueUrl         = "https://t-baiyi.gaodun.com/#/cluesIndex";
    public static final String  cmsUserTel         = "11505606688";//test
    public static final String  repeatTel13         = "10505973503";//  crm项目别人名下的手机号
    public static final String  cmsUserInternationalTel  = "00113507555764";
    public static final String  Table      = "Tpo_Sys_Users" ; //test
    public static final String  Table1      = "Tpo_Sys_Department_User" ; //test
    public static final String  Table2      = "Tpo_Sys_Departments" ; //test
    */

//    public static final String  cmsUserName        = "admin@gaodun.com";
//    public static final String  cmsUserPwd         = "123456";

//    public static final String  cmsUserName        = "xiayunjia@gaodun.com";
//    public static final String  cmsUserPwd         = "gaodun1234";

    public static final String  cmsUserName        = "auto_personal_5@gaodun.com";
    public static final String  cmsUserPwd         = "123456q";

  //   //RPOD
    public static final String  DATABASE_URL       = "offline.haproxy.gaodunwangxiao.com:9988";
    public static final String  DATABASE_NAME      = "dev";
    public static final String  DATABASE_PWD       = "ji35LEWiR5";
    public static final String   batchAllotMany     = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName in (";
    public static final String   batchAllotSingle   = "SELECT TSU.TrueName 'TrueName' FROM crm.CustomInfo CI JOIN crm.Clue_Status CS ON CI.Guid = CS.CustomGuid JOIN gd_permission.Tpo_Sys_Users TSU ON CS.ClueOwner = TSU.UserID WHERE CI.TrueName =";

    public static final String  cmsUserTel         = "12500191824";//prod
    public static final String  repeatTel13         = "10002652992";//prod
    public static final String  cmsUserInternationalTel  = "00119101357621";//prod
    public static final String  cmsOrderUrl        = "https://baiyi.gaodun.com/#/order" ;//prod
    public static final String  cmsCommentUrl      = "https://baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ; //prod
    public static final String  cmsUrl             = "https://baiyi.gaodun.com/#/login" ; //prod
    public static final String  cmsCluesUrl      = "https://baiyi.gaodun.com/#/index" ; //prod
    public static final String  cmsCluesIndexUrl      = "https://baiyi.gaodun.com/#/cluesIndex" ; //prod
    public static final String  cmsAddClientUrl      = "https://baiyi.gaodun.com/#/clue/addClientele?nid=521&nw=1" ; //prod
    public static final String  cmsClueUrl      = "https://baiyi.gaodun.com/#/cluesIndex" ; //prod
    public static final String  cmsTableManage      = "https://baiyi.gaodun.com/#/tableManage" ; //test
    public static final String  cmsClass      = "https://baiyi.gaodun.com/#/class" ; //test

    //    public static final String  Table      = "Tpo_Sys_Users" ; //prod
    public static final String  Table      = "tpo_sys_users" ; //prod
    public static final String  Table1      = "tpo_sys_department_user" ; //prod
    public static final String  Table2      = "tpo_sys_departments" ; //prod


    public static final int     readScore          = 10;
    public static final int     readMaxScore       = 60;
    public static final int     commentScore       = 20;
    public static final int     commentMaxScore    = 300;
    public static final int     signinScore        = 5;
    public static final int     signinExtraDay     = 7;
    public static final int     signinExtraScore   = 10;
    public static  int          totalScore         = 0;
    // 用户名
    public static  String USER_NAME           = "15655103835";
    // 密码
    public static final String PASSWORD            = "password";

    // 根目录
    public static final String ROOT_PATH           = System.getProperty("user.dir");
    //截图保存目录
    public static final String SCREEN_SHOT_PATH    = ROOT_PATH + File.separator + "screenshot";
    //结果日志保存文件
    public static final String RESULT_LOG_PATH     = ROOT_PATH + File.separator + "result.log";
    // 目标平台- ios android
    public static final String PLATFORM            = "android";
    // 是否覆盖安装 3-覆盖安装
    public static final int REUSE                  = 3;

    // ios平台相关信息 各参数含义参考 https://macacajs.github.io/macaca/desired-caps.html
    public static final String IOS_PLATFORM_NAME   = "ios";
    public static final String IOS_DEVICE_NAME     = "iPhone 6s";
    public static final String IOS_APP             = "https://npmcdn.com/ios-app-bootstrap@latest/build/ios-app-bootstrap.zip";
//    public static final String IOS_UDID = "3458343D-AFB1-46E1-BE33-99E04B2DE07";

    // 安卓平台相关信息
    public static final String ADR_PLATFORM_NAME    = "Android";
   // public static final String ADR_APP = ROOT_PATH + File.separator + "app/android-app-bootstrap.zip";
//    public static final String ADR_APP              = ROOT_PATH + File.separator + "app/app-gaodun-debug.apk";
    public static final String ADR_APP              = ROOT_PATH + File.separator + "app/m.apk";

    // 多台设备时，如果指定某一台设备可以在这里指定udid
    public static final String ADR_UDID             = "";

}
