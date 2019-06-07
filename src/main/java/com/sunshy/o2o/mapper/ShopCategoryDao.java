package com.sunshy.o2o.mapper;

import com.sunshy.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-18   20:27
 */
public interface ShopCategoryDao {

    List<ShopCategory> queryShopCategory(@Param("shopCategory") ShopCategory shopCategory);

}
