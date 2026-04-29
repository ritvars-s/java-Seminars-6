package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GradeTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	@Setter(value = AccessLevel.NONE) // negrib lai lomboks taisa setteri tiesi id
	@Column(name= "Gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gid;
	
	
	@Column(name = "GrValue")
	@Min(0)
	@Max(10)
	private int grvalue;
	//sasaiste ar kursu
	@OneToOne
	@JoinColumn(name = "Pid")
	private Course course;
	
	//sasaiste ar studntu
	@ManyToOne
	@JoinColumn(name = "Sid")
	private Student student;
	
	
	public Grade(int newGrValue, Course newCourse, Student newStudent) {
		setGrvalue(newGrValue);
		setCourse(newCourse);
		setStudent(newStudent);
	}
	
	
	
	
	
}
