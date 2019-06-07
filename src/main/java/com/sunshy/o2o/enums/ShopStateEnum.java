package com.sunshy.o2o.enums;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-17   00:00
 */
public enum ShopStateEnum {

    CHECK(0, "审核中"),

    OFFLINE(-1, "非法商铺"),

    SUCCESS(1, "操作成功"),

    PASS(2, "通过认证"),

    INNER_ERROR(-1001, "操作失败"),

    NULL_SHOPID(-1002, "ShopId为空"),

    NULL_SHOP_INFO(-1003, "传入了空的信息"),

    QUERY_FAILD(-1004,"查询商店信息失败"),

    UPDATE_FAILD(-1005,"商铺更新失败"),

    ADD_IMG_FAILD(-1006,"图片添加失败")

    ;


    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    ShopStateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public  static ShopStateEnum getShopStaum(Integer code){

        for(ShopStateEnum shopStateEnum: values()){

            if (code.equals(shopStateEnum.code)){

                return shopStateEnum;
            }
        }

        return  null;
    }


}
