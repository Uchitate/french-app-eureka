package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchUpdateRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class FrenchEditForm implements Serializable {

	@NotEmpty
	private String name;

	@Email
	private String email;

	private Integer age;

	@NotNull
	private French.Gender gender;

	public FrenchEditForm() {
	}

	public FrenchEditForm(French user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.age = user.getAge();
		this.gender = user.getGender();
	}

	public FrenchUpdateRequest toUserUpdateRequest() {
		FrenchUpdateRequest request = new FrenchUpdateRequest();
		request.setName(getName());
		request.setEmail(getEmail());
		request.setAge(getAge());
		request.setGender(getGender());
		return request;
	}
}
