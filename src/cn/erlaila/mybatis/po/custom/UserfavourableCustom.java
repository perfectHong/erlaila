package cn.erlaila.mybatis.po.custom;

import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Userfavourable;

public class UserfavourableCustom extends Userfavourable{

	//�Żݾ���Ϣ
	private	Favourable favourable;

	public Favourable getFavourable() {
		return favourable;
	}

	public void setFavourable(Favourable favourable) {
		this.favourable = favourable;
	}
	
	
}
