package org.yassir.wrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrmApplication.class, args);
        System.out.println("hello ");
    }

}
