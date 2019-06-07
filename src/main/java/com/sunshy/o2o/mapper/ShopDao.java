package com.sunshy.o2o.mapper;

import com.sunshy.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   22:28
 */
public interface ShopDao {


    /***
     * 添加店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @param fileStream
     * @param fileName
     * @return
     */
    int updateShop(Shop shop, MultipartFile fileStream, String fileName);


    /***
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);


    /**
     *
     * 根据Id查询
     *
     * @param shopId
     * @return
     */
    Shop queryById(Long shopId);


    /**
     * 根据条件查询
     * @param shop
     * @param pageSize
     * @param pageIndex
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shop,@Param("pageSize")Integer pageSize,@Param("pageIndex")Integer pageIndex);


    /**
     * 根据条件查询总条数
     * @param shop
     * @return
     */
    Integer queryShopCount(@Param("shopCondition")Shop shop);





}
