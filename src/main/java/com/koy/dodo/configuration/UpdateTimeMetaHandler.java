package com.koy.dodo.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description  时间自动更新插入字段
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
@Component
public class UpdateTimeMetaHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        final Date now = new Date();
        this.setFieldValByName("updated_time", now, metaObject);
    }
}
