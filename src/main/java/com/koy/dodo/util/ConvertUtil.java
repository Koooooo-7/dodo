package com.koy.dodo.util;

import com.koy.dodo.pojo.entity.BaseEntity;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/26
 */
public class ConvertUtil {


    public static<T> List<T> convertTo(List<?extends BaseEntity> source, Class<T> targetClz){
        List<T> list = new ArrayList<>();
        try {
            for (Object o: source
                 ) {
                T instance = targetClz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(o,instance);
                list.add(instance);

            }

        } catch (Exception ignore) {};
        return list;
    }
}
