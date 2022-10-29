package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Student;

public interface StdRepository extends JpaRepository<Student, Integer> {

}
