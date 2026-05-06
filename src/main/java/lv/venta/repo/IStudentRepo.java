package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{

	boolean existsByNameAndSurname(String newName, String newSurname);

	ArrayList<Student> findByGradesGrvalueLessThan(int i);
	
	
	
}
