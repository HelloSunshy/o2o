package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.dto.ProductCategoryExecution;
import com.sunshy.o2o.entity.ProductCategory;
import com.sunshy.o2o.enums.ProductCategoryStateEnum;
import com.sunshy.o2o.exception.ProductCategoryException;
import com.sunshy.o2o.mapper.ProductCategoryDao;
import com.sunshy.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-03   21:18
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;


    @Override
    public List<ProductCategory> queryProductCategoryByShopId(Long shopId) {

        List<ProductCategory> productCategories = new ArrayList<>();

        try {

            productCategories = productCategoryDao.queryProductCategoryByShopId(shopId);

            if (productCategories == null || productCategories.size() < 1) {

                throw new RuntimeException("商品类别为空");
            }

        } catch (Exception e) {

            throw new RuntimeException("商品类别查询失败" + "   " + e.getMessage());
        }

        return productCategories;
    }


    @Override
    @Transactional(rollbackFor = ProductCategoryException.class)
    public ProductCategoryExecution insertManyProductCategory(List<ProductCategory> productCategoryList) {

        if (productCategoryList.size() > 0 && (!productCategoryList.isEmpty())) {

            try {

                int i = productCategoryDao.insertListProductCategory(productCategoryList);

                if (i <= 0) {

                    throw new ProductCategoryException(ProductCategoryStateEnum.INNER_ERROR);

                } else {

                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }

            } catch (Exception e) {

                throw new ProductCategoryException(ProductCategoryStateEnum.INNER_ERROR);

            }

        } else {

            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    public ProductCategoryExecution deleteById(Long productCategoryId,Long shopId) {



        int i = productCategoryDao.deleteById(productCategoryId,shopId);

        if (i > 0){

            return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
        }
        return new ProductCategoryExecution(ProductCategoryStateEnum.INNER_ERROR);
    }
}
