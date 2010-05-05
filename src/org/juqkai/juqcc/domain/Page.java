package org.juqkai.juqcc.domain;

public class Page {
	public static Long PAGE_SIZE = 15l;
	/**
	 * 当前页
	 */
	private Long currentPage = 1l;
	/**
	 * 总数
	 */
	private Long itemCount = 1l;
	
	/**
	 * 当前页开始
	 * @return
	 */
	public Long getPageStart(){
		return (currentPage - 1) * PAGE_SIZE;
	}
	/**
	 * 当前页结束
	 * @return
	 */
	public Long getPageEnd(){
		return currentPage * PAGE_SIZE;
	}
	/**
	 * 下一页
	 */
	public Long getNextPage(){
		return currentPage < getEndPage() ? currentPage + 1 : getEndPage();
	}
	/**
	 * 上一页
	 * @return
	 */
	public Long getPrevPage(){
		return currentPage > 1 ? currentPage -1 : 1;
	}
	/**
	 * 最后一页
	 * @return
	 */
	public Long getEndPage(){
		return itemCount % PAGE_SIZE > 0 ? itemCount / PAGE_SIZE + 1 : itemCount / PAGE_SIZE;
	}
	/**
	 * 当前页
	 * @return
	 */
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getItemCount() {
		return itemCount;
	}
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}
}
