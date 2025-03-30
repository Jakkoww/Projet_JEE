package projet.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import projet.core.config.CoreConfig;

@Configuration
@Import(CoreConfig.class)
public class WebConfig {
}
