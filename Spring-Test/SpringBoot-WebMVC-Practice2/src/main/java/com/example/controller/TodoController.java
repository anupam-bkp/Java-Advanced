package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Todo;
import com.example.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @ModelAttribute("todos")
    public List<Todo> getTodos(@ModelAttribute("name") String name){
    	return service.retrieveTodos(name);
    }
    
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(/*ModelMap model*/){

//        String name = (String) model.get("name");
//        System.out.println("From TODO : " + name);
//        model.put("todos", service.retrieveTodos(name));

        return "list-todos";
    }

}