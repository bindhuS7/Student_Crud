package org.jsp.student_crud.dao;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.jsp.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> fetchAll() {
		
		return repository.findAll();
	}

	public Student findById(int id) {
		
		return repository.findById(id).orElse(null);
	}

	public List<Student> findByName(String name) {
		
		return repository.findByName(name);
	}

	public Student findBYMobile(Long mobile) {
		
		return repository.findByMobile(mobile);
	}

	public List<Student> findByResult(String result) {
		
		return repository.findByResult(result);
	}

	public List<Student> saveStudents(List<Student> student) {
		
		return repository.saveAll(student);
	}
	public void delete(Student student)
	{
		repository.delete(student);
	}

//	public List<Student> findByPercentage(double percentage) {
//		
//		return repository.findByPercentage(percentage);
//	}

//	public List<Student> findByPercentage(double percentage) {
//		
//		return repository.findByPercentage(percentage);
//	}

	
	
	
}
