package com.twitter.DBInstance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twitter.DBInstance.Entity.Post;
@Repository
public  interface IPostRepo extends  JpaRepository<Post,Long>{

    @Query("""
    SELECT p.content
    FROM Post p
    WHERE p.author.id = :authorId
    ORDER BY p.createdAt DESC""")
    List<String> findAllContentByAuthorId( @Param("authorId") String authorId );
    
    @Query("""
    		SELECT p 
    		FROM Post p
    		JOIN Follow f ON p.author.id=f.following.id
    		WHERE p.author.id= :userId
    		ORDER BY p.createdAt DESC""")
    List<Post> findFeedForUser(@Param("userId") String userId );


}

