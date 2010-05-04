package org.juqkai.juqcc.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Photo {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
    @Persistent
	private Blob photo;
    @Persistent
	private String name;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 有问题
	 * @return
	 */
	@Deprecated
	public byte[] parsePhoto(){
		ImagesService is = ImagesServiceFactory.getImagesService();
		Image image = ImagesServiceFactory.makeImage(photo.getBytes());
		Transform resize = ImagesServiceFactory.makeResize(200, 200);
		Image im = is.applyTransform(resize, image);
		return im.getImageData();
	}
}
