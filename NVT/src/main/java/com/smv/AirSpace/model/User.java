package com.smv.AirSpace.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.smv.AirSpace.dto.UserDTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String email;
    protected String password;
    protected String city;
    protected String phoneNumber;
	@Enumerated(EnumType.ORDINAL)
    protected UserStatus userStatus;
	@Enumerated(EnumType.ORDINAL)
    protected UserType userType;
	protected Long companyId;
	
	protected String uuid;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Karta> karte;
    
	



	public List<Karta> getKarte() {
		return karte;
	}


	public void setKarte(List<Karta> karte) {
		this.karte = karte;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public User(){

    }


    public User(String username, String password, String email, UserStatus userStatus, UserType userType) {
        super();
    	this.username = username;
        this.password = password;
        this.email = email;
        this.userStatus = userStatus;
        this.userType = userType;
    }

    public User(String username, String password, UserType userType, UserStatus userStatus) {
    	this.username = username;
        this.password = password;
        this.userStatus = userStatus;
        this.userType = userType;
	}
    

	public User(Long id, String firstName, String lastName, String username, String email, String password, String city,
			String phoneNumber, UserStatus userStatus, UserType userType, Long companyId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.userStatus = userStatus;
		this.userType = userType;
		this.companyId = companyId;
	}


	public User(String username, String password, String email, UserType userType, UserStatus userStatus, Long companyId) {
		this.username = username;
		this.email = email;
		this.password = password;
        this.userStatus = userStatus;
        this.userType = userType;
        this.companyId = companyId;
        //DODATO ZBOG EMAIL AKTIVACIJE ADMINA
        this.uuid = UUID.randomUUID().toString();
        }


	public User(UserDTO dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.username = dto.getUsername();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.city = dto.getCity();
		this.phoneNumber = dto.getNumber();
		this.userType = dto.getUserType();
		this.uuid = UUID.randomUUID().toString();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public UserStatus getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	


	


}
