/**
 * 
 */
package cn.erlaila.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.LinkmanMapper;
import cn.erlaila.mybatis.mapper.OrdersMapper;
import cn.erlaila.mybatis.mapper.custom.LinkmanMapperCustom;
import cn.erlaila.mybatis.mapper.custom.OrdersMapperCustom;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.service.LinkManService;



public class LinkeManServiceImp implements LinkManService{
	
	@Autowired
	private LinkmanMapper linkmanMapper;
	
	@Autowired
	private LinkmanMapperCustom linkmanMapperCustom;
	
	@Autowired
	private OrdersMapperCustom ordersMapperCustom;
	
	@Override
	public int insertLinkMan(Linkman linkman) throws Exception {
		//将该微信用户创建其他的联系人全部设置为不选择
		List<Linkman> list=linkmanMapperCustom.selectAll(linkman.getUserid());
		for (Linkman linkman2 : list) {
			linkman2.setStatus(0);
			linkmanMapper.updateByPrimaryKeySelective(linkman2);
		}
		int num=linkmanMapper.insertSelective(linkman);
		return num;
	}

	@Override
	public Linkman selectLinkManById(Integer linkmanId) throws Exception {
		if(linkmanId!=null){
			Linkman linkMan=linkmanMapper.selectByPrimaryKey(linkmanId);
			return linkMan;
		}		
		return null;
	}

	@Override
	public List<Linkman> selectAll(Integer userid) throws Exception {
		List<Linkman> list=linkmanMapperCustom.selectAll(userid);
		return list;
	}

	@Override
	public int deleteById(Integer linkManId) throws Exception {
		int n=0;
		//判断该联系人是否被订单引用 假如被引用 则不能删除
		System.out.println("=============>12222");
		List<Orders> list=ordersMapperCustom.selectByLinkmanId(linkManId);
		System.out.println("=============>1");
		if(list.size()==0){
			Linkman linkman = new Linkman();
			linkman.setLinkmanid(linkManId);
			linkman.setStatus(4);
			n=linkmanMapper.updateByPrimaryKeySelective(linkman);			
		}else{
			n=4;
		}
		return n;
	}

	@Override
	public int updateStatusByUserId(Integer userId,Integer linkManId) throws Exception {
		List<Linkman> list=linkmanMapperCustom.selectAll(userId);
		for (Linkman linkman2:list) {
			linkman2.setStatus(0);
			linkmanMapper.updateByPrimaryKeySelective(linkman2);
		}
		
		Linkman linkman=new Linkman();
		linkman.setLinkmanid(linkManId);
		linkman.setStatus(1);
		int k=linkmanMapper.updateByPrimaryKeySelective(linkman);
		return k;
	}



	@Override
	public int updateLinkManById(Linkman linkman) throws Exception {
		int n=linkmanMapper.updateByPrimaryKeySelective(linkman);
		return n;
	}

	@Override
	public Linkman selectLinkManByStatus(Integer userid) throws Exception {
		Linkman linkman = linkmanMapperCustom.selectLinkManByStatus(userid);
		return linkman;
	}
	
}
