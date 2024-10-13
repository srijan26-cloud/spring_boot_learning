package com.springsecurity.topic1;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springsecurity.topic1.Entities.UserEntity;
import com.springsecurity.topic1.Services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Topic1ApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		UserEntity userEntity = new UserEntity(4L , "srijan@email.com" , "USER");

		String token = jwtService.generateToken(userEntity);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);

		System.out.println(id);
	}

}
