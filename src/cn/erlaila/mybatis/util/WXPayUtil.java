package cn.erlaila.mybatis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

public class WXPayUtil {

	/**
	 * 工具类中各字段意义，详细意义请查阅微信开发文档 appid:微信公众号唯一标志 mch_id:商户号
	 * device_info:设备号PC网页或公众号内支付传WEB body:商品描述==商品或支付单简要描述
	 * trade_type:交易类型==取值如下：JSAPI，NATIVE，APP我们这里使用的JSAPI
	 * nonce_str：32位随机字符串用于区分订单 notify_url：通知地址==接收微信支付异步通知回调地址
	 * out_trade_n：商户订单号==商户系统内部的订单号 total_fee:总金额==订单总金额，单位为分
	 * openid:用户标识用户在商户appid下的唯一标识 sign:微信签名 key:密匙
	 */


	private static String key = WechatResource.getProperty("wechat.mchKey");
	public static void main(String[] args) {
		// 生成签名
		// Map<String, String> signMap = new HashMap<String, String>();
		// 把signMap中的参数补齐 toXmlForMap这里面出现了n个参数就补n-1个(不需要补的就是sign)
		// String str = getPrepay_id(signMap);
		// String sign=getSign(signMap);
		// 1.拼接统一下单接口请求参数xml
		// Map<String, String> parameters=new HashMap<String, String>();
		// 把parameters中的参数补齐 toXmlForMap这里面出现了多少个参数就补多少个
		// parameters.put("","");
		
		// String xmlString= toXmlForMap(parameters);
		//String appid = WechatResource.getProperty("wechat.appId");
		String appid =PropUtils.getProperty("wechat.appId");
		System.out.println("appId:"+appid);
		String openid = "oYVtmwHOsCfrxBCo378xiy88maxE";// openid换成你自己的，在微信公众平台找
		String mch_id =PropUtils.getProperty("wechat.mchId");// 换成我们商户的id
		// 随机字符串区分订单
		String noncestrRandombit32 = WXPayUtil.getRandomBit32();
		// 随机字符串标志商户订单号
		String trade_noRandombit32 = WXPayUtil.getRandomBit32();
		// 创建订单参数
		Map<String, String> parameters1= new HashMap<String, String>();
		parameters1.put("appid", appid);
		parameters1.put("mch_id", mch_id);
		parameters1.put("device_info", "web");
		parameters1.put("body", "thisagodgoods");
		parameters1.put("trade_type", "JSAPI");
		parameters1.put("nonce_str", noncestrRandombit32);
		parameters1.put("notify_url", "http://www.msw0791.cc/vip.html");// notify_url这个先随便填一个
		parameters1.put("out_trade_no", trade_noRandombit32);
		parameters1.put("total_fee", "1");
		parameters1.put("openid", openid);
		String prepay_id = getPrepay_id(parameters1);// 获取到prepay_id，怎么实现的看方法
		
		System.out.println("prepay_id:"+prepay_id);
		// 下面的就是微信H5支付所需要的参数
		Map<String, String> parameters2 = new HashMap<String, String>();
		String timeStamp = System.currentTimeMillis() + "";
		// System.out.println("---------timeStamp----》" + timeStamp);
		parameters2.put("appId", appid);
		parameters2.put("signType", "MD5");
		parameters2.put("package", "prepay_id=" + prepay_id);
		String strRandombit32 = WXPayUtil.getRandomBit32();
		parameters2.put("nonceStr", strRandombit32);// nonceStr32位随机字符串
		parameters2.put("timeStamp", timeStamp);
		String paySign = WXPayUtil.getSign(parameters2);
		parameters2.put("paySign", paySign);
		// System.out.println("paySign----------->" + paySign);
		JSONObject jsonObject = JSONObject.fromObject(parameters2);
		String jsonstr = jsonObject.toString();
		// System.out.println("jsonstr:=================>" + jsonstr);
	}

	/**
	 * 获取微信返回的xml格式数据中的指定属性的属性值
	 * 
	 * @param xml
	 *            微信返回的xml格式字符串
	 * @param property
	 *            需要获取的属性名
	 * @return 制定属性的属性值
	 */
	public static String getPropertyFromXml(String xml, String property) {
		if ("total_fee".equals(property)) {
			String[] xmlArray = xml.split(property);
			String str = xmlArray[1];
			String strLeft = ">";
			String strRight = "</";
			String str2 = str.replace(strLeft, "");
			String propertyString = str2.replace(strRight, "");
			return propertyString;
		} else {
			String[] xmlArray = xml.split(property);
			String str = xmlArray[1];
			String strLeft = "><![CDATA[";
			String strRight = "]]></";
			String str2 = str.replace(strLeft, "");
			String propertyString = str2.replace(strRight, "");
			return propertyString;
		}
	}

	/**
	 * 获得随机的32位字符串
	 * 
	 * @return 32位字符串
	 */
	public static String getRandomBit32() {
		double doubleNum = Math.random();
		Double doubleNum6 = doubleNum * 1000000;
		int intnum6 = (int) Math.ceil(doubleNum6);
		String string32 = MD5.MD5Encode(intnum6 + "");
		return string32;
	}

	/**
	 * 获得pay的数字签名sign
	 * 
	 * @param parameters
	 *            需要传的五个参数
	 * @return
	 */
	public static String getSign(Map<String, String> parameters) {
		String str = WXPayUtil.formatUrlMap(parameters, false, false);
		String str2 = str + "&key=" + key;
		String sign = MD5.MD5Encode(str2).toUpperCase();
		return sign;
		
		
	}

	/**
	 * 
	 * @param parameters
	 *            需要排序的参数
	 * @return getPrepay_id
	 */
	public static String getPrepay_id(Map<String, String> parameters) {
		String signag = WXPayUtil.formatUrlMap(parameters, false, false);
		System.out.println("key==================>"+key);
		String signaga = signag + "&key=" + key;
		// md5加密形成sign
		String sign = MD5.MD5Encode(signaga).toUpperCase();
		parameters.put("sign", sign);
		String xmlString = toXmlForMap(parameters);
		System.out.println("xmlString============>" + xmlString);
		// 微信统一下单接口
		String urle = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String resultXml = sendPost(urle, xmlString);
		System.out.println("获取微信返回结果resultXml" + resultXml);
		String startstr = "<prepay_id><![CDATA[";
		int index = resultXml.indexOf(startstr);
		String endstr = "]]></prepay_id>";
		int end = resultXml.indexOf(endstr);
		String str = resultXml.substring(index,end);
		System.out.println("str:"+str);
		String prepay_id = str.replace("<prepay_id><![CDATA[", "");
		 System.out.println("------prepay_id------->" + prepay_id);
		return prepay_id;
	}

	/**
	 * 将map集合转成符合微信统一下单接口的xml格式的数据
	 * 
	 * @param map
	 *            map的参数是确定的
	 * @return xml格式的字符串
	 */
	public static String toXmlForMap(Map<String, String> map) {
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append("<xml>\n\t<appid>");
		strbuffer.append(map.get("appid"));
		strbuffer.append("</appid>\n\t");
		strbuffer.append("<body>");
		strbuffer.append(map.get("body"));
		strbuffer.append("</body>\n\t");
		strbuffer.append("<device_info>web</device_info>\n\t");
		strbuffer.append("<mch_id>");
		strbuffer.append(map.get("mch_id"));
		strbuffer.append("</mch_id>\n\t");
		strbuffer.append("<nonce_str>");
		strbuffer.append(map.get("nonce_str"));
		strbuffer.append("</nonce_str>\n\t");
		strbuffer.append("<notify_url>");
		strbuffer.append(map.get("notify_url"));
		strbuffer.append("</notify_url>\n\t");
		strbuffer.append("<openid>");
		strbuffer.append(map.get("openid"));
		strbuffer.append("</openid>\n\t");
		strbuffer.append("<out_trade_no>");
		strbuffer.append(map.get("out_trade_no"));
		strbuffer.append("</out_trade_no>\n\t");
		strbuffer.append("<total_fee>");
		strbuffer.append(map.get("total_fee"));
		strbuffer.append("</total_fee>\n\t");
		strbuffer.append("<trade_type>");
		strbuffer.append(map.get("trade_type"));
		strbuffer.append("</trade_type>\n\t");
		strbuffer.append("<sign>");
		strbuffer.append(map.get("sign"));
		strbuffer.append("</sign>\n");
		strbuffer.append("</xml>");
		return strbuffer.toString();
	}

	/**
	 * 
	 * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
	 * 实现步骤: <br>
	 * 
	 * @param paraMap
	 *            要排序的Map对象
	 * @param urlEncode
	 *            是否需要URLENCODE
	 * @param keyToLower
	 *            是否需要将Key转换为全小写 true:key转化成小写，false:不转化
	 * @return
	 */
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
		String buff = "";
		Map<String, String> tmpMap = paraMap;
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			// 构造URL 键值对的格式
			StringBuilder buf = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				if (StringUtils.isNotBlank(item.getKey())) {
					String key = item.getKey();
					String val = item.getValue();
					if (urlEncode) {
						val = URLEncoder.encode(val, "utf-8");
					}
					if (keyToLower) {
						buf.append(key.toLowerCase() + "=" + val);
					} else {
						buf.append(key + "=" + val);
					}
					buf.append("&");
				}

			}
			buff = buf.toString();
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			return null;
		}
		return buff;
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += "/n" + line;
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}