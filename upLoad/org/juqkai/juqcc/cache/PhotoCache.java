package org.juqkai.juqcc.cache;

import java.util.Collection;
import java.util.Map;

import org.juqkai.juqcc.domain.Photo;

/**
 * 图片缓存
 * @author juqkai E-mail:juqkai@gmail.com
 */
public class PhotoCache{
	private static Map<Long, Photo> photoCache = new LRULinkedHashMap<Long, Photo>(1000);
	
	public static Photo get(Long key){
		return photoCache.get(key);
	}
	
	public static void put(Photo photo){
		if(photo == null || photo.getId() == null){
			return ;
		}
		photoCache.put(photo.getId(), photo);
	}
	
	public static void remove(Photo photo){
		photoCache.remove(photo.getId());
	}
	
	public static void clear(){
		photoCache.clear();
	}
	
	public static Collection<Photo> getAll(){
		return photoCache.values();
	}
}
