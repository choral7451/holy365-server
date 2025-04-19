package goj.holy365;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Holy365Application {

	public static void main(String[] args) {
		SpringApplication.run(Holy365Application.class, args);
	}

}
