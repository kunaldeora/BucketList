package com.neu.BucketList.Pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ticket_Master")
public class Tickets {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ticketID;
	
	@ManyToOne
	@JoinColumn(name="advertisement_id")
	private Advertisement advert ;
	
	@Column(name="date_of_event")
	private Date dataOfEvent;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private double price;
	
	@Column(name="status")
	private String status;
	
	@Column(name="Owned_by")
	private int adventurer;
	
	
	public Tickets(){
		
		
	}
	
	
	public Advertisement getAdvert() {
		return advert;
	}
	public void setAdvert(Advertisement advert) {
		this.advert = advert;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAdventurer() {
		return adventurer;
	}
	public void setAdventurer(int adventurerId) {
		this.adventurer = adventurerId;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public Advertisement getAdvertisement() {
		return advert;
	}
	public void setAdvertisement(Advertisement advert) {
		this.advert = advert;
	}
	public Date getDataOfEvent() {
		return dataOfEvent;
	}
	public void setDataOfEvent(Date dataOfEvent) {
		this.dataOfEvent = dataOfEvent;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
