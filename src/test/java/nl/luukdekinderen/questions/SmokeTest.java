package nl.luukdekinderen.questions;


import static org.assertj.core.api.Assertions.assertThat;

import nl.luukdekinderen.questions.controllers.ReadController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private ReadController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void Test() throws Exception {
		assertThat(true).isEqualTo(true);
	}
}