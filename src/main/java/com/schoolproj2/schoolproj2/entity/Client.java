package com.schoolproj2.schoolproj2.entity;

// import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
// import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreatedDate
	@Column(name = "createAt", nullable = true, columnDefinition = "datetime(3)")
	private LocalDateTime createAt;
	@LastModifiedDate
	@Column(name = "updateAt", nullable = true, columnDefinition = "datetime(3)")
	private LocalDateTime updateAt;
	@Column(name = "name", nullable = true)
	String name = "";
	@Column(name = "phonenumber", nullable = true)
	String phonenumber = "";
	@Column(name = "requireAt", nullable = true)
	String requireAt = "";

	public Client() {
	}

	public Client(String name, String phonenumber, String requireAt) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.requireAt = requireAt;
		this.createAt = LocalDateTime.now();
		this.updateAt = LocalDateTime.now();
	}

	public Long getId() {
		return this.id;
	}

	public LocalDateTime getCreateAt() {
		return this.createAt;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneNumber() {
		return this.phonenumber;
	}

	public String getRequireAt() {
		return this.requireAt;
	}

	public LocalDateTime getUpdateAt() {
		return this.updateAt;
	}

	public Client get() {
		return this;
	}

	public void set(Client a) {
		this.name = a.name;
		this.phonenumber = a.phonenumber;
		this.requireAt = a.requireAt;
		this.createAt = a.createAt;
		this.updateAt = a.updateAt;
	}
}
