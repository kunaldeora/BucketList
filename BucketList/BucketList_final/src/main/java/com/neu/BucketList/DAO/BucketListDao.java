package com.neu.BucketList.DAO;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.BucketList.Pojo.Adventure;
import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.BucketList;



public class BucketListDao extends DAO {
	
	public void insertIntoBucketList(Adventurer adventurerID, Adventure adventureId){
		
		try{
			begin();
			System.err.println("Inside Bucket Dao");
			BucketList bucket = new BucketList();
			bucket.setAdventure(adventureId);
			bucket.setAdventurer(adventurerID);
			getSession().save(bucket);
			commit();
		}
		catch(Exception e){
			rollback();
            System.err.println("Error in inserting in Bucketlist " + e.getMessage());
		}
		
	}
	
	public Set<BucketList> getBucketList(int personId){
		
		try{
			begin();
			System.err.println("Inside Bucket Dao -getBucketList");
			Query q = getSession().createQuery("from Adventurer where personId = :personId");
			q.setInteger("personId", personId);
	        Adventurer adventurer = (Adventurer) q.uniqueResult();
	        commit();
	        return adventurer.getBucketList_adventurer();   
		}catch (HibernateException e) {
            rollback();
            System.err.println("Could not getBucketList " + e.getMessage());
            return null;
        }
	}
	
	public Set<Adventure> getAllAdventures(Set<BucketList> thisBucket){
		Set<Adventure> adventuresInBucketList = new HashSet<Adventure>();
		
		for(BucketList bl : thisBucket){
			adventuresInBucketList.add(bl.getAdventure());			
		}
		return adventuresInBucketList;
	}
	
	public List<BucketList> getAllCompletedAdventures(int adventurer, String status){
		
		try{
			begin();
			//Set<BucketList> bucketList = new HashSet<BucketList>();
			Query q = getSession().createSQLQuery("select * from bucketlist_master where adventurer_id = ? and status = ?");
			q.setInteger(0, adventurer);
			q.setString(1, status);
			List<BucketList> bucketList =   q.list();
			commit();
			return bucketList;	
		}catch (HibernateException e) {
            rollback();
            System.err.println("Could not getAllCompletedAdventures " + e.getMessage());
            return null;
	}
		}
}
