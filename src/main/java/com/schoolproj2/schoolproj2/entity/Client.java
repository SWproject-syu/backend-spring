package com.schoolproj2.schoolproj2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "name", nullable = false, updatable = false)
	String name = "";
	@Column(name = "phonenumber", nullable = true)
	String phonenumber = "";
	@Column(name = "require_at", nullable = true)
	String require_at = "";
	@Column(name = "create_at", nullable = true)
	String create_at = "";

}
