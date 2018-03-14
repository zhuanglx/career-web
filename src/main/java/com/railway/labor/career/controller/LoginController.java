package com.railway.labor.career.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!" + userName + "," + password;
	}
	@RequestMapping("/index")
	@ResponseBody
	String index() {
		return "Hello World!" + userName + "," + password;
	}
}
