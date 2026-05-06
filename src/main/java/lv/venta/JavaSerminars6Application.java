package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class JavaSerminars6Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSerminars6Application.class, args);
	}
	@Bean
	public CommandLineRunner testRepo(IStudentRepo studRepo, IProfessorRepo profRepo, ICourseRepo courRepo, IGradeRepo grRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student stud1 = new Student("Juris", "Aborggens");
				Student stud2 = new Student("Jariks", "Bobs");
				studRepo.saveAll(Arrays.asList(stud1,stud2));
				
				Professor prof1 = new Professor("Vairis", "Cauna", Degree.phd);
				Professor prof2 = new Professor("Galina", "Hilkevica", Degree.phd);
				profRepo.saveAll(Arrays.asList(prof1,prof2));
				
				Course cour1 = new Course("Algoritmu teorija", 16, prof1);
				Course cour2 = new Course("Matematiska analize", 18, prof2);
				courRepo.saveAll(Arrays.asList(cour1,cour2));
				
				Grade gr1 = new Grade(6, cour1, stud1);
				Grade gr2 = new Grade(9, cour2, stud1);
				Grade gr3 = new Grade(4, cour1, stud2);
				Grade gr4 = new Grade(5, cour2, stud2);
				grRepo.saveAll(Arrays.asList(gr1, gr2, gr3, gr4));
			}
		};
	}

}
