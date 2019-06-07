package com.sunshy.o2o.mapper;

import com.sunshy.o2o.BaseTest;
import com.sunshy.o2o.entity.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-21   21:08
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest{

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testShopDao(){
        Shop shop = new Shop();

        shop.setOwnerId(8L);

        shop.setShopImg("123");

        shop.setEnableStatus(0);

        shop.setLastEditTime(new Date());

        shop.setCreateTime(new Date());

        shop.setShopName("1231");

        int i = shopDao.insertShop(shop);

        System.out.println(i);


    }


    @Test
    public void  shopTest(){
        Shop shop = shopDao.queryById(15L);

        System.out.println(shop);

    }




}