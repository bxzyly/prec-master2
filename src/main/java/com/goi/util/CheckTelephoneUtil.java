package com.goi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckTelephoneUtil {

    public static boolean isMobileNum(String telNum){
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }
}
