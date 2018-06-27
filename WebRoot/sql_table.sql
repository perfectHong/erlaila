/*创建数据库*/
create database erlaila;

/*使用数据库*/
use erlaila;

/*系统用户表*/
create table admins(  
    adminId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '系统用户编号',  
    adminName varchar(20) not null COMMENT '系统用户名称登陆账号',  
    passWord varchar(32) not null COMMENT '系统用户密码',  
	realname varchar(20) not null COMMENT '真实姓名',
	sex tinyint(1)  not null DEFAULT 0 COMMENT '性别',
	telphon varchar(32) not null COMMENT '手机号码',
	birthday datetime  COMMENT '出生年月',
	email varchar(32)  COMMENT '邮箱',
	commentas varchar(500)  COMMENT '自我评价',
	icon varchar(32)  COMMENT '头像',
    adminGroup int(2) not null  DEFAULT 0 COMMENT '系统用户分组'
);

/*用户表*/
create table user(  
    userId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '用户编号',  
    openId varchar(50) not null COMMENT '微信用户在商户下的唯一编号，不会发生变化',  
    nickname varchar(20) not null COMMENT '用户名',  
    userIcon varchar(200)  COMMENT '用户头像图标', 
    telephone varchar(20) COMMENT '用户手机号码',
	country varchar(20) COMMENT '国家', 
	province varchar(20) COMMENT '省份',
    city varchar(20) COMMENT '城市',
	sex tinyint(1) COMMENT '性别，1为男', 	
	birthday date COMMENT '出生日期', 
	userage int(3) COMMENT '年龄', 
    userType  tinyint(1) not null  DEFAULT 0 COMMENT '用户类型，0为用户，1为护工',  
    userVerify  tinyint(1) not null  DEFAULT 0 COMMENT '是否通过验证，0为未通过验证，1为通过验证'
);

/*服务区域表*/
create table ServiceArea(  
    serviceAreaid int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '服务区域标志',  
    serviceAreaname varchar(20) not null COMMENT '服务区域名称' 
);

/*服务类型表*/
create table serviceType(  
    serviceId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '服务类型编号',  
    serviceName varchar(32) not null COMMENT '服务名',
    serviceMu varchar(32) not null COMMENT '计量单位',
    price int(9) not null DEFAULT 0  COMMENT '服务单价,单位为分',
    nursegetmoney  int(9) not null DEFAULT 0  COMMENT '护工获取单价,单位为分'
);

/*护工明细表*/
create table Nursedetail(  
    nursedetailId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工明细标志',  
    userID int(11)  NOT NULL COMMENT '用户标志',  
    nurseRealName varchar(32)  COMMENT '护工真实姓名',  
    idCardNo varchar(20)  COMMENT '护工身份证号码',
    adress varchar(200)  COMMENT '护工所在地址',
    adressDetail varchar(200)  COMMENT '护工详细地址',
	marriage varchar(20) COMMENT '护工婚否',
    height varchar(20)  COMMENT '护工身高',
    weight varchar(20)  COMMENT '护工体重',
    blood varchar(20)  COMMENT '护工血型',
    nation varchar(20)  COMMENT '护工名族',
    education varchar(20) COMMENT '护工文化程度',
    begoodat varchar(200)  COMMENT '护工擅长',
    experience varchar(500)  COMMENT '护工工作经验',
    synopsis varchar(500)  COMMENT '自我简介'
);

/*护工服务区域明细表*/
create table NurseServiceArea(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工服务区域标志',  
    userId int(11) NOT NULL  COMMENT '护工标志',
    serviceArea_id int(11) NOT NULL  COMMENT '服务区域标志'
);

/*护工服务项目明细表*/
create table NurseServiceContent(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工服务项目标志',  
    userId int(11)  NOT NULL  COMMENT '护工标志',
    serviceContent_id int(11) NOT NULL  COMMENT '服务标志'
);

/*实名认证表*/
create table realNameAuthentication(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '实名认证编号', 
    userId int(11)  NOT NULL  COMMENT '护工标志', 
    face varchar(250) not null COMMENT '身份证正面照存放路径',
    opposite varchar(250) not null COMMENT '身份证反面照存放路径',
    papers varchar(250)  COMMENT '护工证存放路径'
);

/*联系人表*/
create table Linkman(  
    linkmanID int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '实名认证编号',  
    userID int(11) not null COMMENT '联系人创建用户编号',
    linkmanName varchar(32)  COMMENT '联系人姓名',
    linkmanAge varchar(32)  COMMENT '联系人年龄',    
    linkmanTelephone varchar(32)  COMMENT '联系人手机号码',    
    linkmanSex tinyint(1)   DEFAULT 0  COMMENT '性别,0:女性,1:男性',
    adress  varchar(100)   COMMENT '联系人地址',
    adressDetail  varchar(100)   COMMENT '联系人详细地址',
    status int(2) COMMENT '当前联系人状态，0为无状态，1为选择状态,4为删除状态'
);

/*优惠劵表*/
create table favourable(
	favourableId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '优惠卷标志',
	favourableName varchar(20) not null  COMMENT '活动名称',
	favourableDetail varchar(500) not null  COMMENT '活动明细',
	favourableIcon varchar(500) not null  COMMENT '优惠券图标',
	favourableMoney int(9) COMMENT '优惠金额',
	startTime date COMMENT '活动开始时间',
	endTime date COMMENT '活动结束时间'
);

/*微信用户优惠劵记录表*/
create table userfavourable(
	ufID int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '微信用户优惠劵记录标志',
	userid int(11)  not null  COMMENT '微信用户标志',
	favourableId int(11)  not null  COMMENT '优惠卷标志',
	status int(2) COMMENT '优惠卷使用状态，0为未使用，1为已使用，2为已过期',
	getstartTime date COMMENT '优惠券获取时间',
	useTime date COMMENT '优惠使用获取时间'
);

/*订单表*/
create table orders(  
    orderId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '订单标志',  
    linkman_id int(11)  NOT NULL COMMENT '联系人ID',  
    serviceType_id Int(11) not null COMMENT '服务类型ID',  
    user_id Int(11) not null COMMENT '用户ID',
    nurse_id Int(11) not null COMMENT '护工ID,user表  微信用户表中的ID',
    order_wechatid varchar(200)  COMMENT '商户ID',
    favourableid int(11) COMMENT '微信用户优惠劵记录ID',
    createordername varchar(20)  COMMENT '下单人姓名，提醒用户用真实姓名',
    order_wechat varchar(50)  COMMENT '商户订单号',
    order_during varchar(20)  COMMENT '服务时长',
    order_starttime datetime  COMMENT '服务开始时间',
    order_timeend datetime  COMMENT '服务结束时间',
    order_time datetime  COMMENT '下单时间',
    order_money Integer(9)  COMMENT '订单金额',
    order_moneypay Integer(9)  COMMENT '已支付金额',
    order_status int(2) not null DEFAULT 0  COMMENT '订单状态，0为未支付，1为只支付部分，2为全部支付完成，4为删除订单',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' 删除状态。0为正常。1为删除',
	order_COMMENT varchar(500)  COMMENT '本次服务备注'
);

/*客户订单表*/
create table wechatOrders( 
	id int(11)  primary key NOT NULL AUTO_INCREMENT COMMENT '客户订单标志',
    orderId int(11)  NOT NULL COMMENT '订单标志',
    wechat_id Int(11) not null COMMENT '微信用户ID',
    money Int(9) not null COMMENT '订单金额',
    moneypay Int(9) not null COMMENT '已支付金额',
    paystatus int(2) not null DEFAULT 0  COMMENT '支付状态:0为未支付，1为已支付部分，2为已全部支付',
    nurseStatus int(2) not null DEFAULT 0  COMMENT '护工接单状态:0为未接单，1为已接单,4为护工拒接',
    servicestatus int(2) not null DEFAULT 0  COMMENT '服务状态，0为未服务，1为正在服务，2为服务完成,3为取消，5为用户已经评论',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' 删除状态'          
);

/*护工订单表*/
create table nurseOrders( 
	id int(11)  primary key NOT NULL AUTO_INCREMENT COMMENT '护工订单标志',
    orderId int(11)  NOT NULL COMMENT '订单标志',
    nurse_id Int(11) not null COMMENT '护工ID',
    money Int(9) not null COMMENT '订单金额，本次订单护工所得',
    status int(2) not null DEFAULT 0  COMMENT '订单状态，0为待接单，1为已接单，2为正在服务，3为服务已完成,4为已拒接',
    money_status  int(2) not null DEFAULT 0  COMMENT '订单金额状态，0为待收款，1为已收款，2为已提现',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' 删除状态',
	COMMENT varchar(500)  COMMENT '拒接服务备注'
);

/*资金流水表*/
create table journalaccount(  
    journalaccountId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '资金流水ID',  
    userId Int(11) not null COMMENT '流水发生人ID',
    orderId Int(11) not null COMMENT '资金发生订单',
    money Int(11) not null COMMENT '流水金额',
    timehap  DATETIME not null COMMENT '资金发生时间'   
);

/*资金日结表*/
create table dayaccount(  
    dayaccountId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '资金日结编号',  
    num Int(11) not null COMMENT '交易数量',
    money Int(11) not null COMMENT '金额',
    timehap  DATETIME not null COMMENT '资金发生时间'   
);

/*护工评价表*/
create table commentN(  
    commentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工评价编号', 
    orderId Int(11) not null COMMENT '系统订单id',
    userid Int(11) not null COMMENT '评价用户id',
    nurseid Int(11) not null COMMENT '评价的护工id，user表中的id',
    anonymous tinyint(1) not null COMMENT '是否匿名评价',
    commentValue  text  COMMENT '此次服务评价',
    commentDate datetime COMMENT '此次服务时间',
    score Int(11)   DEFAULT 0  COMMENT '服务得分,1-5',
    grade1 Int(11)  DEFAULT 0  COMMENT '服务态度,服务得分,1-5',
    grade2 Int(11)  DEFAULT 0  COMMENT '专业程度,服务得分,1-5',
    grade3 Int(11)  DEFAULT 0  COMMENT '预留,服务得分,1-5',
    status Int(2)   DEFAULT 0  COMMENT '评论状态，0为不发布，1为发布'
);

/*日志表*/
create table logs(  
    logsId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '日志编号',  
    userId Int(11) not null COMMENT '用户id',
    operationname Varchar(20) not null COMMENT '操作名称',
    className  Varchar(20) not null COMMENT '类名称' ,
    method Varchar(20) not null COMMENT '方法名称',  
    operationTime  Datetime not null COMMENT '操作时间' ,
    operationIp Varchar(20) not null COMMENT '操作IP',
	isWechatUser tinyint(1) not null COMMENT '0是微信用户产生的日志'
);

/*异常处理表*/
create table exceptions(  
    exceptionId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '日志编号',  
    userId Int(11) not null COMMENT '用户id',
    className Varchar(20) not null COMMENT '异常出现的类名称',
    exceptioNname  Varchar(20) not null COMMENT '异常名称' ,
    timeHap Datetime not null COMMENT '方法名称',  
    exceptionIp Varchar(20)  not null COMMENT '操作时间'
);

/*意见表*/
create table opinion(  
    opinionId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '意见编号',  
    userId Int(11) not null COMMENT '用户id',
    coment text not null COMMENT '详细意见',
    opinionTime date not null COMMENT '意见提交时间' 
);

/*资讯表*/
create table document(  
    documentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工评价编号',  
    title Varchar(200) not null COMMENT '文档标题',
    adminId Int(11) not null COMMENT '文档创建人',
    createTime  Datetime not null COMMENT '文档创建时间' ,
    abstracts Varchar(400) not null COMMENT '文档摘要', 
    doccument text not null COMMENT '文档正文',
    icon Varchar(32) not null COMMENT '文档图标',
    status  tinyint(1) not null DEFAULT 0  COMMENT '文档状态,0为不发布,1为发布' 
);

/*咨讯评论表*/
create table documentcomment(  
    commentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '护工评价编号',  
    documentId Varchar(200) not null COMMENT '文档标题',
    anonymous tinyint(1) not null COMMENT '是否匿名评价,0：匿名评价,1：实名评价',
    commentValue  Datetime not null COMMENT '文档创建时间' ,
    status  tinyint(1) not null DEFAULT 0  COMMENT '文档状态,0为不发布,1为发布' 
);