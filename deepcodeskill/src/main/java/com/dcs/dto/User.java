package com.dcs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String lastname2;
    private String password;
    private String email;
    
    @ManyToMany
    @JoinTable(
        name = "user_skills",
        joinColumns = @JoinColumn(name = "id_user"),
        inverseJoinColumns = @JoinColumn(name = "id_skill")
    )
    @JsonIgnoreProperties("users")
    private List<Skill> skills ;
    
    @Lob
    private byte[] resume;

    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonIgnoreProperties("users")
    private Role role;

    @Lob
    private byte[] photo;
    
    @OneToMany
    @JoinColumn(name="id_user")
    private List<UserTest> userTest;
    
    @OneToMany
    @JoinColumn(name="id")
    private List<UserInterview> userInterview;

    public User() {
    }


	public User(int id, String name, String lastname, String lastname2, String password, String email,
			List<Skill> skills, byte[] resume, Role role, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.lastname2 = lastname2;
		this.password = password;
		this.email = email;
		this.skills = skills;
		this.resume = resume;
		this.role = role;
		this.photo = photo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

    
}