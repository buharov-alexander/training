/***************       BEGIN-STANDARD-COPYRIGHT      ***************

 Copyright (c) 2009-2025, Spirent Communications.

 All rights reserved. Proprietary and confidential information of Spirent Communications.
 ***************        END-STANDARD-COPYRIGHT       ***************/
package ru.bukharov.training.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PropertyMultiValueEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name = "multiValueId",
			referencedColumnName = "multiValueId"
	)
	private PropertyEntity property;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
