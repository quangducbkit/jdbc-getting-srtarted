package com.javawebprogramming.paging;

import com.javawebprogramming.sort.Sorter;

public class PageRequest implements IPageble{
	
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter)
	{
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(page != null && maxPageItem != null)
		{
			return (page - 1) * maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		return sorter;
	}


	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

	

}
