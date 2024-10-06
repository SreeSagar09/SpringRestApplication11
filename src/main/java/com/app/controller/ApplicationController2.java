package com.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/app2")
public class ApplicationController2 {
	
	@RequestMapping(path = "/handlerMethod1/{pathVariable}/{matrixVariable}")
	public ResponseEntity<Map<String, Object>> handlerMethod1(@PathVariable String pathVariable, @MatrixVariable Map<String, Object> matrixVariable){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("pathVariable", pathVariable);
		map.put("matrixVariable", matrixVariable);
		ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod2/{variables1}")
	public ResponseEntity<Map<String, Object>> handlerMethod2(@MatrixVariable Map<String, Object> map1){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("variables1", map1);
		
		ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod2/{variables1}/{variables2}")
	public ResponseEntity<Map<String, Object>> handlerMethod3(@MatrixVariable(pathVar = "variables1") Map<String, Object> map1, @MatrixVariable(pathVar = "variables2") Map<String, Object> map2){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("variables1", map1);
		map.put("variables2", map2);
		
		ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return responseEntity;
	}

}
