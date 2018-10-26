package com.github.igmfilho.challenge.itlean.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.igmfilho.challenge.itlean.api.model.UserDTO;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins="*")
public class UserResource {

	@PostMapping(value="/sign-up", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> signup(@Valid @RequestBody UserDTO user, BindingResult result) {
		return null;
	}
	
	@PostMapping(value="/sign-in", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> signin(@Valid @RequestBody UserDTO user, BindingResult result) {
		return null;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getById(@PathVariable String id) {
		return null;
	}
	
}
