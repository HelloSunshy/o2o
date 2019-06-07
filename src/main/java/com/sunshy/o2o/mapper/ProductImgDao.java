package com.sunshy.o2o.mapper;

import com.sunshy.o2o.entity.ProductImg;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   17:27
 */
public interface ProductImgDao {

    /**
     * 批量添加产品图片
     * @param productImgList
     * @return
     */
    int batchInsertProdcutImge(List<ProductImg> productImgList);

    List<ProductImg> queryProductImgList(long productId);

    int batchInsertProductImg(List<ProductImg> productImgList);

    int deleteProductImgByProductId(long productId);

}
