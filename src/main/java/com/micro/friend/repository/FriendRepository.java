package com.micro.friend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.micro.friend.entity.Friend;
@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

	Friend findByPhoneNumberAndFriendNumber(Long phoneNumber, Long friendNumber);
	
	@Query("select f.friendNumber from Friend f where f.phoneNumber=:phoneNumber")
	List<Long> getFriendsNumbersByPhoneNumber(Long phoneNumber);
}
