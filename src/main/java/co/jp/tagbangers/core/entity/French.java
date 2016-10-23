package co.jp.tagbangers.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;

@Entity
@NamedEntityGraph
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class French extends AbstractEntity<Long> {

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private Integer zip;

	@Column(length = 100, nullable = true)
	private String line1;

	private String line2;

	private String line3;

	private String other;
}
