package com.example.demo3.service;

import java.util.List;

import com.example.demo3.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
 Student addStudent(Student student);

    Student getStudent(Long id);

    List<Student> getAll();

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
    Page<Student> getPage(int page, int size, String sort, String direction);
    Page<Student> search(String name, int page, int size);
}
