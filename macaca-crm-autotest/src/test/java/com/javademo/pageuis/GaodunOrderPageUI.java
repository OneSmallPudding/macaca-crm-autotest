package com.javademo.pageuis;

public class GaodunOrderPageUI {
    public static final String    BOOK_BTN =  "//button[3]/span/a";
    public static final String    EMERGE_CONTECT  = "(.//*[normalize-space(text()) and normalize-space(.)='紧急联系人'])[1]/following::input[1]";
    public static final String    EMERGE_CONTECT_TEL  = "(.//*[normalize-space(text()) and normalize-space(.)='紧急联系人电话'])[1]/following::input[1]";
    public static final String    EMAIL = "(.//*[normalize-space(text()) and normalize-space(.)='电子邮箱'])[1]/following::input[1]";
    public static final String    CERTIFICATE_NO = "(.//*[normalize-space(text()) and normalize-space(.)='证件号码'])[1]/following::input[1]";
    public static final String    EXPECT_CLASSTIME = "(.//*[normalize-space(text()) and normalize-space(.)='期望上课时间'])[1]/following::i[1]";
    public static final String    EXPECT_CLASSTIME1 = "(.//*[normalize-space(text()) and normalize-space(.)='日'])[1]/preceding::button[1]";
    public static final String    EXPECT_CLASSTIME2 = "(.//*[normalize-space(text()) and normalize-space(.)='六'])[1]/following::span[7]";
    public static final String    OPENCLASS_SHOOL  =  "(.//*[normalize-space(text()) and normalize-space(.)='上课校区'])[1]/following::input[1]";
    public static final String    OPENCLASS_SHOOLCHOOSE   =   "(.//*[normalize-space(text()) and normalize-space(.)='广东-深圳'])[2]/following::span[1]";
    public static final String    BOOK_SCHOOL      =  "(.//*[normalize-space(text()) and normalize-space(.)='报名校区'])[1]/following::input[1]";
    public static final String    BOOK_SCHOOLCHOOSE      =  "(.//*[normalize-space(text()) and normalize-space(.)='广东-珠海'])[2]/following::li[1]";
    public static final String    OPEM_CLASSCOUNT      = "(.//*[normalize-space(text()) and normalize-space(.)='开课账号'])[1]/following::input[1]";
    public static final String    ENROLLMENT_YEAR   = "(.//*[normalize-space(text()) and normalize-space(.)='入学年份'])[1]/following::input[1]";
    public static final String    ENROLLMENT_YEAR_CHOOSE = "(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::a[1]";
    public static final String     MAJOR  =  "(.//*[normalize-space(text()) and normalize-space(.)='专业'])[1]/following::input[1]";
    public static final String     ADDRESS  = "(.//*[normalize-space(text()) and normalize-space(.)='快递寄送地址'])[1]/following::input[1]";
    public static final String     COURSE_CHOOSE  = "(.//*[normalize-space(text()) and normalize-space(.)='价格'])[2]/following::span[2]";
    public static final String     ORDER_SAVE = "(.//*[normalize-space(text()) and normalize-space(.)='合同备注:'])[1]/following::span[1]";
    public static final String     OFFICERS  = "(.//*[normalize-space(text()) and normalize-space(.)='护照'])[1]/preceding::span[1]";
    public static final String     CERTIFICATETYPE  = "(.//*[normalize-space(text()) and normalize-space(.)='证件类型'])[1]/following::input[1]";


    public static final String  CLUE_MYORDER ="tab-508";//我的订单
    public static final String  CLUE_MYORDERPAY ="(.//*[normalize-space(text()) and normalize-space(.)='我的订单'])[1]/following::span[1]";//我的定金
    public static final String  CLUE_MYORDERPAYSERACH ="(//input[@type='text'])[3]";//搜索框
    public static final String  CLUE_MYORDERFRIST ="//div[2]/table/tbody/tr/td/div/label/span/span";//选择第一个
    public static final String  CLUE_MYORDERCHANGE ="//div[5]/div[2]/table/tbody/tr/td[19]/div/div/span/a";//点击修改
    public static final String  CLUE_MYORDERCHANGETYPE ="(.//*[normalize-space(text()) and normalize-space(.)='订单类型'])[1]/following::input[1]";//订单类型
    public static final String  CLUE_MYORDERCHANGESTU ="(.//*[normalize-space(text()) and normalize-space(.)='销售复购'])[1]/following::li[1]";//学员复购
    public static final String  CLUE_MYORDERCHANGENO ="(.//*[normalize-space(text()) and normalize-space(.)='元'])[1]/following::span[2]";//定金选择否
    public static final String  CLUE_MYORDERCHANGESCHOOL ="(.//*[normalize-space(text()) and normalize-space(.)='学校'])[1]/following::input[1]";//学校
    public static final String  CLUE_MYORDERCHANGESAVE ="//div[4]/div/div/button/span";//保存
    public static final String  CLUE_RELEVANCEHINT ="p.el-message__content";//提示
    public static final String  CLUE_MYORDERCHANGEPROJECT ="(.//*[normalize-space(text()) and normalize-space(.)='报名项目'])[1]/following::input[1]";//报名项目
    public static final String  CLUE_MYORDERCEHINTACCA ="(.//*[normalize-space(text()) and normalize-space(.)='CTA'])[1]/following::li[1]";//选择acca
    public static final String  CLUE_MYORDERCEHINTGETPRO ="//a/span";//选择课程
    public static final String  CLUE_MYORDERCEHINTGETPEOJ ="//td/div/label/span/span";//选择课程
    public static final String  CLUE_MYORDERCEHINTACC ="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::button[1]";//确认
    public static final String  CLUE_MYORDERNOTACC ="(.//*[normalize-space(text()) and normalize-space(.)='我的定金'])[1]/following::span[1]";//未完成订单
    public static final String  CLUE_MYORDERALL ="//li[3]/span";//所有订单
    public static final String  CLUE_MYORDERALLSEARCH ="(.//*[normalize-space(text()) and normalize-space(.)='未匹配到'])[1]/following::input[2]";//所有订单
    public static final String  CLUE_MYORDERALLCHANGE ="//div[5]/div[2]/table/tbody/tr/td[24]/div/div/span/a";//修改
    public static final String  CLUE_MYORDERALLPAPER ="(//input[@type='text'])[22]";//早报优惠
    public static final String  CLUE_MYORDERALLPROJECT ="(//input[@type='text'])[23]";//项目优惠
    public static final String  CLUE_MYORDERBACK ="//li[4]/span";//退回
    public static final String  CLUE_MYORDERCHANGEPAY ="//div[5]/div[2]/table/tbody/tr/td[19]/div/a";//退回
    public static final String  CLUE_MYORDERGETPAY ="(.//*[normalize-space(text()) and normalize-space(.)='修改'])[3]/following::span[1]";//点击支付
    public static final String  CLUE_MYORDERGETPAYBTN ="//div[5]/div/div/button";//点击支付框的确认
    public static final String  CLUE_MYORDERGETPAYTYPE ="(.//*[normalize-space(text()) and normalize-space(.)='支付方式：'])[1]/following::input[1]";//支付方式
    public static final String  CLUE_MYORDERGETPAYNUM ="(.//*[normalize-space(text()) and normalize-space(.)='支付金额：'])[1]/following::input[1]";//支付金额
    public static final String  CLUE_MYORDERGETPAYPTHONE ="(.//*[normalize-space(text()) and normalize-space(.)='支付流水：'])[1]/following::input[1]";//支付流水
    public static final String  CLUE_MYORDERGETPAYTIME ="(.//*[normalize-space(text()) and normalize-space(.)='支付时间：'])[1]/following::input[1]";//支付时间
    public static final String  CLUE_MYORDERGETPAYTIMEBTN ="button.el-button.el-picker-panel__link-btn.el-button--text.el-button--mini";//此刻
    public static final String  CLUE_MYORDERPAYED ="div.cell > span";//获取支付过的金额
    public static final String  CLUE_MYORDERTYPE ="input.el-input__inner";//订单状态
    public static final String  CLUE_MYORDERTYPECHANGE ="el-select-dropdown__item";//选择定金
    public static final String  CLUE_MYORDERCOMMIT ="(.//*[normalize-space(text()) and normalize-space(.)='修改'])[3]/following::span[1]";//提交
    public static final String  CLUE_MYORDERCOMMITBTN ="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[2]/following::button[1]";//确定
    public static final String  CLUE_MYORDERCOMMITDIS ="(.//*[normalize-space(text()) and normalize-space(.)='提交审核'])[1]/following::span[1]";//取消
    public static final String  CLUE_MYORDERALPAY ="div.cell > span";//已付金额
    public static final String  CLUE_ORDERAUDIT ="(.//*[normalize-space(text()) and normalize-space(.)='电子协议'])[1]/following::div[1]";//订单审核
    public static final String  CLUE_ORDERAUDITWAIT ="//li[2]/ul/li[2]/span";//待审核
    public static final String  CLUE_ORDERAUDITSEARCH ="(.//*[normalize-space(text()) and normalize-space(.)='未匹配到'])[1]/following::input[2]";//待审核搜索
    public static final String  CLUE_ORDERAUDITSEARCHBYPHONE ="(.//*[normalize-space(text()) and normalize-space(.)='线索编号'])[1]/following::span[2]";//通过手机号搜索
    public static final String  CLUE_ORDERAUDITDETAILS ="(//a[contains(text(),'详情')])[3]";//详情
    public static final String  CLUE_AUDIT ="(.//*[normalize-space(text()) and normalize-space(.)='协议'])[3]/following::a[1]";//审核
    public static final String  CLUE_AUDITSCHOOL ="(.//*[normalize-space(text()) and normalize-space(.)='学校'])[1]/following::input[1]";//学校
    public static final String  CLUE_AUDITRESULT ="(.//*[normalize-space(text()) and normalize-space(.)='审核结果 :'])[1]/following::i[1]";//审核结果
    public static final String  CLUE_AUDITIDEA ="(.//*[normalize-space(text()) and normalize-space(.)='审核意见 :'])[1]/following::textarea[1]";//审核意见
    public static final String  CLUE_AUDITBTN ="(.//*[normalize-space(text()) and normalize-space(.)='审核意见 :'])[1]/following::button[1]";//审核确认
    public static final String  CLUE_AUDITDIS ="(.//*[normalize-space(text()) and normalize-space(.)='确定'])[1]/following::span[1]";//审核取消
    public static final String  CLUE_AUDITBACKCAUSE="(.//*[normalize-space(text()) and normalize-space(.)='退回原因 :'])[1]/following::input[1]";//退回原因
    public static final String  CLUE_ORDERPAYDIS="(.//*[normalize-space(text()) and normalize-space(.)='详情'])[3]/following::span[1]";//订单取消
    public static final String  CLUE_ORDERPAYDISDIS="(.//*[normalize-space(text()) and normalize-space(.)='订单取消'])[1]/following::button[2]";//订单取消取消
    public static final String  CLUE_ORDERPAYDISBTN="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[4]/following::span[1]";//订单取消确认
    public static final String  CLUE_MYALLORDERGETPAY="(.//*[normalize-space(text()) and normalize-space(.)='协议'])[3]/following::span[1]";//所以订单支付
    public static final String  CLUE_MYORDERSEARCHBYNAME="(.//*[normalize-space(text()) and normalize-space(.)='学生姓名'])[1]/following::span[1]";//学生姓名查询
    public static final String  CLUE_ALLORDERSEARCHBYNAME="(.//*[normalize-space(text()) and normalize-space(.)='客户姓名'])[1]/following::span[1]";//所有订单学生姓名查询
    public static final String  ORDER_BTN="//div[3]/button[2]/span";
    public static final String  ORDER_DIS="(.//*[normalize-space(text()) and normalize-space(.)='批量收款'])[1]/following::button[1]";
    public static final String  ORDER_BTNTN="(.//*[normalize-space(text()) and normalize-space(.)='确定'])[1]/preceding::button[1]";
    public static final String  ORDER_MORE="(.//*[normalize-space(text()) and normalize-space(.)='收款'])[3]/following::span[1]";
    public static final String  ORDER_MORECON="(.//*[normalize-space(text()) and normalize-space(.)='推送学管'])[3]/following::li[1]";
    public static final String  ORDER_CHANGEPROJECT="(.//*[normalize-space(text()) and normalize-space(.)='明细'])[1]/following::input[1]";
    public static final String  ORDER_CHANGEPROJECT1="(.//*[normalize-space(text()) and normalize-space(.)='明细'])[1]/following::input[2]";
    public static final String  ORDER_ADDPROJECT="/html/body/div[9]/div[2]/div[3]/button[2]";
    public static final String  ORDER_ADDPROJECT1="mint-button--primary";
    public static final String  ORDER_ADDCLASS="(.//*[normalize-space(text()) and normalize-space(.)='班级'])[1]/following::img[1]";
    public static final String  ORDER_ADDMONEY="(.//*[normalize-space(text()) and normalize-space(.)='是'])[1]/following::input[1]";
    public static final String  ORDER_ADDMONEY1="(.//*[normalize-space(text()) and normalize-space(.)='是否定金'])[1]/following::span[4]";
    public static final String  ORDER_ADDSCHOOL="(.//*[normalize-space(text()) and normalize-space(.)='学校'])[1]/following::input[1]";
    public static final String  ORDER_WAITWORK="(.//*[normalize-space(text()) and normalize-space(.)='待业'])[1]/preceding::span[2]";
    public static final String  ORDER_STATESWORK="(.//*[normalize-space(text()) and normalize-space(.)='职业状态'])[1]/following::input[1]";
    public static final String  ORDER_WORK="(.//*[normalize-space(text()) and normalize-space(.)='在职'])[1]/following::li[1]";
    public static final String  ORDER_CONS="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::span[1]";
    public static final String  ORDER_NAME="(.//*[normalize-space(text()) and normalize-space(.)='姓名'])[1]/following::input[1]";



    public static final String  ORDER_REFUND="(.//*[normalize-space(text()) and normalize-space(.)='订单奖励'])[3]/following::li[1]";//退款
    public static final String  ORDER_REFUNDORDER="(.//*[normalize-space(text()) and normalize-space(.)='退款账号:'])[1]/following::input[1]";//退款账号
    public static final String  ORDER_REFUNDMONEY="(.//*[normalize-space(text()) and normalize-space(.)='退款金额:'])[1]/following::input[1]";//退款金额
    public static final String  ORDER_REFUNDSAVE="(.//*[normalize-space(text()) and normalize-space(.)='退款说明:'])[1]/following::span[1]";//保存
    public static final String  ORDER_REFUNDSAVEANDCOMMIT="(.//*[normalize-space(text()) and normalize-space(.)='保存'])[1]/following::button[1]";//保存提交
    public static final String  ORDER_REFUNDSAVEANDCOMMITBTN="(.//*[normalize-space(text()) and normalize-space(.)='提交审核'])[1]/following::span[2]";//保存提交确定
    public static final String  ORDER_REFUNDDIS="(.//*[normalize-space(text()) and normalize-space(.)='保存并提交审核'])[1]/following::span[1]";//取消
    public static final String  ORDER_EXCEPT="(.//*[normalize-space(text()) and normalize-space(.)='订单奖励'])[3]/following::li[2]";//取消
    public static final String  ORDER_EXCEPTTYPE="(.//*[normalize-space(text()) and normalize-space(.)='订单状态'])[1]/following::input[1]";//订单状态
    public static final String  ORDER_TYPE1="(.//*[normalize-space(text()) and normalize-space(.)='已完款'])[1]/following::li[1]";//审核
    public static final String  ORDER_TYPE2="(.//*[normalize-space(text()) and normalize-space(.)='未完款'])[1]/following::li[1]";//已完款
    public static final String  ORDER_TYPE3="(.//*[normalize-space(text()) and normalize-space(.)='已完款'])[1]/preceding::li[1]";//未完款
    public static final String  ORDER_TYPE4="(.//*[normalize-space(text()) and normalize-space(.)='待审核'])[1]/following::li[1]";//审核退回
    public static final String  ORDER_TYPE5="(.//*[normalize-space(text()) and normalize-space(.)='审核退回'])[1]/following::li[1]";//完成
    public static final String  ORDER_TYPESEARCH="(.//*[normalize-space(text()) and normalize-space(.)='批量收款'])[1]/following::button[1]";//搜索
    public static final String  ORDER_RECOMMEND="(.//*[normalize-space(text()) and normalize-space(.)='客诉申请'])[3]/following::li[1]";//推荐
    public static final String  ORDER_RECOMMENDYES="(.//*[normalize-space(text()) and normalize-space(.)='是否超时推荐'])[1]/following::span[2]";//推荐
    public static final String  ORDER_RECOMMENDNO="(.//*[normalize-space(text()) and normalize-space(.)='是'])[1]/following::span[2]";//推荐
    public static final String  ORDER_RECOMMENDAUTHOR="(.//*[normalize-space(text()) and normalize-space(.)='推荐人'])[1]/following::input[1]";//推荐
    public static final String  ORDER_RECOMMENDSAVE="(.//*[normalize-space(text()) and normalize-space(.)='推荐人'])[1]/following::button[1]";//推荐


}
