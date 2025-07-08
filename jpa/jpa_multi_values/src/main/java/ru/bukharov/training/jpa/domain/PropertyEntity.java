package ru.bukharov.training.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NaturalId;

@Entity
public class PropertyEntity implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	@NaturalId
	private String multiValueId;

	@OneToMany(mappedBy = "property",
			orphanRemoval = true,
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<PropertyMultiValueEntity> multiSelectValues;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<PropertyMultiValueEntity> getMultiSelectValues() {
		return multiSelectValues;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMultiSelectValues(List<PropertyMultiValueEntity> multiSelectValues) {
		this.multiSelectValues = multiSelectValues;
	}
}
