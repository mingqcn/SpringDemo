package xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ming Qiu
 */
@SpringBootApplication
@MapperScan("xmu.oomall.mapper")
public class OoMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(OoMallApplication.class, args);
	}

}
