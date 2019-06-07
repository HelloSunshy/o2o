package com.sunshy.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码
 *
 * @author sunshy
 * @date 2019-05-19   10:46
 */

public class VerCode {


    public static  boolean getResult(HttpServletRequest request){


        String verifyCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        String veFine = HttpServletRequestUtil.getString(request,"veFine");

        if (veFine.equalsIgnoreCase(verifyCode) && !verifyCode.isEmpty()){

            return true;

        }


        return false;
    }

}
