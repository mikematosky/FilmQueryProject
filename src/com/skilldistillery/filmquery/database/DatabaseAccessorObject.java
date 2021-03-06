package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	//FINALS for Connection
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String USER = "student";
	private static final String PASSWORD = "student";



	@Override
	/*
	 * USER STORY 2
	 */
	public Film getFilmByFilmID(int filmID) throws SQLException{
		Film film= null;
		String sql= "SELECT * FROM film where id = ? ;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		//Try With Resources auto closes in reverse order of their creation (docs.oracle)
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			
			statement= conn.prepareStatement(sql);
			statement.setInt(1, filmID);//bind
			results= statement.executeQuery();
			
			if(results.next()) {
				film= new Film(results.getInt("id"), results.getString("title"),
						results.getString("description"), results.getInt("release_year"),
						getLanguageByLangID(results.getInt("language_id")), results.getInt("rental_duration"),
						results.getDouble("rental_rate"), results.getDouble("length"),
						results.getDouble("replacement_cost"), results.getString("rating"),
						results.getString("special_features"), getActorsByFilmID(results.getInt("id")));
						
			}

		}catch(Exception e){
			System.out.println("Something went wrong populating film by getFilmByFilmID");
		}finally {
			results.close();
			statement.close();
		}
		
		return film;
	}
	
	@Override
	/*
	 * USER STORY 3
	 */
	public List<Film> getFilmsByKeyword(String keyword) throws SQLException {
		List<Film> films= new ArrayList<>();
		String sql = "SELECT * FROM film WHERE lower(film.title) LIKE ? "
						+ "OR lower(film.description) LIKE ? ;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			statement= conn.prepareStatement(sql);
			statement.setString(1, "%"+keyword+"%");//bind
			statement.setString(2, "%"+keyword+"%");
			results= statement.executeQuery();
			
			while(results.next()) {
				Film film= new Film(results.getInt("id"), results.getString("title"),
						results.getString("description"), results.getInt("release_year"),
						getLanguageByLangID( results.getInt("language_id")), results.getInt("rental_duration"),
						results.getDouble("rental_rate"), results.getDouble("length"),
						results.getDouble("replacement_cost"), results.getString("rating"),
						results.getString("special_features"), getActorsByFilmID(results.getInt("id")));
				films.add(film);
			}
		}catch(Exception e){
			System.out.println("Something went wrong in getFilmsByKeyword");
		}finally {
			results.close();
			statement.close();
		}
		
		return films;
	}

	@Override
	/*
	 * USER STORY 5.1 
	 * 
	 * Listing the actors in the cast of a movie.
	 */
	public List<Actor> getActorsByFilmID(int filmID) throws SQLException {
		List<Actor> actors= new ArrayList<>();
		String sql= "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			statement= conn.prepareStatement(sql);
			statement.setInt(1, filmID);//bind
			results= statement.executeQuery();
			
			while(results.next()) {
				Actor actor= new Actor (results.getInt("id"), results.getString("first_name"), results.getString("last_name"));
				actors.add(actor);
			}
			
		}catch(Exception e) {
			System.out.println("Something went wrong getting the list of actors in getActorsByFilmID");
		}finally {
			results.close();
			statement.close();
		}
		
		return actors;
	}
	
	
	@Override
	/*
	 * USER STORY 4
	 */
	public String getLanguageByLangID(int languageID) throws SQLException {
		String language= null;
		String sql = "SELECT name FROM language WHERE id = ?;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			statement= conn.prepareStatement(sql);
			statement.setInt(1, languageID);//bind
			results= statement.executeQuery();
			
			if(results.next()) {
				language= results.getString("name");
			}
			
			
		}catch(Exception e){
			System.out.println("Something went wrong changing language from ID");
		}finally {
			results.close();
			statement.close();
		}
		
		return language;
	}

}
