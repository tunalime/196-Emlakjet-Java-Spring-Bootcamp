package com.emlakjet.crudapp.repository;

import com.emlakjet.crudapp.entity.Author;
import com.emlakjet.crudapp.entity.Category;
import com.emlakjet.crudapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthor(Author author);

    @Query(value = "select * from post p, post_categories pc where p.id = pc.post_id and pc.categories_id = ?1 ", nativeQuery = true)
    List<Post> findAllByCategory(Long categoryId);

    List<Post> getFirst3ByOrderByCreatedAtDesc();

    @Query(value = "select * from post order by created_at desc limit ?1", nativeQuery = true)
    List<Post> getLastPosts(Integer count);


}
