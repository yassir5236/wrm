package org.yassir.wrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.yassir.wrm.config.ConfigurationPropertiesValues;

@SpringBootApplication
public class WrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrmApplication.class, args);
        System.out.println("hello ");
    }

}
