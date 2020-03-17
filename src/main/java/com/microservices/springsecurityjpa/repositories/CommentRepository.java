package com.microservices.springsecurityjpa.repositories;

import com.microservices.springsecurityjpa.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    public List<Comment> findByPostPosId(Integer postId);

    public List<Comment> findByUserUseId(Integer userId);
}
