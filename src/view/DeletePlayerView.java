package view;

import java.util.ArrayList;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.PlayerCard;

public class DeletePlayerView extends VBox{

	private Button delete;
	private ListView<PlayerCard> resultList;
	private TextField inputField;
	
	public DeletePlayerView(Controller controller) {
		this.delete = new Button("Karte entfernen");
		this.resultList = new ListView<PlayerCard>();
		this.inputField = new TextField();
		this.getChildren().addAll(this.inputField, this.delete, this.resultList);
		
		this.delete.setOnAction(controller::deleteCard);
	}

	public String getInputCard() { 
		return this.inputField.getText();
	
	}
	
	public void setResult(ArrayList<PlayerCard> result) {
		this.resultList.getItems().clear(); //resultlist bereits vorhanden, immer zuerst leeren
		this.resultList.getItems().addAll(result); //dann neue resultlist hinzufügen
		
		
	}
}
