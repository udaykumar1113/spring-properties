package com.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.properties.bean.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {
	
	@Value("${spring.datasource.username}")//the values from properties file will be loaded here
	String userName;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Bean
	public DataSource dataSource(){
		//we are setting the properties to data source class
		DataSource dataSource=new DataSource();
		dataSource.setUserName(userName);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		return dataSource;
	}

	//This will bring in properties file values here, if this is not defined values will not be available
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
        		new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
}
