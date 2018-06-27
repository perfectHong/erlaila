package cn.erlaila.mybatis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.OpinionMapper;
import cn.erlaila.mybatis.po.Opinion;
import cn.erlaila.mybatis.service.OpinionService;

public class OpinionServiceImpl implements OpinionService{

	@Autowired
	private OpinionMapper opinionMapper;
	
	@Override
	public int insertOpinion(Opinion opinion) throws Exception {
		Date opiniontime=new Date();
		opinion.setOpiniontime(opiniontime);
		int n=opinionMapper.insertSelective(opinion);
		return n;
	}

}
