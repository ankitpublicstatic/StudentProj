package org.ankit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ankit.domain.Student;
import org.ankit.dto.StudentDTO;
import org.ankit.model.StudentVO;
import org.ankit.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentservice {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void saveStudent(StudentVO studentVo) {

		Student student = new Student();
		BeanUtils.copyProperties(studentVo, student);
		studentRepo.saveAndFlush(student);
	}

	@Override
	public String removeAllStudents() {
		boolean flag = true;
		// use repo
		if (studentRepo.count() >= 1) {
			studentRepo.deleteAllInBatch();
			flag = true;
		} else {
			flag = false;
		}
		return flag ? "All Students are deleted" : " No Students found";
	}

	@Override
	public String registerStudent(StudentDTO dto) {
		System.out.println(studentRepo.getClass() + "---->" + Arrays.toString(studentRepo.getClass().getInterfaces()));
		Student student = null;
		// convert dto to entity
		student = new Student();
		BeanUtils.copyProperties(dto, student);
		// use repo
		student = studentRepo.save(student);
		return student != null ? "Object saved with id" + student.getId() : "Object not saved";

	}

	@Override
	public String registerGroupStudents(List<StudentDTO> listDTO) {
		List<Student> listEntities = new ArrayList();
		List<Student> listEntities1 = null;
		String ids = new String();
		// covert listDTO to list Entities
		listDTO.forEach(dto -> {
			Student entity = new Student();
			BeanUtils.copyProperties(dto, entity);
			listEntities.add(entity);
		});
		// use repo
		listEntities1 = (List<Student>) studentRepo.saveAll(listEntities);
		/*
		 * for(Student e:listEntities1) { ids=ids+","+e.getCno(); }
		 */
		ids = listEntities1.stream().map(e -> e.getId()).collect(Collectors.toList()).toString();

		return listEntities1 != null ? " Batch insertion is done with ids" + ids : " Batch insertion is not done ";
	}

	@Override
	public String removeStudentById(int cno) {
		boolean flag = false;
		// use repo
		flag = studentRepo.existsById(cno);
		if (flag)
			studentRepo.deleteById(cno);
		return flag ? cno + " Student is deleted" : "Student not exist";
	}

	
	@Override
	public long fetchStudentCount() {
		// use repo
		return (int) studentRepo.count();
	}

	@Override
	public Iterable<StudentDTO> fetchAllStudents() {
		Iterable<Student> itEntities = null;
		Iterable<StudentDTO> itDTO = new ArrayList();
		// use reop
		itEntities = studentRepo.findAll();
		// convert List Entities to listDTOs
		itEntities.forEach(entity -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<StudentDTO>) itDTO).add(dto);
		});

		return itDTO;
	}

	@Override
	public Optional<StudentDTO> fetchStudentById(int id) {
		Optional<Student> optEntity = null;
		Optional<StudentDTO> optDTO = null;

		// use repo
		optEntity = studentRepo.findById(id);
		// convert entity to DTO

		if (!optEntity.isEmpty()) {
			optDTO = Optional.of(new StudentDTO());
			BeanUtils.copyProperties(optEntity.get(), optDTO.get());
		} else {
			optDTO = optDTO.empty();
		}
		return optDTO;
	}

}
