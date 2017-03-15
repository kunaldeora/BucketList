package com.neu.BucketList.DAO;

import java.nio.file.AccessDeniedException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;

import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.BucketList;
import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Person;
import com.neu.BucketList.Pojo.UserAccount;

import java.util.List;

public class AdventureDAO extends DAO {

	public Adventure createAdventure(String advName,Location advLocation,Adventurer adventurer, String type){
		try{
			begin();
	        System.out.println("inside DAO");
	        
	        Adventure adventure = new Adventure();
	        
	        adventure.setAdventureName(advName);
	        adventure.setTypeOfAdventure(type);
	        adventure.getLocation().add(advLocation);
	        adventurer.getAd_location().getLocalAdventures().add(adventure);
	        
	        
//	        adventure.addAdventurer(createdBy);       
//	        createdBy.addAdventureInBucketList(adventure);
            getSession().save(adventure);
	        
	        commit();
	        return adventure;
		}catch (HibernateException e) {
            rollback();
            System.err.println("Could not createAdventurer " + e.getMessage());
            return null;
        }
		
		
	}
	
	public Adventurer getAdventurer(int personId)
           {
        try {
            begin();
            Query q = getSession().createQuery("from Adventurer where personId = :personId");
            q.setInteger("personId", personId);
            Adventurer adventurer = (Adventurer) q.uniqueResult();
            commit();
            return adventurer;
        } catch (HibernateException e) {
            rollback();
            System.err.println("Could not getAdventurer " + e.getMessage());
            return null;
        }
    }
	
	public Adventure getAdventurerforAdvertisement(String adventureName)
	    {
		 try {
		     begin();
		     Query q = getSession().createQuery("from Adventure where adventureName = :adventureName");
		     q.setString("adventureName", adventureName);
		     Adventure adventure = (Adventure) q.uniqueResult();
		     commit();
		     return adventure;
		 } catch (HibernateException e) {
		     rollback();
		     System.err.println("Could not getAdventurer " + e.getMessage());
		     return null;
		 }
    }
	
	
	public Adventure getAdventure(int adventureId)
    {
	 try {
	     begin();
	     Query q = getSession().createQuery("from Adventure where adventureID = :adventureId");
	     q.setInteger("adventureId", adventureId);
	     Adventure adventure = (Adventure) q.uniqueResult();
	     commit();
	     return adventure;
	 } catch (HibernateException e) {
	     rollback();
	     System.err.println("Could not getAdventure " + e.getMessage());
	     return null;
	 }
}
	
	
	
	
	public List getAdventureList(){
		
		
		try{
			begin();
			Query q = getSession().createQuery("Select distinct adventureName from Adventure");
			List list =  q.list();
			commit();
			return list;
		}
		catch (HibernateException e) {
            rollback();
            System.err.println("Could not getAdventureList " + e.getMessage());
            return null;
            }
		
	}
	
	public boolean saveFeedBackOnCompletionOfAdventure(Adventurer adventurer,Adventure adventure, String besttime, String feedback, String dateCompleted, String expectedExpense, String rating, String status){
		
		try{
			begin();
			Query q = getSession().createQuery("from BucketList where adventurer = :adventurer and adventure = :adventure ");
			q.setEntity("adventurer", adventurer);
			q.setEntity("adventure", adventure);
			BucketList bucketList = (BucketList) q.uniqueResult();
			

    		bucketList.setBestTime(besttime);
    		bucketList.setDateCompleted(dateCompleted);
    		bucketList.setFeedback(feedback);
		    bucketList.setRating(Integer.parseInt(rating));
			bucketList.setStatus(status);
			bucketList.setExpense(Double.parseDouble(expectedExpense));
//			
//			bucketList.setAdventure(adventureId);
//			bucketList.setAdventurer(adventurerId);
//			
			getSession().saveOrUpdate(bucketList);
			commit();
			return true;
			
		}catch(HibernateException e) {
            rollback();
            System.err.println("Could not saveFeedBackOnCompletionOfAdventure " + e.getMessage());
            return false;
        }
		
		
		
	}
	
	public boolean deleteAdventureFromBucketList(int adventurerIdDelete,int adventureIdDelete){
		
		
		try{
			begin();
			Query q = getSession().createSQLQuery("delete from bucketlist_master where adventurer_id = ? and adventure_id = ? ");
//					createQuery("delete BucketList where adventurer=:adventurer and adventure=:adventurer");
//			q.setParameter("adventurer", delAdventurer, Type.class.cast(delAdventurer));
//			q.setParameter("adventurer", delAdventure, Type.class.cast(delAdventure));
			
			q.setInteger(0, adventurerIdDelete);
			q.setInteger(1, adventureIdDelete);
			
			int result = q.executeUpdate();
			commit();
			if (result>0){
				return true;
			}
		}catch(HibernateException e) {
            rollback();
            System.err.println("Could not deleteAdventureFromBucketList " + e.getMessage());
            return false;
        }
		
		return false;
		
	}
	
	
	
	
	
}
