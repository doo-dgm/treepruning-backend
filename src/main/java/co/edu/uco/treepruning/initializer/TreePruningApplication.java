package co.edu.uco.treepruning.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "co.edu.uco.treepruning")
@EnableJpaRepositories(basePackages = "co.edu.uco.treepruning")
@EntityScan(basePackages = "co.edu.uco.treepruning")
public class TreePruningApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreePruningApplication.class, args);
	}

}
