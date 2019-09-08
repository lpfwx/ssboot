package com.hyxy.utils;
/**
 * 分页工具类
 * 
 * @author 
 *
 */
public class PageUtils {
	
	private int currentPage = 1;
	
	private int prevPage;
	
	private int nextPage;
	
	private int lastPage;
	
	private int count;
	
	private int pageSize = 2;
	
	private int pageRecord;
	
	private String page;
 
	
	public PageUtils(String currentPage, int count, String pageSize) {
		init(currentPage, count, pageSize);
		initLastPage();
		initCurrentPage();
		initPrevPage();
		initNextPage();
		initPageRecord();
		initPage();
	}
 
	
	private void init(String currentPage, int count, String pageSize) {
		if (currentPage != null && currentPage != "" && currentPage != "0") {
			this.currentPage = Integer.parseInt(currentPage);
		}
		
		this.count = count;
		
		if (pageSize != null && pageSize != "" && pageSize != "0") {
			this.pageSize = Integer.parseInt(pageSize);;
		}
	}
 
	
	private void initLastPage() {
		if (count % pageSize == 0) {
			lastPage = count / pageSize;
		} else {
			lastPage = count / pageSize + 1;
		}
	}
 
	
	private void initCurrentPage() {
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > lastPage) {
			currentPage = lastPage;
		}
	}
 
	
	private void initPrevPage() {
		if (currentPage != 1) {
			prevPage = currentPage - 1;
		}else{
			prevPage = 1;
		}
	}
 
	
	private void initNextPage() {
		if (currentPage != lastPage) {
			nextPage = currentPage + 1;
		}else{
			nextPage = lastPage;
		}
	}
 
	
	private void initPageRecord() {
		pageRecord = (currentPage - 1) * pageSize;
        if(pageRecord < 0){
            pageRecord = 0;
        }
	}
 
	
	private void initPage() {
		page = "<div style='text-align: right;'>";
		page += "第" + currentPage + "/" + lastPage + "页，共" + count + "条记录";
		page += "<select style='width: 70px;' id='pageSize' onchange='page(1)'><option>1</option><option>2</option><option>3</option></select>";
		page += "<input type='button' value='首页' onclick='page(1)' />";
		page += "<input type='button' value='上一页' onclick='page(" + prevPage + ")' />";
		page += "<input type='button' value='下一页' onclick='page(" + nextPage + ")' />";
		page += "<input type='button' value='尾页' onclick='page(" + lastPage + ")' />";
		page += "</div>";
	}
 
	
	public int getCurrentPage() {
		return currentPage;
	}
 
	public int getPrevPage() {
		return prevPage;
	}
 
	public int getNextPage() {
		return nextPage;
	}
 
	public int getLastPage() {
		return lastPage;
	}
 
	public int getCount() {
		return count;
	}
 
	public int getPageSize() {
		return pageSize;
	}
 
	public int getPageRecord() {
		return pageRecord;
	}
 
	public String getPage() {
		return page;
	}
 
}
