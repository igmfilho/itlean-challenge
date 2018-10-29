package com.github.igmfilho.challenge.itlean.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.igmfilho.challenge.itlean.api.model.UserDTO;
import com.github.igmfilho.challenge.itlean.service.UserService;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="*")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/sign-up", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> signUp(@RequestBody UserDTO user) {
		
		UserDTO userDto = userService.register(user);
		
		return ResponseEntity.ok(userDto);
	}
	
/*	@PostMapping(value="/sign-in", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> signin(@Valid @RequestBody UserDTO user, BindingResult result) {
		return null;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getById(@PathVariable String id) {
		return null;
	}
*/	
}
