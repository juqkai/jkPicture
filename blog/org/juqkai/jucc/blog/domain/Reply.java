package org.juqkai.jucc.blog.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

/**
 * 回复
 * @author juqkai E-mail:juqkai@gmail.com
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Reply{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String email;
	@Persistent
	private Text content;
}
