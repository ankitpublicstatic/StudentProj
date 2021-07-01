package org.ankit.controller;

import java.util.List;
import java.util.Optional;

import org.ankit.dto.StudentDTO;
import org.ankit.model.StudentVO;
import org.ankit.service.IStudentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/")
public class StudentController {
	 
	@Autowired
	private IStudentservice studentService;
	
	
	@PostMapping("/student/save")
	public ResponseEntity<String> saveStudent(@RequestBody StudentVO studentVo) {
		studentService.saveStudent(studentVo);
		return new ResponseEntity<String>("Record Inserted", HttpStatus.OK);
	}
	
	@ApiOperation("save student")
	@PostMapping("/student/register")
	public ResponseEntity<String> registerStud(@RequestBody StudentDTO studentDTO) {
		studentService.registerStudent(studentDTO);
		return new ResponseEntity<String>("Record Inserted", HttpStatus.OK);
	}

	
	@ApiOperation("save group of  student")
	@PostMapping("/student/groupofregister")
	public ResponseEntity<String> registerGroupOfStudents(@RequestBody List<StudentDTO> listDTO)  {
		studentService.registerGroupStudents(listDTO);
		return new ResponseEntity<String>("Record Inserted All", HttpStatus.OK);
	}
	@ApiOperation("delete student")
	@DeleteMapping("/student/remove")
	public ResponseEntity<String> removeStudentById(@RequestParam int no) {
		studentService.removeStudentById(no);
		return new ResponseEntity<String>("Record Deleted Given Student no"+no, HttpStatus.OK);
	}
	
	@ApiOperation("delete all student")
	@DeleteMapping("/student/removeall")
	public ResponseEntity<String> removeAllStudent() {
		studentService.removeAllStudents();
		return new ResponseEntity<String>("All Record Deleted ", HttpStatus.OK);
	}
	
}