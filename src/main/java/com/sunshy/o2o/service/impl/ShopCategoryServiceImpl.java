package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.entity.ShopCategory;
import com.sunshy.o2o.mapper.ShopCategoryDao;
import com.sunshy.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-18   20:45
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> queryShopCategory(ShopCategory shopCategory) {

        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(shopCategory);

        return shopCategories;
    }

    @Override
    public List<ShopCategory> getFirstLevelShopCategoryList() throws IOException {

        List<ShopCategory> shopCategoryList = null;

            ShopCategory shopCategoryCondition = new ShopCategory();

            // 当shopCategoryId不为空的时候，查询的条件会变为 where parent_id is null

            shopCategoryCondition.setShopCategoryId(-1L);

            shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);

        return shopCategoryList;
    }


    @Override
    public List<ShopCategory> getShopCategoryList(Long parentId) throws IOException {

             List<ShopCategory> shopCategoryList = null;

            ShopCategory shopCategoryCondition = new ShopCategory();

            shopCategoryCondition.setParentId(parentId);

            shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);

        return shopCategoryList;
    }

}
