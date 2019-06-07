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
public class UserProductMap {


	private Long userProductId;

	private Long userId;

	private Long productId;

	private Long shopId;

	private String userName;

	private String productName;

	private Date createTime;

	private Integer point;

	private PersonInfo user;

	private Product product;

	private Shop shop;



}
