package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.connect.ConnectService;

@Controller
@RequestMapping("/connect")
public class ConnectController {
	@Autowired
	private ConnectService svc;
	
	@GetMapping("/json")
	@ResponseBody
	public Map<String,Object> json() throws IOException {
		Map<String,Object> map = new HashMap<>();
		String response = svc.get("http://localhost:7878/json");
		map.put("result", response);
		return map;
	}
}
