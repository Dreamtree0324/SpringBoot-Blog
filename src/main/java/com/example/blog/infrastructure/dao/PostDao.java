package com.example.blog.infrastructure.dao;

import com.example.blog.domain.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {
}
