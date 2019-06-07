package com.sunshy.o2o.util;

import io.netty.util.internal.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-17   21:02
 */
public class HttpServletRequestUtil {



    public static  int getInt(HttpServletRequest request,String key){

        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e ){

            return  -1;
        }

    }


    public static  long getLong(HttpServletRequest request,String key){

        try {

            return Long.decode(request.getParameter(key));

        }catch (Exception e ){

            return  -1;
        }

    }


    public static  Double getDouble(HttpServletRequest request,String key){

        try {

            return Double.valueOf(request.getParameter(key));

        }catch (Exception e ){

            return  -1d;
        }

    }



    public static  Boolean getBoolean(HttpServletRequest request,String key){

        try {

            return Boolean.valueOf(request.getParameter(key));

        }catch (Exception e ){

            return  false;
        }

    }



    public static String getString(HttpServletRequest request,String key){


        try {

            String parameter = request.getParameter(key);

            if (parameter.isEmpty()){

                return null;

            }else {

                return parameter.trim();

            }

        }catch (Exception e){

            return null;
        }





    }

}
