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
public class ShopAuthMap {

	private Long shopAuthId;

	private Long employeeId;

	private Long shopId;

	private String name;

	private String title;

	private Integer titleFlag;

	private Integer enableStatus;

	private Date createTime;

	private Date lastEditTime;

	private PersonInfo employee;

	private Shop shop;


}
