package com.microservices.springsecurityjpa.services;

import com.microservices.springsecurityjpa.entities.Post;
import com.microservices.springsecurityjpa.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);
        return posts;
    }

    public List<Post> getAllPosts(Integer userId){
        List<Post> posts = new ArrayList<>();
        postRepository.findPostsByUserUseId(userId)
                .forEach(posts::add);
        return posts;
    }

    public Optional<Post> getPost(Integer id){
        return postRepository.findById(id);
    }

}
