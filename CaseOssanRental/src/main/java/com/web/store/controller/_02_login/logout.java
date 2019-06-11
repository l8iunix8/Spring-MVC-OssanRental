package com.web.store.controller._02_login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logout {
	
	@RequestMapping("logout")
	public String logout() {
		return "_02_login/logout";
	}
}
