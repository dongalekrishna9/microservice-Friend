package com.micro.friend.service;

import java.util.List;

import com.micro.friend.model.FriendDTO;

public interface IFriendService {

	String addFriend(FriendDTO friendDTO);
	
	List<Long> getAllFriendsNumbersByPhoneNumber(Long phoneNumber);

	String removeFriend(Long phoneNumber, Long friendNumber);
}
