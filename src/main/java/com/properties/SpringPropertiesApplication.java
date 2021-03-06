package com.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.properties.bean.DataSource;

@SpringBootApplication
public class SpringPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringPropertiesApplication.class, args);
		
		//getting the bean and reading the properties set from file
		DataSource dataSource=(DataSource)ctx.getBean(DataSource.class);
		System.out.println(dataSource.getUserName());
		System.out.println(dataSource.getPassword());
		System.out.println(dataSource.getUrl());
	}
}
