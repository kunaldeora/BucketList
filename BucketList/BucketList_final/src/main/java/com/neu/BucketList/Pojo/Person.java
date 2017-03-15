package com.neu.BucketList.Pojo;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) // specify how to create the strategy for id generation
	@Column(name = "personID", unique =true, nullable = false)
	private int personId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL )
	private UserAccount userAccount;

	public UserAccount getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	public Person(){
		
	}


	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
}
