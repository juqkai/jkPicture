package org.juqkai.jucc.blog.domain;

import java.util.Date;

import com.google.appengine.api.datastore.Text;

/**
 * 文章
 * @author juqkai E-mail:juqkai@gmail.com
 */
public class Article {
	private Long id;
	private String name;
	private Text content;
	private Date createDate;
	private String classification;
	
}
