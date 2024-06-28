package com.gestiondestock.backend.backendgestiondestock.controller;


import com.gestiondestock.backend.backendgestiondestock.dto.UserDto;
import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AdminUserFinancierController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/public/articles")
    public ResponseEntity<Object> getAllArticles() {
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @PostMapping("/admin/savearticle")
    public ResponseEntity<Object> saveArticle(@RequestBody UserDto article) {
        Article articleToSave = new Article();
        articleToSave.setNom(article.getNom());
        return ResponseEntity.ok(articleRepository.save(articleToSave));
    }

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone() {
        return ResponseEntity.ok("Users alone can access this Api Only");
    }

    @GetMapping("/adminuserfinancier/together")
    public ResponseEntity<Object> adminUserFinancierApi() {
        return ResponseEntity.ok("Admin, User and Financier only can access this Api Only");
    }
}
