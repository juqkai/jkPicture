package org.juqkai.juqcc.blog.service.impl;

import java.util.List;

import org.juqkai.juqcc.blog.dao.ArticleDao;
import org.juqkai.juqcc.blog.domain.Article;
import org.juqkai.juqcc.blog.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	private ArticleDao articleDao;
	
	@Override
	public void save(Article article) {
		System.out.print("this is Service:");
		System.out.println(article.getName());
	}
	
	@Override
	public List<Article> list() {
		return null;
	}

	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	
}
