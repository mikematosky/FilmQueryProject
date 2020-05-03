package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args)throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
    app.launch();
  }

  private void launch() throws SQLException {
    
	  Scanner input = new Scanner(System.in);
    
	  	welcome();
	  	startUserInterface(input);
	  
	  input.close();
  }

  private void startUserInterface(Scanner input) throws SQLException {
	  boolean dontExit= true;
	  String selection= "";
	  int id=0;
	  String keyword= "";
	  Film film= null;
	  List<Film> films= new ArrayList<>();
	  
	  
	  
	  
	  
	  MENU: while(dontExit) {
		  //semi GUI
		  System.out.println("|| -- Please make a selection from the menu -- ||");
		  System.out.println("||                                             ||");
		  System.out.println("|| '1': Search film by ID                      ||");
		  System.out.println("|| '2': Search film by Keyword                 ||");
		  System.out.println("|| '3': Exit                                   ||");
		  System.out.println("||                                             ||");
		  System.out.print("|| Your selection: ");
		  
		  selection= input.next();
		  
		  /*
		   * USER STORY 1
		   * 
		   * The user is presented with a menu in which they can choose to:
		   * Look up a film by its id.
		   * Look up a film by a search keyword.
		   * Exit the application.
		   */
		  switch(selection) {
		  case "1":
			  
			  /*
			   * USER STORY 2
			   * 
			   * If the user looks up a film by id, they are prompted to enter the film id. 
			   * If the film is not found, they see a message saying so. If the film is found, 
			   * its title, year, rating, and description are displayed.
			   * 
			   */
			  
			  try {
				  
				  System.out.print("|| Please enter the film ID: ");
				  id= input.nextInt();
				  
				  //check and except incoming input
				  try {
					  film= new DatabaseAccessorObject().getFilmByFilmID(id);
					  //check if null
					  if(film == null) {
						  System.out.println("|| -+=+-  No matching ID found  -+=+-");
					  }
					  //everything worked
					  else {
						  System.out.println(film);
					  }
					  
				  }catch(Exception e) {
					  System.out.println(" --* Not a valid ID input *--");
				  }
				  
			  }catch(Exception e) {
				  System.out.println(" --* Not a valid ID input *--");
			  }
			  
			  break;
			  
		  case "2":
			  
			  /*
			   * USER STORY 3
			   * 
			   * If the user looks up a film by search keyword, they are prompted to enter it. 
			   * If no matching films are found, they see a message saying so. Otherwise, they 
			   * see a list of films for which the search term was found anywhere in the title 
			   * or description, with each film displayed exactly as it is for User Story 2.
			   */
			  System.out.print("|| Please enter the keyword: ");
			  keyword= input.next();//I just don't want to mess with nextLine
			  films= new DatabaseAccessorObject().getFilmsByKeyword(keyword);
			  
			  if(films.size()== 0) {
				  System.out.println("|| -+=+-  No matching KEYWORD found  -+=+-");
			  }
			  else {
				  for (Film movie : films) {
					System.out.println(movie);
				}
			  }
			  break;
		  case "3":
			  System.out.println("||    Goodbye!");
			  dontExit= false;
			  break;
		  default:
			  System.out.println("###@ Not a valid MENU input @###");
			  continue MENU;
		  		
		  }//end switch
	  }//end while
  }//end startUserInterface
  
  private void welcome() {
	  System.out.println("||");
	  System.out.println("||");
	  System.out.println("||  Welcome to Film Query Project");
	  System.out.println("||");
  }

}
