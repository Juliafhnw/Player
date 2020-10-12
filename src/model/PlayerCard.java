package model;

public class PlayerCard {

	private static final boolean String = false;

	public static int globalCardCount = 0; // statischer Zähler

	// Instanzvariablen für PlayerCard Objekte
	private Player player; // Aggregartion von Player
	private String clubName;
	private int cardNumber;

	/**
	 * Konstruktor für PlayerCard Objekte
	 */
	public PlayerCard(Player player, String clubName) {
		this.player = player; // Player-Objekt wird in PlayerCard gespeichert(aggregiert)
		this.clubName = clubName;
		globalCardCount++;
		this.cardNumber = globalCardCount;
	}

	/**
	 * Zeichenkettenrepräsentation für PlayerCard Objekte
	 */
	public String toString() {
		return this.cardNumber + ", " + this.player.getName() + ", " + this.clubName + ", "
				+ this.player.getNationality().name() + ", " + this.player.getPosition().name();
	}

	// Gross/Kleinschreibung wäre mit toLowerCase möglich
	public boolean containsSearchString(String searchString) { // durchsucht alle Parameter
		String cardnumberasString = Integer.toString(this.cardNumber);// int in string umwandeln
		if (this.player.getName().contains(searchString) || this.clubName.contains(searchString) || // clubname kein getter nötig
				this.player.getNationality().contains(searchString) || // enum
				this.player.getPosition().contains(searchString) || cardnumberasString.equals(searchString))

			return true;
		else
			return false;
	}

}
