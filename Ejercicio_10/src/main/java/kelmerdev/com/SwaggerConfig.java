package kelmerdev.com;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .description("Order Service API Description")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Codmind")
                                .email("apis@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("LICENSE")
                                .url("LICENSE URL"))
                );
    }
}