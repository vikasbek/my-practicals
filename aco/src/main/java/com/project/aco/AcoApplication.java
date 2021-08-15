package com.project.aco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AcoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AcoApplication.class, args);
		List<String> strList = new ArrayList<String>();
		strList.add("aaa");
		strList.add("aba");
		strList.add("abc");
		strList.add("aaa");
		removeGivenValueFromList(strList, "aaa");
		System.out.println(strList);
	}
	
//	Write a method to remove a given value from array list having string values.

	public static void removeGivenValueFromList(List<String> stringList, String str) {
		while(stringList.contains(str))
			stringList.remove(str);
	}
	
	@Bean
	public RestTemplate restTemplate() throws Exception {
		return new RestTemplate();
	}

	
}
