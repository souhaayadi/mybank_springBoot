package com.projet.web;


import com.projet.dao.UserRepository;
import com.projet.entites.Client;
import com.projet.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserRestService {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public HttpEntity<User> addUser(@RequestBody User user) {
        User result;
        result= userRepository.save(user);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/users/{login}&{password}")
    public HttpEntity<User> verifyCredentials(@PathVariable  String login, @PathVariable String password) {
        User result;
        result= userRepository.findByLoginAndPassword(login,password);
        if(result!=null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

    }
}
