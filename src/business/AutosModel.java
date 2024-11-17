package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutosModel {


	private Autos autos;

	public Autos getAutos() {
		return autos;
	}

	public void setAutos(Autos autos) {
		this.autos = autos;
	}
	public void schreibeAutosInCsvDatei() throws IOException {
	
			BufferedWriter aus = new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv"));
			aus.write(autos.gibAutosZurueck(';'));
			aus.close();
			
			
}
	
	 public void leseAusDatei(String typ)throws IOException{
	    	
	      		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.autos = new Autos(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				zeile[2], 
	      				Float.parseFloat(zeile[3]), 
	      				zeile[4].split("_"));
	      				ein.close();
}
	 }
}

