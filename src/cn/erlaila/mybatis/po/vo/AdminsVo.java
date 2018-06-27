package cn.erlaila.mybatis.po.vo;

public class AdminsVo{
	private int pageNum ;
	private int limitcount;
	
	private String psw;
	private String newpsw;
	private String confirmpsw;
	/**
	 * @return the confirmpsw
	 */
	public String getConfirmpsw() {
		return confirmpsw;
	}

	/**
	 * @param confirmpsw the confirmpsw to set
	 */
	public void setConfirmpsw(String confirmpsw) {
		this.confirmpsw = confirmpsw;
	}
	private int adminid;
	
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getNewpsw() {
		return newpsw;
	}

	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getLimitcount() {
		return limitcount;
	}
	public void setLimitcount(int limitcount) {
		this.limitcount = limitcount;
	}
}
