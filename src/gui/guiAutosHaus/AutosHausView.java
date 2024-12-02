package gui.guiAutosHaus;

import business.Autos;
import business.AutosModel;
import gui.guiAutos.AutosControl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class AutosHausView {
	
	private AutosHausControl autosHausControl;
    private AutosModel autosModel;
    private Pane pane     					= new  Pane();
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private Autos autos;
    
    public AutosHausView(AutosHausControl autosHausControl, AutosModel autosModel,Stage primaryStage) {
		super();
		this.autosHausControl = autosHausControl;
		this.autosModel = autosModel;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Autos");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}

	private void initListener() {
		
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeAutosAn();
	        } 
   	    });
	}

	private void initKomponenten() {
		// TODO Auto-generated method stub
		Font font = new Font("Arial", 24); 
    	 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;");
       	pane.getChildren().addAll( lblAnzeige);
       	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnAnzeige);
	}
    
	public void zeigeAutosAn(){
       	if(this.autosModel.getAutos() != null){
       		txtAnzeige.setText(
       			this.autosModel.getAutos().gibAutosZurueck(' '));
       	}
       	else{
       		zeigeInformationsfensterAn("Bisher wurde kein Autos aufgenommen!");
       	}
       }
    


    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
    }	

}
