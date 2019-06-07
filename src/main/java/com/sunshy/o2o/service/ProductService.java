package com.sunshy.o2o.service;

import com.sunshy.o2o.dto.ProductExecution;
import com.sunshy.o2o.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   17:58
 */
public interface ProductService {

    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    Product getProductById(long productId);

    ProductExecution addProduct(Product product, MultipartFile thumbnail, List<MultipartFile> productImgs)
            throws RuntimeException;

    ProductExecution modifyProduct(Product product, MultipartFile thumbnail,
                                   List<MultipartFile> productImgs) throws RuntimeException;
}
