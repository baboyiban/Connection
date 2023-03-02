package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.connect.ConnectService;

@Controller
@RequestMapping("/connect")
public class ConnectController {
	@Autowired
	private ConnectService connectService;
	
	@GetMapping("/json")
	@ResponseBody
	public String json() throws IOException {
		String response = connectService.get("http://localhost:7878/json");
		return response;
	}
	
	@GetMapping("/predict/{num}")
	@ResponseBody
	public String predict(@PathVariable(name="num") Integer num) throws IOException {
		String response = connectService.get("http://localhost:7878/predict/"+num);
		return response;
	}
}
