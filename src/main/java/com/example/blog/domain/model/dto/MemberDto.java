package com.example.blog.domain.model.dto;

import com.example.blog.domain.model.entity.Members;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Members toEntity(){
        return Members.builder()
                .id(id)
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String nickname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
