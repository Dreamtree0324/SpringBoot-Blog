package com.example.blog.presentation.controller;

import com.example.blog.domain.model.entity.Post;
import com.example.blog.infrastructure.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @GetMapping("/write")
    public String form(Post post){
        return "form";
    }

    @PostMapping("/write")
    public String write(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        post.setRegDate(LocalDateTime.now());
        return "redirect:/post/" + postDao.save(post).getId();
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Post> postList = postDao.findAll();
        model.addAttribute("postList", postList);
        return "blog";
    }

    @RequestMapping("/{id}")
    public String view(Model model, @PathVariable int id){
        Post post = postDao.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        postDao.deleteById(id);
        return "redirect:/post/list";
    }

    @GetMapping("/{id}/edit")
    public String editor(Model model, @PathVariable int id) {
        Post post = postDao.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "form";
    }

    @PostMapping("/{id}/edit")
    public String edit(@Valid Post post, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/post/" + postDao.save(post).getId();
    }
}
