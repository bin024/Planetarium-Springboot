package com.project1.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project1.boot.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(String name);

    @Modifying
    @Transactional
    @Query(value = "insert into users values(default, :username, :password)", nativeQuery = true)
    int createUser(@Param("username")String username, @Param("password")String password);

    // @Modifying
    // @Transactional
    // @Query(value = "update users set username = :username, password = :password where id = id", nativeQuery = true)
    // int updateUser(@Param("username")String username, @Param("password")String password, @Param("id")int id);
}
