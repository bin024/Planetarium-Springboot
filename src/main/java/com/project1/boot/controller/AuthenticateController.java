package com.project1.boot.controller;


import javax.servlet.http.HttpSession;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project1.boot.entities.User;
import com.project1.boot.exceptions.AuthenticationFailed;
import com.project1.boot.exceptions.EntityNotFound;
import com.project1.boot.service.UserService;

@RestController
public class AuthenticateController {
    
    // private static Logger userLogger = LoggerFactory.getLogger(AuthenticateController.class);


//     @ExceptionHandler(AuthenticationFailed.class)
//     public ResponseEntity<String> authenticationFailed(AuthenticationFailed e){
//         userLogger.error(e.getLocalizedMessage(), e);
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//     }
//    @ExceptionHandler(EntityNotFound.class)
//    public ResponseEntity<String> entityNotFound(EntityNotFound e){
//        userLogger.error(e.getLocalizedMessage(), e);
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(PSQLException.class)
//    public ResponseEntity<String> sqlIssue(PSQLException e){
//        userLogger.error(e.getLocalizedMessage(), e);
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }

   
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(HttpSession session){
        session.setAttribute("user", "some username");
        return "logged in successfully";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "logged out";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.register(user),HttpStatus.CREATED);
    }

}

