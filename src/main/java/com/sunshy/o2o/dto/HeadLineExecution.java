package com.sunshy.o2o.dto;

import com.sunshy.o2o.entity.HeadLine;
import com.sunshy.o2o.enums.HeadLineStateEnum;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-07   09:54
 */
public class HeadLineExecution {

    /***
     *
     结果状态
     */
    private int state;

    /**
     *
     状态标识
     */
    private String stateInfo;

    /**
     *
     店铺数量
     */
    private int count;

    /**
     *
     操作的award（增删改商品的时候用）
     */
    private HeadLine headLine;

    /**
     *    获取的award列表(查询商品列表的时候用)
     */
    private List<HeadLine> headLineList;

    public HeadLineExecution() {
    }

    /**
     *     失败的构造器
     */
    public HeadLineExecution(HeadLineStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     *     成功的构造器
      */
    public HeadLineExecution(HeadLineStateEnum stateEnum, HeadLine headLine) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.headLine = headLine;
    }

    /**
     *     成功的构造器
      */
    public HeadLineExecution(HeadLineStateEnum stateEnum, List<HeadLine> headLineList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.headLineList = headLineList;
    }


}
