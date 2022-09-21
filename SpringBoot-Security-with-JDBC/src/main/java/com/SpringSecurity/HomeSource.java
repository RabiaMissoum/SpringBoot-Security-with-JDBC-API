package com.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeSource {

	@GetMapping("/")
	public String home() {
		return "<h1> Welcome </>";
	}
	
	@GetMapping("/user")
	public String Userhome() {
		return "<h1> Welcome User </>";
	}
	
	@GetMapping("/admin")
	public String Adminhome() {
		return "<h1> Welcome Admin</>";
	}
}
