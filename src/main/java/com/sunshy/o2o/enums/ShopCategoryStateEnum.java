package com.sunshy.o2o.enums;

import lombok.Getter;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-07   09:51
 */
@Getter
public enum ShopCategoryStateEnum {
    SUCCESS(0, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(-1002, "区域信息为空");

    private int state;

    private String stateInfo;

     ShopCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopCategoryStateEnum stateOf(int index) {
        for (ShopCategoryStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
