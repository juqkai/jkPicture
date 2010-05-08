package org.juqkai.jucc.blog.service.impl;

import org.juqkai.jucc.blog.dao.ArticleDao;
import org.juqkai.jucc.blog.domain.Article;
import org.juqkai.jucc.blog.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	private ArticleDao articleDao;
	
	@Override
	public void save(Article article) {
		System.out.println("this is Service");
	}

	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
}
