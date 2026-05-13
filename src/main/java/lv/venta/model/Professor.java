package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;

@Table(name = "ProfessorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person{
	
	@Setter(value = AccessLevel.NONE) // negrib lai lomboks taisa setteri tiesi id
	@Column(name= "Pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	

	@Column(name = "Degree")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	//mapped by ir ar mainigo jasasaista
	@ManyToMany
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();
	
	
	
	public Professor(String newName, String newSurname, Degree newDegree) {
		super(newName, newSurname);
		setDegree(newDegree);
	}
	
	public void addCourse(Course newCourse)throws Exception {
		if(newCourse == null) {
			throw new Exception("Nav pareizi ievades dati");
		}
		if(courses.contains(newCourse)) {
			throw new Exception(newCourse.getTitle() + " jau eksiste profesora panigtaja kursu saraksta");
		}
		courses.add(newCourse);
	}
	
	public void removeCourse(Course newCourse)throws Exception {
		if(newCourse == null) {
			throw new Exception("Nav pareizi ievades dati");
		}
		if(!courses.contains(newCourse)) {
			throw new Exception(newCourse.getTitle() + "  neeeksiste profesora panigtaja kursu saraksta");
		}
		courses.remove(newCourse);
	}
	
	
}
