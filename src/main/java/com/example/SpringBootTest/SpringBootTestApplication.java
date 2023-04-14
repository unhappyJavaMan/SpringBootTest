package com.example.SpringBootTest;

import com.example.SpringBootTest.common.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({
		"com.example",
})
@ComponentScan({
		"com.example",
})
@EnableJpaRepositories({
		"com.example",
})
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
		Log.init();
	}

}
