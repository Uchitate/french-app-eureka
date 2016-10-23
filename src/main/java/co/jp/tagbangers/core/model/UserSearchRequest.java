package co.jp.tagbangers.core.model;

import co.jp.tagbangers.core.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserSearchRequest implements Serializable {

	private String name;

	private Integer ageStart;

	private Integer ageEnd;

	private User.Gender gender;
}
