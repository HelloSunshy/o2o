package com.sunshy.o2o.dto;

import com.sunshy.o2o.entity.Shop;
import com.sunshy.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-16   23:55
 */
public class ShopExecution {


    private int statue;

    private String msg;

    private Shop shop;

    private int conut;

    private List<Shop> shopList;

    public ShopExecution() {

    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getConut() {
        return conut;
    }

    public void setConut(int conut) {
        this.conut = conut;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    /**
     * 店铺操作失败的构造器
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum) {

        this.statue = shopStateEnum.getCode();

        this.msg = shopStateEnum.getMsg();

    }


    /***
     * 店铺操作成功的构造器
     * @param shopStateEnum
     * @param shop
     */
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop) {

        this.statue = shopStateEnum.getCode();

        this.msg = shopStateEnum.getMsg();

        this.shop = shop;

    }


    /***
     * 店铺操作成功的构造器
     * @param shopStateEnum
     * @param shopList
     */
    public ShopExecution(ShopStateEnum shopStateEnum,List<Shop> shopList) {

        this.statue = shopStateEnum.getCode();

        this.msg = shopStateEnum.getMsg();

        this.shopList = shopList;

    }




}
