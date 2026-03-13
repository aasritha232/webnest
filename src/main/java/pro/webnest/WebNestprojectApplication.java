package pro.webnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebNestprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebNestprojectApplication.class, args);
	}
	@Bean
	//This allows HTTP calls from Spring.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
