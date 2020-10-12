package view;

import Controller.Controller;
import model.Position;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Nationality;

public class AddPlayerView extends GridPane {
	
	private ChoiceBox<Nationality> nationalityChoiceBox;
	private TextField nameField, clubField;
	private RadioButton forwardButton, backbutton, goalieButton;
	private HBox buttonBox;
	private Button addButton;
	private Label nationLabel, nameLabel, clubLabel;
	
	public AddPlayerView(Controller controller) {
		this.nationLabel = new Label("Nationalität");
		this.add(this.nationLabel, 1, 1);
		this.nationalityChoiceBox = new ChoiceBox<Nationality>();
		for (Nationality nationality : Nationality.values()) { //gibt array zurück
			this.nationalityChoiceBox.getItems().add(nationality); //alle einträge werden der choicebox hinzugefügt
		}
		this.add(this.nationalityChoiceBox, 2, 1);		
		
		this.nameLabel = new Label("Spielername");
		this.add(this.nameLabel, 1, 2);
		this.nameField = new TextField();
		this.add(this.nameField, 2, 2);
		this.clubLabel = new Label("Club");
		this.add(this.clubLabel, 1, 3);
		this.clubField = new TextField();
		this.add(this.clubField, 2, 3);
		this.forwardButton = new RadioButton("Stürmer");
		this.backbutton = new RadioButton("Verteidiger");
		this.goalieButton = new RadioButton("Torwart");
		this.forwardButton.setSelected(true);
		ToggleGroup tg = new ToggleGroup();
		this.forwardButton.setToggleGroup(tg);
		this.backbutton.setToggleGroup(tg);
		this.goalieButton.setToggleGroup(tg);		
		this.buttonBox = new HBox();
		this.buttonBox.getChildren().addAll(this.forwardButton, this.backbutton, this.goalieButton);
		this.add(this.buttonBox, 2, 5);
		this.addButton = new Button("Hinzufügen");
		this.add(this.addButton, 2, 6);
		
		
		this.addButton.setOnAction(controller::addPlayer);
	}

	public String getClubName() {
		return this.clubField.getText();
	}

	public String getPlayerName() {
		return this.nameField.getText();
	}

	public Nationality getNationality() {
		return this.nationalityChoiceBox.getSelectionModel().getSelectedItem();
		
	}

	public Position getPosition() {
		if(this.forwardButton.isSelected())
			return Position.Stürmer;
		if(this.backbutton.isSelected())
			return Position.Verteidiger;
		return Position.Torwart;
	}

	public void reset() {
		this.nationalityChoiceBox.getSelectionModel().clearSelection(); //API
		this.forwardButton.setSelected(true);
		this.nameField.setText("");
		this.clubField.setText("");
		
	}


}
