package model;

import java.util.ArrayList;

public class PlayerCardCollection {

	// Sammlung als ArrayList
	private ArrayList<PlayerCard> collection;

	// Aggregation aus Playercard-Objekten
	public PlayerCardCollection() {
		this.collection = new ArrayList<PlayerCard>();
	}

	public void addPlayerCard(PlayerCard playerCard) {
		this.collection.add(playerCard);
	}

	public String toString() {
		String collectionAsString = "Anzahl Karten: " + this.collection.size() + "\n";
		collectionAsString += "\nMeine Karten:\n";
		for (int i = 0; i < this.collection.size(); i++)
			collectionAsString += this.collection.get(i) + "\n";

		return collectionAsString;
	}

	public ArrayList<PlayerCard> search(String searchString) { // ArrayList wird zurück gegeben
		ArrayList<PlayerCard> result = new ArrayList<PlayerCard>(); // Behälter für Rückgabe
		for (PlayerCard p : this.collection) {// durch Liste iterieren, für jede Spielerkarte aus DIESER collection
			if (p.containsSearchString(searchString)) { // containsSearchString = ausgelagerte Methode
				result.add(p);
			}
		}
		return result;

	}

	public void deleteCard(String cardNumber) {
		ArrayList<PlayerCard> searchResult = this.search(cardNumber);
		this.collection.removeAll(searchResult);

	}

}
