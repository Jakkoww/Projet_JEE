package projet.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "projet.core.dao")
@EntityScan(basePackages = "projet.core.entity")
@ComponentScan(basePackages = "projet.core.service")
public class CoreConfig {
}

