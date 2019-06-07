package com.sunshy.o2o.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunshy.o2o.dto.Results;
import com.sunshy.o2o.dto.ShopExecution;
import com.sunshy.o2o.entity.*;
import com.sunshy.o2o.enums.ShopStateEnum;
import com.sunshy.o2o.exception.ShopException;
import com.sunshy.o2o.service.AreaService;
import com.sunshy.o2o.service.ProductCategoryService;
import com.sunshy.o2o.service.ShopCategoryService;
import com.sunshy.o2o.service.ShopService;
import com.sunshy.o2o.util.HttpServletRequestUtil;
import com.sunshy.o2o.util.VerCode;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-17   20:58
 */

@Controller
@RequestMapping("/shopAdmin")
public class ShopManageController  {

    @Autowired
    private ShopService shopService;


    @Autowired
    private AreaService areaService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    private ProductCategoryService productCategoryService;



    @PostMapping("/registerShop")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> registerShop(HttpServletRequest request){

        Map<String,Object> modelAndView = new HashMap<>();

        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");

        ObjectMapper om = new ObjectMapper();

        Shop shop = null;

        if (!VerCode.getResult(request)){

            modelAndView.put("statue",false);

            modelAndView.put("errMsg","验证码不正确 ");

            return modelAndView;

        }

        try {
          shop =  om.readValue(shopStr, Shop.class);

        }catch (Exception e){

            modelAndView.put("statue",false);

            return modelAndView;
        }
        MultipartFile shopImage = null;

        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());

        cmr.setDefaultEncoding("utf-8");

        cmr.setMaxUploadSize(20971520);

        cmr.setMaxInMemorySize(20971520);

        if (cmr.isMultipart(request)){

            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

          shopImage = multipartHttpServletRequest.getFile("shopImage");

        }else {

            modelAndView.put("statue",false);

            modelAndView.put("errMsg","上传图片不能为空");

            return modelAndView;

        }
        if (shop == null && shopImage == null){

            modelAndView.put("statue",false);

            modelAndView.put("errMsg","请输入店铺信息");

            return modelAndView;
        }
        PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");

        shop.setOwnerId(owner.getUserId());

        try {

            ShopExecution shopExecution = shopService.addShop(shop, shopImage);

            if (shopExecution.getStatue() == ShopStateEnum.SUCCESS.getCode()){

                modelAndView.put("success",true);

                List<Shop> allListShop = (List<Shop>) request.getSession().getAttribute("shop");

                if (allListShop.size()==0 || allListShop == null){

                    allListShop = new ArrayList<>();

                }

                allListShop.add(shop);

                request.getSession().setAttribute("shop",allListShop);

                return modelAndView;

            }else {

                modelAndView.put("success",false);

                modelAndView.put("errMsg","插入失败");

                return  modelAndView;

            }

        }catch (Exception e){

            modelAndView.put("success",false);

            modelAndView.put("errMsg","请输入店铺信息");

            return modelAndView;
        }
    }




    @RequestMapping("/shopOpera")
    public String toShop(){

        return "shop/index";
    }


    @RequestMapping("shopList")
    public String toShopList(){

        return "shop/shopList";
    }


    @ResponseBody
    @RequestMapping("/shopInfo")
    public Map<String,Object> shopAllInfo(){

        Map<String,Object> hashMap =  new HashMap<>();

        try {

            ShopCategory shopCategory = new ShopCategory();

            List<Area> areas = areaService.queryArea();

            List<ShopCategory> shopCategories = shopCategoryService.queryShopCategory(shopCategory);

            hashMap.put("success",true);

            hashMap.put("areaList",areas);

            hashMap.put("ShopCategoryList",shopCategories);

        }catch (Exception e){


            hashMap.put("success",true);

            hashMap.put("msg",e.getMessage());

        }

        return hashMap;

    }



    @RequestMapping("/queryShopById")
    @ResponseBody
    public Map<String,Object> queryShopById(HttpServletRequest request){

        long shopId = HttpServletRequestUtil.getLong(request, "shopId");

        Map<String,Object> mapModel = new HashMap<>(16);

        try {

        if (shopId>-1){

            Shop shop = shopService.queryShopId(shopId);

            List<Area> areas = areaService.queryArea();

            mapModel.put("shop",shop);

            mapModel.put("areaList",areas);

            mapModel.put("success",true);

        }else {

            mapModel.put("success",false);

            mapModel.put("msg","empty shopId ");

        }

        }catch (Exception e){

            mapModel.put("success",false);

            mapModel.put("msg",e.getMessage());

        }

        return mapModel;

    }




    @PostMapping("/modifyShop")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> updateShop(HttpServletRequest request){

        Map<String,Object> modelAndView = new HashMap<>();

        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");

        ObjectMapper om = new ObjectMapper();

        Shop shop = null;

        if (!VerCode.getResult(request)){

            modelAndView.put("statue",false);

            modelAndView.put("errMsg","验证码不正确 ");

            return modelAndView;

        }

        try {

            shop =  om.readValue(shopStr, Shop.class);

        }catch (Exception e){

            modelAndView.put("statue",false);

            return modelAndView;

        }

        MultipartFile shopImage = null;

        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());


        if (cmr.isMultipart(request)){

            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

            shopImage = multipartHttpServletRequest.getFile("shopImage");

        }

        if (shop == null || shop.getShopId() == null ){

            modelAndView.put("success",false);

            modelAndView.put("errMsg","请输入店铺信息");

            return modelAndView;
        }

        try {

            ShopExecution shopExecution = null;

            if (shopImage != null){

                shopExecution = shopService.updateShop(shop,shopImage,shop.getShopId()+"");

            }else {

                shopExecution =  shopService.updateShop(shop,null,null);

            }



            if (shopExecution.getStatue() == ShopStateEnum.SUCCESS.getCode()){

                modelAndView.put("success",true);

                return modelAndView;

            }else {

                modelAndView.put("success",false);

                modelAndView.put("errMsg","插入失败");

                return  modelAndView;

            }

        }catch (Exception e){

            modelAndView.put("success",false);

            modelAndView.put("errMsg","请输入店铺信息");

            return modelAndView;

        }


    }



    @ResponseBody
    @GetMapping("/getShopList")
    public Map<String,Object> getShopList(HttpServletRequest request){

        Map<String,Object> map = new HashMap<>(16);

        PersonInfo personInfo = new PersonInfo();

        personInfo.setUserId(8L);

        personInfo.setName("zhangsan");

        request.getSession().setAttribute("user",personInfo);

        personInfo = (PersonInfo) request.getSession().getAttribute("user");

        try {

            Shop shopCondition = new Shop();

            shopCondition.setOwner(personInfo);

            ShopExecution shopList = shopService.getShopList(shopCondition, 0, 100);

            map.put("shopList",shopList.getShopList());

            map.put("user",personInfo);

            map.put("success",true);


        }catch (Exception e ){

            map.put("success",false);

            map.put("msg",e.getMessage());
        }

        return map;

    }



    @GetMapping("/getShopManageInfo")
    @ResponseBody
    public  Map<String,Object> getCount(HttpServletRequest request){

        Map<String,Object> map = new HashMap<>(16);

        long shopId = HttpServletRequestUtil.getLong(request, "shopId");

        if (shopId  <= 0){

            Object currentShop = request.getSession().getAttribute("currentShop");

            if (currentShop == null){

                map.put("redirect", true);

                map.put("url","/o2o/shop/shopList");

            }else {

                Shop shopCondition = (Shop) currentShop;

                map.put("redirect",false);

                map.put("shopId",shopCondition.getShopId());
            }

        }else {

            Shop shop = new Shop();

            shop.setShopId(shopId);

            request.getSession().setAttribute("currentShop",shop);

            map.put("redirect",false);

        }

        return  map;


    }



    @RequestMapping("/shopManage")
    public String shopManage(){

        return "shop/shopManage";
    }


    @RequestMapping("/shopManageCategory")
    public String shopManageCategory(){

        return "shop/shopCategoryManage";
    }


    @GetMapping("/getProductCategoryList")
    @ResponseBody
    public Results<List<ProductCategory>> getProductCategoryList(HttpServletRequest request){


       Shop shop = (Shop) request.getSession().getAttribute("currentShop");

//       shop.setShopId(20L);

       //TODO

        List<ProductCategory> productCategories = null;

        try {

//            if (shop.getShopId() > 0 && shop != null) {

            if (true){



                productCategories = productCategoryService.queryProductCategoryByShopId(20L);

                return new Results<>(true, productCategories);}
//            }
        }catch (Exception e ){

            throw  new  RuntimeException("查询失败"+"  " +e.getMessage());

        }

        return new Results<>("网络链接错误",-1);
    }





}
