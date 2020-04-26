package com.wallet.respository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setName("set up User");
		user.setPassword("1234");
		user.setEmail(EMAIL);
		
		User response = userRepository.save(user);
	}
	
	@After
	public void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	public void testSave( ) {
		User user = new User();
		user.setName("Teste");
		user.setPassword("1234");
		user.setEmail("teste@teste.com");
		
		User response = userRepository.save(user);
		
		assertNotNull(response);
	}
	
	@Test
	public void testFinfByEmail() {
		Optional<User> response = userRepository.findByEmailEquals(EMAIL);
	 
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	
	}

}
