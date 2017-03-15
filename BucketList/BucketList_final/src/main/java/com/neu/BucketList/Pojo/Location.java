package com.neu.BucketList.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int locationId;
	
	@Column(name="locationName")
	private String locationName;

	@OneToMany(mappedBy="location", cascade = CascadeType.ALL)
	private Set<Organizer> localOrganizers = new HashSet<Organizer>();
	
	@OneToMany(mappedBy="ad_location", cascade = CascadeType.ALL)
	private Set<Adventurer> localAdventurers = new HashSet<Adventurer>();
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Location_Adventure_Master", joinColumns = { @JoinColumn(name = "locationId") },
    inverseJoinColumns = { @JoinColumn(name = "adventureID") })
	private Set<Adventure> localAdventures = new HashSet<Adventure>();
		
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Set<Organizer> getLocalOrganizers() {
		return localOrganizers;
	}

	public void setLocalOrganizers(Set<Organizer> localOrganizers) {
		this.localOrganizers = localOrganizers;
	}

	public Set<Adventure> getLocalAdventures() {
		return localAdventures;
	}

	public void setLocalAdventures(Set<Adventure> localAdventures) {
		this.localAdventures = localAdventures;
	}

	public Location(){
		
	}


}
