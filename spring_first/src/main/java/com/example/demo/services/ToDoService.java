package com.example.demo.services;

import com.example.demo.controller.ToDoController;
import com.example.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
@Service
public class ToDoService {
    private static List<ToDoModel> todos=new ArrayList<ToDoModel>();
    private static int toDoCount=3;
    static {
      todos.add(new ToDoModel(1,"subbu","apple",new Date(),false));
        todos.add(new ToDoModel(2,"subbu","ball",new Date(),true));
        todos.add(new ToDoModel(3,"subbu","cat",new Date(),false));
    }
    public List<ToDoModel> retrieveTodos(String user) {
        List<ToDoModel> filteredTodos = new ArrayList<ToDoModel>();
        for (ToDoModel todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date date,
                        boolean isDone) {
        todos.add(new ToDoModel(++toDoCount, name, desc, date, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<ToDoModel> iterator = todos.iterator();
        while (iterator.hasNext()) {
            ToDoModel todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public ToDoModel retrieveTodo(int id) {
        for (ToDoModel todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(ToDoModel todo){
        todos.remove(todo);
        todos.add(todo);
    }
}
