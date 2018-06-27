package cn.erlaila.mybatis.controller.wechat;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;






















import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.Userfavourable;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.service.FavourableService;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.NurseOrdersService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.service.ServiceTypeService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.UserfavourableService;
import cn.erlaila.mybatis.service.WechatOrdersService;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.PropUtils;
import cn.erlaila.mybatis.util.WXPayUtil;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/wechatpay")
public class WeiXinPayController {
		// ������ID
		private final String appid = WechatResource.getProperty("wechat.appId");
		// ����������
		private final String secret = WechatResource.getProperty("wechat.secret");
		
		private final String mchId = WechatResource.getProperty("wechat.mchId");
		//΢���û���Ȩ�ص���ַ
		//���url����������Ҫ�����ٹ��ں��н���ע����֤�������ַ�ǳɹ���Ļص���ַ
		private final String backUrl = WechatResource.getProperty("wechat.backUrl");
		
		private Logger logger = LoggerFactory.getLogger(WeiXinPayController.class);
		
		@Autowired
		private UserService userService;
		
		@Autowired
		private OrdersService ordersService;
		
		@Autowired
		private NurseOrdersService nurseOrdersService;
		
		@Autowired
		private WechatOrdersService wechatOrdersService;
		
		@Autowired
		private FavourableService favourableService;
		
		@Autowired
		private UserfavourableService userFavourableService;
		
		@RequestMapping("/getp")
		@ResponseBody
		public Map<String, String> auth(HttpServletRequest request,HttpServletResponse response,Integer orderid) throws Exception {
			User user=(User)request.getSession().getAttribute("userWechat");
			String openid=user.getOpenid();
			System.out.println("==========>openid"+openid);				
			//���ݶ�����Ų�ѯ����
			Orders orders=ordersService.selectOrdersById(orderid);
			//��ȡ����֧��״̬
			int orderStatus=orders.getOrderStatus();	
			System.out.println("orderStatus==================>"+orderStatus);
			int money=orders.getOrderMoney();
			int realPay=orders.getOrderMoneypay();//Ŀǰ����ʵ��֧���Ľ��
			//ֻ֧������
			if(orderStatus==1){
				realPay=money-realPay;//֧�������仯  ��ʣ���֧�����
			}
			System.out.println("realPay===========>"+realPay);
			// ����ַ������ֶ���
			String noncestrRandombit32 = WXPayUtil.getRandomBit32();
			// ����ַ�����־�̻�������
			String trade_noRandombit32 = WXPayUtil.getRandomBit32();			
			String notify_url =PropUtils.getProperty("wechat.notifyUrl");
			//������������
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("appid", appid);
			parameters.put("mch_id", mchId);//΢��֧��������̻���
			parameters.put("device_info", "web");
			parameters.put("body", "TEST1");
			parameters.put("trade_type", "JSAPI");
			parameters.put("nonce_str", noncestrRandombit32);
			parameters.put("notify_url", notify_url);// notify_url ΢��֧���ص���ַ
			parameters.put("out_trade_no", trade_noRandombit32);//out_trade_no�̻�������
			parameters.put("total_fee", realPay+"");//���׽��
			parameters.put("openid", openid);
			String prepay_id = WXPayUtil.getPrepay_id(parameters);// ��ȡ��prepay_id����ôʵ�ֵĿ�����	
			//���¶�����Ϣ
			orders.setOrderWechat(trade_noRandombit32);//�����̻�������
			orders.setOrderWechatid(mchId);//�����̻����
			int n=ordersService.updateOrdersById(orderid, orders);
			System.out.println("=======���¼�¼=========>"+n);
			System.out.println("===========================>prepay_id:"+prepay_id);			
			String timeStamp = System.currentTimeMillis() + "";
			Map<String, String> parameters2 = new HashMap<String, String>();
			parameters2.put("appId", appid);
			parameters2.put("signType", "MD5");
			parameters2.put("package", "prepay_id=" + prepay_id);
			String strRandombit32 = WXPayUtil.getRandomBit32();
			parameters2.put("nonceStr", strRandombit32);// nonceStr32λ����ַ���
			parameters2.put("timeStamp", timeStamp);
			String paySign = WXPayUtil.getSign(parameters2);
			parameters2.put("paySign", paySign);
			JSONObject jsonObject = JSONObject.fromObject(parameters2);
			String jsonstr = jsonObject.toString();
			System.out.println("jsonstr:=================>"+jsonstr);
			return parameters2;
		}
		
		
		@RequestMapping("/notify")
		public void notify(HttpServletRequest req, HttpServletResponse response) throws Exception{
			ServletInputStream inStream = req.getInputStream();
			StringBuffer out = new StringBuffer();
			byte[] b = new byte[4096];
			for (int n; (n = inStream.read(b)) != -1;) {
				out.append(new String(b, 0, n));
			}
			//��ȡ΢�ŷ��ص��ַ���
			String resultXmlString = out.toString();
			System.out.println("resultXmlString:"+resultXmlString);
			// ��ȡ����
			String appid = WXPayUtil.getPropertyFromXml(resultXmlString, "appid");
			String bank_type = WXPayUtil.getPropertyFromXml(resultXmlString, "bank_type");
			String cash_fee = WXPayUtil.getPropertyFromXml(resultXmlString, "cash_fee");
			String device_info = WXPayUtil.getPropertyFromXml(resultXmlString, "device_info");
			String fee_type = WXPayUtil.getPropertyFromXml(resultXmlString, "fee_type");
			String is_subscribe = WXPayUtil.getPropertyFromXml(resultXmlString, "is_subscribe");
			String mch_id = WXPayUtil.getPropertyFromXml(resultXmlString, "mch_id");
			String nonce_str = WXPayUtil.getPropertyFromXml(resultXmlString, "nonce_str");
			String openid = WXPayUtil.getPropertyFromXml(resultXmlString, "openid");
			String out_trade_no = WXPayUtil.getPropertyFromXml(resultXmlString, "out_trade_no");
			String result_code = WXPayUtil.getPropertyFromXml(resultXmlString, "result_code");
			String return_code = WXPayUtil.getPropertyFromXml(resultXmlString, "return_code");
			String sign = WXPayUtil.getPropertyFromXml(resultXmlString, "sign");
			String time_end = WXPayUtil.getPropertyFromXml(resultXmlString, "time_end");
			String total_fee = WXPayUtil.getPropertyFromXml(resultXmlString, "total_fee");
			String trade_type = WXPayUtil.getPropertyFromXml(resultXmlString, "trade_type");
			String transaction_id = WXPayUtil.getPropertyFromXml(resultXmlString, "transaction_id");

			// ǩ����֤�ǲ���΢�ŷ��͹���������
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("appid", appid);
			parameters.put("bank_type", bank_type);
			parameters.put("cash_fee", cash_fee);
			parameters.put("device_info", device_info);
			parameters.put("fee_type", fee_type);
			parameters.put("is_subscribe", is_subscribe);
			parameters.put("mch_id", mch_id);
			parameters.put("nonce_str", nonce_str);
			parameters.put("openid", openid);
			parameters.put("out_trade_no", out_trade_no);
			parameters.put("result_code", result_code);
			parameters.put("return_code", return_code);
			parameters.put("time_end", time_end);
			parameters.put("total_fee", total_fee);
			parameters.put("trade_type", trade_type);
			parameters.put("transaction_id", transaction_id);
			String resultSign = WXPayUtil.getSign(parameters);
			
			if (sign != "" && sign != null) {
				if (sign.equals(resultSign)) {
					// System.out.println("------------->����֤��΢�ŷ��͹�������Ϣ");
					/* ΢��֧���ɹ� */
					if ("SUCCESS".equals(result_code)){
						System.out.println("===========>��֧���ɹ�");
						//ϵͳ����
						Orders order=new Orders();
						//΢���û�����
						WechatOrders wechatOrders=new WechatOrders();						
						order =ordersService.selectOrderBytradeNo(out_trade_no);
						int oOrderMoney = order.getOrderMoney();
						int oOrderMoneyPay = order.getOrderMoneypay();
						int favourableId=order.getFavourableid();
						//�Ż݄�  favourableid
						Favourable favourable = favourableService.selectFavourableById(favourableId);
						Userfavourable userFavourable=new Userfavourable();
						int userId=order.getUserId();
						userFavourable.setUserid(userId);//΢���û�id
						userFavourable.setFavourableid(favourableId);//�Żݾ�id
						userFavourable.setStatus(1);//���Żݾ�ĳ�ʹ�ù���״̬
						Date usetime=new Date();
						userFavourable.setUsetime(usetime);
						userFavourableService.updateFavourableByUIdAndFId(userFavourable);
						//��ǰ֧����� total_fee
						int totalfee  =Integer.parseInt(total_fee);
						int orderStatus=order.getOrderStatus();//����״̬
						System.out.println("orderStatus==========>"+orderStatus);
						if(orderStatus==0 && totalfee==oOrderMoney){//��һ��֧�� ����֧�����
							order.setOrderStatus(2);//2Ϊ��֧�� ���
							wechatOrders.setPaystatus(2);//2Ϊ΢���û�֧�����
						}
						else if(orderStatus==0 && totalfee==oOrderMoneyPay){//��һ��֧�� ����֧������
							order.setOrderStatus(1);//1Ϊ��֧��δ���
							wechatOrders.setPaystatus(1);//1Ϊ΢���û�֧��δ���
						}else{
							order.setOrderStatus(2);//2Ϊ��֧�� ���
							wechatOrders.setPaystatus(2);//΢���û�֧�����
						}
						//����ϵͳ����
						int orderid=order.getOrderid();
						wechatOrders.setOrderid(orderid);
						ordersService.updateOrdersById(orderid, order);
						//����΢���û�����
						int wechatOrdersn= wechatOrdersService.updateByorderIdSelective(orderid, wechatOrders);
						System.out.println("�Ѹ���΢���û�������Ϣ==========>"+wechatOrdersn);						
													
						//��΢�ŷ��ؽ��ճɹ���Ϣ
						String returnMess="<xml>\n\n  <return_code><![CDATA[SUCCESS]]></return_code>\n  <return_msg><![CDATA[OK]]></return_msg>\n</xml>";
						System.out.println("=======================================>");
						response.getWriter().write(returnMess);
					}
				} else {
					 System.out.println("------------->������Ϣû��ͨ����֤�������ԭ��");
				}
			}
		}
		
}
