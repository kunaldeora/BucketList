package com.neu.BucketList.DAO;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.web.multipart.MultipartFile;

import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.Advertisement;
import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Organizer;
import com.neu.BucketList.Pojo.UserAccount;

public class OrganizerDao extends DAO {

	public UserAccount create(String password,String email, String firstName, String lastName, Location searchedLoc){
		
		 try {
			  begin();
			  
	            System.out.println("inside DAO");
	            
	            Organizer organizer = new Organizer();
	           
	            UserAccount user=new UserAccount(email,password);
	            
	            user.setPerson(organizer);
	            user.setTypeOfUser("Organizer");
	         	            
	            organizer.setFirstName(firstName);
	            organizer.setLastName(lastName);
	            organizer.setUserAccount(user);
	            organizer.setLocation(searchedLoc);
	            
	            
		        getSession().save(organizer);
		        
	            commit();
	            
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            System.err.println("Exception while creating user: " + e.getMessage());
	            return null;
	        }
		
	}
	
//	public void setLocationForOrganizerPerson(UserAccount orgAcc, String loc){
//		
//		begin();
//		
//		//orgAcc.getPerson().setMyLocation(loc);
//		
//		commit();
//		
//	}
	
	public Advertisement createAdvertisement(String description, String message, String date,Organizer organizer, Adventure adventure){
		
		try{
			begin();
			Advertisement advert = new Advertisement();
			
//			com.mysql.jdbc.Blob photoBlob = (com.mysql.jdbc.Blob) Hibernate.getLobCreator(getSession()).createBlob(photo.getBytes());
		
//			Query q = getSession().createQuery("from Adventure where adventureName = :adventureName");
//			Adventure adventure = (Adventure) q.uniqueResult();
//			q.setString("adventureName", adventureName);
			advert.setAdventures(adventure);
			advert.setOrganizer(organizer);
			advert.setDescription(description);
			advert.setDateofEvent(date);
			advert.setMessage(message);
//			advert.setContent(photoBlob);
//			advert.setImageName(photo.getOriginalFilename());
			organizer.addAdvertisement(advert);
			getSession().save(advert);
			commit();
			return advert;
		}catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            System.err.println("not able to add the advertisement from organizer: " + e.getMessage());
            return null;
        }
	}
	
  public Organizer getOrganizer(int personId)
    {
		 try {
		     begin();
		     Query q = getSession().createQuery("from Organizer where personId = :personId");
		     q.setInteger("personId", personId);
		     Organizer organizer = (Organizer) q.uniqueResult();
		     commit();
		     return organizer;
		 } catch (HibernateException e) {
		     rollback();
		     System.err.println("Could not getOrganizer " + e.getMessage());
		     return null;
		 }
      }
	
	
	
	
}
