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
 * @Description: TODO(������һ�仰��������������)  
 * @author �Ϸ���  
 * @date 2018��5��14��  ����4:20:40
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
	    * @Description: TODO  �����û�����
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����5:26:59
	    *  
	    * @param request
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/findCount")
	public @ResponseBody String findCount(HttpServletRequest request) throws Exception {
		int count=userService.selectCount();
		System.out.println("======================>�û�����"+count);
        return count+"";	
	}
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   ���������û�
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����5:27:22
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
