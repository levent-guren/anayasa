package tr.gov.anayasa.config;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import tr.gov.anayasa.service.Security;

@Named
public class DatabaseConfig {
	@Value("#{environment.model_number}")
	private String dbPassword;
	@Inject
	private Security security;

	@Bean("datasourceAnayasa")
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties getDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource getDataSource(
			@Qualifier("datasourceAnayasa") DataSourceProperties dsProperties) {
		dsProperties.setPassword(security.getDecrypted(dbPassword));
		return dsProperties.initializeDataSourceBuilder().build();
	}
}
