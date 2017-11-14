package com.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.properties.bean.DataSource;
import com.properties.bean.JMS;

@SpringBootApplication
public class SpringPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringPropertiesApplication.class, args);
		
		//getting the bean and reading the properties set from file
		DataSource dataSource=(DataSource)ctx.getBean(DataSource.class);
		System.out.println(dataSource.getUserName());
		System.out.println(dataSource.getPassword());
		System.out.println(dataSource.getUrl());
		
		JMS jms=(JMS)ctx.getBean(JMS.class);
		System.out.println(jms.getUserName());
		System.out.println(jms.getPassword());
		System.out.println(jms.getUrl());
	}
}
