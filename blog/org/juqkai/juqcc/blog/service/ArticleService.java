package org.juqkai.juqcc.blog.service;

import java.util.List;

import org.juqkai.juqcc.blog.domain.Article;

public interface ArticleService {

	public void save(Article article);

	public List<Article> list();

}
