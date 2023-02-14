package com.daniellanza.clpbackend;

import com.daniellanza.clpbackend.data.User;
import com.daniellanza.clpbackend.dto.UserRegistration;
import com.daniellanza.clpbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ClpBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void registerUserTest(){
		User user = new User();
		boolean created = (user!=null);
		Assert.isTrue(created,"A user was created");
	}

	@Test
	void userServiceTest(){
		UserRegistration register = new UserRegistration();
		register.setEmail("ripper@rag.com");
		register.setUsername("jackDaRipper");
		register.setPassword("1234");
		register.setFirstName("Jack");
		register.setLastName("Smith");



	}
}
