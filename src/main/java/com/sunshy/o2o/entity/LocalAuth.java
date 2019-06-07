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
public class LocalAuth {


	private Long localAuthId;

	private String userName;

	private String password;

	private Long userId;

	private Date createTime;

	private Date lastEditTime;

	private PersonInfo personInfo;



}
