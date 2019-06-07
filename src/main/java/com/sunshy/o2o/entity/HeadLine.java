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
public class HeadLine {


	private Long lineId;

	private String lineName;

	private String lineLink;

	private String lineImg;

	private Integer priority;

	private Integer enableStatus;

	private Date createTime;

	private Date lastEditTime;


}
