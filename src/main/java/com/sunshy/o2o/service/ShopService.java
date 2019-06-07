package com.sunshy.o2o.service;

import com.sunshy.o2o.dto.ShopExecution;
import com.sunshy.o2o.entity.Shop;
import org.springframework.web.multipart.MultipartFile;



/**
 * 店铺Service
 *
 * @author sunshy
 * @date 2019-05-16   23:44
 */
public interface ShopService {


    /***
     * 添加店铺
     *
     * @param shop 店铺实体类
     * @param shopImage 店铺图片
     * @return
     */
    ShopExecution addShop(Shop shop, MultipartFile shopImage);


    /**
     * 店铺更新
     * @param shop
     * @param fileStream
     * @param fileName
     * @return
     */
    ShopExecution updateShop(Shop shop, MultipartFile fileStream, String fileName);


    /**
     *
     * 店铺查询
     *
     * @param shopId
     * @return
     */
    Shop queryShopId(long shopId);


    /**
     * 分页查询条件查询
     * @param shop
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExecution getShopList(Shop shop,Integer pageIndex,Integer pageSize);

}
