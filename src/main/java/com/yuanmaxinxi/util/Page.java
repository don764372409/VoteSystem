package com.yuanmaxinxi.util;

import java.util.ArrayList;
import java.util.List;

public class Page {
	 // The number of current page size 当前页
    private Integer currentPage;

    // The number of records in one page 一页显示数
    private Integer pageSize;

    // The total number of records in DB 数据库总记录数
    private Integer total;

    // The total number of page 总页数
    private Integer pageCount;

    // The number where we begin to get record 起始位置
    private Integer startRecord;

    // Whether it has previous page 是否有前页
    private boolean hasPreviousPage;

    // Whether it has next page 是否有下一页
    private boolean hasNextPage;

    // Whether it has only one page 是否只有一个页面
    private boolean onlyOnePage;

    // The records of page designed
    private List pageRecords;
    public Integer getCurrentPage() {
        return currentPage;
    }
    
    /**
     * 构造方法，只构造空页.
     */
    public Page() {

    	this(1, 0, 15, new ArrayList());

    }
    
    /**
	 * 构造方法，只构造空页.
	 */
	public Page(Integer currentPage,Integer pageSize) {
		this(currentPage, 0, pageSize, new ArrayList());
	}
	
	/**
	 * 默认构造方法.
	 * 
	 * @param start
	 *            本页数据在数据库中的起始位置
	 * @param totalSize
	 *            数据库中总记录条数
	 * @param pageSize
	 *            本页容量
	 * @param data
	 *            本页包含的数据
	 */
	public Page(Integer currentPage, Integer totalSize, Integer pageSize, List data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.total = totalSize;
		this.pageRecords = data;
	}

    /**
     * make sure the page is in the range of the total pages
     * 
     * @param currentPage
     *            current page
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        /*if (currentPage > getPageCount()) {
            this.currentPage = getPageCount();
            return;
        }*/
        this.currentPage = currentPage;
    }

    /**
     * get page size
     * 
     * @return page size number
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * set page size
     * 
     * @param pageSize
     *            page size number
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * get total records
     * 
     * @return total record's number
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * set total records
     * 
     * @param totalRecords
     *            total record number
     */
    public void setTotal(Integer totalRecords) {
        this.total = totalRecords;
    }

    /**
     * Get the total count of the page
     * 
     * @return count number
     */
    public Integer getPageCount() {
        // If there is no data in database.
        if (total == 0) {
            pageCount = 1;
            return pageCount;
        }
        boolean isZero = total % pageSize == 0;
        pageCount = total / pageSize;
        pageCount = isZero ? pageCount : pageCount + 1;
        return pageCount;
    }


	/**
     * First record of one page
     * 
     * @return start records
     */
    public Integer getStartRecord() {
        startRecord = ((currentPage - 1) * pageSize);
        return startRecord;
    }

    /**
     * Whether has previous page
     * 
     * @return if previous page's is exist,return true else not
     */
    public boolean isHasPreviousPage() {
        hasPreviousPage = (currentPage == 1) ? false : true;
        return hasPreviousPage;
    }

    /**
     * Whether has next page
     * 
     * @return if next page's is exist,return true else not
     */
    public boolean isHasNextPage() {
        hasNextPage = (currentPage == getPageCount()) ? false : true;
        return hasNextPage;
    }

    /**
     * Whether is only one page
     * 
     * @return if only one page,return true else not
     */
    public boolean isOnlyOnePage() {
        onlyOnePage = ((getPageCount() == 1) ? true : false);
        return onlyOnePage;
    }

    
    /**
     * 查询到的所有的记录
     * @return the pageRecords
     */
    
    public List getPageRecords() {
        return pageRecords;
    }

	public void setPageRecords(List pageRecords) {
		this.pageRecords = pageRecords;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

}