package com.sunshy.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-06   21:49
 */
public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,
                "verifyCodeActual");
        if (verifyCodeActual == null
                || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }

}
