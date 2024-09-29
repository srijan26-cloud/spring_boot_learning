package com.spring.chapter_2.DataTransferObject;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestDTO {
	
	@JsonProperty("Name")
	private String name;
	
	public TestDTO(String name) {
		this.name = name;
	}

}
