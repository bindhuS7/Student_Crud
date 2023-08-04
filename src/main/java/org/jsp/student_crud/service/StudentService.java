package org.jsp.student_crud.service;

import java.util.List;

import org.jsp.student_crud.dao.StudentDao;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {
	
	@Autowired
	StudentDao dao;

	public ResponseEntity<ResponseStructure<Student>> saveDetails(Student student) {
		double percentage=(student.getMathematic()+student.getEnglish()+student.getScience())/3.0;
		student.setPercentage(percentage);
		if(student.getEnglish()<35 || student.getMathematic()<35 ||student.getScience()<35) {
			
			student.setResult("fail");
		}
		else {
			if(percentage<60)
			{
				student.setResult("second class");
			}
			else if(percentage<85)
			{
				student.setResult("first class");
			}
		else {
				student.setResult("Distinction");
			}
		}
		ResponseStructure<Student> structure=new  ResponseStructure<>();
		structure.setMessage("data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));
		
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {
		List<Student> list=dao.fetchAll();
		if(list.isEmpty()) {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is empty");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}else {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is fetched  successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
	
		
	}

	public ResponseEntity<ResponseStructure<Student>> findById(int id) {
		Student student=dao.findById(id);
		if(student ==null) {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			structure.setMessage("data is not available");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			
			
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
			
		}else {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
		}
		
		
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByName(String name) {
		
		List<Student> student=dao.findByName(name);
		if(student.isEmpty()) {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is empty");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}else {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is fetched  successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
		
	}

	public ResponseEntity<ResponseStructure<Student>> findByMobile(Long mobile) {
		Student student=dao.findBYMobile(mobile);
		if(student==null) {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			structure.setMessage("data is not available");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);	
		}else {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);	
	    }
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByResult(String result) {
		List<Student> student=dao.findByResult(result);
		if(student.isEmpty()) {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is empty");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}else {
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data is fetched  successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		
	}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> saveList(List<Student> list) {
		
		for(Student student:list) {
			
			double percentage=(student.getMathematic()+student.getEnglish()+student.getScience())/3.0;
			student.setPercentage(percentage);
			if(student.getEnglish()<35 || student.getMathematic()<35 ||student.getScience()<35) {
				
				student.setResult("fail");
			}
			else {
				if(percentage<60)
				{
					student.setResult("second class");
				}
				else if(percentage<85)
				{
					student.setResult("first class");
				}
			else {
					student.setResult("Distinction");
				}
			
		}
		}
			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
			structure.setMessage("data saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveStudents(list));
	
			
	
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.CREATED);
}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		
		double percentage=(student.getMathematic()+student.getEnglish()+student.getScience())/3.0;
		student.setPercentage(percentage);
		if(student.getEnglish()<35 || student.getMathematic()<35 ||student.getScience()<35) {
			
			student.setResult("fail");
		}
		else {
			if(percentage<60)
			{
				student.setResult("second class");
			}
			else if(percentage<85)
			{
				student.setResult("first class");
			}
		else {
				student.setResult("Distinction");
			}
		}
		ResponseStructure<Student> structure=new  ResponseStructure<>();
		structure.setMessage("data updated successfully");
		structure.setStatus(HttpStatus.ACCEPTED.value());
		structure.setData(dao.saveStudent(student));
		
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		
		
		
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		
		Student student=dao.findById(id);
		if(student ==null) {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			structure.setMessage("data is not available");
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setData(student);
			
			
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
			
		}else {
			ResponseStructure<Student> structure=new  ResponseStructure<>();
			dao.delete(student);
			structure.setMessage("data Deleted successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			structure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
		}
		
		
	}

//	public ResponseEntity<ResponseStructure<List<Student>>> findPercentage(double percentage) {
//
//		List<Student> student=dao.findByPercentage(percentage);
//		if(student.isEmpty()) {
//			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
//			structure.setMessage("data is empty");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			
//			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
//		}else {
//			ResponseStructure<List<Student>> structure=new  ResponseStructure<>();
//			structure.setMessage("data is fetched  successfully");
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setData(student);
//			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
//		}
//}

	


}