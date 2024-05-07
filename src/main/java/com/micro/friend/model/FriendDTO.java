package com.micro.friend.model;

import java.io.Serializable;

public class FriendDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Long phoneNumber;
	private Long friendNumber;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getFriendNumber() {
		return friendNumber;
	}
	public void setFriendNumber(Long friendNumber) {
		this.friendNumber = friendNumber;
	}
	
	
}
