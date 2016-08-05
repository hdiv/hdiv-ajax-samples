package org.hdiv.samples.mvc.bean;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = -613203198610920319L;

	private int id;

	private String name;

	private String language;

	private boolean selected;

	public Country() {
		name = null;
		language = null;
		selected = false;
	}

	public Country(final int id, final String name, final String language) {
		this.name = name;
		this.id = id;
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

}
