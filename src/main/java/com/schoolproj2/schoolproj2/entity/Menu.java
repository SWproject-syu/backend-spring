package com.schoolproj2.schoolproj2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {
	@Id
	@Column(name = "coffee", nullable = false, updatable = false)
	String coffee = "";
	@Column(name = "coffee_type", nullable = false)
	String type = "";
	@Column(name = "price", nullable = false)
	int price = -1;
	@Column(name = "price2", nullable = false)
	int price2 = -1;
	@Column(name = "price3", nullable = false)
	int price3 = -1;

	public String getCoffee() {
		return this.coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void CoffeeMenu() {
	}

	public void CoffeeMenu(String coffee, String type, int price) {
		this.coffee = coffee;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		builder.append("\"coffee\":\"");
		builder.append(this.coffee);
		builder.append("\"type\":\"");
		builder.append(this.type);
		builder.append("\",\"price\":");
		builder.append(this.price);
		builder.append("}");
		return builder.toString();
	}

}
