package com.schoolproj2.schoolproj2.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "volunteer")
public class Volunteer implements Serializable {
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
	@Column(name = "location", nullable = true)
	String location = "";
	@Column(name = "date", nullable = true)
	String date = "";
	@Column(name = "startAt", nullable = true)
	String startAt = "";
	@Column(name = "endAt", nullable = true)
	String endAt = "";
	@Column(name = "dateDesc", nullable = true)
	String dateDesc = "";

	public Volunteer() {
	}

	public Volunteer(String name, String phonenumber, String location, String date, String startAt,
			String endAt, String dateDesc) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.location = location;
		this.date = date;
		this.startAt = startAt;
		this.endAt = endAt;
		this.dateDesc = dateDesc;
		this.createAt = LocalDateTime.now();
		this.updateAt = LocalDateTime.now();
	}

	public Volunteer get() {
		return this;
	}

	public void set(Volunteer a) {
		this.name = a.name;
		this.phonenumber = a.phonenumber;
		this.location = a.location;
		this.date = a.date;
		this.startAt = a.startAt;
		this.endAt = a.endAt;
		this.dateDesc = a.dateDesc;
	}

	// @Override
	// public String toString() {
	// StringBuilder builder = new StringBuilder("{");
	// builder.append("\"coffee\":\"");
	// builder.append(this.coffee);
	// builder.append("\"type\":\"");
	// builder.append(this.type);
	// builder.append("\",\"price\":");
	// builder.append(this.price);
	// builder.append("}");
	// return builder.toString();
	// }

}
