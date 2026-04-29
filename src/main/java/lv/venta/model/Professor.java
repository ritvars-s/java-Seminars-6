package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Professor {
	
	@Setter(value = AccessLevel.NONE) // negrib lai lomboks taisa setteri tiesi id
	@Column(name= "Pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	@Column(name = "Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	//mapped by ir ar mainigo jasasaista
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	//@JsonIgnore , tad ja izmanto citu orijsgakssustenu pimeram React Vue Angulat Utt.
	private Course course;
	
	
	
	public Professor(String newName, String newSurname, Degree newDegree) {
		setName(newName);
		setSurname(newSurname);
		setDegree(newDegree);
	}
}
