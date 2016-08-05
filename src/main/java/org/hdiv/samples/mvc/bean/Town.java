package org.hdiv.samples.mvc.bean;

import java.io.Serializable;

public class Town implements Serializable {

	private static final long serialVersionUID = 6651987005377596584L;

	private String key;

	private String name;

	public Town(final String name, final String key) {
		this.name = name;
		this.key = key;
	}

	public Town() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
