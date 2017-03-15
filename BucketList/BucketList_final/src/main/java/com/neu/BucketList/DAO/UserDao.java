package com.neu.BucketList.DAO;



import java.nio.file.AccessDeniedException;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.BucketList.Pojo.Adventurer;
import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Person;
import com.neu.BucketList.Pojo.UserAccount;





public class UserDao extends DAO {

	public Adventurer create(String password,String email, String firstName, String lastName, Location location)
           {
        try {
            begin();
            System.out.println("inside DAO");
            
            Adventurer adventurer = new Adventurer();
            UserAccount user=new UserAccount(email,password);
            adventurer.setFirstName(firstName);
            adventurer.setLastName(lastName);
            adventurer.setUserAccount(user);
            adventurer.setAd_location(location);
            
            user.setPerson(adventurer);
            user.setTypeOfUser("Adventurer");
 
            getSession().save(adventurer);
            
            commit();
            return adventurer;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            System.err.println("Exception while creating user: " + e.getMessage());
            return null;
        }
    }
	
	public UserAccount checkIfUserExists(String username, String password) throws Exception{
		
		
		try{
			//begin();
			//String typeOfUser = null;
            Query q=getSession().createQuery("from UserAccount where email= :username and password = :password");
            q.setString("username",username);
            q.setString("password",password);
           // q.setString("typeOfUser", typeOfUser);     
            UserAccount account = (UserAccount) q.uniqueResult();
            //commit();
            return account;
			
		}
		catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the named category " + username + " " + e.getMessage());
        }
		
	}
	
	public UserAccount get(String userEmail)
          {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where email = :userEmail");
            q.setString("userEmail", userEmail);
            UserAccount user = (UserAccount) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            System.err.println("Could not get user " + e.getMessage());
            return null;
        }
    }
	
}
