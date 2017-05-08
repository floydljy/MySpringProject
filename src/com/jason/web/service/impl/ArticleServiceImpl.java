package com.jason.web.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jason.web.dao.ArticleDao;
import com.jason.web.model.Article;
import com.jason.web.service.ArticleService;



@Service("articleService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	public ArticleServiceImpl() {
	}

	@Override
	public void addArticle(Article article) {
		try {
			articleDao.save(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Article> listArticles() {
		return articleDao.findAll();
	}
	
	@Override
	public void deleteArticle( Article article) {
		try {
			articleDao.delete(article);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Article getArticleByName(String name) {
		return null;
	}

}