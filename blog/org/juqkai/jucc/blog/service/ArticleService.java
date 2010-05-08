package org.juqkai.jucc.blog.service;

import java.util.List;

import org.juqkai.jucc.blog.domain.Article;

public interface ArticleService {

	public void save(Article article);

	public List<Article> list();

}
