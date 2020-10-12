package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Nationality;
import model.Player;
import model.PlayerCard;
import model.PlayerCardCollection;
import model.Position;


public class Initializer {

	// statischer Pfad zur Datei mit initialen Spielern
	private final static String pathName = "src/resources/players.txt";

	//Liest die Datei mit initialen Spielern ein
	//Service-Methode, um initialcollction zu erzeugen
	public static PlayerCardCollection readPlayerFile() throws FileNotFoundException { // Rückgabe PlayerCardCollection
		PlayerCardCollection initialCards = new PlayerCardCollection(); // PlayerCardCollection eröffnen

		Scanner fileReader = new Scanner(new File(pathName)); // pathName = konstante s. oben

		while (fileReader.hasNext()) {
			String line = fileReader.nextLine();
			PlayerCard pc = convertStringToPlayerCard(line); // Support-Methode, um aus ausgelesenen String ein PlayerCard-Objekt zu erzeugen
			initialCards.addPlayerCard(pc); //addPlayerCard-Methode aus PlayerCardCollection
		}
		return initialCards;
	}

	//Support-Methode, um PlayerCard Objekte aus Datei zu lesen, damit obere Methode nicht allzu lang
	private static PlayerCard convertStringToPlayerCard(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		String playerName = lineScanner.next();
		String clubName = lineScanner.next();
		
		String temp = lineScanner.next(); //enum-Nationality
		Nationality  nationality = Nationality.valueOf(temp); //temp wird konvertiert, da enum
		
		String tempPos = lineScanner.next(); //enum-Nationality
		Position  position = Position.valueOf(tempPos); //temp wird konvertiert, da enum
		
		Player player = new Player(playerName, nationality, position); //gemäss Player Konstruktor
		PlayerCard playerCard = new PlayerCard(player, clubName); //gemäss PlayerCard Konstruktor
		return playerCard;
	}

}
