package com.election.version.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@EnableConfigurationProperties(DataSourceProperties.class)
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
/*@Configuration
@EnableAutoConfiguration(
exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
*/
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Bean 
	WebMvcConfigurer configurer () {
		return new WebMvcConfigurerAdapter() {
			   @Override
			   public void addResourceHandlers( ResourceHandlerRegistry registry) {
				   registry.addResourceHandler("/ui/").addResourceLocations("classpath:/static/ui/index.html");
				   
			   }
		};
	}
  
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/publicregister").
				allowedOrigins("http://localhost:4200");
			   registry.addMapping("/auth/login").allowedOrigins("http://localhost:4200");
			   registry.addMapping("/auth/register").allowedOrigins("http://localhost:4200");
			   registry.addMapping("/candidates").allowedOrigins("http://localhost:4200");
			}
		};
	}
	
	
}


