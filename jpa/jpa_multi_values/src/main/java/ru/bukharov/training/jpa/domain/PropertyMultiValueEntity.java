/***************       BEGIN-STANDARD-COPYRIGHT      ***************

 Copyright (c) 2009-2025, Spirent Communications.

 All rights reserved. Proprietary and confidential information of Spirent Communications.
 ***************        END-STANDARD-COPYRIGHT       ***************/
package ru.bukharov.training.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropertyMultiValueEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
