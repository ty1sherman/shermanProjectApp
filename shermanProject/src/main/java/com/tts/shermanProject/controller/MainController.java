package com.tts.shermanProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

		@GetMapping(value="/main")
		public String home() 
		{
			return "main";
		}
}
