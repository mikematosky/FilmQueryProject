package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;


//Just an interface. Don't touch if you don't have to.
public interface DatabaseAccessor {
  public List<Actor> getActorsByFilmID(int filmId) throws SQLException;
  public List<Film> getFilmsByKeyword(String keyword) throws SQLException;
  public Film getFilmByFilmID(int filmID) throws SQLException;
  public String getLanguageByLangID(int languageId) throws SQLException;

}
