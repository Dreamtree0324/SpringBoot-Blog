package com.example.blog.presentation.controller;

import com.example.blog.domain.model.dto.MemberDto;
import com.example.blog.domain.model.entity.Members;
import com.example.blog.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UsersController {

    private MemberService memberService;

    @GetMapping("/signup")
    public String dispSignup(){
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDto member){
        memberService.joinUser(member);

        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String dispLogin(){
        return "user/login";
    }

    @GetMapping("/login/result")
    public String dispLoginResult(Model model){
        return "user/loginSuccess";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);

            return "redirect:/user/logout/result";
    }

    @GetMapping("/logout/result")
    public String dispLogoutResult(){
        return "user/logout";
    }

    @GetMapping("/denied")
    public String dispDenied(){
        return "user/denied";
    }

    @GetMapping("/info")
    public String dispMyInfo(){
        return "user/myinfo";
    }

    @GetMapping("/admin")
    public String dispAdmin(){
        return "user/admin";
    }
}
