package com.juaracoding.JavaWeb.repo;/*
IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author User a.k.a. Safril Efendi Lubis
Java Developer
Created on 2/27/2023 9:29 PM
@Last Modified 2/27/2023 9:29 PM
Version 1.1
*/
import com.juaracoding.JavaWeb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
