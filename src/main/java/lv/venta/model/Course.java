package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "CourseTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE) // negrib lai lomboks taisa setteri tiesi id
	@Column(name= "Cid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	@Column(name = "Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[A-Za-z0-9 ]{1,40}")
	private String title;
	
	@Column(name = "CP")
	@Min(1)
	@Max(30)
	private int cp;
	//=======
	
	@ManyToMany
	@JoinTable(name = "ProfCourseTable", joinColumns = @JoinColumn(name = "Pid"), inverseJoinColumns = @JoinColumn(name = "Cid"))
	@ToString.Exclude
	private Collection<Professor> professor = new ArrayList<>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<Grade>();
	
	
	public Course(String newTitle, int newCp, Professor newProfessor) {
		setTitle(newTitle);
		setCp(newCp);
		
	}
	
	public void addProfessor(Professor newProfessor) throws Exception{
		if(newProfessor == null) {
			throw new Exception("Nav pareizi ievades dati");
		}
		if(professor.contains(newProfessor)) {
			throw new Exception(newProfessor.getSurname() + " jau eksiste sads profesors saja kursa saraksta");
		}
		professor.add(newProfessor);
	}

	public void removeProfessor(Professor newProfessor) throws Exception{
		if(newProfessor == null) {
			throw new Exception("Nav pareizi ievades dati");
		}
		if(!professor.contains(newProfessor)) {
			throw new Exception(newProfessor.getSurname() + " neeksiste sads profesors saja kursa saraksta");
		}
		professor.remove(newProfessor);
	}
}
