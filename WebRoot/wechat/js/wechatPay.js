//閸掓繂顫愰崠鏍т簳娣団剝鏁禒妯哄棘閺侊拷
var appId = "";
var signType = "";
var package = "";
var nonceStr = "";
var timeStamp = "";
var paySign = "";

	function getPay(orderid){
		$.ajax({  
	 		type :'POST',
			url : SERVER_URL+"/wechatpay/getp.action",
			data : "orderid="+orderid,
			async : true, //娑撹桨绨＄粻锟界┒閿涘矁顔曠純顔昏礋閸氬本顒為幙宥勭稊
			cache : false,
			success:function(response){
				appId = response.appId;
				signType = response.signType;
				package = response.package;
				nonceStr = response.nonceStr;
				timeStamp = response.timeStamp;
				paySign = response.paySign;			
				wxPayJs();
			},  
			error:function(){  
		
			}  
		});
	}	
	
	function wxPayJs(){
		if (typeof WeixinJSBridge == "undefined") {
			if (document.addEventListener) {
				document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
			} else if (document.attachEvent) {
				document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
				document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
			}
			} 
		else {
				onBridgeReady();
		}
	}
		
	function onBridgeReady() {
		WeixinJSBridge.invoke(
			'getBrandWCPayRequest', {
				"appId":appId, 
				"timeStamp":timeStamp,  
				"nonceStr":nonceStr, 
				"package":package,
				"signType":signType,     
				"paySign":paySign         
			},
			function(res) {
				if (res.err_msg == "get_brand_wcpay_request:ok") {
					location="myOrders.html?initUser=0";
				}else{
					location="myOrders.html?initUser=0";
				}
			}
		);
	}