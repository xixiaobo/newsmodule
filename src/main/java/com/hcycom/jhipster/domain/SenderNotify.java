package com.hcycom.jhipster.domain;

public class SenderNotify {
	private int id;
	private String uuid;
	private String title;
	private String time;
	private String content;
	private String  addressee;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	@Override
	public String toString() {
		return "SenderNotify [id=" + id + ", uuid=" + uuid + ", title=" + title + ", time=" + time + ", content="
				+ content + ", addressee=" + addressee + "]";
	}
	
}
