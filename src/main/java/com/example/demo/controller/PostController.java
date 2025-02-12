package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(value = "myposts", produces = "application/json")
    public Post getPost() {
        System.out.println("Request received for post");
        return postService.getPostById(1);
    }

    @GetMapping(value = "myposts/{uid}", produces = "application/json")
    public Post getPost(@PathVariable int uid) {
        System.out.println("Request received for post with id: " + uid);
        return postService.getPostById(uid);
    }
}