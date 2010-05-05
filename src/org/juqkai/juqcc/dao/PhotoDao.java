package org.juqkai.juqcc.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.juqkai.juqcc.domain.Page;
import org.juqkai.juqcc.domain.Photo;

public class PhotoDao {
    private static PhotoDao _instance = null;
    private PersistenceManager pm = PMF.get().getPersistenceManager();
 
    public static PhotoDao getInstance() {
        if (_instance == null) {
            _instance = new PhotoDao();
        }
        return _instance;
    }
 
    //
    public Long insertPhoto(Photo photo) {
        try {
            pm.makePersistent(photo);
        } finally {
            pm.close();
        }
        return photo.getId();
    }
    
    public List<Photo> listAll(){
    	return (List<Photo>) pm.newQuery(Photo.class).execute();
    }
 
    public Photo getById(Long id) {
        Query query = pm.newQuery(Photo.class);
        query.setFilter("id == idParam");
        query.declareParameters("Long idParam");
        
        List<Photo> photo = null;
        try {
            photo = (List<Photo>) query.execute(id);
            if (photo.isEmpty()){
                return null;
            }
            return photo.get(0);
           
        } finally {
            query.closeAll();
        }
    }

	public List<Photo> listAll(Page page) {
		listAllCount(page);
		System.out.println(page.getCurrentPage());
		Query query = pm.newQuery(Photo.class);
		query.setRange(page.getPageStart(), page.getPageEnd());
		return (List<Photo>) query.execute();
	}
	
	private  void listAllCount(Page page){
		Query query = pm.newQuery("select count(1) from " + Photo.class.getName());
		page.setPageCount(Long.parseLong(query.execute().toString()));
	}
    
}