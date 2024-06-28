package com.gestiondestock.backend.backendgestiondestock.controller;

import com.gestiondestock.backend.backendgestiondestock.entity.Article;
import com.gestiondestock.backend.backendgestiondestock.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
//@CrossOrigin(origins = "*")
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

    @DeleteMapping("articles/deleteArticle/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        try {
            articleService.deleteArticleById(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Article d'identifiant " + id + " supprimé avec succès !!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    //Rechercher les articles par leurs noms

    @GetMapping("search/articles")
    public ResponseEntity<List<Article>> searchArticles(@RequestParam String nom) {
        List<Article> articlesSearched = articleService.searchArticlesByName(nom);

        return ResponseEntity.ok(articlesSearched);
    }


}
