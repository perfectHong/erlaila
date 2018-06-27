/**
 * 
 */
package cn.erlaila.mybatis.controller.pc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.util.GetIdCardMessage;
import cn.erlaila.mybatis.util.WechatResource;



    /**  
 * @ClassName: CustomersController  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author 孟凡红  
 * @date 2018年5月14日  下午4:20:40
 *    
 */
@Controller
@RequestMapping("/pcnurse")
public class PcNurseController {
	
	//身份证识别
	private final String idCardAppcode = WechatResource.getProperty("idcard.appcode");
	//身份证识别
	private final String imgRealPath = WechatResource.getProperty("wechat.imgRealPath");
	@Autowired
	private UserService userService;
	
	@Autowired
	private NurseDetailService nurseDetailService;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  查找护工总数
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午5:26:59  
	    * @param request
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/findCount")
	public @ResponseBody String findCount(HttpServletRequest request) throws Exception {
		int count=userService.selectNurseCount();
		System.out.println("======================>护工总数"+count);
        return count+"";	
	}
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   查找所有用户
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午5:27:22
	    * @param adminsVo
	    * @return
	    * @throws Exception
	*/
	@RequestMapping("/findAllNurse")
	public @ResponseBody Page findAllCustomer(AdminsVo adminsVo) throws Exception {
        Page page=userService.selectNurseByLimit(adminsVo);
        return page;
	}
	
	
	/**
	 * 
	 * @Title: selectWaitValidateNurse
	 * @date:2018年5月16日下午7:57:32
	 * @Description: TODO 查找已提交材料但未通过实名认证的护工
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/selectWaitValidateNurse")
	public @ResponseBody Page selectWaitValidateNurse() throws Exception {
		Page page= nurseDetailService.selectWaitValidateNurse();
        return page;
	}
	
	/**
	 * 
	 * @Title: selectNurseDetailById
	 * @date:2018年5月16日下午7:58:12
	 * @Description: TODO 根据微信用户id(护工)，查找护工的详细资料
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/selectNurseDetailById")
	public @ResponseBody NurseDetailVo selectNurseDetailById(Integer userid) throws Exception {
		NurseDetailVo nurseDetailVo= nurseDetailService.selectNurseDetailById(userid);
        return nurseDetailVo;
	}
	
	
	@RequestMapping("/validateIdCardBy")
	public @ResponseBody NurseDetailVo validateIdCardBy() throws Exception {
		NurseDetailVo nurseDetailVo= nurseDetailService.selectNurseDetailById(1);
        return nurseDetailVo;
	}
	
	/**
	 * 
	 * @Title: validateIdCardForPho
	 * @date:2018年5月17日上午9:11:57
	 * @Description: TODO 提交照片去审核
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/validateIdCardByPho")
	@ResponseBody
	public  String validateIdCardForPho(String side,String pathString,String userid) throws Exception {
		System.out.println("userid==========>"+userid);
		String fg="false";
		String phoRealPath=imgRealPath+pathString;
		String returnString=GetIdCardMessage.getIdCardMess(idCardAppcode,phoRealPath,side);	
		if(!fg.equals(returnString)){
			fg="true";
			//通过验证，改写数据库资料
			//User user=new User();
			//user.setUsertype(true);
			//userService.updateUserByUserid(Integer.parseInt(userid),user);			
		}
        return fg;
	}	
	
	@RequestMapping("/changeUserType")
	@ResponseBody
	public  String changeUserType(Integer userid) throws Exception {
		System.out.println("userid==========>"+userid);
		User user=new User();
		user.setUserid(userid);
		user.setUsertype(true);
		userService.updateUserByUserid(userid,user);			
		return "1";
	}
}