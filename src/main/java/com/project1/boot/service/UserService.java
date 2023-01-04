package com.project1.boot.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.boot.entities.User;
import com.project1.boot.exceptions.EntityNotFound;
import com.project1.boot.repository.UserDao;


@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;

    public User findUserByUsername(String username){
        Optional<User> possibleUser = this.userDao.findByUsername(username);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        }else{
            throw new EntityNotFound("User not found");
        }
    }

    public String register(User user){
        this.userDao.createUser(user.getUsername(), user.getPassword());
        return "User registered";
    }

    public String deleteUserById(int id){
        this.userDao.deleteById(id);
        return "User with given id deleted";
    }
    
}
