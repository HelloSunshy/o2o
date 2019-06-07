package com.sunshy.o2o.dto;

import com.sunshy.o2o.entity.ProductCategory;
import com.sunshy.o2o.enums.ProductCategoryStateEnum;
import lombok.Data;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-04   22:10
 */
@Data
public class ProductCategoryExecution {

    /**
     * 结果状态
     */
    private int state;

    /**
     * 状态标识
     */
    private String stateInfo;


    /**
     * 操作的商铺类别
     */
    private List<ProductCategory> productCategoryList;


    public ProductCategoryExecution() {
    }


    /**
     * 返回成功的构造器
     * @param stateEnum
     * @param productCategoryList
     */
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList) {

        this.state = stateEnum.getState();

        this.stateInfo = stateEnum.getStateInfo();

        this.productCategoryList = productCategoryList;
    }

    /**
     * 预约失败的构造器
     * @param stateEnum
     *
     */
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {

        this.state = stateEnum.getState();

        this.stateInfo = stateEnum.getStateInfo();
    }
}
