/**
 * 
 */
package cn.erlaila.mybatis.controller.pc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.UserService;



    /**  
 * @ClassName: CustomersController  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author 孟凡红  
 * @date 2018年5月14日  下午4:20:40
 *    
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  查找用户总数
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午5:26:59
	    *  
	    * @param request
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/findCount")
	public @ResponseBody String findCount(HttpServletRequest request) throws Exception {
		int count=userService.selectCount();
		System.out.println("======================>用户总数"+count);
        return count+"";	
	}
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   查找所有用户
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午5:27:22
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/findAllCustomer")
	public @ResponseBody Page findAllCustomer(AdminsVo adminsVo) throws Exception {
        Page page=userService.selectByLimit(adminsVo);
        return page;
	}
}
