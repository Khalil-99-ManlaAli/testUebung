package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {

	

	private BufferedReader br;
	
	
	
	public ConcreteProductA() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		this.br= new BufferedReader(new FileReader("AutosAusgabe.csv"));
	}

	@Override
	/*public String[] lieseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String [] ergebnisZeile= new String[5];
		String zeile=br.readLine();
		int i=0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[0]=zeile;
			zeile=br.readLine();
			i++;
		}
		String [] array=ergebnisZeile[0].split(";");
		
		return ergebnisZeile[0].split(";");
	}
*/
		
	
	
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String [] ergebnisZeile= new String[1];
		String zeile= br.readLine();
		int i=0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			zeile=br.readLine();
			i++;
		}
		String [] array= ergebnisZeile[0].split(";");
		return ergebnisZeile[0].split(";");
	}


	
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		br.close();
		
	}


}
