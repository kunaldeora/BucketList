package com.neu.BucketList.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.BucketList.Pojo.Location;
import com.neu.BucketList.Pojo.Organizer;

public class LocationDAO extends DAO {

	public Location checkIfLocationExists(String locationName) {

		try {
			
			Query q = getSession().createQuery("from Location where locationName = :locationName");
			q.setString("locationName", locationName);
			Location locationDB = (Location) q.uniqueResult();
			
			if (locationDB == null) {
				begin();
				Location newLocation = new Location();
				newLocation.setLocationName(locationName);
				getSession().save(newLocation);
				commit();
				return newLocation;
			}
			
			
			return locationDB;
		} catch (Exception e) {
			rollback();
			System.err.println("could not get the location" + e.getMessage());
			return null;
		}

	}

}
