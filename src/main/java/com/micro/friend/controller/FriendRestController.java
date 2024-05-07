package com.micro.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.friend.model.FriendDTO;
import com.micro.friend.service.IFriendService;

@RestController
public class FriendRestController {

	@Autowired
	IFriendService friendService;
	
	//Add friend 
	@PostMapping(value = "/addFriend", consumes = "application/json")
	public ResponseEntity<String> addFriendContact(@RequestBody FriendDTO friendDTO)
	{
		return new ResponseEntity<String>(this.friendService.addFriend(friendDTO),HttpStatus.OK);
	}
	
	//Get all friends numbers of given phone number
	@GetMapping(value = "/{phoneNumber}", produces = "application/json")
	public ResponseEntity<List<Long>> getFriendsNumbersByPhoneNumber(@PathVariable Long phoneNumber)
	{
		return new ResponseEntity<List<Long>>(this.friendService.getAllFriendsNumbersByPhoneNumber(phoneNumber),HttpStatus.OK);
	}
	
	//Remove friends contact details
	@DeleteMapping(value = "/deleteFriend/{phoneNumber}/{friendNumber}", consumes = "application/json")
	public ResponseEntity<String> deleteFriend(@PathVariable Long phoneNumber, @PathVariable Long friendNumber)
	{
		return new ResponseEntity<String>(this.friendService.removeFriend(phoneNumber, friendNumber),HttpStatus.OK);
	}
	
}
