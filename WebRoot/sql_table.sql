/*�������ݿ�*/
create database erlaila;

/*ʹ�����ݿ�*/
use erlaila;

/*ϵͳ�û���*/
create table admins(  
    adminId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT 'ϵͳ�û����',  
    adminName varchar(20) not null COMMENT 'ϵͳ�û����Ƶ�½�˺�',  
    passWord varchar(32) not null COMMENT 'ϵͳ�û�����',  
	realname varchar(20) not null COMMENT '��ʵ����',
	sex tinyint(1)  not null DEFAULT 0 COMMENT '�Ա�',
	telphon varchar(32) not null COMMENT '�ֻ�����',
	birthday datetime  COMMENT '��������',
	email varchar(32)  COMMENT '����',
	commentas varchar(500)  COMMENT '��������',
	icon varchar(32)  COMMENT 'ͷ��',
    adminGroup int(2) not null  DEFAULT 0 COMMENT 'ϵͳ�û�����'
);

/*�û���*/
create table user(  
    userId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�û����',  
    openId varchar(50) not null COMMENT '΢���û����̻��µ�Ψһ��ţ����ᷢ���仯',  
    nickname varchar(20) not null COMMENT '�û���',  
    userIcon varchar(200)  COMMENT '�û�ͷ��ͼ��', 
    telephone varchar(20) COMMENT '�û��ֻ�����',
	country varchar(20) COMMENT '����', 
	province varchar(20) COMMENT 'ʡ��',
    city varchar(20) COMMENT '����',
	sex tinyint(1) COMMENT '�Ա�1Ϊ��', 	
	birthday date COMMENT '��������', 
	userage int(3) COMMENT '����', 
    userType  tinyint(1) not null  DEFAULT 0 COMMENT '�û����ͣ�0Ϊ�û���1Ϊ����',  
    userVerify  tinyint(1) not null  DEFAULT 0 COMMENT '�Ƿ�ͨ����֤��0Ϊδͨ����֤��1Ϊͨ����֤'
);

/*���������*/
create table ServiceArea(  
    serviceAreaid int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '���������־',  
    serviceAreaname varchar(20) not null COMMENT '������������' 
);

/*�������ͱ�*/
create table serviceType(  
    serviceId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�������ͱ��',  
    serviceName varchar(32) not null COMMENT '������',
    serviceMu varchar(32) not null COMMENT '������λ',
    price int(9) not null DEFAULT 0  COMMENT '���񵥼�,��λΪ��',
    nursegetmoney  int(9) not null DEFAULT 0  COMMENT '������ȡ����,��λΪ��'
);

/*������ϸ��*/
create table Nursedetail(  
    nursedetailId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '������ϸ��־',  
    userID int(11)  NOT NULL COMMENT '�û���־',  
    nurseRealName varchar(32)  COMMENT '������ʵ����',  
    idCardNo varchar(20)  COMMENT '�������֤����',
    adress varchar(200)  COMMENT '�������ڵ�ַ',
    adressDetail varchar(200)  COMMENT '������ϸ��ַ',
	marriage varchar(20) COMMENT '�������',
    height varchar(20)  COMMENT '�������',
    weight varchar(20)  COMMENT '��������',
    blood varchar(20)  COMMENT '����Ѫ��',
    nation varchar(20)  COMMENT '��������',
    education varchar(20) COMMENT '�����Ļ��̶�',
    begoodat varchar(200)  COMMENT '�����ó�',
    experience varchar(500)  COMMENT '������������',
    synopsis varchar(500)  COMMENT '���Ҽ��'
);

/*��������������ϸ��*/
create table NurseServiceArea(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�������������־',  
    userId int(11) NOT NULL  COMMENT '������־',
    serviceArea_id int(11) NOT NULL  COMMENT '���������־'
);

/*����������Ŀ��ϸ��*/
create table NurseServiceContent(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '����������Ŀ��־',  
    userId int(11)  NOT NULL  COMMENT '������־',
    serviceContent_id int(11) NOT NULL  COMMENT '�����־'
);

/*ʵ����֤��*/
create table realNameAuthentication(  
    id int(11) primary key NOT NULL AUTO_INCREMENT COMMENT 'ʵ����֤���', 
    userId int(11)  NOT NULL  COMMENT '������־', 
    face varchar(250) not null COMMENT '���֤�����մ��·��',
    opposite varchar(250) not null COMMENT '���֤�����մ��·��',
    papers varchar(250)  COMMENT '����֤���·��'
);

/*��ϵ�˱�*/
create table Linkman(  
    linkmanID int(11) primary key NOT NULL AUTO_INCREMENT COMMENT 'ʵ����֤���',  
    userID int(11) not null COMMENT '��ϵ�˴����û����',
    linkmanName varchar(32)  COMMENT '��ϵ������',
    linkmanAge varchar(32)  COMMENT '��ϵ������',    
    linkmanTelephone varchar(32)  COMMENT '��ϵ���ֻ�����',    
    linkmanSex tinyint(1)   DEFAULT 0  COMMENT '�Ա�,0:Ů��,1:����',
    adress  varchar(100)   COMMENT '��ϵ�˵�ַ',
    adressDetail  varchar(100)   COMMENT '��ϵ����ϸ��ַ',
    status int(2) COMMENT '��ǰ��ϵ��״̬��0Ϊ��״̬��1Ϊѡ��״̬,4Ϊɾ��״̬'
);

/*�Ż݄���*/
create table favourable(
	favourableId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�Żݾ��־',
	favourableName varchar(20) not null  COMMENT '�����',
	favourableDetail varchar(500) not null  COMMENT '���ϸ',
	favourableIcon varchar(500) not null  COMMENT '�Ż�ȯͼ��',
	favourableMoney int(9) COMMENT '�Żݽ��',
	startTime date COMMENT '���ʼʱ��',
	endTime date COMMENT '�����ʱ��'
);

/*΢���û��Ż݄���¼��*/
create table userfavourable(
	ufID int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '΢���û��Ż݄���¼��־',
	userid int(11)  not null  COMMENT '΢���û���־',
	favourableId int(11)  not null  COMMENT '�Żݾ��־',
	status int(2) COMMENT '�Żݾ�ʹ��״̬��0Ϊδʹ�ã�1Ϊ��ʹ�ã�2Ϊ�ѹ���',
	getstartTime date COMMENT '�Ż�ȯ��ȡʱ��',
	useTime date COMMENT '�Ż�ʹ�û�ȡʱ��'
);

/*������*/
create table orders(  
    orderId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '������־',  
    linkman_id int(11)  NOT NULL COMMENT '��ϵ��ID',  
    serviceType_id Int(11) not null COMMENT '��������ID',  
    user_id Int(11) not null COMMENT '�û�ID',
    nurse_id Int(11) not null COMMENT '����ID,user��  ΢���û����е�ID',
    order_wechatid varchar(200)  COMMENT '�̻�ID',
    favourableid int(11) COMMENT '΢���û��Ż݄���¼ID',
    createordername varchar(20)  COMMENT '�µ��������������û�����ʵ����',
    order_wechat varchar(50)  COMMENT '�̻�������',
    order_during varchar(20)  COMMENT '����ʱ��',
    order_starttime datetime  COMMENT '����ʼʱ��',
    order_timeend datetime  COMMENT '�������ʱ��',
    order_time datetime  COMMENT '�µ�ʱ��',
    order_money Integer(9)  COMMENT '�������',
    order_moneypay Integer(9)  COMMENT '��֧�����',
    order_status int(2) not null DEFAULT 0  COMMENT '����״̬��0Ϊδ֧����1Ϊֻ֧�����֣�2Ϊȫ��֧����ɣ�4Ϊɾ������',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' ɾ��״̬��0Ϊ������1Ϊɾ��',
	order_COMMENT varchar(500)  COMMENT '���η���ע'
);

/*�ͻ�������*/
create table wechatOrders( 
	id int(11)  primary key NOT NULL AUTO_INCREMENT COMMENT '�ͻ�������־',
    orderId int(11)  NOT NULL COMMENT '������־',
    wechat_id Int(11) not null COMMENT '΢���û�ID',
    money Int(9) not null COMMENT '�������',
    moneypay Int(9) not null COMMENT '��֧�����',
    paystatus int(2) not null DEFAULT 0  COMMENT '֧��״̬:0Ϊδ֧����1Ϊ��֧�����֣�2Ϊ��ȫ��֧��',
    nurseStatus int(2) not null DEFAULT 0  COMMENT '�����ӵ�״̬:0Ϊδ�ӵ���1Ϊ�ѽӵ�,4Ϊ�����ܽ�',
    servicestatus int(2) not null DEFAULT 0  COMMENT '����״̬��0Ϊδ����1Ϊ���ڷ���2Ϊ�������,3Ϊȡ����5Ϊ�û��Ѿ�����',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' ɾ��״̬'          
);

/*����������*/
create table nurseOrders( 
	id int(11)  primary key NOT NULL AUTO_INCREMENT COMMENT '����������־',
    orderId int(11)  NOT NULL COMMENT '������־',
    nurse_id Int(11) not null COMMENT '����ID',
    money Int(9) not null COMMENT '���������ζ�����������',
    status int(2) not null DEFAULT 0  COMMENT '����״̬��0Ϊ���ӵ���1Ϊ�ѽӵ���2Ϊ���ڷ���3Ϊ���������,4Ϊ�Ѿܽ�',
    money_status  int(2) not null DEFAULT 0  COMMENT '�������״̬��0Ϊ���տ1Ϊ���տ2Ϊ������',
    deleStatus int(2) not null DEFAULT 0  COMMENT ' ɾ��״̬',
	COMMENT varchar(500)  COMMENT '�ܽӷ���ע'
);

/*�ʽ���ˮ��*/
create table journalaccount(  
    journalaccountId int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�ʽ���ˮID',  
    userId Int(11) not null COMMENT '��ˮ������ID',
    orderId Int(11) not null COMMENT '�ʽ�������',
    money Int(11) not null COMMENT '��ˮ���',
    timehap  DATETIME not null COMMENT '�ʽ���ʱ��'   
);

/*�ʽ��ս��*/
create table dayaccount(  
    dayaccountId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�ʽ��ս���',  
    num Int(11) not null COMMENT '��������',
    money Int(11) not null COMMENT '���',
    timehap  DATETIME not null COMMENT '�ʽ���ʱ��'   
);

/*�������۱�*/
create table commentN(  
    commentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�������۱��', 
    orderId Int(11) not null COMMENT 'ϵͳ����id',
    userid Int(11) not null COMMENT '�����û�id',
    nurseid Int(11) not null COMMENT '���۵Ļ���id��user���е�id',
    anonymous tinyint(1) not null COMMENT '�Ƿ���������',
    commentValue  text  COMMENT '�˴η�������',
    commentDate datetime COMMENT '�˴η���ʱ��',
    score Int(11)   DEFAULT 0  COMMENT '����÷�,1-5',
    grade1 Int(11)  DEFAULT 0  COMMENT '����̬��,����÷�,1-5',
    grade2 Int(11)  DEFAULT 0  COMMENT 'רҵ�̶�,����÷�,1-5',
    grade3 Int(11)  DEFAULT 0  COMMENT 'Ԥ��,����÷�,1-5',
    status Int(2)   DEFAULT 0  COMMENT '����״̬��0Ϊ��������1Ϊ����'
);

/*��־��*/
create table logs(  
    logsId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '��־���',  
    userId Int(11) not null COMMENT '�û�id',
    operationname Varchar(20) not null COMMENT '��������',
    className  Varchar(20) not null COMMENT '������' ,
    method Varchar(20) not null COMMENT '��������',  
    operationTime  Datetime not null COMMENT '����ʱ��' ,
    operationIp Varchar(20) not null COMMENT '����IP',
	isWechatUser tinyint(1) not null COMMENT '0��΢���û���������־'
);

/*�쳣�����*/
create table exceptions(  
    exceptionId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '��־���',  
    userId Int(11) not null COMMENT '�û�id',
    className Varchar(20) not null COMMENT '�쳣���ֵ�������',
    exceptioNname  Varchar(20) not null COMMENT '�쳣����' ,
    timeHap Datetime not null COMMENT '��������',  
    exceptionIp Varchar(20)  not null COMMENT '����ʱ��'
);

/*�����*/
create table opinion(  
    opinionId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '������',  
    userId Int(11) not null COMMENT '�û�id',
    coment text not null COMMENT '��ϸ���',
    opinionTime date not null COMMENT '����ύʱ��' 
);

/*��Ѷ��*/
create table document(  
    documentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�������۱��',  
    title Varchar(200) not null COMMENT '�ĵ�����',
    adminId Int(11) not null COMMENT '�ĵ�������',
    createTime  Datetime not null COMMENT '�ĵ�����ʱ��' ,
    abstracts Varchar(400) not null COMMENT '�ĵ�ժҪ', 
    doccument text not null COMMENT '�ĵ�����',
    icon Varchar(32) not null COMMENT '�ĵ�ͼ��',
    status  tinyint(1) not null DEFAULT 0  COMMENT '�ĵ�״̬,0Ϊ������,1Ϊ����' 
);

/*��Ѷ���۱�*/
create table documentcomment(  
    commentId  int(11) primary key NOT NULL AUTO_INCREMENT COMMENT '�������۱��',  
    documentId Varchar(200) not null COMMENT '�ĵ�����',
    anonymous tinyint(1) not null COMMENT '�Ƿ���������,0����������,1��ʵ������',
    commentValue  Datetime not null COMMENT '�ĵ�����ʱ��' ,
    status  tinyint(1) not null DEFAULT 0  COMMENT '�ĵ�״̬,0Ϊ������,1Ϊ����' 
);