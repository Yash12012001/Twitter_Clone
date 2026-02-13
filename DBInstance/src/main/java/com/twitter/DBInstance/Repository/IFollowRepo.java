package com.twitter.DBInstance.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.DBInstance.Entity.Follow;

@Repository
public interface IFollowRepo extends JpaRepository<Follow, Long>{

	Optional<Follow> findByFollowerAndFollowing(String followerId, String follwingId);
	
	

}
