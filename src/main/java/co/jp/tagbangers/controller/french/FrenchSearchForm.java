package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.model.FrenchSearchRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FrenchSearchForm implements Serializable {

	private String name;

	public FrenchSearchRequest toFrenchSearchRequest() {
		FrenchSearchRequest request = new FrenchSearchRequest();
		request.setName(getName());
		return request;
	}
}
