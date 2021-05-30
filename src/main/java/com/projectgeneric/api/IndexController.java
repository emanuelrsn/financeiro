/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santana
 */
@RestController
@RequestMapping("/")
public class IndexController {
    
    
   

    @GetMapping("/userInfo")
    public String get() {
        return "Get Spring Boot";
    }
    
    @PutMapping
    public String put() {
        return "Put Spring Boot";
    }
    
    @PostMapping
    public String post() {
        return "Post Spring Boot";
    }
    
    @DeleteMapping
    public String delete() {
        return "Delete Spring Boot";
    }

    
}
