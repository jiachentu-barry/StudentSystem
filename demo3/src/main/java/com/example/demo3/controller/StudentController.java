package com.example.demo3.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.entity.Student;
import com.example.demo3.service.StudentService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @GetMapping
    public List<Student> list() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping("/page")
public Page<Student> getPage(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam(defaultValue = "id") String sort,
        @RequestParam(defaultValue = "asc") String direction) {

    return service.getPage(page, size, sort, direction);
}

@GetMapping("/search")
public Page<Student> search(
        @RequestParam String name,
        @RequestParam int page,
        @RequestParam int size) {

    return service.search(name, page, size);
}
}