package com.simpleprogram;

import java.util.HashMap;
import java.util.Map;

public class User {
	private int id;
	private String name;
	private ProteinData proteinData = new ProteinData();
	private Map<String, UserHistory> userHistories = new HashMap<String, UserHistory>();

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

	public Map<String, UserHistory> getUserHistories() {
		return userHistories;
	}

	public void setUserHistories(Map<String, UserHistory> userHistories) {
		this.userHistories = userHistories;
	}
}
