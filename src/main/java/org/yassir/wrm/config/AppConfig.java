package org.yassir.wrm.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConfigurationPropertiesValues.class)
public class AppConfig {

}
