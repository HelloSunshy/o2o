package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.entity.ProductCategory;
import com.sunshy.o2o.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-03   21:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testQuery(){

        List<ProductCategory> productCategories = productCategoryService.queryProductCategoryByShopId(20L);

//        System.out.println(productCategories.size());

        System.out.println(productCategories);

    }

}