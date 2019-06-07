package com.sunshy.o2o.service;

import com.sunshy.o2o.entity.ShopCategory;

import java.io.IOException;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-18   20:45
 */
public interface ShopCategoryService {


    /**
     * 根据
     * @param shopCategory
     * @return
     */
    List<ShopCategory> queryShopCategory(ShopCategory shopCategory);


    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @return List<ProductCategory>
     * @throws IOException
     */
    List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;


    /**
     *
     * @param parentId
     * @return
     * @throws IOException
     */
    List<ShopCategory> getShopCategoryList(Long parentId) throws IOException;



}
