package com.election.version.one.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.election.version.one.repository")
@PropertySource("datasource.properties")
@EnableTransactionManagement
public class H2JpaConfig {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		
		//dataSource.set
		return dataSource;
	}

	 @Bean
	 public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
	     final DataSourceInitializer initializer = new DataSourceInitializer();
	     initializer.setDataSource(dataSource);
	     initializer.setDatabasePopulator(databasePopulator());
	     return initializer;
	 }

	 private DatabasePopulator databasePopulator() {
	     final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	     populator.setSeparator(";");
	     populator.setCommentPrefix("--");
	     populator.addScript(new ClassPathResource("schema.sql"));
	     populator.addScript(new ClassPathResource("data.sql"));
	     return populator;
	 }
}
