package com.github.igmfilho.challenge.itlean.api;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.github.igmfilho.challenge.itlean.SpringBootRestApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestApiApplication.class)
@WebAppConfiguration
public class UserResourceTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
