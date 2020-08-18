package com.example.demo.services;

import com.example.demo.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDoModel,Integer> {
    List<ToDoModel> findByUser(String user);
    //other methods are already defined in the todo service file
}
