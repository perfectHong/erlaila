//服务器地址
SERVER_URL = "http://erlaile.nat300.top/erlaila/";
//SERVER_URL = "http://www.erlaila.com/erlaila/";
//WX_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx093d2f93b581f9d3&redirect_uri=http://www.erlaila.com/erlailele/weixin/auth&response_type=code&scope=snsapi_base&state=0#wechat_redirect";
WX_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx093d2f93b581f9d3&redirect_uri=http%3A%2F%2Ferlaile.nat300.top%2Ferlaila%2Fwechat%2FcallBack.action&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]);
	return null;
}
//返回上一页
$(".histroyback").bind("click",function(){
  	window.history.go(-1);
});
//初始化用户
function initUser(){
	$.ajax({  
	 	url:SERVER_URL+"/wechat/userinit.action",  
		type:"get",  
		dataType:"",  
		data:"",  
		success:function(response){
			if(response=="1"){
				show();		
			}
		},  
		error:function() {  
			//mui.toast('登陆失败',{ duration:'long', type:'div' }) 
		}  
	});	
}
//
function show(){
	var info = document.getElementById("info");
 	var btnArray = ['否', '是'];
   	mui.confirm('系统已经检测您为护工，是否跳转到护工页面？','儿来啦',btnArray,function(e){
       	 if (e.index == 1) {
           	 location="../nurse/index.html";
       	 } 
    })
}
