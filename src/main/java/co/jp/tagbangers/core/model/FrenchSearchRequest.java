package co.jp.tagbangers.core.model;

import co.jp.tagbangers.core.entity.French;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FrenchSearchRequest implements Serializable {

	private String name;

	private Integer ageStart;

	private Integer ageEnd;

	private French.Gender gender;
}
