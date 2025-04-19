package goj.holy365.common.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Holy365 API")
				.version("1.0")
				.description("Holy365 API DOC")
			);
	}

	@Bean
	public GroupedOpenApi api() {
		String[] paths = {"/api/v1/**"};
		String[] packagesToScan = {"goj.holy365"};
		return GroupedOpenApi.builder().group("springdoc-openapi")
			.pathsToMatch(paths)
			.packagesToScan(packagesToScan).build();
	}
}
