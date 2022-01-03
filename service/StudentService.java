package com.great.learning.service;

import java.util.List;

import com.great.learning.entity.Student;



public interface StudentService {

	public List<Student> findAll();

	public void save(Student theStudent);

	public void deleteById(int theId);

	public Student findById(int theId);
}
