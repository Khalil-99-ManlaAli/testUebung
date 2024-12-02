package gui.guiAutosHaus;

import business.AutosModel;
import gui.guiAutos.AutosView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class AutosHausControl implements Observer{
	
	private AutosModel autosModel;
	private AutosHausView  autosView;
	
	public AutosHausControl(Stage primStage) {
		super();
		this.autosModel = autosModel.getInstanz();
		this.autosView = new AutosHausView(this,autosModel,primStage);
		autosModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		autosView.zeigeAutosAn();
		
	}

}
