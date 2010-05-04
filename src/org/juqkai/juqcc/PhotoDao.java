package org.juqkai.juqcc;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class PhotoDao {
    private static PhotoDao _instance = null;
 
    public static PhotoDao getInstance() {
        if (_instance == null) {
            _instance = new PhotoDao();
        }
        return _instance;
    }
 
    //
    public String insertPhoto(Photo photo) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(photo);
        } finally {
            pm.close();
        }
        return photo.getId().toString();
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