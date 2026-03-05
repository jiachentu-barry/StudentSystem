package com.example.demo3.service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo3.entity.Student;
import com.example.demo3.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student old = repository.findById(id).orElseThrow();

        old.setName(student.getName());
        old.setAge(student.getAge());
        old.setEmail(student.getEmail());

        return repository.save(old);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

     @Override
    public Page<Student> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
