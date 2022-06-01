package com.schoolproj2.schoolproj2.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "volunteer")

public class Volunteer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	@Column(length = 100, nullable = false)
	private LocalDateTime createAt;

	@LastModifiedDate
	@Column(length = 100, nullable = false)
	private LocalDateTime updateAt;
	@Column(length = 100, nullable = false)
	private String name;
	@Column(length = 100, nullable = false)
	private	String phonenumber;
	@Column(length = 100, nullable = false)
	private String location;
	@Column(length = 100, nullable = false)
    private String date;
	@Column(length = 100, nullable = false)
	private String startAt;
	@Column(length = 100, nullable = false)
	private String endAt;
	@Column(length = 100, nullable = false)
	private String dateDesc;



	@Builder
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

/**
	public Volunteer get() {
		return this;
	}

	public void set(Volunteer volunteer) {
		this.name = volunteer.name;
		this.phonenumber = volunteer.phonenumber;
		this.location = volunteer.location;
		this.date = volunteer.date;
		this.startAt = volunteer.startAt;
		this.endAt = volunteer.endAt;
		this.dateDesc = volunteer.dateDesc;
	}
**/

}
