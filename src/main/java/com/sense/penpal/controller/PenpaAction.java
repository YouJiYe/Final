package com.sense.penpal.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class PenpaAction {
	
	@RequestMapping(value="panpel_main.nhn")
	public String panpel_main() {
		return "/panpel_main";
	}
	
	
}
