package com.sunshy.o2o.enums;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-04   22:08
 */
public enum ProductCategoryStateEnum {

    SUCCESS(1, "创建成功"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY_LIST(-1002, "添加数少于1");

    private int state;

    private String stateInfo;

    private ProductCategoryStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ProductCategoryStateEnum stateOf(int index) {
        for (ProductCategoryStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
