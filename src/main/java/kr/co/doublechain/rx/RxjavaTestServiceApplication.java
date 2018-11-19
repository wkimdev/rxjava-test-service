package kr.co.doublechain.rx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RxjavaTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxjavaTestServiceApplication.class, args);
	}
}
