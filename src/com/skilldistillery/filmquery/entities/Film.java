package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;


public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private Double length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors= new ArrayList<>();
	
	public Film(int id, String title, String description, Integer releaseYear, String language, int rentalDuration,
				double rentalRate, Double length, double replacementCost, String rating, String specialFeatures, List<Actor> actors) {
		super();
		this.id= id;
		this.title= title;
		this.description= description;
		this.releaseYear= releaseYear;
		this.language= language;
		this.rentalDuration= rentalDuration;
		this.rentalRate= rentalRate;
		this.length= length;
		this.replacementCost= replacementCost;
		this.rating= rating;
		this.specialFeatures= specialFeatures;
		this.actors= actors;
		
	}
	
	
	
	
	
	
	
	
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getLanguageId() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	
	
	
	
	
	
//	@Override
//	public String toString() {
//		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
//				+ ", language=" + language + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
//				+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
//				+ ", specialFeatures=" + specialFeatures + ", actors=" + actors + "]";
//	}
	
	@Override
	public String toString() {
		return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+"||>("+id+") Title: "+title+"  ("+releaseYear+")    Rating: "+rating+"  Language: "+language+"\n"+
				"||> Description: "+description+"\n"+
				"||> Actors: "+actors+"\n"+
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language != other.language)
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
