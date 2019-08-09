package com.shujuniu.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {

    private static JsonWithoutBytesFilter withoutBytesFilter = new JsonWithoutBytesFilter();
    // private static HedoneIEnumValueFilter iEnumValueFilter = new HedoneIEnumValueFilter();
    private static SerializeFilter[] filters = new SerializeFilter[] { withoutBytesFilter };

    /**
     * 校验该串是否为合法的json串
     */
    public static boolean isJsonStr(String jsonStr) {
        if (jsonStr == null)
            return false;
        try {
            JSON.parseObject(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String toJson(Object src) {
        return JSON.toJSONString(src);
    }

    public static String toJsonWithoutBytes(Object src) {
        return JSON.toJSONString(src, filters);
    }

    @SuppressWarnings("unchecked")
    public static <T> T toObject(String src, Class<T> clz) {
        // string 类型特殊处理，不需要json转化
        if (clz == String.class) {
            return (T) src;
        }

        return JSON.parseObject(src, clz);
    }

    public static <T> T toObject(String src, Type clz) {

        return JSON.parseObject(src, clz);
    }

    public static String getJsonValue(String rescontent, String key) {
        JSONObject jsonObject = JSONObject.parseObject(rescontent);
        return jsonObject.getString(key);

    }

    public static <T> List<T> parseArray(String jsonStr, Class<T> clz) {
        return JSON.parseArray(jsonStr, clz);
    }
}
