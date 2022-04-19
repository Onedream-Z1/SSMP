package cn.xz.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("cn.xz.springboot.mapper")
public class SSMPApplication {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        SpringApplication.run(SSMPApplication.class, args);
    }
}
