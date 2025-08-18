package com.xuqj.gamepicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.xuqj.gamepicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class GamePictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamePictureBackendApplication.class, args);
    }

}
