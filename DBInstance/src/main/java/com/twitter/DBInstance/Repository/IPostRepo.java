package com.twitter.DBInstance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.DBInstance.Entity.Post;

public  interface IPostRepo extends  JpaRepository<Post,Long>{




}

