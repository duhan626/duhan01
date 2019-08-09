package com.shujuniu.common.utils;

/**
 * Created by haiwei on 2018/7/6.
 */

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class NCarsBeanUtil {

    private static final Logger logger = LoggerFactory.getLogger(NCarsBeanUtil.class);

    static final ConcurrentMap<Class<?>, List<String>> strongClassCache = new ConcurrentHashMap<Class<?>, List<String>>(64);

    /**
     * List转换
     *
     * @param sourceList 原数据数据list
     * @param clazz      目标类型
     * @param <B>
     * @return
     */
    public static <B> List<B> convertList(List sourceList, Class<B> clazz) {

        if (sourceList == null || sourceList.size() <= 0) {
            return new ArrayList<B>(); //防止使用接品报空异常
        }

        List<B> resultList = new ArrayList<B>();
        try {
            for (Object source : sourceList) {
                B target = clazz.newInstance();
                BeanUtils.copyProperties(source, target);
                resultList.add(target);
            }
        } catch (InstantiationException e) {
            logger.error("BeanList转换出现异常{}", ExceptionUtils.getFullStackTrace(e));
        } catch (IllegalAccessException e) {
            logger.error("BeanList转换出现异常{}", ExceptionUtils.getFullStackTrace(e));
        }

        return resultList;
    }


    public static <B> B convertBean(Object source, Class<B> clazz) {
        if (source == null) {
            return null;
        }

        B target = null;

        try {
            target = clazz.newInstance();
            BeanUtils.copyProperties(source, target);
        } catch (InstantiationException e) {
            logger.error("Bean转换出现异常{}", ExceptionUtils.getFullStackTrace(e));
        } catch (IllegalAccessException e) {
            logger.error("Bean转换出现异常{}", ExceptionUtils.getFullStackTrace(e));
        }

        return target;
    }

    /**
     * 如果目的对象声明为原始类型而源对象为封装类型，则跳过null值
     * porting from BeanUtils.copyProperties(Object source, Object target, Class<?> editable, String... ignoreProperties)
     *
     * @param source
     * @param destCl
     * @return
     */
    public static <T> T convertWithoutNull(Object source, Class<T> destCl) {
        T target = null;

        try {
            target = destCl.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unable to create instance of dest.", ex);
        }

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(destCl);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null &&
                            ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);

                            //add by Ning to check primitive type
                            if (value == null) {
                                Class<?>[] clzParams = writeMethod.getParameterTypes();
                                if (clzParams[0].isPrimitive()) {
                                    continue;
                                }
                            }

                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        } catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }

        return target;
    }

    public static <T> List<T> convertListWithoutNull(List<?> srcList, Class<T> destCl) {
        try {
            List<T> destList = new ArrayList<T>();
            if (srcList.size() > 0) {
                for (Object src : srcList) {
                    T dest = convertWithoutNull(src, destCl);
                    destList.add(dest);
                }
            }
            return destList;
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to convert the src obj to dest obj.", e);

        }
    }


    public static <T> T mapToBean(Map<String, Object> map, Class<T> destCl) {
        if (map == null)
            return null;

        try {
            T dest = destCl.newInstance();

            BeanInfo beanInfo = Introspector.getBeanInfo(destCl);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(dest, value);
                }
            }
            return dest;
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to mapToBean.", e);

        }
    }


    public static void copyProperties(Object source, Object target)
            throws BeansException {

        Class<?> actualEditable = target.getClass();

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);

        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, value);
                    } catch (Throwable ex) {
                        //ignore this property
                    }
                }
            }
        }
    }

    /**
     * bean转化成对象Map<String, Object>
     *
     * @param entity
     */
    public static Map<String, Object> beanToMapOnlyDeclaredFields(Object entity) {
        return beanToMapOnlyDeclaredFields(entity, null);
    }

    /**
     * bean转化成对象Map<String, Object>
     *
     * @param entity
     * @return
     * @author ndai
     * @date Sep 14, 2016 6:08:10 PM
     */
    public static Map<String, Object> beanToMapOnlyDeclaredFields(Object entity, List<String> fieldNames) {
        try {

            Class<?> entityClz = entity.getClass();

            List<String> fields = strongClassCache.get(entityClz);
            if (fields == null) {
                fields = new ArrayList<>();

                Class<?> clz = entityClz;
                while (!clz.equals(Object.class)) {
                    Field[] ps = clz.getDeclaredFields();
                    for (Field field : ps) {
                        if (field.getName().equals("class") || field.getName().equals("serialVersionUID"))
                            continue;

                        fields.add(field.getName());
                    }

                    clz = clz.getSuperclass();
                }

                if (fields.size() > 0)
                    strongClassCache.put(entityClz, fields);
            }

            if (fields.size() == 0)
                return null;

            Map<String, Object> mapEntity = new HashMap<>();

            for (String field : fields) {

                if (fieldNames != null && !fieldNames.contains(field))
                    continue;

                PropertyDescriptor targetPd = BeanUtils.getPropertyDescriptor(entity.getClass(), field);

                if (targetPd != null && targetPd.getReadMethod() != null) {

                    if (targetPd.getName().equals("class"))
                        continue;

                    try {
                        Method readMethod = targetPd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            continue;
                        }
                        Object value = readMethod.invoke(entity);

                        if (value != null) {
                            mapEntity.put(targetPd.getName(), value);
                        }
                    } catch (Throwable ex) {
                        //ignore this property
                    }
                }
            }

            return mapEntity;

        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to convert entity to Map<String, Object.", e);
        }
    }

    public static List<String> fillBean(Object entity, Map<String, Object> fields) {
        List<String> updated = new ArrayList<>();

        for (String field : fields.keySet()) {
            if (fillBean(entity, field, fields.get(field)) == 1)
                updated.add(field);
        }

        return updated;
    }

    public static int fillBean(Object entity, String field, Object value) {
        PropertyDescriptor targetPd = BeanUtils.getPropertyDescriptor(entity.getClass(), field);

        if (targetPd != null && targetPd.getWriteMethod() != null) {

            try {
                Method writeMethod = targetPd.getWriteMethod();
                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                    logger.warn(entity.getClass() + ".set" + field + "方法不是public的");
                    return -1;
                }

                writeMethod.invoke(entity, value);

                return 1;

            } catch (Throwable ex) {
                logger.error("填装bean失败", ex);
            }
        }

        return -1;
    }
}
