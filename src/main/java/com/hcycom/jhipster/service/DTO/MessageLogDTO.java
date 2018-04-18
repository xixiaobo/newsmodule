package com.hcycom.jhipster.service.DTO;

public class MessageLogDTO {
	private String title;
	private String time;
	private String content;
	private String senderuuid;
	private String sender;
	private String addresseeuuid;
	private String  addressee;
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
	public String getSenderuuid() {
		return senderuuid;
	}
	public void setSenderuuid(String senderuuid) {
		this.senderuuid = senderuuid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAddresseeuuid() {
		return addresseeuuid;
	}
	public void setAddresseeuuid(String addresseeuuid) {
		this.addresseeuuid = addresseeuuid;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	@Override
	public String toString() {
		return "MessageLog [title=" + title + ", time=" + time + ", content=" + content + ", senderuuid=" + senderuuid
				+ ", sender=" + sender + ", addresseeuuid=" + addresseeuuid + ", addressee=" + addressee + "]";
	}
	
}
