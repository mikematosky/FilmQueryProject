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

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USER = "student";
	private static final String PASSWORD = "student";


	@Override
	public List<Film> getFilmsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film getFilmByFilmID(int filmID) throws SQLException{
		Film film= null;
		String sql= "SELECT * FROM film where id = ? ;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		//Try With Resources auto closes in reverse order of their creation (docs.oracle)
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			
			statement= conn.prepareStatement(sql);
			results= statement.executeQuery();
			
			if(results.next()) {
				film= new Film(results.getInt("id"), results.getString("title"),
						results.getString("description"), results.getInt("release_year"),
						results.getInt("language_id"), results.getInt("rental_duration"),
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
	public List<Actor> getActorsByFilmID(int filmID) throws SQLException {
		List<Actor> actors= new ArrayList<>();
		String sql= "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?;";
		PreparedStatement statement= null;
		ResultSet results = null;
		
		try (Connection conn= DriverManager.getConnection(URL, USER, PASSWORD)){
			statement= conn.prepareStatement(sql);
			statement.setInt(1, filmID);
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
	public String getLanguageByLangID(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
