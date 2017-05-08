package com.jason.web.dao;

import java.util.List;

import com.jason.web.model.Article;

public interface ArticleDao extends BaseDao<Article, Long>{
		  
	  //get article list by sender
	  public List<Article> getArticleBySender(String sender);
	  
}
