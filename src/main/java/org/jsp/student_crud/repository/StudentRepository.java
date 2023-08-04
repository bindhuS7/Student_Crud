package org.jsp.student_crud.repository;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);

	Student findByMobile(Long mobile);

	List<Student> findByResult(String result);

//	List<Student> findByPercentage(double percentage);

	
	

}
