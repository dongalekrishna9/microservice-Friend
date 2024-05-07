package com.micro.friend.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.micro.friend.model.FriendDTO;
import com.micro.friend.repository.FriendRepository;
import com.micro.friend.service.IFriendService;
//@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	IFriendService service;
	
	@Autowired
	FriendRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Long> friendNoList = this.repo.getFriendsNumbersByPhoneNumber(9975267699L);
		
		friendNoList.forEach(f->{
			System.out.println(f);
		});
	}

}
