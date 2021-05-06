package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: SpringBoot主启动类
 *
 * @author : Juice
 */
@SpringBootApplication
@MapperScan("com.fc.mapper")// 指定扫描包，创建接口实现类
@EnableSwagger2// 开启丝袜哥
public class SpringBootRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner.class, args);
    }
}
