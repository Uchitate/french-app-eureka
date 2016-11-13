package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchSearchRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FrenchSearchForm implements Serializable {

	private String name;

//	private Integer ageStart;
//
//	private Integer ageEnd;
//
	private French.Gender gender;

	public FrenchSearchRequest toUserSearchRequest() {
		FrenchSearchRequest request = new FrenchSearchRequest();
		request.setName(getName());
//		request.setAgeStart(getAgeStart());
//		request.setAgeEnd(getAgeEnd());
		request.setGender(getGender());
		return request;
	}
}
