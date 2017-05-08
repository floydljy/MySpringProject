package com.jason.web.utils;

import java.util.List;
public class PaginationSupport {

	private static final int PAGE_SIZE = 20;
	private List<Object> list;
	private int pageSize;
	private int totalCount;
	private int currPage;
	private int totalPage;
	private int nextPage;
	private int prevPage;
	private String url;
	
	public PaginationSupport(List list, int totalCount, int currPage) {
		this(list, PAGE_SIZE, totalCount, currPage);
	}

	public PaginationSupport(List list,
			int pageSize, 
			int totalCount, 
			int currPage) {
		this.list = list;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.setTotalPage();
		this.setCurrPage(currPage);
		this.setPrevPage();
		this.setNextPage();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {	
		if(currPage < 1){
			this.currPage = 1;
		}else if(currPage > this.getTotalPage()){
			this.currPage = this.getTotalPage();
		}else{
			this.currPage = currPage;
		}
	}

	public int getTotalPage() {	
		return this.totalPage;
	}

	public void setTotalPage() {	
		if(this.getTotalCount() == 0){
			this.totalPage = 1;
		}else{
			this.totalPage = (this.totalCount - 1) / this.pageSize + 1;
		}
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage() {
		if(this.getCurrPage() == this.getTotalPage()){
			this.nextPage = this.getTotalPage();
		}else {
			this.nextPage = this.getCurrPage() + 1;
		}
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage() {
		if (this.getCurrPage() == 1) {
			this.prevPage = 1;
		} else {
			this.prevPage = this.getCurrPage() - 1;
		}
	}
	
	public boolean hasPrev() {
		return this.getCurrPage() == 1 ? false : true;
	}
	
	public boolean hasNext() {
		return this.getCurrPage() == this.getTotalPage() ? false : true;
	}
	
	public boolean isFirst() {
		return this.getCurrPage() == 1 ? true : false;
	}
	
	public boolean isLast() {
		return this.getCurrPage() == this.getTotalPage() ? true : false;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	// build next query str for pagination
	public String nextQuery() {
		int page = this.getNextPage();
		int size = this.getPageSize();
		return String.format("page=%d&size=%d", page, size);
	}
	
	// build next query str for pagination
	public String lastQuery() {
		int page = this.getTotalPage();
		int size = this.getPageSize();
		return String.format("page=%d&size=%d", page, size);
	}


	public String toString() {
		final String BLANK = "  ";
		StringBuffer html = new StringBuffer(200);
		if(!this.isFirst()){
			html.append("<a href='" + this.getUrl() + "?page=1'>首页</a>" + BLANK + BLANK);
		}else{
			html.append("首页" + BLANK + BLANK);
		}
		if(this.hasPrev()){
			html.append("<a href='" + this.getUrl() + "?page=" + this.getPrevPage() + "'>上一页</a>" + BLANK + BLANK);
		}else{
			html.append("上一页" + BLANK + BLANK);
		}
		if(this.hasNext()){
			html.append("<a href='" + this.getUrl() + "?page=" + this.getNextPage() + "'>下一页</a>" + BLANK + BLANK);
		}else{
			html.append("下一页" + BLANK + BLANK);
		}
		if(!this.isLast()){
			html.append("<a href='" + this.getUrl() + "?page=" + this.getTotalPage() + "'>尾页</a>" + BLANK + BLANK);
		}else{
			html.append("最后一页" + BLANK + BLANK);
		}

		html.append(BLANK + BLANK + "每页显示" + this.getPageSize());
		html.append(BLANK + BLANK + "当前第" + this.getCurrPage() + "/" + this.getTotalPage() + "页，共" + this.getTotalCount() + "条");
		html.append(BLANK + BLANK + "跳转");
		return html.toString();
	}
	
	public static void main(String[] args) {
		
		PaginationSupport ps = new PaginationSupport(null, 80, 2);
		ps.setUrl("user.do");
		System.out.println(ps);
	}
}
