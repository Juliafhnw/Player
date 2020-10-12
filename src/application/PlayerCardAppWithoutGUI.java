package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Nationality;
import model.Player;
import model.PlayerCard;
import model.PlayerCardCollection;
import model.Position;
import util.Initializer;

public class PlayerCardAppWithoutGUI {
	
	//statische Variable, die aus Main zugegriffen wird
	private static PlayerCardCollection myCards; //aus eigener Klasse
	private static Scanner scan = new Scanner(System.in); // statischer Scanner, gleich auch schon instanziert, damit weitere Methoden darauf zugreifen können
	
	//Startpunkt des Programms
	public static void main(String[] args) throws FileNotFoundException {
		myCards = Initializer.readPlayerFile(); //statische Methode
		//System.out.println(myCards); //aus Datei ausgelesen, gemäss ToString aus PlayerCardCollection
		
		int selection;
		do {
			System.out.println("1 = Spielerkarte hinzufügen, 2 = Sammlung ausgeben, 3 = Karte suchen, 4 = Karte löschen, 0 = EXIT");
			selection = scan.nextInt();
			scan.nextLine(); //damit Pointer auf nächste Zeile springt, technisches Detail, nicht ganz so wichtig :)
			switch (selection) {
			case 1 :
				addNewPlayerCard();
				break;
			case 2 :
				printMyCards();
				break;
			case 3 :
				searchCards();
				break;
			case 4 :
				deleteCard();
				break;
			case 0 :
				System.out.println("Programm wird beendet"); //da 0 erst ausserhalb der Schleife und bei 0 sonst default ausgespielt wird
				break;
			default :
				System.out.println("Eingabe ungültig");
			}
			
		} while (selection !=0);
		
	}

	



	private static void deleteCard() {
	System.out.println("Kartennummer?");
	String cardNumber = scan.next();
	myCards.deleteCard(cardNumber);
		
	}





	private static void searchCards() {
		System.out.println("Suchbegriff eingeben");
		String searchString = scan.nextLine(); //1. Schritt einlesen
		ArrayList<PlayerCard> result = myCards.search(searchString); //Methode durchsuchen wird an Collection ausgelagert, ArrayList wird zurück gegeben aus dieser Methode
		printMyCards(result);
	}

	private static void printMyCards(ArrayList<PlayerCard> result) { //überladene Methode = gleicher Bezeichner, 1x mit, 1x ohne formalen Parameter
		if (result.size() == 0) { //size = Methode aus ArrayList
			System.out.println("Keine passende Karte gefunden"); //Könnte auch einfach result geprintet werden, wenn aber leer dann [] = unschön
		} else {
			System.out.println("Folgende Karten wurden gefunden"); 
			for (PlayerCard p : result)
				System.out.println(p);
		}
	}

	private static void printMyCards() {
		System.out.println(myCards); //ToString Methode von myCards
		
	}
	
	//neue Spielerkarte einlesen, Player-Objekt und PlayerCard-Objekt erzeugen und zu myCards hinzufügen
	private static void addNewPlayerCard() {
		System.out.println("Name des Spielers");
		String name = scan.nextLine();
		System.out.println("Club des Spielers");
		String club = scan.nextLine();
		System.out.println("Nationalität des Spielers");
		String temp = scan.nextLine(); //muss in Nationality-Objekt konvertiert werden
		Nationality nationality = Nationality.valueOf(temp);
		System.out.println("Position des Spielers");
		String tempPos = scan.nextLine(); //muss in Position-Objekt konvertiert werden
		Position position = Position.valueOf(tempPos);
		
		//Spieler erzeugen
		Player player = new Player(name, nationality, position);
		PlayerCard playerCard = new PlayerCard(player, club);
		
		myCards.addPlayerCard(playerCard); //Methode bereits vorhanden, da ArrayList, wird playerCard ans Ende der Liste hinzugefügt
	}


}
