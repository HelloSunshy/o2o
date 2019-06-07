package com.sunshy.o2o.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-15   17:43
 */
public class PathUtil  {

    /**获取文件的分隔符**/
    private static final  String SPEATOR = System.getProperty("file.separator");

    /** 日期格式 **/
    private static final SimpleDateFormat S_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Random ran = new Random();


    /**
     * 存放照片路径
     *
     * @return
     */
    public static String getImagePath(String fileName){

        /** 获取操作系统 **/
        String os = System.getProperty("os.name");

        String basePath ="";

        if (os.toLowerCase().startsWith("win")){

            basePath = "D:/ss"+fileName+"/";

        }else {

            basePath = "/Users/sunyinleng/image/"+fileName+"/";

        }

        basePath.replace("/",SPEATOR);

        return basePath;
    }

    /**
     * 存放照片路径
     *
     * @return
     */
    public static String getProductImagePath(String fileName){

        /** 获取操作系统 **/
        String os = System.getProperty("os.name");

        String basePath ="";

        if (os.toLowerCase().startsWith("win")){

            basePath = "D:/ss"+fileName+"/";

        }else {

            basePath = "/Users/sunyinleng/image/product/"+fileName+"/";

        }

        basePath.replace("/",SPEATOR);

        return basePath;
    }


    /***
     *
     * 生成随机文件名：时间 + 五位随机数
     *
     * @return
     */
    public static String getRandFileName(){

        String format = S_DATE_FORMAT.format(new Date());

        int rannum =   ran.nextInt(89999)+10000;

        return  format + rannum;

    }

}
