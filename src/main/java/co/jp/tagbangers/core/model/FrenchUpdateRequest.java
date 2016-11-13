package co.jp.tagbangers.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrenchUpdateRequest {

	private Long id;

	private String name;

	private String email;

	private String address;
}
