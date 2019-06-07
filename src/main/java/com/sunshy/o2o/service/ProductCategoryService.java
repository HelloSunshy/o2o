package com.sunshy.o2o.service;

import com.sunshy.o2o.dto.ProductCategoryExecution;
import com.sunshy.o2o.entity.ProductCategory;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-03   21:16
 */
public interface ProductCategoryService {


    /**
     * 跟据shopId查询商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryByShopId(Long shopId);


    /**
     * 批量添加产品类别
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution insertManyProductCategory(List<ProductCategory> productCategoryList);


    /**
     * 根据Id删除
     * @param productCategoryId
     * @param shopId
     * @return
     */
    ProductCategoryExecution deleteById(Long productCategoryId,Long shopId);

}
