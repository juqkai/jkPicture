package org.juqkai.jucc.blog.servlet;

import java.util.List;

import org.juqkai.jucc.blog.domain.Article;
import org.juqkai.jucc.blog.service.ArticleService;
import org.juqkai.juqcc.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleServlet{
	private ArticleService articleService;
	
	@RequestMapping("/article/save.htm")
	public ModelAndView save(Article article){
		
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
		return null;
	}
	
	@RequestMapping("/article/list.htm")
	public ModelAndView list(Long currentPage){
		Page pa = new Page();
		pa.setCurrentPage(currentPage);
		List<Article> articles = articleService.list();
		
		
		return null;
	}
	
	
	

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
}
