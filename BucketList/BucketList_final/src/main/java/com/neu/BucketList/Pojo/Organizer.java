package com.neu.BucketList.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Organizer")
@PrimaryKeyJoinColumn(name="personID")
public class Organizer extends Person{
	
	@Column(name="about_organization")
	private String aboutOrganization;
	
	@Column(name="number_of_events")
	private int numberOfEventsConducted;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="organizer")
	@Column(name = "advert_id")
	private Set<Advertisement> advertisement = new HashSet<Advertisement>();
	
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

	public String getAboutOrganization() {
		return aboutOrganization;
	}

	public void setAboutOrganization(String aboutOrganization) {
		this.aboutOrganization = aboutOrganization;
	}

	public int getNumberOfEventsConducted() {
		return numberOfEventsConducted;
	}

	public void setNumberOfEventsConducted(int numberOfEventsConducted) {
		this.numberOfEventsConducted = numberOfEventsConducted;
	}

	public Set<Advertisement> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Set<Advertisement> advertisement) {
		this.advertisement = advertisement;
	}

	
	public Set<Advertisement> addAdvertisement(Advertisement advertisementToAdd) {

         advertisement.add(advertisementToAdd);

		return advertisement;
	}
	
}


