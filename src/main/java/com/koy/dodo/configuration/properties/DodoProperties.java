package com.koy.dodo.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
@ConfigurationProperties(prefix = "dodo")
@Component
@Data
public class DodoProperties{
    private String fileStorePath;

}
