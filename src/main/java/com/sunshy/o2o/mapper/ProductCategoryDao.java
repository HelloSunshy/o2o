package com.sunshy.o2o.mapper;

import com.sunshy.o2o.entity.ProductCategory;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-03   21:05
 */
public interface ProductCategoryDao {


    /**
     * 根据店铺Id查询商品类别
     *
     * @param shopId
     *
     * @return
     */
    List<ProductCategory> queryProductCategoryByShopId(Long shopId);


    /**
     * 批量添加
     * @param productCategoryList
     * @return
     */
    int insertListProductCategory(List<ProductCategory> productCategoryList);


    /**
     * 根据主键删除
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int  deleteById(Long productCategoryId,Long shopId);

}
