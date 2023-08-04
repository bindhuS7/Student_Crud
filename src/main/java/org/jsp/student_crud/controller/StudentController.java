package org.jsp.student_crud.controller;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.jsp.student_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
//@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;
	
@PostMapping("/students")
public ResponseEntity<ResponseStructure<Student>> saveDetails(@RequestBody Student student){
	
	return service.saveDetails(student);
	
}
@GetMapping("/students")
public ResponseEntity<ResponseStructure<List<Student>>> fetchAll()
{
	
	return service.fetchAll();
}
	
@GetMapping("students/{id}")
public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable int id)
{
	return service.findById(id);
}

//@GetMapping("findbyid/{id}")
//public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable int id)
//{
//	return service.findById(id);
//}
@GetMapping("fetchbyname/{name}")
public ResponseEntity<ResponseStructure<List<Student>>> findByName( @PathVariable String  name)
{
	return service.findByName(name);
}
@GetMapping("fetch/{mobile}")
public ResponseEntity<ResponseStructure<Student>> findByMobile( @PathVariable Long mobile)
{
	return service.findByMobile(mobile);
}

@GetMapping("fetchbyresult/{result}")
public ResponseEntity<ResponseStructure<List<Student>>> findByResult( @PathVariable String  result)
{
	return service.findByResult(result);
}
@PostMapping("listofstudents")
public ResponseEntity<ResponseStructure<List<Student>>> saveList(@RequestBody List<Student> list)
{

	return service.saveList(list);
}

//@GetMapping("percentage/{percentage}")
//public ResponseEntity<ResponseStructure<List<Student>>> Percentage(@PathVariable double percentage)
//{
//
//	return service.findPercentage(percentage);
//}


@PutMapping("updating/{id}")
public ResponseEntity<ResponseStructure<Student>>update(@RequestBody Student student){
	
	return service.updateStudent(student);
}
@DeleteMapping("delete/{id}")
public ResponseEntity<ResponseStructure<Student>> delete(@PathVariable int id){

return service.deleteStudent(id);
}
}