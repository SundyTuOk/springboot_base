package com.tt.utils.rusult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ResultUtils {

    private static final Logger logger = LoggerFactory.getLogger(ResultUtils.class);

    /**
     * 处理成功，带返回对象的
     * @param data 返回成功的对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data) {
        return new Result<T>(Result.ResultEnum.SUCCESS,data);
    }

    /**
     * 处理成功，不带返回对象
     * @return
     */
    public static Result ok() {
        return ok(null);
    }


    /**
     * 处理失败，自己输入错误枚举，和返回数据
     * @param resultEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(Result.ResultEnum resultEnum, T data) {
        return new Result<T>(resultEnum,data);
    }

    /**
     * 处理失败，使用默认错误枚举，不返回数据
     * @return
     */
    public static Result failed() {
        return failed(Result.ResultEnum.FAILED,null);
    }


    /**
     * 把result按照属性的键值对，返回为map
     * @param result
     * @return
     */
    public static Map resultToMap(Result result) {
        Field[] resultFields = Result.class.getDeclaredFields();
        Map map = new HashMap<String, String>();
        String fieldName = null;
        for (Field field : resultFields) {
            field.setAccessible(true);
            fieldName = field.getName();
            Object o = null;
            try {
                o = field.get(result);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage());
                continue;
            }
            map.put(fieldName, o);
        }
        return map;
    }
}
