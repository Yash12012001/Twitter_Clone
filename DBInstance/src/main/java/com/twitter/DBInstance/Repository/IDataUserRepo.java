package com.twitter.DBInstance.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.DBInstance.Entity.DataUser;

@Repository
public interface IDataUserRepo extends JpaRepository<DataUser, String>{

	Optional<DataUser> findByUsername(String email);

}
