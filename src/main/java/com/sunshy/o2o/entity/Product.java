package com.sunshy.o2o.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   23:55
 */
@Data
public class Product implements Serializable{
	

	private static final long serialVersionUID = -349433539553804024L;

	private Long productId;

	private String productName;

	private String productDesc;

	/**简略图**/
	private String imgAddr;

	private String normalPrice;

	private String promotionPrice;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;

	private Integer enableStatus;

	private Integer point;

	private List<ProductImg> productImgList;

	private ProductCategory productCategory;

	private Shop shop;



}
