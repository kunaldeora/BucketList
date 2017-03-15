	package com.neu.BucketList.Pojo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="userAccount_master")
//@PrimaryKeyJoinColumn(name="personId") // only when there is table per subclass, it will add a column named personID
public class UserAccount {
	
	public UserAccount() {
    }
	
	public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
	
	@GenericGenerator(name="generator", strategy ="foreign", parameters = @Parameter(name="property", value="person"))
	@Id
	@GeneratedValue(generator = "generator") // specify a custom generator
	@Column(name="userAccountid" , unique=true, nullable = false)
	private int userAccountid;
	
//	@Column(name="username")
//	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="type_of_user")
	private String typeOfUser;
	
	
	

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="personId")
	private Person person;
	
//	@Column(name="userType")
//	private String userType;
	
	public int getUserAccountid() {
		return userAccountid;
	}

	public void setUserAccountid(int userAccountid) {
		this.userAccountid = userAccountid;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

}
