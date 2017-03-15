package com.neu.BucketList.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OrdersItems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="advertId", unique = true, nullable=false)
	private int order_item_id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="order_item_ticket_id")
	private Tickets ticket;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders fk_orders;
	

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public Tickets getTicket() {
		return ticket;
	}

	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}

	public Orders getFk_orders() {
		return fk_orders;
	}

	public void setFk_orders(Orders fk_orders) {
		this.fk_orders = fk_orders;
	}
	

}
