package org.ankit.repository;
import org.ankit.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	
	}

 interface CustomerRepo extends  CrudRepository<Student,Integer> {
}