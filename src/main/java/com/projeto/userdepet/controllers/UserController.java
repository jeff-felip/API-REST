package com.projeto.userdepet.controllers;

import com.projeto.userdepet.entities.Department;
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

    @Autowired//injeção de dependência
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    @GetMapping(value = "/page")
    public Page<User> findAll(Pageable pageable){
        Page<User> result = repository.findAll(pageable);
        return result;
    }

    @GetMapping(value = "/search-salary/page")
    public Page<User> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary,
                                   @RequestParam(defaultValue = "10000000000") Double maxSalary,
                                   Pageable pageable){
       Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
       return result;
    }

    @GetMapping(value = "/search-salary")
    public List<User> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary,
                                     @RequestParam(defaultValue = "10000000000") Double maxSalary){
        List<User> result = repository.findBySalaryBetween(minSalary, maxSalary);
        return result;
    }

    @GetMapping(value = "/search-name/page")
    public Page<User> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable){
        Page<User> result = repository.findByNameContainingIgnoreCase(name, pageable);
        return result;
    }

    @GetMapping(value = "/search-name")
    public List<User> searchByName(@RequestParam(defaultValue = "") String name){
        List<User> result = repository.findByNameContainingIgnoreCase(name);
        return result;
    }

    @GetMapping(value = "/search-email/page")
    public Page<User> searchByEmail(@RequestParam(defaultValue = "") String email, Pageable pageable){
        Page<User> result = repository.searchEmail(email, pageable);
        return result;
    }

    @GetMapping(value = "/search-email")
    public List<User> searchByEmail(@RequestParam(defaultValue = "") String email){
        List<User> result = repository.searchEmail(email);
        return result;
    }

    @GetMapping(value = "/search-department/page")
    public Page<User> searchByDepartment(@RequestParam(defaultValue = "") String name, Pageable pageable){
        Page<User> result = repository.searchDepartment(name, pageable);
        return result;
    }

    @GetMapping(value = "/search-department")
    public List<User> searchByDepartment(@RequestParam(defaultValue = "") String name){
        List<User> result = repository.searchDepartment(name);
        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }


}
