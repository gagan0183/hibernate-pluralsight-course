package com.simpleprogram;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	private int id;
	private String name;
	private ProteinData proteinData = new ProteinData();
	private Collection<UserHistory> userHistories = new ArrayList<UserHistory>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public Collection<UserHistory> getUserHistories() {
		return userHistories;
	}

	public void setUserHistories(Collection<UserHistory> userHistories) {
		this.userHistories = userHistories;
	}
}
