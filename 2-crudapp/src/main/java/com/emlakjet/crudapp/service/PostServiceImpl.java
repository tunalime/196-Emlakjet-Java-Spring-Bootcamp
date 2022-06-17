package com.emlakjet.crudapp.service;

import com.emlakjet.crudapp.dto.PostFilter;
import com.emlakjet.crudapp.entity.Author;
import com.emlakjet.crudapp.entity.Category;
import com.emlakjet.crudapp.entity.Post;
import com.emlakjet.crudapp.repository.AuthorRepository;
import com.emlakjet.crudapp.repository.CategoryRepository;
import com.emlakjet.crudapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        if (!postRepository.existsById(id)) {
            return null;
        }
        return postRepository.findById(id).get();
    }

    @Override
    public boolean createPost(Post post) {
        try {
            Author author = authorRepository.getByFirstNameAndAndLastNameAndTckNo(post.getAuthor().getFirstName(), post.getAuthor().getLastName(), post.getAuthor().getTckNo());
            if (author != null) {
                post.setAuthor(author);
            }
            Set<Category> categories = new HashSet<>();
            for (Category category : post.getCategories()
            ) {
                Category category1 = categoryRepository.getByName(category.getName());
                if (category1 == null) {
                    category1 = categoryRepository.save(category);
                }
                categories.add(category1);
            }
            post.setCategories(categories);
            post.setCreatedAt(new Date());
            postRepository.save(post);
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

    @Override
    public boolean updatePost(Post post, Long id) {
        try {
            if (postRepository.existsById(id)) {
                Post oldPost = postRepository.findById(id).get();
                oldPost.setUpdatedAt(new Date());
                oldPost.setCategories(post.getCategories());
                oldPost.setText(post.getText());
                oldPost.setTitle(post.getTitle());
                createPost(oldPost);
                return true;
            }
            return false;
        } catch (Exception exception) {
            return false;
        }

    }

    @Override
    public List<Post> getByAuthor(PostFilter postFilter) {
        Author author = authorRepository.getByFirstNameAndAndLastNameAndTckNo(postFilter.getAuthor().getFirstName(), postFilter.getAuthor().getLastName(), postFilter.getAuthor().getTckNo());
        return postRepository.findAllByAuthor(author);
    }

    @Override
    public List<Post> getByCategory(PostFilter postFilter) {
        Category category = categoryRepository.getByName(postFilter.getCategory().getName());
        return postRepository.findAllByCategory(category.getId());
    }

    @Override
    public List<Post> getTop3ByOrderByCreatedAt() {
        return postRepository.getFirst3ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Post> getLastPosts(Integer count) {
        return postRepository.getLastPosts(count);
    }

    @Override
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
