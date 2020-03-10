package com.example.blog.domain.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Hello {
    @Id
    @GeneratedValue
    int id;

    String name;

    @Builder
    public Hello(String name){
        this.name = name;
    }
}
