package xmu.litemall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"xmu.malldemo.litemall"})
@MapperScan("xmu.malldemo.litemall.dao")
public class MalldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalldemoApplication.class, args);
	}

}
