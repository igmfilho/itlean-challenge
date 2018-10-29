package com.github.igmfilho.challenge.itlean.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
	public void test() throws Exception {
		mockMvc.perform(post("/users/sign-up").contentType(MediaType.APPLICATION_JSON).content("{\"name\": \"grep\", \"password\": \"123456\" }") )
        				.andExpect(status().isOk());
	}
}