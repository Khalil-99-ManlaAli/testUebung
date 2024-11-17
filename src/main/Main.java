package main;

import gui.AutosAnwendersystem;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new AutosAnwendersystem(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
