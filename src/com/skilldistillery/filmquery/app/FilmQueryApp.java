package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.launch();
  }

  private void launch() {
    
	  Scanner input = new Scanner(System.in);
    
	  	welcome();
	  	startUserInterface(input);
	  
	  input.close();
  }

  private void startUserInterface(Scanner input) {
	  boolean dontExit= true;
	  String selection= "";
	  int id=0;
	  String keyword= "";
	  Film film= null;
	  
	  
	  
	  
	  
	  MENU: while(dontExit) {
		  //semi GUI
		  System.out.println("|| -- Please make a selection from the menu -- ||");
		  System.out.println("||                                             ||");
		  System.out.println("|| '1': Search film by ID                      ||");
		  System.out.println("|| '2': Search film by Keyword                 ||");
		  System.out.println("|| '3': Exit                                   ||");
		  System.out.println("||                                             ||");
		  System.out.println("|| Your selection: ");
		  
		  selection= input.next();
		  
		  switch(selection) {
		  case "1":
			  try {
				  id= input.nextInt();
			  }catch(Exception e) {
				  System.out.println("--* Not a valid ID input *--");
			  }
			  film= new DatabaseAccessorObject().getFilmByFilmID(id);
			  if(film == null) {
				  System.out.println("-+=+ No matching ID found +=+-");
			  }
			  else {
				  System.out.println(film);
			  }
			  
			  break;
		  case "2":
			  System.out.println("Please enter the keyword");
			  
			  break;
		  case "3":
			  dontExit= false;
			  break;
		  default:
			  System.out.println("###@ Not a valid MENU input @###");
			  continue MENU;
		  		
		  }
		  
		  
	  }
    
  }
  
  private void welcome() {
	  System.out.println("||");
	  System.out.println("||");
	  System.out.println("||");
	  System.out.println("||  Welcome to Film Query Project");
	  System.out.println("||");
	  System.out.println("||");
	  System.out.println("||");
  }

}
