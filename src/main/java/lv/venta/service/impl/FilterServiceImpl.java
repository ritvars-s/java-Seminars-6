package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService{
	
	@Autowired
	private IProfessorRepo profRepo;
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public ArrayList<Professor> filterProfessorBydegree(Degree degree) throws Exception {
		if(degree == null) {
			throw new Exception("degree nevar but tuksa");
		}
		
		ArrayList<Professor> result = profRepo.findByDegree(degree);
		if(result.isEmpty()) {
			throw new Exception("Nav profesori ar noteikto gradu");
		}
//		ArrayList<Professor> corDeg = new ArrayList<Professor>();
//		ArrayList<Professor> prof = (ArrayList<Professor>)profRepo.findAll();
//		for(Professor tempP : prof) {
//			if(tempP.getDegree() == degree) {
//				corDeg.add(tempP);
//			}
//		}
//		
		return result;
	}

	@Override
	public ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if(!profRepo.existsById(id)) {
			throw new Exception("Profesors ar sadu id neeksiste");
		}
		
		ArrayList<Course> result = courseRepo.findByProfessorsPid(id);
		
		if(result.isEmpty()) {
			throw new Exception("Tadam profesoram nav neviena kursa");
		}
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentNameSurname(String newName, String newSurname) throws Exception {
		
		if(newName == null || newName.isEmpty() || newSurname == null || newSurname.isEmpty()) {
			throw new Exception("Vards vai/un uzvards nav pareizi");
		}
		if(!studRepo.existsByNameAndSurname(newName, newSurname)) {
			throw new Exception("Students neeksisste");
		}
		ArrayList<Grade> result = gradeRepo.findByStudentNameAndStudentSurname(newName, newSurname);
		
		if(result.isEmpty()) {
			throw new Exception("Studentam nav neviena atzime");
		}
		return result;
	}

	@Override
	public float calclateAverageGradeByCourseTitle(String newTitle) throws Exception {
		if(newTitle == null || newTitle.isEmpty()) {
			throw new Exception("Kursa nosaukums nevar but tukss vai null");
		}
		if(!courseRepo.existsByTitle(newTitle)) {
			throw new Exception("Sads kurss neeksiste");
		}
		float avgGr = gradeRepo.calculateAVGGradeForCourse(newTitle);
		
		return avgGr;
	}

	@Override
	public ArrayList<Student> filterStudentByFailingGrade() throws Exception {
		ArrayList<Student> failingStud = studRepo.findByGradesGrvalueLessThan(4);
		if(failingStud.isEmpty()) {
			throw new Exception("Nav neviena studenta ar nesekmigu atzimi");
		}
		
		return failingStud;
	}

}
