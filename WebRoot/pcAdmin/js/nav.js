var navs = [{
	"title" : "后台首页",
	"icon" : "icon-computer",
	"href" : "page/main.html",
	"spread" : false
},{
	"title" : "文章列表",
	"icon" : "icon-text",
	"href" : "page/news/newsList.html",
	"spread" : false
},{
	"title" : "友情链接",
	"icon" : "icon-text",
	"href" : "page/links/linksList.html",
	"spread" : false
},{
	"title" : "404页面",
	"icon" : "&#xe61c;",
	"href" : "page/404.html",
	"spread" : false
},{
	"title" : "系统基本参数",
	"icon" : "&#xe631;",
	"href" : "page/systemParameter/systemParameter.html",
	"spread" : false
},{
	"title" : "用户管理",
	"icon" : "&#xe61c;",
	"href" : "",
	"spread" : true,
	"children" : [
		{
			"title" : "系统用户管理",
			"icon" : "&#xe631;",
			"href" : "page/user/userList.html",
			"spread" : false
		},
		{
			"title" : "客户管理",
			"icon" : "&#xe631;",
			"href" : "page/user/customerList.html",
			"spread" : false
		},
		{
			"title" : "护工管理",
			"icon" : "&#xe631;",
			"href" : "page/user/nurseList.html",
			"spread" : false
		}
	]
},{
	"title" : "护工管理",
	"icon" : "&#xe61c;",
	"href" : "",
	"spread" : true,
	"children" : [
		{
			"title" : "已审核护工",
			"icon" : "&#xe631;",
			"href" : "page/user/serviceList.html",
			"spread" : false
		},
		{
			"title" : "待审核护工",
			"icon" : "&#xe631;",
			"href" : "page/nurse/waitNurse.html",
			"spread" : false
		}
	]
},{
	"title" : "咨询管理",
	"icon" : "&#xe61c;",
	"href" : "",
	"spread" : true,
	"children" : [
		{
			"title" : "服务项目管理",
			"icon" : "&#xe631;",
			"href" : "page/user/serviceList.html",
			"spread" : false
		},
		{
			"title" : "what?管理",
			"icon" : "&#xe631;",
			"href" : "",
			"spread" : false
		}
	]
},{
	"title" : "订单管理",
	"icon" : "&#xe61c;",
	"href" : "",
	"spread" : true,
	"children" : [
		{
			"title" : "待付款订单管理",
			"icon" : "&#xe631;",
			"href" : "",
			"spread" : false
		},
		{
			"title" : "待接单订单管理",
			"icon" : "&#xe631;",
			"href" : "",
			"spread" : false
		},
		{
			"title" : "待服务订单管理",
			"icon" : "&#xe631;",
			"href" : "",
			"spread" : false
		},
		{
			"title" : "待评价订单管理",
			"icon" : "&#xe631;",
			"href" : "",
			"spread" : false
		}
	]
}
]