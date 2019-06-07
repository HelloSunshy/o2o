package com.sunshy.o2o.controller.product;

import com.sunshy.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   18:48
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @RequestMapping("/addProduct")
    @ResponseBody
    public Map<String,Object> addProduct(){

        return null;
    }

}
