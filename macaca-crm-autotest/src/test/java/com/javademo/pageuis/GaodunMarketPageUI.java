package com.javademo.pageuis;

public class GaodunMarketPageUI {
    public static final String  MARKET_TIP ="p.el-message__content";//提示
    //1新建彩信模板
    public static final String MMS_NAME="(.//*[normalize-space(text()) and normalize-space(.)='彩信名称'])[1]/following::input[1]";//彩信名称
    public static final String MMS_RAESON="(.//*[normalize-space(text()) and normalize-space(.)='申请原因'])[1]/following::textarea[1]";//申请原因
    public static final String MMS_SCREEN="(.//*[normalize-space(text()) and normalize-space(.)='彩信分屏'])[1]/following::span[1]";//彩信分屏
    public static final String MMS_WORD="(.//*[normalize-space(text()) and normalize-space(.)='文字内容：'])[1]/following::textarea[1]";//文字内容
    public static final String MMS_CONFIRM="//*[@id='app']/div/section/div/div/div[2]/div/div[3]/span/button[2]";//确定
    public static final String MMS_SAVE="//*[@id='app']/div/section/div/div/div[1]/div[5]/button[1]";//保存


   //2新建短信模板
    public static final String MESSAGE_NAME ="(.//*[normalize-space(text()) and normalize-space(.)='模板标题'])[1]/following::input[1]";//模板标题
    public static final String MESSAGE_WORD ="(.//*[normalize-space(text()) and normalize-space(.)='短信内容'])[1]/following::textarea[1]";//短信内容
    public static final String MESSAGE_APPLICATION ="(.//*[normalize-space(text()) and normalize-space(.)='申请说明'])[1]/following::textarea[1]";//申请说明
    public static final String MESSAGE_DOWN ="//*[@id='app']/div/section/div/div/div/div[4]/div[1]/span";//点出来
    public static final String MESSAGE_SAVE ="//*[@id='app']/div/section/div/div/div/div[5]/button";//保存

   //3新建市场营销活动
    public static final String ACTIVITY_NAME="//*[@id='app']/div/section/div/div/form/div[1]/div/div[1]/input";//名称
    public static final String PRICIPAL ="(.//*[normalize-space(text()) and normalize-space(.)='负责人'])[1]/following::input[1]";//负责人
    public static final String PRICIPAL1 ="(.//*[normalize-space(text()) and normalize-space(.)='本人'])[1]/following::span[1]";//+号
    public static final String PRICIPAL2 ="(.//*[normalize-space(text()) and normalize-space(.)='autotest5'])[2]/following::span[2]";//选autotest8
    public static final String PROJECT ="(.//*[normalize-space(text()) and normalize-space(.)='所属项目'])[1]/following::input[1]";//所属项目
    public static final String PROJECT1 ="(.//*[normalize-space(text()) and normalize-space(.)='金融'])[1]/following::li[1]";//
    public static final String PROVINCE ="(.//*[normalize-space(text()) and normalize-space(.)='省市'])[1]/following::input[1]";//省
    public static final String PROVINCE1 ="(.//*[normalize-space(text()) and normalize-space(.)='黑龙江'])[1]/preceding::li[1]";//
    public static final String CITY ="(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::input[1]";//市
    public static final String TEACHER ="(.//*[normalize-space(text()) and normalize-space(.)='讲师'])[1]/following::input[1]";//讲师
    public static final String CLASSTIME ="(.//*[normalize-space(text()) and normalize-space(.)='课时'])[1]/following::input[1]";//课时
    public static final String ACTIVITYTIME ="(.//*[normalize-space(text()) and normalize-space(.)='活动时间'])[1]/following::i[1]";//活动时间
    public static final String ACTIVITYTIME1 ="(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[30]";//
    public static final String ACTIVITYTIME2 ="(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::span[33]";//
    public static final String CONFIRM ="(.//*[normalize-space(text()) and normalize-space(.)='清空'])[1]/following::span[1]";//确定
    public static final String SCHOOL ="(.//*[normalize-space(text()) and normalize-space(.)='学校'])[1]/following::input[1]";//学校
    public static final String BUDGET ="(.//*[normalize-space(text()) and normalize-space(.)='预算金额'])[1]/following::input[1]";//预算金额
    public static final String ACTIVITYTYPE ="(.//*[normalize-space(text()) and normalize-space(.)='活动类型'])[1]/following::input[1]";//活动类型
    public static final String TV ="(.//*[normalize-space(text()) and normalize-space(.)='直播'])[1]/following::li[1]";//图书
    public static final String STATMENT ="(.//*[normalize-space(text()) and normalize-space(.)='说明'])[1]/following::textarea[1]";//说明
    public static final String ACTIVITYPAGE ="(.//*[normalize-space(text()) and normalize-space(.)='活动主页'])[1]/following::input[1]";//活动主页
    public static final String ACTIVITYSAVE ="(.//*[normalize-space(text()) and normalize-space(.)='活动主页'])[1]/following::span[1]";//立即提交

    //4修改市场营销活动
    public static final String INPUT="//*[@id='app']/div/section/div/div/form/div[1]/div/div/div[2]/div/input";//搜索框
    public static final String SEARCH="//*[@id='app']/div/section/div/div/form/div[1]/div/div/div[7]/button";//查询按钮
    public static final String DATALINE="//*[@id='app']/div/section/div/div/div/div[1]/div[4]/div[2]/table/tbody/tr/td[5]/div/a/button/span";//修改第一行
    public static final String ACTIVITY_NAME4="(.//*[normalize-space(text()) and normalize-space(.)='名称'])[1]/following::input[1]";//名称
    public static final String DELPRINCIPAL="//*[@id='app']/div/section/div/div/form/div[2]/div/div/i";//删除原有负责人
    public static final String CLICKPRICIPAL="(.//*[normalize-space(text()) and normalize-space(.)='负责人'])[1]/following::input[1]";//点击负责人
    public static final String PRICIPAL1_4 ="(.//*[normalize-space(text()) and normalize-space(.)='本人'])[1]/following::span[1]";//+号
    public static final String PRICIPAL2_4 ="(.//*[normalize-space(text()) and normalize-space(.)='autotest5'])[2]/preceding::span[2]";//选择负责人
    public static final String PROJECT4 ="//*[@id='app']/div/section/div/div/form/div[3]/div/div/div[1]/span/span/i";//删所属项目
    public static final String PROJECT1_4 ="//*[@id='app']/div/section/div/div/form/div[3]/div/div[1]/div[2]/input";//点
    public static final String PROVINCE4="(.//*[normalize-space(text()) and normalize-space(.)='省市'])[1]/following::input[1]";//省
    public static final String CITY4 ="(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::input[1]";//市
    public static final String TEACHER4="(.//*[normalize-space(text()) and normalize-space(.)='讲师'])[1]/following::input[1]";//讲师
    public static final String CLASSTIME4 ="(.//*[normalize-space(text()) and normalize-space(.)='课时'])[1]/following::input[1]";//课时
    public static final String ACTIVITYTIME_4 ="(.//*[normalize-space(text()) and normalize-space(.)='活动时间'])[1]/following::i[1]";//活动时间
    public static final String ACTIVITYTIME1_4 ="(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[29]";//
    public static final String ACTIVITYTIME2_4 ="(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::span[29]";//
    public static final String CONFIRM4="(.//*[normalize-space(text()) and normalize-space(.)='清空'])[1]/following::button[1]";//确定
    public static final String SCHOOL4 ="(.//*[normalize-space(text()) and normalize-space(.)='学校'])[1]/following::input[1]";//学校
    public static final String BUGET4 ="(.//*[normalize-space(text()) and normalize-space(.)='预算金额'])[1]/following::input[1]";//预算金额
    public static final String ACTIVITYTYPE4 ="(.//*[normalize-space(text()) and normalize-space(.)='活动类型'])[1]/following::input[1]";//活动类型
    public static final String IFSHOW="(.//*[normalize-space(text()) and normalize-space(.)='是否显示'])[1]/following::span[1]";//是否显示
    public static final String STATMENT4 ="(.//*[normalize-space(text()) and normalize-space(.)='说明'])[1]/following::textarea[1]";//说明
    public static final String ACTIVITYPAGE4 ="(.//*[normalize-space(text()) and normalize-space(.)='活动主页'])[1]/following::input[1]";//活动主页
    public static final String ACTIVITYSAVE4 ="(.//*[normalize-space(text()) and normalize-space(.)='活动主页'])[1]/following::span[1]";//立即提交

    //5发短信
    public static final String SENDMESSAGE="//*[@id='app']/div/section/div/div/div/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[5]/div/button[3]/span";//发短信给第一条活动
    public static final String TASKNAME="(.//*[normalize-space(text()) and normalize-space(.)='任务名称:'])[1]/following::input[1]";//任务名称
    public static final String SELECTMEESAGE="/html/body/div[2]/div[2]/div/div/form/div[4]/div/div/div/div[1]/label/span[1]/span";//选择第一条短信
    public static final String SENDTIME="(.//*[normalize-space(text()) and normalize-space(.)='发送时间:'])[1]/following::input[1]";//发送时间
    public static final String SELECTTIME="(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[22]";//选择时间
    public static final String TIMECONFIRM="(.//*[normalize-space(text()) and normalize-space(.)='此刻'])[1]/following::span[1]";//确定
    public static final String MESSAGESAVE="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::button[1]";//保存

    //6发彩信
    public static final String SENDMMS="//*[@id='app']/div/section/div/div/div/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[5]/div/button[2]/span";//发彩信给第一条
    public static final String SELECTMMS="/html/body/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[1]/label/span[1]/span";//选择第一条模板
    public static final String MMSSENDTIME="(.//*[normalize-space(text()) and normalize-space(.)='发送时间:'])[1]/following::input[1]";//发送时间
    public static final String SELECTMMSTIME="(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[30]";//选择时间
    public static final String MMSCONFIRM="(.//*[normalize-space(text()) and normalize-space(.)='此刻'])[1]/following::button[1]";//确定
    public static final String MMSSAVE="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::span[1]";//保存

}
