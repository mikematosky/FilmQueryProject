package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;


//Just an interface. Don't touch if you don't have to.
public interface DatabaseAccessor {
  public List<Actor> getActorsByFilmID(int filmId);
  public List<Film> getFilmsByKeyword(String keyword);
  public Film getFilmByFilmID(int filmID) throws SQLException;
  public String getLanguageByLangID(int languageId);
	//public List<Actor> findFilmById(int filmId); - Examples of the queries to be defined here.
	//public List<Actor> findFilmById(int filmId); - Examples of the queries to be defined here.
	//public List<Actor> findFilmById(int filmId); - Examples of the queries to be defined here.
	//public List<Actor> findFilmById(int filmId); - Examples of the queries to be defined here.
}
