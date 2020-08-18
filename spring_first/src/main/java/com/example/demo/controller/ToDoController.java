package com.example.demo.controller;

import com.example.demo.model.ToDoModel;
import com.example.demo.services.LoginService;
import com.example.demo.services.ToDoService;
import com.example.demo.services.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @Autowired
    TodoRepository todoRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name= getLoggedInUserName();
       model.put("todos",todoRepository.findByUser(name));
        //model.put("todos",toDoService.retrieveTodos("subbu"));
        return "list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @RequestMapping(value = "/add-todos",method = RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        model.addAttribute("toDoModel", new ToDoModel(0, getLoggedInUserName(), "Default Desc",
                new Date(), false));
        return "todos";
    }
    @RequestMapping(value = "/add-todos",method = RequestMethod.POST)
    public String addTodo(ToDoModel toDoModel, ModelMap model){

        toDoModel.setUser(getLoggedInUserName());
        todoRepository.save(toDoModel);
       /* toDoService.addTodo(getLoggedInUserName(),toDoModel.getDesc(),toDoModel.getDate(),true);*/
        return "redirect:/list-todos";
    }
    @RequestMapping(value = "/delete-todos",method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        // toDoService.deleteTodo(id);
       return "redirect:/list-todos";
    }
    @RequestMapping(value = "/update-todos", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        ToDoModel toDoModel=todoRepository.findById(id).get();
        //ToDoModel toDoModel = toDoService.retrieveTodo(id);
        model.put("toDoModel", toDoModel);
        return "todos";
    }
    @RequestMapping(value = "/update-todos", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, ToDoModel toDoModel){

        toDoModel.setUser(getLoggedInUserName());

        todoRepository.save(toDoModel);
        //toDoService.updateTodo(toDoModel);

        return "redirect:/list-todos";
    }
}
