package org.juqkai.juqcc.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.juqkai.juqcc.domain.Photo;

public class PhotoDao {
    private static PhotoDao _instance = null;
 
    public static PhotoDao getInstance() {
        if (_instance == null) {
            _instance = new PhotoDao();
        }
        return _instance;
    }
 
    //
    public Long insertPhoto(Photo photo) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(photo);
        } finally {
            pm.close();
        }
        return photo.getId();
    }
    
    public List<Photo> listAll(){
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	return (List<Photo>) pm.newQuery(Photo.class).execute();
    }
 
    public Photo getById(Long id) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
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
    
}