package com.newer.tea;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class Order {
	private int id;
	private String drink;
	private String cuptype;
	private String sweet;
	private String temperature;
	private List<String> ingredients;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getCuptype() {
		return cuptype;
	}

	public void setCuptype(String cuptype) {
		this.cuptype = cuptype;
	}

	public String getSweet() {
		return sweet;
	}

	public void setSweet(String sweet) {
		this.sweet = sweet;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", drink=" + drink + ", cuptype=" + cuptype + ", sweet=" + sweet + ", temperature="
				+ temperature + ", ingredients=" + ingredients + "]";
	}

}
