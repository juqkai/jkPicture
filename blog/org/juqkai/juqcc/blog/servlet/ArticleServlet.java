package org.juqkai.juqcc.blog.servlet;

import java.util.List;

import org.juqkai.juqcc.blog.domain.Article;
import org.juqkai.juqcc.blog.service.ArticleService;
import org.juqkai.juqcc.domain.Page;
import org.nutz.mvc.adaptor.PairAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;

@At("/article")
@AdaptBy(type = PairAdaptor.class)
public class ArticleServlet{
	private ArticleService articleService;
	
	@At
	public void save(Article article){
		
		System.out.println(article);
		System.out.println(article.getName());
		System.out.println(article.getContent());
		System.out.println(article.getId());
		
		
//		articleService.save(article);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("article/list");
////		list(1l);
//		return mav;
	}
	
	public void list(Long currentPage){
		Page pa = new Page();
		pa.setCurrentPage(currentPage);
		List<Article> articles = articleService.list();
		
	}
	
	
	

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
}
