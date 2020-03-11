package com.example.blog.domain.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String nickname;

    @Builder
    public Members(Long id, String email, String password, String nickname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
