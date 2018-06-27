var $form;
var form;
var $;
layui.config({
	base : "../../js/"
}).use(['form','layer','upload','laydate'],function(){
	form = layui.form();
	var layer = parent.layer === undefined ? layui.layer : parent.layer;
		$ = layui.jquery;
		$form = $('form');
		laydate = layui.laydate;
        layui.upload({
        	url : "http://127.0.0.1:8080/erlaila/admins/saveHeaderPic.action",
        	success: function(response){
        		$("#userFace").attr("src","http://127.0.0.1:8080/pic/"+response.icon);
		    }
        });
        //添加验证规则
        form.verify({
            //oldPwd : function(value, item){
            //   if(value != "123456"){
            //        return "密码错误，请重新输入！";
            //    }
            //},
            newPwd : function(value, item){
                if(value.length < 6){
                    return "密码长度不能小于6位";
                }
            },
            confirmPwd : function(value, item){
                if(!new RegExp($("#oldPwd").val()).test(value)){
                    return "两次输入密码不一致，请重新输入！";
                }
            }
        })
         //修改密码
        form.on("submit(changePwd)",function(data,xp){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	alert($("#PSW").serialize());
           
            	$.ajax({
            		type:"post",
					url:"http://127.0.0.1:8080/erlaila/admins/updatePSW.action",  
            		data:$("#PSW").serialize(),
            		success:function(response){   
            			layer.close(index);
            			layer.msg("提交成功！");
            		},  
            		error:function(){
					
            		}  
            	})
    	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })
   
        /*
        //判断是否修改过头像，如果修改过则显示修改后的头像，否则显示默认头像
        if(window.sessionStorage.getItem('userFace')){
        	$("#userFace").attr("src",window.sessionStorage.getItem('userFace'));
        }else{
        	$("#userFace").attr("src","../../images/face.jpg");
        }
        */
      //  var xp=getTableJson("form1");
       // alert(xp);
        //提交个人资料
        form.on("submit(changeUser)",function(data,xp){
        	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        	alert($("#form1").serialize());
            setTimeout(function(){
   			    //json='{"adminid":"1","adminname":"张翰","sex":"男"}';alert(json);
            	//alert();
				$.ajax({  
					type:"post",
					url:"http://127.0.0.1:8080/erlaila/admins/updateAdmin.action",  
					//contentType:"application/json;charset=utf-8",
					data:$("#form1").serialize(),//'{"adminid":"1","adminname":"张11s","sex":"true","telphon":"13647096349","email":"23@qq.com","commentas":""}',//getTableJson("form1"),//$("#form1").serializeArray(),//'{"adminid":"1","adminname":"张11s","sex":"false","telphon":"13647096349","email":"23@qq.com","commentas":""}',//'{"adminid":"1","adminname":"张11","realname":"张思"}', 
					          //  '{"adminid":"1","adminname":"张11","sex":"1","telphon":"13647096349","email":"23@qq.com","commentas":""}'
					success:function(response){   
						layer.close(index);
						layer.msg("提交成功！");
						initShow(response);
					},  
					error:function(){
						
					}  
				});				
				 
              
            },0);
        	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        })
       

})


	