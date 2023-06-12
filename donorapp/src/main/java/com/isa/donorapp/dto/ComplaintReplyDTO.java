package com.isa.donorapp.dto;

public class ComplaintReplyDTO {
	private Integer id;
	private String reply;
	
	public ComplaintReplyDTO() {}
	
	public ComplaintReplyDTO(Integer id, String reply) {
		this.id = id;
		this.reply = reply;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
