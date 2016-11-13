package co.jp.tagbangers.core.model;

import co.jp.tagbangers.core.entity.French;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrenchUpdateRequest {

	private Long id;

	private String name;

	private String email;

	private Integer age;

	private French.Gender gender;
}
