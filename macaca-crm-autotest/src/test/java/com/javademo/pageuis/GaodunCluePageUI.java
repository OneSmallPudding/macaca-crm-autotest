package com.javademo.pageuis;

import macaca.java.biz.CommonUIBean;

public class GaodunCluePageUI {
    public static final String  CLUE_INPUT  =  "el-input__inner";//姓名、感兴趣项目、性别、国际电话等
    public static final String  CLUE_LAB  =  "el-radio";//性别
    public static final String  CLUE_PHONE  =  "//*[@id=\"app\"]/div/section/div/form/div[2]/div[1]/div/div/div/input";//手机号
    public static final String  CLUE_SOURCE =  "el-cascader__label";//客户来源
    public static final String  CLUE_NOTES  =  "el-textarea__inner";//备注
    public static final String  CLUE_BTN  =  "el-button";//确认自动分配、保存不自动分配
//    public static final String  CLUE_BTN  =  "(//button[@type='button'])[17]";//确认自动分配、保存不自动分配
    public static final String  CLUE_CLUE  =  "tab-489";//线索管理
    public static final String  CLUE_ADD  =  "clues-new-add-bnt";//新增客户
    public static final String  CLUE_BACK  =  "datagrid-cell-check";//线索复选 框
    public static final String  CLUE_BELONGERS  =  "beyond-hidden-2";//所属人
    public static final String  CLUE_PHONEMUNBER  =  "clues-phone-number";//查询的加密手机号
    public static final String  CLUE_DAREGRID =  "datagrid-cell";//跟进
    public static final String  CLUE_CHAT =  "//div/div/div/textarea";//沟通记录
    public static final String  CLUE_CLOSEWINDOWS =  "btn-close";//关闭自动领取弹窗
    public static final String  CLUE_SETBACK = "(.//*[normalize-space(text()) and normalize-space(.)='报名'])[2]/following::button[1]";//踢回公池
    public static final String  CLUE_GETBACK = "(.//*[normalize-space(text()) and normalize-space(.)='自助领取'])[2]/following::input[1]";//领取查询
    public static final String  CLUE_GETBACKCLICK = "(.//*[normalize-space(text()) and normalize-space(.)='自助领取'])[2]/following::span[2]";//领取查询点击
    public static final String  CLUE_GET = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[5]/div/button/span/a";//领取
//    public static final String  CLUE_GETBYPHONE = "(.//*[normalize-space(text()) and normalize-space(.)='批量处理'])[1]/following::input[1]";//通过手机号查询
    public static final String  CLUE_GETBYPHONE = "(//input[@type='text'])[2]";//通过手机号查询
    public static final String  CLUE_RELEVANCE = "(.//*[normalize-space(text()) and normalize-space(.)='线索分配'])[1]/following::span[3]";//点击营销关联
    public static final String  CLUE_RELEVANCEINP = "(.//*[normalize-space(text()) and normalize-space(.)='关联到:'])[1]/following::input[2]";//点击营销关联输入框
    public static final String  CLUE_RELEVANCEINPUT = "(.//*[normalize-space(text()) and normalize-space(.)='关联到:'])[1]/following::input[1]";//营销关联输入框输入内容
    public static final String  CLUE_RELEVANCEBTN = "//div[3]/div/div/div[2]/div/div/button/span";//营销关联的关联按钮
    public static final String  CLUE_RELEVANCELIST = "//td[22]/div/div/span";//列表页内容位置
    public static final String  CLUE_RELEVANCEDETAILS = "(.//*[normalize-space(text()) and normalize-space(.)=':'])[9]/following::span[1]";//详情页内容位置
    public static final String  CLUE_ADDLABEL = "//span[7]/span[6]/button/span/span";//添加标签按钮
    public static final String  CLUE_ALERTCLK = "(//input[@type='text'])[67]";//点击框弹窗勾选框
    public static final String  CLUE_ALERTXM = "//div[2]/div[2]/div/div/div/div[2]/ul/li[3]/span[2]";//勾选小马学长标签
    public static final String  CLUE_ALERTADD = "//div[2]/div[2]/div/div/button/span";//添加按钮
    public static final String  CLUE_LISTLABEL = "//td[19]/div/div/span";//获取列表页里面关联标签内容
    public static final String  CLUE_SEARCH = "//div[2]/div/div/div/button";//获取列表页里面关联标签内容
    public static final String  CLUE_FOLLOWBASE = "//div[2]/div/div/div/div/div[2]/div/span";////编辑基本信息
    public static final String  CLUE_FOLLOWNAME = "//form/div/div/div/input";//姓名
    public static final String  CLUE_FOLLOWSGX = "//div[2]/div/div/div/label[2]/span[1]";//性别
    public static final String  CLUE_FOLLOECITY = "//form/div[4]/div/div/div/div/input";//国家
    public static final String  CLUE_FOLLOWPHONE = "//div[4]/div/div/div[2]/input";//手机号
    public static final String  CLUE_FOLLOWACCEPT = "//div[5]/div/div/div/button";//点击确定
    public static final String  CLUE_FOLLOWDIS = "//div[5]/div/div/div/button[2]/span";//点击取消
    public static final String  CLUE_CITYPHONE= "span.clues-call-number";//点击列表页的国际电话
    public static final String  CLUE_GETCITYPHONE = "//tr[1]/td[2]/div/span/div";//获取列表页的国际电话
    public static final String  CLUE_GETPTONE = "//div[2]/table/tbody/tr/td[2]/div";//获取列表页的国际电话
    public static final String  CLUE_ADDRELEVANCE = "div.add-server-icon > span";//关联客户
    public static final String  CLUE_RELEVANCENAME = "(.//*[normalize-space(text()) and normalize-space(.)='联系人姓名：'])[1]/following::input[1]";//关联客户姓名
    public static final String  CLUE_RELEVANCEPHONE = "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[2]/following::input[1]";//关联客户手机号
    public static final String  CLUE_RELEVANCEACC = "//div[8]/div/div/div/button";//确认
    public static final String  CLUE_RELEVANCEHINT = "p.el-message__content";//提示信息
    public static final String  CLUE_FOLLOWSAVE = "//div[5]/div/div/button/span";//保存或关闭
    public static final String  CLUE_FOLLOWINFOSTATUS = "(//input[@type='text'])[78]";//线索状态
    public static final String  CLUE_FOLLOWUSER = "//div[2]/div/div/div[2]/div/div/div/div/input";//客户意向度
    public static final String  CLUE_FOLLOWTELSTATUS ="(.//*[normalize-space(text()) and normalize-space(.)='话务状态'])[3]/following::input[1]";//话务状态
    public static final String  CLUE_FOLLOWAGAINTIME ="(//input[@name=''])[17]";//下次沟通时间
    public static final String  CLUE_FOLLOWAFFTER ="(//button[@type='button'])[46]";//之后
    public static final String  CLUE_FOLLOWBEFORE ="(//button[@type='button'])[44]";//之前
    public static final String  CLUE_FOLLOWAPPLY ="//button[3]/span/a";//报名
    public static final String  CLUE_CHANGEPROJECT ="//span[7]/button/span/span";//转项目按钮
    public static final String  CLUE_CHANGEPROJECTGET ="//form/div/div/div/div/input";//选择项目框
    public static final String  CLUE_CHANGEPROJECTBTN ="//div[2]/div[2]/div/div/button/span";//确认
    public static final String  CLUE_CHANGEPROJECTCON ="p.el-message__content";//提示

    public static final String  SEARCH_HIGHSEARCH ="(.//*[normalize-space(text()) and normalize-space(.)='批量处理'])[1]/following::span[1]";//高级搜索
    public static final String  SEARCH_CREATETIME ="(.//*[normalize-space(text()) and normalize-space(.)='线索创建时间:'])[1]/following::input[1]";//时间
    public static final String  SEARCH_CREATETIMEONE ="(.//*[normalize-space(text()) and normalize-space(.)='当月'])[1]/following::button[1]";//时间
    public static final String  SEARCH_CREATEAUTHOR ="(.//*[normalize-space(text()) and normalize-space(.)='线索所属人:'])[1]/following::input[1]";
    public static final String  SEARCH_CREATEAUTHORTEMA ="(.//*[normalize-space(text()) and normalize-space(.)='线索所属人:'])[1]/following::span[6]";
    public static final String  SEARCH_CREATEAFTERTIME ="(.//*[normalize-space(text()) and normalize-space(.)='下次沟通时间:'])[1]/following::input[1]";
    public static final String  SEARCH_CREATEAFTERTIME1 ="(.//*[normalize-space(text()) and normalize-space(.)='昨天'])[1]/following::button[1]";
    public static final String  SEARCH_SEARCH ="(.//*[normalize-space(text()) and normalize-space(.)='清除条件'])[1]/preceding::button[1]";
    public static final String  SEARCH_CLEAR ="(.//*[normalize-space(text()) and normalize-space(.)='查询'])[1]/following::span[1]";
    public static final String  SEARCH_PROJECT ="(.//*[normalize-space(text()) and normalize-space(.)='感兴趣的项目:'])[1]/following::input[2]";
    public static final String  SEARCH_PROJECTBIMAWEI ="(.//*[normalize-space(text()) and normalize-space(.)='GIFT 微学院'])[1]/following::li[1]";
    public static final String  SEARCH_PROJECTAMIBA ="(.//*[normalize-space(text()) and normalize-space(.)='高校渠道-ACCA'])[1]/following::li[1]";
    public static final String  SEARCH_PROFESSIONAL ="(.//*[normalize-space(text()) and normalize-space(.)='职业状态:'])[1]/following::input[2]";
    public static final String  SEARCH_PROFESSIONALSCHOOL ="(.//*[normalize-space(text()) and normalize-space(.)='在职'])[1]/following::span[1]";
    public static final String  SEARCH_REMAN ="(.//*[normalize-space(text()) and normalize-space(.)='重复咨询人:'])[1]/following::input[1]";
    public static final String  SEARCH_REMANTEMA ="(.//*[normalize-space(text()) and normalize-space(.)='重复咨询人:'])[1]/following::span[6]";
    public static final String  SEARCH_RETIME ="(.//*[normalize-space(text()) and normalize-space(.)='重复咨询时间:'])[1]/following::input[1]";
    public static final String  SEARCH_RETIME1 ="el-picker-panel__shortcut";
    public static final String  SEARCH_RESOURE ="(.//*[normalize-space(text()) and normalize-space(.)='重复咨询渠道:'])[1]/following::input[1]";
    public static final String  SEARCH_RESOURE1 ="(.//*[normalize-space(text()) and normalize-space(.)='重复咨询渠道:'])[1]/following::span[2]";
    public static final String  SEARCH_RESOURE2 ="(.//*[normalize-space(text()) and normalize-space(.)='面访'])[1]/following::span[6]";
    public static final String  SEARCH_RESOURENOT ="(.//*[normalize-space(text()) and normalize-space(.)='末次沟通时间:'])[1]/following::input[1]";
    public static final String  SEARCH_RESOURENOTONE ="(.//*[normalize-space(text()) and normalize-space(.)='当月'])[2]/following::button[1]";
    public static final String  SEARCH_RESCHOOL ="(.//*[normalize-space(text()) and normalize-space(.)='包含学校:'])[1]/following::input[1]";
    public static final String  SEARCH_RESCHOOL1 ="(.//*[normalize-space(text()) and normalize-space(.)='包含专业:'])[1]/following::input[1]";
    public static final String  SEARCH_RESCHOOLTIME ="(.//*[normalize-space(text()) and normalize-space(.)='入学年份'])[1]/following::input[1]";
    public static final String  SEARCH_RESCHOOLTIME1 ="(.//*[normalize-space(text()) and normalize-space(.)='沟通记录'])[2]/following::li[3]";
    public static final String  SEARCH_YESORNOTEL ="(.//*[normalize-space(text()) and normalize-space(.)='是否有号码'])[1]/following::span[2]";
    public static final String  SEARCH_SEARCHMORE ="(.//*[normalize-space(text()) and normalize-space(.)='否'])[5]/following::i[1]";
    public static final String  SEARCH_SEARCHMORESOUCE ="(.//*[normalize-space(text()) and normalize-space(.)='首次客户来源:'])[1]/following::input[1]";
    public static final String  SEARCH_SEARCHMORESOUCE1 ="(.//*[normalize-space(text()) and normalize-space(.)='首次客户来源:'])[1]/following::span[2]";
    public static final String  SEARCH_SEARCHMORESOUCE2 ="(.//*[normalize-space(text()) and normalize-space(.)='面访'])[2]/following::span[2]";
    public static final String  SEARCH_SEARCHMORESOUCE3 ="(.//*[normalize-space(text()) and normalize-space(.)='来电'])[2]/following::span[2]";
    public static final String  SEARCH_SEARCHMORESOUCEEND ="(.//*[normalize-space(text()) and normalize-space(.)='末次客户来源:'])[1]/following::input[1]";
    public static final String  SEARCH_SEARCHMORESOUCEEND1 ="(.//*[normalize-space(text()) and normalize-space(.)='末次客户来源:'])[1]/following::span[2]";
    public static final String  SEARCH_SEARCHMORESOUCEEND2 ="(.//*[normalize-space(text()) and normalize-space(.)='面访'])[3]/following::span[2]";
    public static final String  SEARCH_PLAN ="(.//*[normalize-space(text()) and normalize-space(.)='营销计划:'])[1]/following::input[1]";
    public static final String  SEARCH_TEMA ="(.//*[normalize-space(text()) and normalize-space(.)='协作人:'])[1]/following::input[1]";
    public static final String  SEARCH_TEMA1 ="(.//*[normalize-space(text()) and normalize-space(.)='本人'])[9]/following::span[2]";
    public static final String  SEARCH_FOLLOW ="(.//*[normalize-space(text()) and normalize-space(.)='是否有历史跟进:'])[1]/following::span[2]";
    public static final String  SEARCH_SEARCHTEL ="(.//*[normalize-space(text()) and normalize-space(.)='国际电话'])[1]/following::span[1]";

    public static final String  CLUE_BOX           =  "datagrid-cell-check";//线索复选 框
    public static final String  CLUE_MERGE_1       =  "//*[@id='app']/div/section/div/div/div/div[1]/div[1]/div/div[1]/span[6]/button";//线索合并1
    public static final String  CLUE_MERGE_2       =  "//div[2]/div/div/div/button[2]/span";//线索合并2
    public static final String  CLUE_CHANGE        =  "//div[3]/div[2]/button";//线索交换
    public static final String  CLUE_SECOND        =  "//div[2]/div[2]/div/input";//被合并线索框
    public static final String  CLUE_ID            =  "//div[3]/ul/li/span";//按照线索ID搜索
    public static final String  CLUE_ALLOT         =  "//span[7]/span[2]/button/span/span";//分配
    public static final String  CLUE_ALLOT_SELECT  =  "div.clues-distribution>div.g-extend-ztree-box>div.el-input.el-input--small>input.el-input__inner";//点击请选择框
    public static final String  CLUE_ALLOT_MYSELF  =  "//div[2]/div[2]/div/div/div/div[2]/ul/li/span[2]";//分配给本人
    public static final String  CLUE_ALLOT_TEAM    =  "//div[2]/div[2]/div/div/div/div[2]/ul/li[2]/span[2]";//分配到团队
    public static final String  CLUE_ALLOT_SURE    = "//div[2]/div[2]/div/div/button";//确认分配
    public static final String  CLUE_ALLOT_OPEN    = "//div[2]/div[2]/div/div/div/div[2]/ul/li[2]/span";//展开团队
    public static final String  CLUE_ALLOT_OTHER   = "//li[2]/ul/li[2]/span[2]";//选择团队下的其他人
    public static final String  CLUE_MORE_BTN      = "a.hove_menu";//线索的更多按钮
    public static final String  CLUE_AUDITION_BTN  = "div.hover.clues_audition";//线索的更多按钮下的预约试听
    public static final String  AUDIT_BEGINGTIME   =  "//div[@id='app']/div/section/div/div/div/div[3]/div/div[2]/div/form/div[4]/div/div/input";//预约试听的开始时间input 框
    public static final String  AUDIT_ENDTIME      =  "//div[@id='app']/div/section/div/div/div/div[3]/div/div[2]/div/form/div[5]/div/div/input";//预约试听的结束时间input 框
    public static final String  AUDIT_SNEXT_TIME    =  ".el-picker-panel__icon-btn:nth-child(6)";//点击开始时间的下一个月
    public static final String  AUDIT_ENEXT_TIME    =  "//div[4]/div/div/div[2]/button[4]";//点击结束时间的下一个月
    public static final String  AUDIT_SCHOOSE_TIME  =   "//tr[2]/td[7]/div/span";
    public static final String  AUDIT_LIVE          =   "//div[6]/div/div/input"; //创建直播间
    public static final String  AUDIT_SURE_BTN      = "//div[2]/button[2]/span";//预约试听时间框确定按钮
    public static final String  AUDIT_MEET          = "//*[@id='app']/div/section/div/div/div/div[3]/div/div[2]/div/div/button/span";//邀约按钮

    public static final String RECOMMEND            ="(.//*[normalize-space(text()) and normalize-space(.)='修改联系方式'])[1]/following::div[1]"; //转推荐按钮
    public static final String RECOMMEND_PROJECT    ="(.//*[normalize-space(text()) and normalize-space(.)='转推荐项目:'])[1]/following::input[1]"; //转推荐input框
    public static final String RECOMMEND_SURE       ="(.//*[normalize-space(text()) and normalize-space(.)='取消'])[1]/following::span[1]";//转推荐确认按钮

    public static final String BOOK_BTN             ="(.//*[normalize-space(text()) and normalize-space(.)='详情'])[1]/following::div[2]";//更多下的预约按钮
    public static final String BOOK_START           ="(.//*[normalize-space(text()) and normalize-space(.)='开始日期'])[1]/following::input[1]";//预约项目的开始时间
    public static final String BOOK_END             ="(.//*[normalize-space(text()) and normalize-space(.)='结束日期'])[1]/following::input[1]";//结束时间
    public static final String BOOK_NEXT_MONTH      ="(.//*[normalize-space(text()) and normalize-space(.)='确定'])[3]/following::button[4]";//选择下一个月
    public static final String BOOK_DAY_CHOOSE      ="(.//*[normalize-space(text()) and normalize-space(.)='六'])[2]/following::span[7]";//选择第6个按钮
    public static final String CURRENT              ="(.//*[normalize-space(text()) and normalize-space(.)='此刻'])[2]/following::span[1]";
    public static final String BOOK_LIVE            ="(.//*[normalize-space(text()) and normalize-space(.)='创建直播间'])[1]/following::input[1]";
    public static final String LIVE_SURE            ="(.//*[normalize-space(text()) and normalize-space(.)='确定'])[1]/preceding::span[3]";//预约确认按钮
    public static final String  CLUE_SEARCH_INPUT  = "//*[@id='app']/div/section/div/div/div/div[1]/div[1]/div/div[2]/div/div[1]/input";//线索搜索input框
    public static final String  CLUE_SHARE_BTN      = "div.hover.clues_shared";//线索的更多按钮下共享查询
    public static final String  SOURCE_OTHER       =   "(.//*[normalize-space(text()) and normalize-space(.)='网校用户'])[1]/following::li[1]"; //其他客户来源


    public static final String  CLUE_NAME_INPUNT    =        "(.//*[normalize-space(text()) and normalize-space(.)='姓名：'])[1]/following::input[1]";
    public static final String  CLUE_TEL_INPUT      =        "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[1]/following::input[1]";
    public static final String  CLUE_INTERTEL_BTN   =         "(.//*[normalize-space(text()) and normalize-space(.)='国际号码：'])[1]/following::i[1]";
    public static final String  CLUE_CANADA_BTN     =         "/html/body/div[3]/div[1]/div[1]/ul/li[1]/span";
    public static final String  CLUE_INTERTEL_INPUT =        "(.//*[normalize-space(text()) and normalize-space(.)='国际号码：'])[1]/following::input[2]";
    public static final String  CLUE_LINE_INPUT     =         "(.//*[normalize-space(text()) and normalize-space(.)='直线：'])[1]/following::input[1]";
    public static final String  CLUE_MAIL_INPUT     =          "(.//*[normalize-space(text()) and normalize-space(.)='邮箱：'])[1]/following::input[1]";
    public static final String  CLUE_QQ_INPUT       =         "(.//*[normalize-space(text()) and normalize-space(.)='QQ：'])[1]/following::input[1]";
    public static final String  CLUE_WECHAT_INPUT   =        "(.//*[normalize-space(text()) and normalize-space(.)='微信：'])[1]/following::input[1]";
//"(.//*[normalize-space(text()) and normalize-space(.)='姓名：'])[1]/following::button[1]"
    public static final String  CONTECT_NAME_INPUNT =        "(.//*[normalize-space(text()) and normalize-space(.)='姓名：'])[1]/following::input[1]";
    public static final String  CONTECT_TEL_INPUT   =        "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[2]/following::input[1]";
    public static final String  CONTECT_QQ_INPUT    =         "(.//*[normalize-space(text()) and normalize-space(.)='QQ：'])[2]/following::input[1]";
    public static final String  CONTECT_NAME_SAVE   =        "(.//*[normalize-space(text()) and normalize-space(.)='姓名：'])[1]/following::span[1]";
    public static final String  CONTECT_TEL_SAVE    =        "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[1]/following::span[1]";
    public static final String  CONTECT_QQ_SAVE     =     "(.//*[normalize-space(text()) and normalize-space(.)='QQ：'])[1]/following::span[1]";
    public static final String  CLUE_NAME_SAVE      =        "(.//*[normalize-space(text()) and normalize-space(.)='姓名：'])[1]/following::span[1]";
    public static final String  CLUE_TEL_SAVE       =        "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[1]/following::span[1]";
    public static final String  CLUE_INTERTEL_SAVE    =        "(.//*[normalize-space(text()) and normalize-space(.)='国际号码：'])[1]/following::button[1]";
    public static final String  CLUE_LINE_SAVE    =        "(.//*[normalize-space(text()) and normalize-space(.)='直线：'])[1]/following::span[1]";
    public static final String  CLUE_MAIL_SAVE    =        "(.//*[normalize-space(text()) and normalize-space(.)='邮箱：'])[1]/following::span[1]";
    public static final String  CLUE_WECHAT_SAVE    =        "(.//*[normalize-space(text()) and normalize-space(.)='微信：'])[1]/following::button[1]";
    public static final String  CLUE_QQ_SAVE    =     "(.//*[normalize-space(text()) and normalize-space(.)='QQ：'])[1]/following::span[1]";
//    public static final String  CLUE_ADDRELEVANCE = "div.add-server-icon > span";//关联客户
//    public static final String  CLUE_RELEVANCENAME = "(.//*[normalize-space(text()) and normalize-space(.)='联系人姓名：'])[1]/following::input[1]";//关联客户姓名
//    public static final String  CLUE_RELEVANCEPHONE = "(.//*[normalize-space(text()) and normalize-space(.)='手机：'])[2]/following::input[1]";//关联客户手机号
//    public static final String  CLUE_RELEVANCEACC = "//div[8]/div/div/div/button";//确认

    public static final String  CONTECT_DEL_BTN   = "//div[@id='tab-0']/span";
    public static final String  CONTECT_SURE_BTN  = "//div[3]/button[2]/span";
}
