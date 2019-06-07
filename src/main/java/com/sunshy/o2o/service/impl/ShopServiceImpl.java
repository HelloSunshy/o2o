package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.dto.ShopExecution;
import com.sunshy.o2o.entity.Shop;
import com.sunshy.o2o.enums.ShopStateEnum;
import com.sunshy.o2o.exception.ShopException;
import com.sunshy.o2o.mapper.ShopDao;
import com.sunshy.o2o.service.ShopService;
import com.sunshy.o2o.util.ImageUtils;
import com.sunshy.o2o.util.PageCalculator;
import com.sunshy.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   23:47
 */

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;


    @Override
    @Transactional(rollbackFor = ShopException.class)
    public ShopExecution addShop(Shop shop, MultipartFile shopImage) {



        if (shop == null){

            throw new ShopException(ShopStateEnum.NULL_SHOP_INFO);

        }

        try {

            shop.setEnableStatus(0);

            shop.setCreateTime(new Date());

            shop.setLastEditTime(new Date());

            int addShopResult = shopDao.insertShop(shop);

            if (addShopResult <= 0){

                throw  new ShopException(ShopStateEnum.INNER_ERROR);

            }else {

                if (shopImage != null){

                    try {

                        addShopImage(shop,shopImage,shop.getShopId()+"");

                    }catch (Exception e){

                        throw new ShopException(ShopStateEnum.ADD_IMG_FAILD);
                    }

                     addShopResult =  shopDao.updateShop(shop);

                    if (addShopResult <= 0){

                        throw new  ShopException(ShopStateEnum.ADD_IMG_FAILD);

                    }

                }

            }

        }catch (ShopException e){

            throw new ShopException(ShopStateEnum.UPDATE_FAILD);

        }

        return new ShopExecution(ShopStateEnum.SUCCESS,shop);
    }

    @Override
    public ShopExecution updateShop(Shop shop, MultipartFile fileStream, String fileName) {

        try {


            if (shop == null || shop.getShopId() == null) {

                return new ShopExecution(ShopStateEnum.OFFLINE);
            }

            int result = 0;

            shop.setLastEditTime(new Date());

            if (fileStream != null) {

                Shop queryById = shopDao.queryById(shop.getShopId());

                if (!queryById.getShopImg().isEmpty()) {


                    ImageUtils.deleteFileOrPath(queryById.getShopImg());

                }

                addShopImage(shop, fileStream, fileName);


            }

                result = shopDao.updateShop(shop);




            if (result < 1) {

                return new ShopExecution(ShopStateEnum.UPDATE_FAILD);
            }
        }catch (Exception e){

            throw new  RuntimeException("更新店铺失败");

        }


        return new ShopExecution(ShopStateEnum.SUCCESS,shop);
    }


    /**
     * 添加图片
     * @param shop
     * @param shopImage
     */
    private void addShopImage(Shop shop, MultipartFile shopImage,String filename) {

        String imagePath = PathUtil.getImagePath(filename);

        String thumbnail = ImageUtils.getThumbnail(shopImage, imagePath);

        shop.setShopImg(thumbnail);
    }



    @Override
    public Shop queryShopId(long shopId) {

        try {

            Shop shop = shopDao.queryById(shopId);

            return shop;

        }catch (Exception e){

            throw new ShopException(ShopStateEnum.QUERY_FAILD);

        }

    }




    @Override
    public ShopExecution getShopList(Shop shop,Integer pageIndex,Integer pageSize){

        int pageInfo = PageCalculator.getPageInfo(pageIndex, pageSize);

        try{

            List<Shop> shops = shopDao.queryShopList(shop, pageSize, pageInfo);

            Integer integer = shopDao.queryShopCount(shop);

            ShopExecution shopExecution = new ShopExecution();

            if (shops.size() > 0){

                shopExecution.setShopList(shops);

                shopExecution.setConut(integer);

            }else {

                shopExecution.setStatue(ShopStateEnum.OFFLINE.getCode());

            }

            return shopExecution;


        }catch (Exception e ){

            throw  new  RuntimeException("查询失败");
        }


    }
}
