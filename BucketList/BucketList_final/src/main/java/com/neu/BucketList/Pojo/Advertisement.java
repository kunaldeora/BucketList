package com.neu.BucketList.Pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Blob;

@Entity
@Table(name="Advertisement_Master")
public class Advertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int advertID;

	@ManyToOne
	@JoinColumn(name="organizer_id")
	private Organizer organizer;
	
	@OneToOne
	@JoinColumn(name="adventure_id")
	private Adventure adventures;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="advert")
	private Set<Tickets> ticketsOffered = new HashSet<Tickets>();
	
	@Column(name="description")
	private String description;
	
	@Column(name="message")
	private String message;
	
	@Column(name="date_of_event")
	private String dateofEvent;
	
	@Transient
    private MultipartFile photo;
	
	@Column(name="content")
    @Lob
	private Blob content;
	
	@Column(name="image_name")
	private String imageName;

	@Transient
	private String postedBy;
	
	
	
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public Set<Tickets> getTicketsOffered() {
		return ticketsOffered;
	}
	public void setTicketsOffered(Set<Tickets> ticketsOffered) {
		this.ticketsOffered = ticketsOffered;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateofEvent() {
		return dateofEvent;
	}
	public void setDateofEvent(String dateofEvent) {
		this.dateofEvent = dateofEvent;
	}
	public int getAdvertID() {
		return advertID;
	}
	public void setAdvertID(int advertID) {
		this.advertID = advertID;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public Adventure getAdventures() {
		return adventures;
	}
	public void setAdventures(Adventure adventures) {
		this.adventures = adventures;
	}
	
}
