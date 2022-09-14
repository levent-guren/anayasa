package tr.gov.anayasa.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Named
public class SecurityConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				List<String> allowedMethods = new ArrayList<>();
				allowedMethods.add("GET");
				allowedMethods.add("POST");
				allowedMethods.add("PUT");
				allowedMethods.add("PATCH");
				allowedMethods.add("DELETE");
				allowedMethods.add("OPTIONS");

				List<String> origins = new ArrayList<>();
				origins.add("http://localhost:4200");

				List<String> exposedHeaders = new ArrayList<String>();
				exposedHeaders.add("Access-Control-Allow-Headers");
				exposedHeaders.add("Origin");
				exposedHeaders.add("Accept, X-Requested-With");
				exposedHeaders.add("Content-Type");
				exposedHeaders.add("Access-Control-Request-Method");
				exposedHeaders.add("Access-Control-Request-Headers");

				// @formatter:off
				registry
				  .addMapping("/**")
				  .allowedMethods(allowedMethods.toArray(new String[allowedMethods.size()]))
				  .allowedOrigins(origins.toArray(new String[origins.size()]))
				  .allowedHeaders(exposedHeaders.toArray(new String[exposedHeaders.size()]));
				// @formatter:on
			}
		};
	}
}
