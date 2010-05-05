package org.juqkai.juqcc.domain;

public class Page {
	public static Long PAGE_SIZE = 1l;
	private Long currentPage = 1l;
	private Long pageCount = 1l;
	
	public Long getPageStart(){
		return (currentPage - 1) * PAGE_SIZE;
	}
	public Long getPageEnd(){
		return currentPage * PAGE_SIZE;
	}
	
	public Long getNextPage(){
		return pageCount > currentPage ? currentPage + 1 : pageCount;
	}
	public Long getPrevPage(){
		return currentPage > 1 ? currentPage -1 : 1;
	}
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
