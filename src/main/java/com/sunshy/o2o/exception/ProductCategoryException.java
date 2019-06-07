package com.sunshy.o2o.exception;

import com.sunshy.o2o.enums.ProductCategoryStateEnum;
import lombok.Data;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-04   23:30
 */

@Data
public class ProductCategoryException extends RuntimeException {

    private Integer code;

    private String msg;

    public ProductCategoryException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public ProductCategoryException(ProductCategoryStateEnum stateEnum){

        this.code = stateEnum.getState();

        this.msg = stateEnum.getStateInfo();

    }
}
