package co.jp.tagbangers.controller.user;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.model.UserUpdateRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UserEditForm implements Serializable {

	@NotEmpty
	private String name;

	@Email
	private String email;

	private Integer age;

	@NotNull
	private User.Gender gender;

	public UserEditForm() {
	}

	public UserEditForm(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.age = user.getAge();
		this.gender = user.getGender();
	}

	public UserUpdateRequest toUserUpdateRequest() {
		UserUpdateRequest request = new UserUpdateRequest();
		request.setName(getName());
		request.setEmail(getEmail());
		request.setAge(getAge());
		request.setGender(getGender());
		return request;
	}
}
