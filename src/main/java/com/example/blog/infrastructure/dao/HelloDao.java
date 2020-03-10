package com.example.blog.infrastructure.dao;

import com.example.blog.domain.model.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloDao extends JpaRepository<Hello, Integer> {
}
