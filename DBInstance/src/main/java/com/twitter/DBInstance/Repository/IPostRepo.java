package com.twitter.DBInstance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public  interface IPostRepo extends  JpaRepository<Post,Long>{

    @Query("""
    SELECT p.content
    FROM Post p
    WHERE p.author.id = :authorId
    ORDER BY p.createdAt DESC""")
    List<String> findAllContentByAuthorId( @Param("authorId") Long authorI );


}

