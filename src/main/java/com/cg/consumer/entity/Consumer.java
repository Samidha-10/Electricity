package com.cg.consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Consumer_INFO")
@Data

public class Consumer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@Pattern(regexp="^[A-Za-z]",message=" must be a charecter")
	@NotBlank(message = "first name must not be null or empty")
    @Column(name="first_name")
    private String firstName;
	//@Pattern(regexp="^[a-zA-Z]",message="must be a charecter")
   @NotBlank(message = "last name must not be null or empty")
    @Column(name="last_name")
    private String lastName;
    
    @Email(message = "email must be in web-format abc@xyz.com")
    @Column(name="email")
    private String email;
    
    @Column(name = "mobile")
    @NotNull(message = "phone must not be null or empty")
    private int mobile;
    
    //@Pattern(regexp="^[a-zA-Z0-9]")
    @NotBlank(message = "address must not be null or empty")
    @Column(name="address")
    private String address;
    
    @Column(name="username")
    private String userName;
    
    //@Pattern(regexp="^[a-zA-Z0-9]")
    @Column(name="password")
    private String password;
    
   public Consumer(long id, String firstName, String lastName, String email,int mobile, String address, String userName,
	String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.mobile=mobile;
	}
	public Consumer() {
		super();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	
	
    
	
	

}
