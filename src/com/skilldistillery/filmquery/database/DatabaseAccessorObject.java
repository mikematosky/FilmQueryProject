package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private String user= "student";
	private String password= "student";
	
	
	
	@Override
	public List<Actor> getActorsByFilmID(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Film> getFilmsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Film getFilmByFilmID(int filmID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getLanguageByLangID(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

  

}
