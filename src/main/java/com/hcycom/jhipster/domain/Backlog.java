package com.hcycom.jhipster.domain;

public class Backlog {
	private int id;
	private String uuid;
	private String title;
	private int checkbox;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(int checkbox) {
		this.checkbox = checkbox;
	}
	@Override
	public String toString() {
		return "Backlog [id=" + id + ", uuid=" + uuid + ", title=" + title + ", checkbox=" + checkbox + "]";
	}
	
}
