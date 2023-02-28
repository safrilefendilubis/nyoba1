package com.juaracoding.JavaWeb.repo;/*
IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author User a.k.a. Safril Efendi Lubis
Java Developer
Created on 2/27/2023 9:30 PM
@Last Modified 2/27/2023 9:30 PM
Version 1.1
*/
import com.juaracoding.JavaWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Long> {

    public List<User> findByEmail(String value);
    public List<User> findByEmailOrUsername(String emails, String username);
}
