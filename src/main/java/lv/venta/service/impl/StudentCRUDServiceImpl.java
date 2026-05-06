package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;

@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Student> retriveAll() throws Exception {
		if (studRepo.count() == 0) {
			throw new Exception("Studentu tabula DB ir tuksa");
		}
		ArrayList<Student> allStudents = (ArrayList<Student>)studRepo.findAll();
		
		return allStudents;
	}

	@Override
	public Student retrieveByID(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if (!studRepo.existsById(id)) {
			throw new Exception("Tads id DB nav");
		}
		Student newStud = studRepo.findById(id).get();
		return newStud;
	}

	@Override
	public void deleteByID(long id) throws Exception {
		Student studForRemoveing = retrieveByID(id);
		
		
		ArrayList<Grade> gradesStud = gradeRepo.findByStudentSid(id);
		
		for(Grade tempG : gradesStud) {
			tempG.setStudent(null);
			gradeRepo.save(tempG);
			
		}
		
		studRepo.deleteById(id);
	}

	@Override
	public void create(String newName, String newSurname) throws Exception {
		if(newName == null || newSurname == null ||!newName.matches("[A-Z]{1}[a-z]{2,20}") || !newSurname.matches("[A-Z]{1}[a-z]{2,20}")) {
			throw new Exception("Nav atbilstoss vards vai uzvards");
		}
		Student newStud = new Student(newName, newSurname);
		studRepo.save(newStud);
		
	}

	@Override
	public void updateById(long id, String newName, String newSurname) throws Exception {
		Student stud = retrieveByID(id);
		if(newName == null || newSurname == null ||!newName.matches("[A-Z]{1}[a-z]{2,20}") || !newSurname.matches("[A-Z]{1}[a-z]{2,20}")) {
			throw new Exception("Nav atbilstoss vards vai uzvards");
		}
		stud.setName(newName);
		stud.setSurname(newSurname);
		studRepo.save(stud);
	}

}
