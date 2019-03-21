package com.newer.tea;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component
public class From {
	
	
	private List<String> drinks;
	private List<String> cuptypes;
	private List<String> sweets;
	private List<String> temperatures;
	private List<String> ingredients;
	
	
	public List<String> getDrinks() {
		return drinks;
	}
	public void setDrinks(List<String> drinks) {
		this.drinks = drinks;
	}
	public List<String> getCuptypes() {
		return cuptypes;
	}
	public void setCuptypes(List<String> cuptypes) {
		this.cuptypes = cuptypes;
	}
	public List<String> getSweets() {
		return sweets;
	}
	public void setSweets(List<String> sweets) {
		this.sweets = sweets;
	}
	public List<String> getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(List<String> temperatures) {
		this.temperatures = temperatures;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	

}
