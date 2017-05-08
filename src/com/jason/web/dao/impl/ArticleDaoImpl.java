package com.jason.web.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jason.web.dao.ArticleDao;
import com.jason.web.model.Article;

@Repository("articleDao")
@Transactional
public class ArticleDaoImpl extends BaseDaoImpl<Article, Long> implements ArticleDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getArticleBySender(String sender) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
