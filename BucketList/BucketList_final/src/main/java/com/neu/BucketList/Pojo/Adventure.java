package com.neu.BucketList.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="adventure_master")
public class Adventure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int adventureID;
	
	@Transient
	private String postedBy; // email address
	
	@Column(name="adventureName")
	private String adventureName;
		
	@Column(name="typeOfAdventure")
	private String typeOfAdventure;
	
	@ManyToMany(mappedBy="localAdventures")
	private Set<Location> location = new HashSet<Location>();
	
	@OneToMany(mappedBy="adventure", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<BucketList> fk_bucketList;
	
	
	
	
//	@Column(name="image_adventure")
//	private  MultipartFile   adventureLocation;
	
	
//	public Set<Adventurer> getAdventurers() {
//		return adventurers;
//	}
//
//	public void setAdventurers(Set<Adventurer> adventurers) {
//		this.adventurers = adventurers;
//	}

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}



	public Adventure(){
		
	}
		
	public Set<BucketList> getFk_bucketList() {
		return fk_bucketList;
	}

	public void setFk_bucketList(Set<BucketList> fk_bucketList) {
		this.fk_bucketList = fk_bucketList;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getTypeOfAdventure() {
		return typeOfAdventure;
	}
	public void setTypeOfAdventure(String typeOfAdventure) {
		this.typeOfAdventure = typeOfAdventure;
	}
	public int getAdventureID() {
		return adventureID;
	}
	public void setAdventureID(int adventureID) {
		this.adventureID = adventureID;
	}
	public String getAdventureName() {
		return adventureName;
	}
	public void setAdventureName(String adventureName) {
		this.adventureName = adventureName;
	}
	
	
//	public Set<Adventurer> addAdventurer(Adventurer newAdventurer) {
//        
//		getAdventurers().add(newAdventurer);
//
//		return getAdventurers();
//	}

}
