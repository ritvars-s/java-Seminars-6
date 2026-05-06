package lv.venta.service.impl;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;

public interface IFilterService {
	
	//visi profesori kura grads ir ....
	public abstract ArrayList<Professor> filterProfessorBydegree(Degree degree) throws Exception;
	
	
	//igeut kursus kurus pasniedz profesors ar konkreto id
	public abstract ArrayList<Course> filterCoursesByProfessorId(long id) throws Exception;
	
	//iegut visas atzimes ja ir zinams studenta vards un uzvards
	public abstract ArrayList<Grade> filterGradesByStudentNameSurname(String newName, String newSurname) throws Exception;
	
	//iegut videjo atzimju vertibu ja ir zinams kursa nosaukums
	public abstract double calclateAverageGradeByCourseTitle(String newTitle) throws Exception;
	
	
	//iegut visus studentus kuriem ir kada nesekmiga atzime
	
	public abstract ArrayList<Student> filterStudentByFailingGrade() throws Exception;
	
	
	
}