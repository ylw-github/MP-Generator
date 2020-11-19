package cn.com.ylw.generator;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author YangLinWei
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.com.ylw.generator.mapper")
@EnableSwagger2Doc
public class CodeGeneratorApp {

    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApp.class, args);
    }

}
