package com.twitter.DBInstance.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "TWITTER_USER",
uniqueConstraints = @UniqueConstraint(columnNames = {"username"})
		)
public class DataUser {
	
	@Id
	private String email;
	
	private String name;
	

	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "following")
	private Set<Follow> followers;
	
	@OneToMany(mappedBy = "follower")
	private Set<Follow> following;


}
