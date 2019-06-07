package com.sunshy.o2o.enums;

import lombok.Getter;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-05   18:10
 */
@Getter
public enum ProductStateEnum {

    OFFLINE(-1, "非法商品"),
    SUCCESS(0, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "操作失败"),
    EMPTY(-1002, "商品为空"),
    IMG_IS_NULL(-1003,"图片为空"),
    ADD_IMG_FAIL(-1005,"添加图片失败");

    private Integer statue;

    private String msg;

    ProductStateEnum(Integer statue, String msg) {
        this.statue = statue;
        this.msg = msg;
    }

}
