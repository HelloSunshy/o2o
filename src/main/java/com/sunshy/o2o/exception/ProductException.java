package com.sunshy.o2o.exception;

import com.sunshy.o2o.enums.ProductStateEnum;
import lombok.Data;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   18:39
 */
@Data
public class ProductException extends RuntimeException {

    private Integer state;

    private String msg;

    public ProductException( Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }


    public ProductException(ProductStateEnum productStateEnum) {
        this.state = productStateEnum.getStatue();
        this.msg = productStateEnum.getMsg();
    }

}
