package com.authDemo.ClickProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class ClickProjectApplication {

	//this ClickProjectApplication will have a github way to login

	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("name", principal.getAttribute("login"));
	}

	@GetMapping("/user-details")
	public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User principal) {
		return principal.getAttributes();
	}


	public static void main(String[] args) {
		SpringApplication.run(ClickProjectApplication.class, args);
	}

}
