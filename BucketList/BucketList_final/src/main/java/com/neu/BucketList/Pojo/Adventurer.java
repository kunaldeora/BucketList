package com.neu.BucketList.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "adventurer_master")
@PrimaryKeyJoinColumn(name = "personID") // we are doing this because it is
											// extending from person. It will
											// allow to join
public class Adventurer extends Person {

	@Column(name = "aboutMe")
	private String aboutMe;

	@Column(name = "completed_journeys")
	private int numberOfJourneyCompleted;
	
	@OneToMany(mappedBy="adventurer")
	private Set<BucketList> bucketList_adventurer;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location ad_location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "madventurer")
	private Set<Orders> noOfOrders;

	public Set<BucketList> getBucketList_adventurer() {
		return bucketList_adventurer;
	}

	public void setBucketList_adventurer(Set<BucketList> bucketList_adventurer) {
		this.bucketList_adventurer = bucketList_adventurer;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public int getNumberOfJourneyCompleted() {
		return numberOfJourneyCompleted;
	}

	public void setNumberOfJourneyCompleted(int numberOfJourneyCompleted) {
		this.numberOfJourneyCompleted = numberOfJourneyCompleted;
	}

	public Set<Orders> getNoOfOrders() {
		return noOfOrders;
	}


	public void setNoOfOrders(Set<Orders> noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	public Location getAd_location() {
		return ad_location;
	}

	public void setAd_location(Location ad_location) {
		this.ad_location = ad_location;
	}
	
	

}
