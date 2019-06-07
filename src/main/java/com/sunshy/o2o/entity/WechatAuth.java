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
public class WechatAuth {


	private Long weChatAuthId;

	private Long userId;

	private String openId;

	private Date createTime;

	private PersonInfo personInfo;


}
