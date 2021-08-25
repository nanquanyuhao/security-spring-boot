package net.nanquanyuhao.security.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@MapperScan("net.nanquanyuhao.security.springboot.mapper")
public class SecuritySpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringBootApp.class, args);
    }
}
