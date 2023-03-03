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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.connect.ConnectService;

@Controller
@RequestMapping("/connect")
public class ConnectController {
	@Autowired
	private ConnectService connectService;
	
	@GetMapping("/get")
	@ResponseBody
	public String get(@RequestParam Map<String,String> param) throws IOException {
		String response = connectService.get(param.get("url"));
		return response;
	}
	
	@GetMapping("/post")
	@ResponseBody
	public String post(@RequestParam Map<String,String> param) throws IOException, ParseException {
		return connectService.post(param.get("url"),param);
	}
}
