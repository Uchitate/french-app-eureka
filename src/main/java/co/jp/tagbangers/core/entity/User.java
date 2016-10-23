package co.jp.tagbangers.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;

@Entity
@NamedEntityGraph
@Getter
@Setter
public class User extends AbstractEntity<Long> {

	public enum Gender {
		MAN, WOMAN,
	}

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 100, nullable = true)
	private String email;

	private Integer age;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	@Field(analyze = Analyze.NO)
	private Gender gender;
}
