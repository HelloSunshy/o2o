package com.sunshy.o2o.entity;

import lombok.Data;

import java.util.Date;


@Data
public class WechatAuth {


	private Long weChatAuthId;

	private Long userId;

	private String openId;

	private Date createTime;

	private PersonInfo personInfo;


}
