package com.example.blog.infrastructure.dao;

import com.example.blog.domain.model.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberDao extends JpaRepository<Members, Long> {
    Optional<Members> findByEmail(String userEmail);
}
