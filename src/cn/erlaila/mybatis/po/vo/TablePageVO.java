package cn.erlaila.mybatis.po.vo;
public class TablePageVO {
	private int pIds ;
	private int pageNum ;
	private int limitcount;
	public int getpIds() {
		return pIds;
	}
	public void setpIds(int pIds) {
		this.pIds = pIds;
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
