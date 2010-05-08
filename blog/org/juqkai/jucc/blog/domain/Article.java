package org.juqkai.jucc.blog.domain;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

/**
 * 文章
 * @author juqkai E-mail:juqkai@gmail.com
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Article{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String name;
	@Persistent
	private Text content;
	@Persistent
	private Date createDate;
	@Persistent
	private String classification;
	@Persistent
	private List<Reply> replys; 
}
