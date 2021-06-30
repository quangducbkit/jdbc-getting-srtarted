package com.javawebprogramming.paging;

import com.javawebprogramming.sort.Sorter;

public interface IPageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
