package com.coderslab.repository;

import com.coderslab.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Collection<Tweet> findByUserId(long id);

}