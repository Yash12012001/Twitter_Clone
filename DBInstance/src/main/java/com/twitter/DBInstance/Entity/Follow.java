package com.twitter.DBInstance.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(
		name="Follows",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"follower_id","following_id"})}
		)
@Data
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="follower_id",nullable=false)
	private DataUser follower;
	
	@ManyToOne
	@JoinColumn(name="following_id",nullable= false)
	private DataUser following;
	
	
	
	

}
