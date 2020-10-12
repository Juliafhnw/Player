package view;

import java.util.ArrayList;

import Controller.Controller;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.PlayerCard;


public class SearchPlayerView extends VBox {

	private TextField searchField;
	private Button searchButton;
	private ListView<PlayerCard> resultList;
	
	public SearchPlayerView(Controller controller) {
		this.searchField = new TextField();
		this.searchButton = new Button("Suchen");
		this.resultList = new ListView<PlayerCard>();
		this.resultList.getItems().addAll(); //!!
		this.getChildren().addAll(this.searchField, this.searchButton, this.resultList);
		
		this.searchButton.setOnAction(controller::searchPlayers); //Methode in Player
		this.searchField.setOnAction(controller::searchPlayers);
	}

	public String getSearchString() { //searchString wird wieder in Methode in Controller zurück gegeben werden
		return this.searchField.getText();
	}

	public void setResult(ArrayList<PlayerCard> result) {
		this.resultList.getItems().clear(); //resultlist bereits vorhanden, immer zuerst leeren
		this.resultList.getItems().addAll(result); //dann neue resultlist hinzufügen
		
		
	}
	

}
