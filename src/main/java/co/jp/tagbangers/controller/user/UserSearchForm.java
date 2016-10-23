package co.jp.tagbangers.controller.user;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.model.UserSearchRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserSearchForm implements Serializable {

	private String name;

//	private Integer ageStart;
//
//	private Integer ageEnd;
//
	private User.Gender gender;

	public UserSearchRequest toUserSearchRequest() {
		UserSearchRequest request = new UserSearchRequest();
		request.setName(getName());
//		request.setAgeStart(getAgeStart());
//		request.setAgeEnd(getAgeEnd());
		request.setGender(getGender());
		return request;
	}
}
