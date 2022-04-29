package com.example.metaflink.database.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author binghe
 * @version 1.0.0
 * @description 集合的工具类
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Object[] collection) {
        return collection == null;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}

