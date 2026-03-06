package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContaining(String name, Pageable pageable);
}
