import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.window_programming_api")
@EnableJpaRepositories("com.window_programming_api.repository")
@EntityScan("com.window_programming_api.entity")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Application {

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}


}