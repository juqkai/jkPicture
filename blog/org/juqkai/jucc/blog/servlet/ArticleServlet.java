package org.juqkai.jucc.blog.servlet;

import org.juqkai.jucc.blog.domain.Article;
import org.juqkai.jucc.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleServlet{
	private ArticleService articleService;
	
	@RequestMapping("/article/save.htm")
	public void save(Article article){
		articleService.save(article);
	}
	
	
	

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
}
