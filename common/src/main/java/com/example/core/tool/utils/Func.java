package com.example.core.tool.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Func {

    /**
     * 转换为String数组<br>
     *
     * @param str 被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String str) {
        return toStrArray(",", str);
    }

    /**
     * 转换为String数组<br>
     *
     * @param split 分隔符
     * @param str   被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String split, String str) {
        if (ObjectUtils.isEmpty(str)) {
            return new String[]{};
        }
        return str.split(split);
    }

    public static Long[] toLongArray(String str) {
        return toLongArray(",", str);
    }

    public static Long[] toLongArray(String split, String str) {
        if (ObjectUtils.isEmpty(str)) {
            return new Long[]{};
        }
        String[] strArray = str.split(split);
        return Arrays.stream(strArray).map(Long::valueOf).toArray(Long[]::new);
    }

    public static List<Long> toLongList(String str) {
        Long[] longArray = toLongArray(str);
        return Arrays.asList(longArray);
    }

    public static List<Long> toLongList(String split, String str) {
        Long[] longArray = toLongArray(split, str);
        return Arrays.asList(longArray);
    }

    public static String toStr(Object str, String defaultValue) {
        return null == str ? defaultValue : String.valueOf(str);
    }

    public static String toStr(Object str) {
        return toStr(str, "");
    }
}
