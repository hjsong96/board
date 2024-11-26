package kr.msp.config;

import java.util.Collections;

import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.morpheus.gateway.jdbc.GatewayDataSourceContext;

@Configuration(proxyBeanMethods = false)
public class DataSourceInitializerConfiguration {

	@Bean
	SqlDataSourceScriptDatabaseInitializer sqlDataSourceScriptDatabaseInitializer(GatewayDataSourceContext context) {
		SqlInitializationProperties sqlInitializationProperties = new SqlInitializationProperties();
		sqlInitializationProperties.setSchemaLocations(Collections.singletonList("classpath:schema.sql"));
		sqlInitializationProperties.setDataLocations(Collections.singletonList("classpath:data.sql"));
		return new SqlDataSourceScriptDatabaseInitializer(context.getDataSource(), sqlInitializationProperties);
	}

}
