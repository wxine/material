package com.test.material.domain;

import java.util.List;

public class PageUtil {
	private final static int PAGESIZE = 3;
	private int page;// 当前页
	private int pagesize = PAGESIZE;// 每页显示
	private int pagetotal;// 总页数
	private int infototal;// 数据总数
	private List<PageUtil> pagelist;

	public PageUtil(int page, int pagesize, int pagetotal, int infototal, List<PageUtil> pagelist) {
		this.page = page;
		this.pagesize = pagesize;
		this.pagetotal = pagetotal;
		this.infototal = infototal;
		this.pagelist = pagelist;
	}

	public PageUtil() {

	}

	public int Pages() {
		return infototal % pagesize == 0 ? infototal / pagesize : infototal / pagesize + 1;
	}

	public int getPage() {
		if (page > pagetotal) {
			page = pagetotal;
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagetotal() {
		return pagetotal;
	}

	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}

	public int getInfototal() {
		return infototal;
	}

	public void setInfototal(int infototal) {
		this.infototal = infototal;
	}

	public List<PageUtil> getPagelist() {
		 
		return pagelist;
	}

	public void setPagelist(List<PageUtil> pagelist) {
		this.pagelist = pagelist;
	}

}
