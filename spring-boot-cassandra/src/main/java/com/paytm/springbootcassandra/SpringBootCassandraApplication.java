package com.paytm.springbootcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.paytm.springbootcassandra.service.ProductSerializer;

@SpringBootApplication
public class SpringBootCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraApplication.class, args);
	}
	
	@Bean
	public SimpleModule simpleModule() throws Exception {
		SimpleModule simpleModule = new SimpleModule();
		return simpleModule;
	}
	
	@Bean("objectMapper")
	public ObjectMapper objectMapper() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		return objectMapper;
	}
	@Bean("mapper")
	public ObjectMapper objectMapper3() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		return objectMapper;
	}
	@Bean("updateObjectMapper")
	public ObjectMapper updateObjectMapper() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper;
	}
	
	@Bean("addSerializer")
	ProductSerializer addSerializer() {
		return new ProductSerializer(false);
	}
	
	@Bean("updateSerializer")
	ProductSerializer updateSerializer() {
		return new ProductSerializer(true);
	}
}
