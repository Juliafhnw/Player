package view;

import Controller.Controller;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabView extends TabPane {

	private AddPlayerView addPlayerView;
	private SearchPlayerView searchPlayerView;
	private DeletePlayerView deletePlayerView;
	private Tab addTab, searchTab, deleteTab;

	public TabView(Controller controller) {
		this.addPlayerView = new AddPlayerView(controller); // alle Views sollen den Controller kennen
		this.searchPlayerView = new SearchPlayerView(controller); // Controller muss entsprechend auch in den Parametern mitgegeben werden
		this.deletePlayerView = new DeletePlayerView(controller);

		this.addTab = new Tab("Hinzufügen");
		this.searchTab = new Tab("Suchen");
		this.deleteTab = new Tab("Entfernen");
		this.addTab.setContent(this.addPlayerView);
		this.searchTab.setContent(this.searchPlayerView);
		this.deleteTab.setContent(this.deletePlayerView);
		this.deleteTab.setClosable(false);
		this.addTab.setClosable(false);
		this.searchTab.setClosable(false);
		this.getTabs().addAll(this.addTab, this.searchTab, this.deleteTab);
		
	}

	public AddPlayerView getAddPlayerView() { // Wird an Controller zurück gegeben, da oben als Instanzvariablen vorhanden
		return this.addPlayerView;
	}

	public SearchPlayerView getSearchPlayerView() {
		return this.searchPlayerView;
	}


	public DeletePlayerView deletePlayerView() {
		return this.deletePlayerView;
	}
	

}
