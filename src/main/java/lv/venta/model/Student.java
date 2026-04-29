package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "StudentTable") //tabula un tas nosaukums
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person{
	
	@Setter(value = AccessLevel.NONE) // negrib lai lomboks taisa setteri tiesi id
	@Column(name= "Sid")
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	
	//savienots ar grade klasi
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades = new ArrayList<Grade>();
	
	
	
	public Student(String newName, String newSurname) {
		super(newName, newSurname);
	}
	
	
}
