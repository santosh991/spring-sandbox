package net.agilegeeks.wicketspring.services;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	public String sayHello() {
		return "Hello World !";
	}
	
}
