package com.shujuniu.common.utils;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class JsonWithoutBytesFilter implements PropertyPreFilter, SerializeFilter {

    @Override
    public boolean apply(JSONSerializer serializer, Object object, String name) {

        try {
            if(Map.class.isAssignableFrom(object.getClass())) {
                return true;
            }

            //营养食谱小bug,需要首字母转换成小写
            name = new StringBuilder().append(Character.toLowerCase(name.charAt(0))).append(name.substring(1)).toString();

            PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(object.getClass(), name);
            if (sourcePd != null) {
                Method readMethod = sourcePd.getReadMethod();

                if(readMethod != null) {
                    if(readMethod.getReturnType().isArray() && readMethod.getReturnType().getComponentType().equals(byte.class)) {
                        return false;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

}