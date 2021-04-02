package com.techm.todomanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techm.todomanagement.model.ToDoBean;
import com.techm.todomanagement.service.ToDoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todomanagement/api/todoController")
public class ToDoController {

	@Autowired
	private ToDoService todoService;
	
	public ToDoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value= {"/getTodos"})
	public ResponseEntity<Map<String, Object>> getTodos() {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.getAllToDo(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= {RequestMethod.GET}, value= {"/getTodoById/{_id}"})
	public ResponseEntity<Map<String, Object>> getTodoById(@PathVariable int _id) {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.getToDoById(_id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= {RequestMethod.POST}, value= {"/addTodo"})
	public ResponseEntity<Map<String, Object>> addTodo(@RequestBody ToDoBean input) {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.SaveToDo(input), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= {RequestMethod.PUT}, value= {"/updateTodo"})
	public ResponseEntity<Map<String, Object>> updateTodo(@RequestBody ToDoBean input) {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.UpdateToDo(input), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= {RequestMethod.DELETE}, value= {"/deleteTodo/{_id}"})
	public ResponseEntity<Map<String, Object>> deleteTodo(@PathVariable int _id) {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.deleteTodoById(_id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= {RequestMethod.DELETE}, value= {"/deleteAll"})
	public ResponseEntity<Map<String, Object>> deleteAll() {
		try {
			return new ResponseEntity<Map<String, Object>>(todoService.deleteAll(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
