package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import factory.ConceteCreatorA;
import factory.ConceteCreatorB;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class AutosModel implements Observable {
	
	LinkedList <Observer> liste = new LinkedList <Observer>();
	private AutosModel() {
		
	}
	private static AutosModel instanz = null;
	public static AutosModel getInstanz() {
		if(instanz ==null ) {
			instanz = new AutosModel();
		}
		return instanz;
	}

	public static void setInstanz(AutosModel instanz) {
		AutosModel.instanz = instanz;
	}
	private Autos autos;

	public Autos getAutos() {
		return autos;
	}

	public void setAutos(Autos autos) {
		this.autos = autos;
		notifyObservers();
	}
	public void schreibeAutosInCsvDatei() throws IOException {
	
			BufferedWriter aus = new BufferedWriter(new FileWriter("AutosAusgabe.csv"));
			aus.write(autos.gibAutosZurueck(';'));
			aus.close();
			
			
}
	
	 public void leseAusDatei(String typ)throws IOException{
	    	
		 Creator creator;
		 if(typ.equals("csv")) {
			 creator= new ConceteCreatorA();
		 }else {
			 creator= new ConceteCreatorB();
			 
			 Product reader= creator.factoryMethode(typ);
			 
			 String[] zeile=reader.leseAusDatei();
			 this.autos = new Autos(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				zeile[2], 
	      				Float.parseFloat(zeile[3]), 
	      				zeile[4].split("_"));
			 
			 reader.schliesseDatei();

		 }
	      		/*if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("AutosAusgabe.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.autos = new Autos(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				zeile[2], 
	      				Float.parseFloat(zeile[3]), 
	      				zeile[4].split("_"));
	      				ein.close();
	      				}*/
	 }

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.add(obs);
	}

	@Override
	public void removObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);
	}

	
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o: liste) {
			o.update();
		}
	}

	
}

