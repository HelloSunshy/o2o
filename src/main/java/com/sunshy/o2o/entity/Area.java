package com.sunshy.o2o.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   23:55
 */
@Data
public class Area {

	private Long areaId;

	private String areaName;

	private String areaDesc;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;



}
