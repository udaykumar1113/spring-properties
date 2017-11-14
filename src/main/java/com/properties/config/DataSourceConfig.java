package com.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.properties.bean.DataSource;
import com.properties.bean.JMS;

@Configuration
@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class DataSourceConfig {
	
	@Value("${spring.datasource.username}")//the values from properties file will be loaded here
	String userName;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.jms.username}")//the values from properties file will be loaded here
	String jms_userName;
	
	@Value("${spring.jms.password}")
	String jms_password;
	
	@Value("${spring.jms.url}")
	String jms_url;
	
	@Bean
	public DataSource dataSource(){
		//we are setting the properties to data source class
		DataSource dataSource=new DataSource();
		dataSource.setUserName(userName);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		return dataSource;
	}

	@Bean
	public JMS jms(){
		JMS jms=new JMS();
		jms.setUserName(jms_userName);
		jms.setPassword(jms_password);
		jms.setUrl(jms_url);
		return jms;
	}
	
	//This will bring in properties file values here, if this is not defined values will not be available
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
        		new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
}
