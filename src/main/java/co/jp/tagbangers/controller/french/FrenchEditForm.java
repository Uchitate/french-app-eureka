package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchUpdateRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Getter
@Setter
public class FrenchEditForm implements Serializable {

	@NotEmpty
	private String name;

	@Email
	private String email;

	private String address;

	public FrenchEditForm() {}

	public FrenchEditForm(French french) {
		this.name = french.getName();
		this.email = french.getEmail();
		this.address = french.getAddress();
	}

	public FrenchUpdateRequest toFrenchUpdateRequest() {
		FrenchUpdateRequest request = new FrenchUpdateRequest();
		request.setName(getName());
		request.setEmail(getEmail());
		request.setAddress(getAddress());
		return request;
	}
}
