package com.sunshy.o2o.exception;

import com.sunshy.o2o.enums.ShopStateEnum;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-17   00:14
 */
public class ShopException extends RuntimeException {

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public ShopException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ShopException(ShopStateEnum shopStateEnum) {

        this.msg = shopStateEnum.getMsg();

        this.code = shopStateEnum.getCode();
    }



}
