package com.example.metaflink.util;

public class StringUtils extends org.apache.commons.lang.StringUtils{

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (org.apache.commons.lang.StringUtils.isBlank(s) || Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return new StringBuilder().append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
