package com.neu.BucketList.Pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="BucketList_master")
public class BucketList implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="adventurer_id")
	private Adventurer adventurer = new Adventurer();
	
	@Id
	@ManyToOne
	@JoinColumn(name="adventure_id")
	private Adventure adventure = new Adventure();
	
	@Column(name="feedback")
	private String feedback;
	
	@Column(name="status")
	private String status;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="DateCompleted")
	private String dateCompleted;
		
	@Column(name="bestTime")
	private String bestTime;
	
	@Column(name="expected_expense")
	private double expense;		

	public Adventurer getAdventurer() {
		return adventurer;
	}

	public void setAdventurer(Adventurer adventurer) {
		this.adventurer = adventurer;
	}

	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
	public String getBestTime() {
		return bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	
	
	
	
	
	
	
}
