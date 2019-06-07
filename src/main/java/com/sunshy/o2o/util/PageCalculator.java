package com.sunshy.o2o.util;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-02   09:59
 */
public class PageCalculator {


    public static int getPageInfo(int pageIndex, int pageSize){

        return (pageIndex > 0) ? (pageIndex-1)*pageSize:0;
    }

    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }

}
