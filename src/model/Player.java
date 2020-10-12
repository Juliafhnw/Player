package model;

public class Player {
	
	// Instanzvariablen für Player
	private String name;
	private Nationality nationality;
	private Position position;
	
	
	/**
	 * Konstruktor für Player
	 */
	public Player(String name, Nationality nationality2, Position position) {
		this.name = name;
		this.nationality = nationality2;
		this.position = position;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public Position getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}


}
