package com.bit.devScore.repositories;

import com.bit.devScore.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository <Post, Long> {


}