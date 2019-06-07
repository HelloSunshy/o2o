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
public class ShopCategory {

	private Long shopCategoryId;

	private String shopCategoryName;

	private String shopCategoryDesc;

	private String shopCategoryImg;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;

	private Long parentId;


}
