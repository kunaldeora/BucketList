package com.neu.BucketList.Pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderID", unique=true, nullable=false)
	private int orderID;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@OneToMany(fetch=FetchType.EAGER ,mappedBy = "fk_orders")
	//@Column(name="order_item_id") //unidirectional ; discuss TA
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	
	
	@ManyToOne
	@JoinColumn(name="adventurer_id") // as we want to know how many orders by a particular adventurer. thats why bidirectional mapping
	private Adventurer madventurer;
	
	
	public Orders(){
		
	}
	
	
	
	public Adventurer getMadventurer() {
		return madventurer;
	}
	public void setMadventurer(Adventurer madventurer) {
		this.madventurer = madventurer;
	}
	
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
