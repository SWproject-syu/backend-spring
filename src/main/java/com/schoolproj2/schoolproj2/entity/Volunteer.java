package com.schoolproj2.schoolproj2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "volunteer")
public class Volunteer implements Serializable {
	@Id
	@Column(name = "name", nullable = false, updatable = false)
	String name = "";
	@Column(name = "phonenumber", nullable = true)
	String phonenumber = "";
	@Column(name = "location", nullable = true)
	int location = -1;
	@Column(name = "date", nullable = true)
	String date = "";
	@Column(name = "start_at", nullable = true)
	String start_at = "";
	@Column(name = "end_at", nullable = true)
	String end_at = "";
	@Column(name = "date_desc", nullable = true)
	String date_desc = "";

	public Volunteer get() {
		return this;
	}

	public void set(Volunteer a) {
		this.name = a.name;
		this.phonenumber = a.phonenumber;
		this.location = a.location;
		this.date = a.date;
		this.start_at = a.start_at;
		this.end_at = a.end_at;
		this.date_desc = a.date_desc;
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
