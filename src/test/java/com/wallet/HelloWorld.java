package com.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class HelloWorld {
	
	@Test
	public void testHelloWorld() {
		assertEquals(1, 1);
	}

}
