package com.emlakjet.crudapp.controller;

import com.emlakjet.crudapp.dto.PostFilter;
import com.emlakjet.crudapp.entity.Post;
import com.emlakjet.crudapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity("Not Found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        if (postService.createPost(post)) {
            return new ResponseEntity("Created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Not Created", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long id) {
        if (postService.updatePost(post, id)) {
            return new ResponseEntity("Updated", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Not Updated", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/author")
    public ResponseEntity<List<Post>> findByAuthor(@RequestBody PostFilter postFilter) {
        return new ResponseEntity(postService.getByAuthor(postFilter), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Post>> findByCategory(@RequestBody PostFilter postFilter) {
        return new ResponseEntity(postService.getByCategory(postFilter), HttpStatus.OK);
    }

    @GetMapping("/last3")
    public ResponseEntity<List<Post>> getLast3Posts() {
        return new ResponseEntity(postService.getTop3ByOrderByCreatedAt(), HttpStatus.OK);
    }


    @GetMapping("/last/{count}")
    public ResponseEntity<List<Post>> getLastPosts(@PathVariable Integer count) {
        return new ResponseEntity(postService.getLastPosts(count), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        if (postService.deletePost(id)) {
            return new ResponseEntity("Post Deleted", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("ID not found", HttpStatus.BAD_REQUEST);
    }

}
