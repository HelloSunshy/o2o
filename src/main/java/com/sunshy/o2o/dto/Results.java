package com.sunshy.o2o.dto;

import lombok.Data;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-03   21:41
 */
@Data
public class Results<T> {

    /**成功标志**/
    private boolean success;

    /**成功数据***/
    private T data;

    /**错误信息**/
    private String errMsg;

    /**错误代码**/
    private Integer errorCode;

    public Results() {
    }

    public Results(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Results(String errMsg, Integer errorCode) {
        this.errMsg = errMsg;
        this.errorCode = errorCode;
    }

}
