package com.projeto.userdepet.controllers;

import com.projeto.userdepet.entities.User;
import com.projeto.userdepet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){//buscar todos os usuários
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    @GetMapping(value = "/page")
    public Page<User> findAll(Pageable pageable){//buscar todos os usuários
        Page<User> result = repository.findAll(pageable);
        return result;
    }

    @GetMapping(value = "/search-salary")
    public Page<User> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary,
                                   @RequestParam(defaultValue = "10000000000") Double maxSalary,
                                   Pageable pageable){
       Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
       return result;
    }

    @GetMapping(value = "/search-name")
    public Page<User> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable){
        Page<User> result = repository.findByNameContainingIgnoreCase(name, pageable);
        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }


}
