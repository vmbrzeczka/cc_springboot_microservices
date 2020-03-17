package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.entities.Comment;
import com.microservices.springsecurityjpa.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CommentService commentService;

    //only ROLE_ADMIN
    @RequestMapping("/comments")
    public List<Comment> getAllComments(){
        logger.info("Comments method accessed");
        return commentService.getAllComments();
    }

    @RequestMapping("/comments/{id}")
    public Optional<Comment> getComment(@PathVariable Integer id){
        logger.info("Comment method accessed");
        return commentService.getComment(id);
    }

    @RequestMapping("/user/{id}/comments")
    public List<Comment> getCommentsByUserId(@PathVariable Integer id){
        logger.info("Comments by user method accessed");
        return commentService.getAllCommentsByUserId(id);
    }

    @RequestMapping("/posts/{id}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable Integer id){
        logger.info("Comments by post method accessed");
        return commentService.getAllCommentsByPostId(id);
    }
}
