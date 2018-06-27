package cn.erlaila.mybatis.util;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.util.StringUtils;
  
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 微信媒体下载类
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月14日 上午9:58:56
 * @版本 V 1.0
 */
public class DloadImgUtil {
	
	/**
	 * 
	 * @Title: getFileexpandedName
	 * @date:2018年5月14日上午10:00:04
	 * @Description: TODO根据内容类型判断文件扩展名
	 * @param: @param contentType
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public static String getFileexpandedName(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}
	
	/**
	 * 
	 * @Title: downloadMedia
	 * @date:2018年5月14日上午10:01:06
	 * @Description: TODO 获取媒体文件
	 * @param accessToken 接口访问凭证
	 * @param mediaId 媒体文件id
	 * @param savePath 文件在本地服务器上的存储路径
	 * @return: bulesky  
	 * @throws
	 */
	public static String downloadMedia(String accessToken, String mediaId, String savePath) {
		
		//判断文件夹是否存在
		judeDirExists(savePath);
		
		String filePath = null;
		
		String fileName="";
		// 拼接请求地址
		String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
  
			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = DloadImgUtil .getFileexpandedName(conn.getHeaderField("Content-Type"));
			// 生成时间戳作为文件名
			long mediaName=System.currentTimeMillis();
			fileName=mediaName + fileExt;
			filePath = savePath + fileName ;
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
				fos.close();
				bis.close();
				conn.disconnect();
				String info = String.format("下载媒体文件成功，filePath=" + filePath);
				System.out.println(info);
			} catch (Exception e) {
				filePath = null;
				String error = String.format("下载媒体文件失败：%s", e);
				System.out.println(error);
			}
			return fileName;
		}
	
		// 判断文件夹是否存在
	     public static void judeDirExists(String pathname) {	 
	    	 File file=new File(pathname);
	         if (file.exists()) {
	             if (file.isDirectory()) {
	                 System.out.println("dir exists");
	             } else {
	                 System.out.println("the same name file exists, can not create dir");
	             }
	         } else {
	             System.out.println("dir not exists, create it ...");
	             file.mkdir();
	         }
	 
	     }
//测试方法
//		public static void main(String[] args) {
//			String accessToken = "9_K7TvnDZI7ThhxS9EFPczmCGJJ0zu1jNoUfzaiWtLIHSl_qYHl2koc0bq66kJxDgvuE_e18i3YB3keVzyXGOaMG6hE_HdesfMNm9Civ_ofwVkwU_-bvn0sZpvvZCew3iykI9wBh_p2fTW1niiRJVhAFABTF";
//			String media_id="pUIW-2oEiIYfGemJfQXM-81sNivathKMGQ9mL8phWEOEbJoDfzDLEbO6c_f7253w";
//			downloadMedia(accessToken,media_id,"d:\\"); 
//		}
	}