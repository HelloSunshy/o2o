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
public class ProductImg {


	private Long productImgId;

	private String imgAddr;

	private String imgDesc;

	private Integer priority;

	private Date createTime;

	private Long productId;


}
