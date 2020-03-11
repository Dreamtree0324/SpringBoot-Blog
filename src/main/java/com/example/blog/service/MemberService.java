package com.example.blog.service;

import com.example.blog.domain.Role;
import com.example.blog.domain.model.dto.MemberDto;
import com.example.blog.domain.model.entity.Members;
import com.example.blog.infrastructure.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private MemberDao memberDao;

    @Transactional
    public Long joinUser(MemberDto memberDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberDao.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Members> userEntityWrapper = memberDao.findByEmail(userEmail);
        Members userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("tiqmffk123@gmail.com").equals(userEmail)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else{
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
}
