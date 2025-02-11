package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Post getPostById(int uid) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + uid;
        return restTemplate.getForObject(url, Post.class);
    }
}
