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
public class Award {

    private Long awardId;

    private String awardName;

    private String awardDesc;

    private String awardImg;

    private Integer point;

    private Integer priority;

    private Date createTime;

    private Date expireTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private Long shopId;


}
