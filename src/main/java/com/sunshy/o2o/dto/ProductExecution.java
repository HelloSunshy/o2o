package com.sunshy.o2o.dto;

import com.sunshy.o2o.entity.Product;
import com.sunshy.o2o.enums.ProductStateEnum;
import lombok.Data;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   18:06
 */
@Data
public class ProductExecution {

    /**
     * 结果状态
     */
    private int state;

    /**
     * 状态标示符号
     */
    private String stateInfo;

    /**
     * 店铺数量
     */
    private int count;

    /***
     *  操作的product（增删改商品的时候用）
      */
    private Product product;

    /** 获取的product列表(查询商品列表的时候用)**/
    private List<Product> productList;

    public ProductExecution() {
    }



    public ProductExecution(ProductStateEnum productStateEnum) {
        this.state = productStateEnum.getStatue();
        this.stateInfo = productStateEnum.getMsg();
    }

    public ProductExecution(ProductStateEnum productStateEnum, Product product) {
        this.state = productStateEnum.getStatue();
        this.stateInfo = productStateEnum.getMsg();
        this.product = product;
    }

    public ProductExecution(ProductStateEnum productStateEnum, List<Product> list) {
        this.state = productStateEnum.getStatue();
        this.stateInfo = productStateEnum.getMsg();
        this.productList = list;
    }

}
