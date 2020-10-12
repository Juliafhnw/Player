package view;

import Controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class PlayerCardMainView extends BorderPane {
	private MenuItem helpItem, finishItem;
	private Menu menu;
	private MenuBar menuBar;
	private Label statuslabel;
	private TabView tabView;

	public PlayerCardMainView(Controller controller) {
		this.helpItem = new MenuItem("Hilfe");
		this.finishItem = new MenuItem("Beenden");
		this.menu = new Menu("Menü");
		this.menuBar = new MenuBar();
		this.menu.getItems().addAll(this.helpItem, this.finishItem);
		this.menuBar.getMenus().add(this.menu);
		this.statuslabel = new Label("Alles ok");

		this.tabView = new TabView(controller);

		this.setTop(this.menuBar);
		this.setCenter(this.tabView);
		this.setBottom(this.statuslabel);
	}

	public AddPlayerView getAddPlayerView() { // Job wird weitergegeben an TabView, da nicht als INstanz in dieser Klasse vorhanden
		return this.tabView.getAddPlayerView();
	}

	public SearchPlayerView getSearchPlayerView() {
		return this.tabView.getSearchPlayerView();
	}

	public DeletePlayerView getDeletePlayerView() {
		return this.tabView.deletePlayerView();
	}
	public void setStatus(String message) {
		this.statuslabel.setText(message); // status = Label

	}

}
