package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//no sis klases neveidosies tabula datubaze (parasti ja netaisa objektu no siss klases vai avstractam modelu klasem)

@MappedSuperclass // nevajag lietot @Table un @Entity tikai @column pie mainigajiem
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {

	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Surname")
	private String surname;
	
	
	public Person(String newName, String newSurname) {
		setName(newName);
		setSurname(newSurname);
	}
}
