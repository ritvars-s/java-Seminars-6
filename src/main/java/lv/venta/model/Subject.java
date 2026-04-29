package lv.venta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "SubjectTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject {
	private long suid;
	private String subjectName;
	private int cp;
	//=======
}
