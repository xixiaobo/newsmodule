package com.hcycom.jhipster.service;

import org.springframework.web.bind.annotation.GetMapping;

import com.hcycom.jhipster.client.AuthorizedFeignClient;

@AuthorizedFeignClient(name = "jhipsteruaa")
public interface userService {
	
	@GetMapping("/api/allusers")
	String allusers();
}
