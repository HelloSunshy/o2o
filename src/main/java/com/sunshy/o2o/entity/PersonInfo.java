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
public class PersonInfo {

	private Long userId;

	private String name;

	private Date birthday;

	private String gender;

	private String phone;

	private String email;

	private String profileImg;

	private Integer customerFlag;

	private Integer shopOwnerFlag;

	private Integer adminFlag;

	private Date createTime;

	private Date lastEditTime;

	private Integer enableStatus;



}
