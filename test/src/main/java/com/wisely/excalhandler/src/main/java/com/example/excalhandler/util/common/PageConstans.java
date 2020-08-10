package com.example.excalhandler.util.common;

/**
 * 分页常量
 *
 * @author 
 * @date 
 */
public interface PageConstans {

    public static final String PAGE_DEFAULT = "1";

    public static final String SIZE_DEFAULT = "100";

    /** 值域信息 */
    public interface PARAM_NAME {
    	
    	public static final Integer category = 1;
    	
    	 /** 页面号码 */
        public static final String PAGE = "currentPage";

        /** 页面大小 */
        public static final String SIZE = "pageSize";

    }
}
