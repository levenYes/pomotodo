package cn.liwenye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author liwenye on 2018/01/02
 */
@SpringBootApplication
@MapperScan("cn.liwenye.dao")
@ImportResource({"classpath:spring/schedule.xml"})
public class PomotodoServerApplication{
    public static void main(String [] args){
        SpringApplication.run(PomotodoServerApplication.class, args);
    }
}