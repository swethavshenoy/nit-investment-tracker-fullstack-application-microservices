package com.natwest.performance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = PerformanceApplication.class) // Specify the main application class
class PerformanceApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}
}
