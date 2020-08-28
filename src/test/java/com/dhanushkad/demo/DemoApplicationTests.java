package com.dhanushkad.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	WelcomeController welcomeController;
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void contextLoads() {
		RequestThread one = new RequestThread(restTemplate);
		RequestThread two = new RequestThread(restTemplate);
		RequestThread three = new RequestThread(restTemplate);
		RequestThread four = new RequestThread(restTemplate);

		one.run();
		two.run();
		three.run();
		four.run();
		assertThat(this.restTemplate.getForObject("http://localhost:8080/hello", String.class)).contains("1");
	}

}

class RequestThread extends Thread {
	TestRestTemplate restTemplate;

	public RequestThread(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public void run() {
		for(int i = 1; i < 100000; i++) {
			this.restTemplate.getForObject("http://127.0.0.1:8080/hello",
					String.class);
		}
	}
}
