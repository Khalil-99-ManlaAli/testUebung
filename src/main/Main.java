package main;

import gui.guiAutos.AutosControl;
import gui.guiAutosHaus.AutosHausControl;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	

	public void start(Stage primaryStage) {
		new AutosControl(primaryStage);
		Stage autosHaus = new Stage();
		new AutosHausControl(autosHaus);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
