package com.micro.friend.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.friend.entity.Friend;
import com.micro.friend.model.FriendDTO;
import com.micro.friend.repository.FriendRepository;
import com.micro.friend.service.IFriendService;
@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	FriendRepository friendRepo;
	
	@Override
	public String addFriend(FriendDTO friendDTO) {
		Friend friend=new Friend();
		BeanUtils.copyProperties(friendDTO, friend);
		
		Friend f = this.friendRepo.findByPhoneNumberAndFriendNumber(friend.getPhoneNumber(), friend.getFriendNumber());
		
		if(f!=null)
		{
			return "Friend contact is already exist..!";
		}
		else
		{
			this.friendRepo.saveAndFlush(friend);
			return "Friend contact is added to database";
		}	
			
		
	}

	@Override
	public List<Long> getAllFriendsNumbersByPhoneNumber(Long phoneNumber) {
		
		return this.friendRepo.getFriendsNumbersByPhoneNumber(phoneNumber);
	}

	@Override
	public String removeFriend(Long phoneNumber, Long friendNumber) {
		
		Friend friend = this.friendRepo.findByPhoneNumberAndFriendNumber(phoneNumber, friendNumber);
		if(friend!=null)
		{
			this.friendRepo.delete(friend);
			return "Friend is deleted from the Database";
		}
		else
		{
			return "Friend didn't Exist..! Please try again.";
		}
		
	}

}
