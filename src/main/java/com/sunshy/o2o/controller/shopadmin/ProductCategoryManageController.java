package com.sunshy.o2o.controller.shopadmin;

import com.sunshy.o2o.dto.ProductCategoryExecution;
import com.sunshy.o2o.entity.ProductCategory;
import com.sunshy.o2o.entity.Shop;
import com.sunshy.o2o.enums.ProductCategoryStateEnum;
import com.sunshy.o2o.exception.ProductCategoryException;
import com.sunshy.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-04   22:31
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryManageController {

    @Autowired
    private ProductCategoryService productCategoryService;



    @ResponseBody
    @RequestMapping("/addProductList")
    public Map<String ,Object> addProductCategoryList(@RequestBody List<ProductCategory> productCategoryList, HttpServletRequest request){

        Map<String,Object> mapList = new HashMap<>(16);

        Shop shop = (Shop) request.getSession().getAttribute("currentShop");

        for (ProductCategory productCategory:productCategoryList){
        //TODO
            productCategory.setShopId(20L);

        }

        if ((!productCategoryList.isEmpty()) && productCategoryList.size() > 0){

            try {


            ProductCategoryExecution productCategoryExecution = productCategoryService.insertManyProductCategory(productCategoryList);

            if (productCategoryExecution.getState()== ProductCategoryStateEnum.SUCCESS.getState()){

                mapList.put("success",true);

            }else {

                mapList.put("success",false);

                mapList.put("msg",productCategoryExecution.getStateInfo());

            }
            }catch (ProductCategoryException e){

                mapList.put("success",false);

                mapList.put("msg",e.getMessage());
            }
        }else {

            mapList.put("success",false);

            mapList.put("msg","传值不能为空");

            return mapList;

        }
        return mapList;

    }


    @PostMapping("/deleteById")
    @ResponseBody
    public Map<String,Object> deleteById(Long productCategoryId,HttpServletRequest request){

       Shop shop = (Shop) request.getSession().getAttribute("currentShop");

        Map<String,Object> model =  new HashMap<>(16);

        try {
            //TODO  shopId替换掉
            ProductCategoryExecution productCategoryExecution = productCategoryService.deleteById(productCategoryId,20L);

            if (productCategoryExecution.getState()==ProductCategoryStateEnum.SUCCESS.getState()){

                model.put("success",true);
            }else {
                model.put("success",false);

                model.put("msg",productCategoryExecution.getStateInfo());

            }
        }catch (ProductCategoryException e){

            model.put("success",false);

            model.put("msg","添加失败");
        }

        return model;
    }



    @RequestMapping("/productEdit")
    public String productEdit(){

        return "product/productedit";
    }


}
