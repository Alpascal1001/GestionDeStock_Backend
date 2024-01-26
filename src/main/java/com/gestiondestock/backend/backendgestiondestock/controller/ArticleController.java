package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/listArticle")
    public List<Article> getAllArticles() {
        return articleService.getAllArticle();
    }

    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @PutMapping("/updateArticle")
    public Article updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
