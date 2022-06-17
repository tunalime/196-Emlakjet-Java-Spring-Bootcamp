package com.emlakjet.crudapp.service;

import com.emlakjet.crudapp.dto.PostFilter;
import com.emlakjet.crudapp.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAll();

    Post getPostById(Long Id);

    boolean createPost(Post post);

    boolean updatePost(Post post, Long id);

    boolean deletePost(Long id);

    List<Post> getByAuthor(PostFilter postFilter);

    List<Post> getByCategory(PostFilter postFilter);

    List<Post> getTop3ByOrderByCreatedAt();

    List<Post> getLastPosts(Integer count);

}
