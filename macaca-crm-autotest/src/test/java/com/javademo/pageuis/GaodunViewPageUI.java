package com.javademo.pageuis;

public class GaodunViewPageUI {
    public static final String    VIEW_BUILT =  "(.//*[normalize-space(text()) and normalize-space(.)='测试'])[1]/following::button[1]";//新建视图
    public static final String    VIEW_CONDITION =  "(.//*[normalize-space(text()) and normalize-space(.)='操作'])[1]/following::input[1]";//名称
    public static final String    VIEW_VIEWNAME =  "(.//*[normalize-space(text()) and normalize-space(.)='视图名称'])[1]/following::input[1]";//条件
    public static final String    VIEW_VALUE =  "(.//*[normalize-space(text()) and normalize-space(.)='操作'])[1]/following::input[3]";//值
    public static final String    VIEW_VALUECLICK =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[1]/following::input[1]";//值
    public static final String    VIEW_VALUETEMA =  "(//input[@type='text'])[7]";//值
    public static final String    VIEW_VALUEINPUT =  "div.g-extend-ztree-area > div.el-input.el-input--small > input.el-input__inner";//值
    public static final String    VIEW_VALUEINPUTCLICK =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[1]/following::span[2]";//值
    public static final String    VIEW_VALUEAUTO =  "(.//*[normalize-space(text()) and normalize-space(.)='自动化测试'])[1]/preceding::span[3]";//自动化测试组
    public static final String    VIEW_VALUEAUTO9 =  "(.//*[normalize-space(text()) and normalize-space(.)='autotest5'])[2]/following::span[2]";//AUTO9
    public static final String    VIEW_VALUECONFIG =  "(.//*[normalize-space(text()) and normalize-space(.)='配置'])[1]/following::i[1]";//配置
    public static final String    VIEW_VALUEPLAN =  "(.//*[normalize-space(text()) and normalize-space(.)='营销计划'])[1]/preceding::span[1]";//营销计划
    public static final String    VIEW_VALUEPLANSAVE =  "(.//*[normalize-space(text()) and normalize-space(.)='营销计划'])[2]/following::span[1]";//营销计划
    public static final String    VIEW_ASSOCIATES =  "(.//*[normalize-space(text()) and normalize-space(.)='手机'])[1]/following::span[2]";//协作人
    public static final String    VIEW_ASSOCIATESSAVE =  "(.//*[normalize-space(text()) and normalize-space(.)='协作人'])[2]/following::span[1]";//协作人
    public static final String    VIEW_SAVE =  "(.//*[normalize-space(text()) and normalize-space(.)='收起'])[1]/following::button[1]";//保存
    public static final String    VIEW_CHIOCE =  "(.//*[normalize-space(text()) and normalize-space(.)='学管工作台'])[1]/following::input[1]";//保存
    public static final String    VIEW_SEARCHPEOJECT =  "(.//*[normalize-space(text()) and normalize-space(.)='查询对象'])[1]/following::input[1]";//查询对象

    public static final String    VIEW_SEARCHPEOJECT1 =  "(.//*[normalize-space(text()) and normalize-space(.)='线索'])[1]/following::li[1]";//查询对象
    public static final String    VIEW_CONFIG =  "(.//*[normalize-space(text()) and normalize-space(.)='自定义显示列'])[1]/following::button[1]";//配置
    public static final String    VIEW_SEARCHPEOJECT2 =  "(.//*[normalize-space(text()) and normalize-space(.)='查询对象'])[2]/following::input[1]";//配置查询对象
    public static final String    VIEW_SEARCHPEOJECT3 =  "(.//*[normalize-space(text()) and normalize-space(.)='线索'])[2]/following::li[1]";//配置查询对象
    public static final String    VIEW_PLANID =  "(.//*[normalize-space(text()) and normalize-space(.)='手机'])[1]/following::span[3]";//ID
    public static final String    VIEW_PLANIDSAVE =  "(.//*[normalize-space(text()) and normalize-space(.)='订单ID'])[2]/following::button[1]";//ID
    public static final String    VIEW_TIME1 =  "(.//*[normalize-space(text()) and normalize-space(.)='区间'])[1]/following::input[1]";//时间
    public static final String    VIEW_TIME2 =  "(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::input[1]";//时间
    public static final String    VIEW_PAGE =  "(.//*[normalize-space(text()) and normalize-space(.)='前往页'])[1]/preceding::input[1]";//页码
    public static final String    VIEW_PAGE1 =  "(.//*[normalize-space(text()) and normalize-space(.)='测试'])[1]/following::span[6]";//页码
    public static final String    VIEW_CHANGEVIEW =  "(.//*[normalize-space(text()) and normalize-space(.)='新建视图'])[1]/following::span[1]";//修改视图
    public static final String    VIEW_VIEW =  "(.//*[normalize-space(text()) and normalize-space(.)='修改视图'])[1]/following::span[1]";//修改视图
    public static final String    VIEW_ADD1 =  "(.//*[normalize-space(text()) and normalize-space(.)='上月'])[1]/following::a[1]";//添加1
    public static final String    VIEW_ADD2 =  "(.//*[normalize-space(text()) and normalize-space(.)='上月'])[2]/following::a[1]";//添加2
    public static final String    VIEW_CHOUSE1 =  "(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::input[2]";//感兴趣的项目
    public static final String    VIEW_VALUE1 =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[2]/following::input[2]";//感兴趣的项目
    public static final String    VIEW_VALUE2 =  "(.//*[normalize-space(text()) and normalize-space(.)='毕马威'])[1]/following::input[1]";//感兴趣的项目
    public static final String    VIEW_CHOUSE2 =  "(.//*[normalize-space(text()) and normalize-space(.)='阿米巴'])[1]/following::input[3]";//职业状态
    public static final String    VIEW_VALUE3 =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[3]/following::input[2]";//职业状态
    public static final String    VIEW_ID =  "(.//*[normalize-space(text()) and normalize-space(.)='客户编号'])[2]/following::span[2]";//ID线索ID
    public static final String    VIEW_IDSAVE =  "(.//*[normalize-space(text()) and normalize-space(.)='线索ID'])[2]/following::button[1]";//ID
    public static final String    VIEW_CHOUSE11 =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[1]/following::input[2]";//
    public static final String    VIEW_VALUE11 =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[2]/following::input[1]";//
    public static final String    VIEW_VALUE12 =  "(.//*[normalize-space(text()) and normalize-space(.)='包含'])[3]/following::input[1]";//
    public static final String    VIEW_SHARE =  "(.//*[normalize-space(text()) and normalize-space(.)='启用'])[1]/following::span[1]";//共享
    public static final String    VIEW_SHARE1 =  "(.//*[normalize-space(text()) and normalize-space(.)='用户：'])[1]/following::input[1]";//共享
    public static final String    VIEW_SHARE2 =  "(.//*[normalize-space(text()) and normalize-space(.)='未匹配到'])[1]/following::input[1]";//共享
    public static final String    VIEW_SHARE3 = "(.//*[normalize-space(text()) and normalize-space(.)='未匹配到'])[1]/following::input[1]";//共享
    public static final String    VIEW_SHARE4 = "(.//*[normalize-space(text()) and normalize-space(.)='用户：'])[1]/following::span[6]";//共享
    public static final String    VIEW_SHARESAVE="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/preceding::button[1]";//共享
    public static final String    VIEW_START="(.//*[normalize-space(text()) and normalize-space(.)='共享'])[1]/following::span[1]";//启用
    public static final String    VIEW_START1="(.//*[normalize-space(text()) and normalize-space(.)='autotest5'])[2]/following::div[2]";//启用
    public static final String    VIEW_DELETE="(.//*[normalize-space(text()) and normalize-space(.)='停用'])[1]/following::span[1]";//删除
    public static final String    VIEW_DELETE1="(.//*[normalize-space(text()) and normalize-space(.)='操作'])[1]/following::div[2]";//删除
    public static final String    VIEW_PLAN="(.//*[normalize-space(text()) and normalize-space(.)='本人'])[1]/following::span[2]";



    public static final String    PROD_ADD="(.//*[normalize-space(text()) and normalize-space(.)='产品性质权限'])[1]/following::span[2]";
    public static final String    PROD_ADDNAME="(.//*[normalize-space(text()) and normalize-space(.)='产品名称'])[4]/following::input[1]";
    public static final String    PROD_ADDPROJECT="(.//*[normalize-space(text()) and normalize-space(.)='所属项目'])[4]/following::input[1]";
    public static final String    PROD_ADDTYPE="(.//*[normalize-space(text()) and normalize-space(.)='产品类型'])[4]/following::input[1]";
    public static final String    PROD_BEGINTIME="(.//*[normalize-space(text()) and normalize-space(.)='开始日期'])[1]/following::input[1]";
    public static final String    PROD_ENDTIME="(.//*[normalize-space(text()) and normalize-space(.)='结束日期'])[1]/following::input[1]";
    public static final String    PROD_ADDPRO="(.//*[normalize-space(text()) and normalize-space(.)='产品模块'])[1]/following::input[1]";
    public static final String    PROD_ADDHOUR="(.//*[normalize-space(text()) and normalize-space(.)='课时（小时）'])[4]/following::input[1]";
    public static final String    PROD_ADDPRICE="(.//*[normalize-space(text()) and normalize-space(.)='价格'])[4]/following::input[1]";
    public static final String    PROD_ADDPERIOD="(.//*[normalize-space(text()) and normalize-space(.)='周期 (月)'])[1]/following::input[1]";
    public static final String    PROD_ADDCOURSE="(.//*[normalize-space(text()) and normalize-space(.)='课程性质'])[1]/following::input[1]";
    public static final String    PROD_ADDSAVE="(.//*[normalize-space(text()) and normalize-space(.)='保存'])[1]/following::button[1]";
    public static final String    PROD_FIRSTNAME="(.//*[normalize-space(text()) and normalize-space(.)='操作'])[2]/following::div[3]";
    public static final String    PROD_SEARCH="(.//*[normalize-space(text()) and normalize-space(.)='生成班级'])[1]/following::input[1]";
    public static final String    PROD_SEARCHBTN="(.//*[normalize-space(text()) and normalize-space(.)='生成班级'])[1]/following::i[1]";
    public static final String    PROD_SEARCHFIRST="(.//*[normalize-space(text()) and normalize-space(.)='操作'])[2]/following::span[2]";
    public static final String    PROD_SEARCHSTOP="(.//*[normalize-space(text()) and normalize-space(.)='停用'])[1]/i[1]";
    public static final String    PROD_SEARCHSTOPSAVE="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::span[1]";
    public static final String    PROD_STATE="(.//*[normalize-space(text()) and normalize-space(.)='是'])[1]/preceding::div[2]";

    public static final String    PROD_SEARCHDELETE="(.//*[normalize-space(text()) and normalize-space(.)='删除'])[1]/i[1]";
}
