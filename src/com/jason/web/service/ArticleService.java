package com.jason.web.service;

import java.util.List;

import com.jason.web.model.Article;


public interface ArticleService {

	public void addArticle(Article article);
	
	public void deleteArticle(Article article);

	public List<Article> listArticles();
	
	public Article getArticleByName(String name);
}