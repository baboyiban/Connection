package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
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
	
	@GetMapping("/get")
	@ResponseBody
	public String get(String url) throws IOException {
		String response = connectService.get(url);
		return response;
	}
	
	@GetMapping("/post")
	@ResponseBody
	public String post(String url) throws IOException, ParseException {
		return connectService.post(url);
	}
	
	@GetMapping("/json")
	@ResponseBody
	public String json(String url) throws IOException, ParseException {
		return connectService.json(url);
	}
}
