package com.lyp.count;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.lyp.count.*.mapper")
//@PropertySource(name = "EncryptedProperties", value = "classpath:encrypted.yml")
public class CountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountApplication.class, args);
	}

}
