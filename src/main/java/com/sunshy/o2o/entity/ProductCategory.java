package com.sunshy.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   23:55
 */
@Data
public class ProductCategory {

	private Long productCategoryId;

	private Long shopId;

	private String productCategoryName;

	private String productCategoryDesc;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;



}
