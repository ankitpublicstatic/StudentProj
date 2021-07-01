package org.ankit.service;

import java.util.List;
import java.util.Optional;

import org.ankit.dto.StudentDTO;
import org.ankit.model.StudentVO;

public interface IStudentservice {
	public void saveStudent(StudentVO studentVo);

	public String registerStudent(StudentDTO dto);

	public String registerGroupStudents(List<StudentDTO> listDTO);

	public String removeStudentById(int cno);

	public String removeAllStudents();
	
	public long fetchStudentCount() 

	public Iterable<StudentDTO> fetchAllStudents();

	public Optional<StudentDTO> fetchStudentById(int id);

}
