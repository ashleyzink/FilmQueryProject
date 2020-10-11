package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(490);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input, db);

		input.close();
	}

	private void startUserInterface(Scanner input, DatabaseAccessor db) {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println(" *~*~*~*~*~*~* Valiant Videos *~*~*~*~*~*~*");
			System.out.println("   *~*~* For Your Viewing Pleasure *~*~*");
			System.out.println("\nHow would you like to find your film tonight?");
			System.out.println("\n\t1.) Look up film by its Id");
			System.out.println("\t2.) Search for film using keyword");
			System.out.println("\t3.) Exit");
			System.out.println("\n *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
			int menuSelection = input.nextInt();
			switch (menuSelection) {
			case 1:
				try {
					System.out.println("What is the films Id number?");
					int filmId = input.nextInt();
					Film film = db.findFilmById(filmId);
					if (film == null) {
						System.out
								.println("We could not find the film that you're looking for." + "\nPlease try again");
					} else {
						printfilm(film);

					}
					System.out.println();
				} catch (InputMismatchException e) {
					String badInput = input.next();
					System.out.println("Most of our film's have an Id that is a number less than 4 digits long."
							+ "\nPlease try again");
					continue;
				}
				break;
			case 2:
				System.out.println("Which keyword would you like to use?");
				String keyword = input.next();
				db.findFilmsByKeyword(keyword);

			case 3:
				
				
			default:

			}

		}

	}

	private void printfilm(Film film) {
		System.out.println("Film title: " + film.getTitle() + "\nRelease Year: " + film.getReleaseYear() + "\nRating: "
				+ film.getRating() + "\nDescription: " + film.getDescription() + "\nLanguage: " + film.getLanguage());
		printActors(film.getActors());
	}

	private void printActors(List<Actor> actors) {
		System.out.println("List of Actors: ");
		for (Actor actor : actors) {
			System.out.println("\t" + actor.getFirstName() + " " + actor.getLastName());

		}

	}

}
