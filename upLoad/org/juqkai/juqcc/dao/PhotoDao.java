package org.juqkai.juqcc.dao;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.juqkai.juqcc.cache.PhotoCache;
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
 
    /**
     * 添加图片
     */
    public Long insertPhoto(Photo photo) {
    	pm.makePersistent(photo);
        return photo.getId();
    }
    
    /**
     * 删除图片
     * @param photo
     */
    public void deletePhoto(Photo photo){
    	pm.deletePersistent(findById(photo));
    	PhotoCache.remove(photo);
    }
    
    public List<Photo> listAll(){
    	return (List<Photo>) pm.newQuery(Photo.class).execute();
    }
 
    /**
     * 根据ID进行查询
     * @param photo
     * @return
     */
    public Photo findById(Photo photo) {
    	Photo cph = PhotoCache.get(photo.getId());
    	if(cph != null){
    		return cph;
    	}
    	
        Query query = pm.newQuery(Photo.class);
        query.setFilter("id == idParam");
        query.declareParameters("Long idParam");
        
        List<Photo> ph = null;
        try {
            ph = (List<Photo>) query.execute(photo.getId());
            if (ph.isEmpty()){
                return null;
            }
            PhotoCache.put(ph.get(0));
            return ph.get(0);
           
        } finally {
            query.closeAll();
        }
    }
    

	public List<Photo> listAll(Page page) {
		listAllCount(page);
		Query query = pm.newQuery(Photo.class);
		query.setOrdering("id desc");
		query.setRange(page.getPageStart(), page.getPageEnd());
		try{
			return (List<Photo>) query.execute();
		} finally {
	        query.closeAll();
	    }
	}
	
	private  void listAllCount(Page page){
		Query query = pm.newQuery("select count(1) from " + Photo.class.getName() );
		page.setItemCount(Long.parseLong(query.execute().toString()));
		try{
		} finally {
	        query.closeAll();
	    }
	}
    @Override
    protected void finalize() throws Throwable {
    	super.finalize();
    	pm.close();
    }
}