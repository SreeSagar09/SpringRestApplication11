package com.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/app1")
public class ApplicationController1 {	
	
	@RequestMapping(path = "/handlerMethod1/{variable}")
	public ResponseEntity<String> handlerMethod1(@MatrixVariable String variable){
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<String>(variable, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod2/{variables}")
	public ResponseEntity<String[]> handlerMethod2(@MatrixVariable String variable1, @MatrixVariable String variable2){
		ResponseEntity<String[]> responseEntity = null;
		try {
			String[] variables = {variable1, variable2};
			responseEntity = new ResponseEntity<String[]>(variables, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod3/{variables}")
	public ResponseEntity<String[]> handlerMethod3(@MatrixVariable(name = "variable") String[] variables){
		ResponseEntity<String[]> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<String[]>(variables, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod4/{variables}")
	public ResponseEntity<Map<String, Object>> handlerMethod4(@MatrixVariable Map<String, Object> map){
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod5/{variables}")
	public ResponseEntity<MultiValueMap<String, Object>> handlerMethod5(@MatrixVariable MultiValueMap<String, Object> multiValueMap){
		ResponseEntity<MultiValueMap<String, Object>> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<MultiValueMap<String, Object>>(multiValueMap, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<MultiValueMap<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod6/{variables1}/{variables2}")
	public ResponseEntity<Map<String, Object>> handlerMethod6(@MatrixVariable(pathVar = "variables1") Map<String, Object> map1, @MatrixVariable(pathVar = "variables2") Map<String, Object> map2){
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put("variables1", map1);
			map.put("variables2", map2);
			
			responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = { "/handlerMethod7/{variable}", "/handlerMethod7" })
	public ResponseEntity<String> handlerMethod7(@MatrixVariable(defaultValue = "No Matrix Variable") String variable){
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<String>(variable, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = { "/handlerMethod8/{variable}", "/handlerMethod8" })
	public ResponseEntity<String> handlerMethod8(@MatrixVariable(required = false) String variable){
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<String>(variable, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
