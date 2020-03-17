package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.entities.Post;
import com.microservices.springsecurityjpa.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PostService postService;

    //only ROLE_ADMIN
    @RequestMapping("/posts")
    public List<Post> getAllPosts(){
        logger.info("Posts method accessed");
        return postService.getAllPosts();
    }

    @RequestMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable Integer id){
        logger.info("Post method accessed");
        return postService.getPost(id);
    }

    @RequestMapping("/user/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id){
        logger.info("Posts by user method accessed");
        return postService.getAllPosts(id);
    }
}
