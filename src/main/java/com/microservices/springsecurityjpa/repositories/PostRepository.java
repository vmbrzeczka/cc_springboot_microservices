package com.microservices.springsecurityjpa.repositories;

import com.microservices.springsecurityjpa.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    public List<Post> findPostsByUserUseId(Integer userId);
}
