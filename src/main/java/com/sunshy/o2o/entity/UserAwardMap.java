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
public class UserAwardMap {


	private Long userAwardId;

	private Long userId;

	private Long awardId;

	private Long shopId;

	private String userName;

	private String awardName;

	private Date expireTime;

	private Date createTime;

	private Integer usedStatus;

	private Integer point;

	private PersonInfo user;

	private Award award;

	private Shop shop;



}
