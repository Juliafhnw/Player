package Controller;

import java.util.ArrayList;

import javafx.event.Event;
import model.Nationality;
import model.Player;
import model.PlayerCard;
import model.PlayerCardCollection;
import model.Position;
import view.AddPlayerView;
import view.DeletePlayerView;
import view.PlayerCardMainView;
import view.SearchPlayerView;

public class Controller {

	private PlayerCardCollection myCards;
	private PlayerCardMainView mainView;
	private AddPlayerView addPlayerView;
	private SearchPlayerView searchPlayerView;
	private DeletePlayerView deletePlayerView;
	
	public Controller(PlayerCardCollection myCards) {
		this.myCards = myCards;
	}

	public void setView(PlayerCardMainView mainView) {
		this.mainView = mainView;
		this.addPlayerView = mainView.getAddPlayerView();
		this.searchPlayerView = mainView.getSearchPlayerView();
		this.deletePlayerView = mainView.getDeletePlayerView();
	}

	public void searchPlayers(Event event) {
		String searchString = this.searchPlayerView.getSearchString();
		ArrayList<PlayerCard> result = this.myCards.search(searchString); // Search = methode in playcardcollection, erwartet ArrayList<PlayerCard>
		this.searchPlayerView.setResult(result); // setResult = neue Methode in SearchPlayerView
		this.mainView.setStatus("Suche durchgeführt"); // setStatus = neue Methode in PlayerCardMainView
	}

	
	public void addPlayer(Event event) {
		String clubName = this.addPlayerView.getClubName();
		String playerName = this.addPlayerView.getPlayerName();
		Nationality nationality = this.addPlayerView.getNationality(); 
		Position position = this.addPlayerView.getPosition();
		
		Player player = new Player(playerName, nationality, position);
		PlayerCard playerCard = new PlayerCard(player, clubName);
		this.myCards.addPlayerCard(playerCard);
		this.mainView.setStatus("Spieler hinzugefügt");
		this.addPlayerView.reset();
	}
	
	

	public void deleteCard(Event event) {
		String cardInput = this.deletePlayerView.getInputCard();
		myCards.deleteCard(cardInput);
		
	}

	

}
