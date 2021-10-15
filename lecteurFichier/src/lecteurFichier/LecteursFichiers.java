package lecteurFichier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecteursFichiers extends Fichier{

	public LecteursFichiers(String a) {
		super(a, "txt");
	}
	
// Lecteur du fichier
	
	public void lireLignes() throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;
		while(  (line = reader.readLine()) != null ) {
			System.out.println(line);
		}
	}
	
// Lecteur à l'envers en terme de lignes
	
	public void lireLignesUpToDown() throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;
		ArrayList<String> listaa=new ArrayList<String>();
		while((line = reader.readLine()) != null) {
			listaa.add(line);
		}
		for(int j=listaa.size()-1; j >= 0; j--) {
			System.out.println(listaa.get(j));
		}
	}
	
// Lecture Palindromique en terme de caractères:

	public void lecturePalindromique() throws IOException{
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String ligne;
		ArrayList<String> tableauLettres = new ArrayList<String>();
		while((ligne = reader.readLine()) != null) {
			  char[] lettresLigne = ligne.toCharArray();
			  		for(int i = 0; i < lettresLigne.length; i++) {
			  			tableauLettres.add(Character.toString(lettresLigne[i]));
			  		}
			  tableauLettres.add("\n");
		}
		for(int i = tableauLettres.size()-1;  i >=0; i--) {
			System.out.print(tableauLettres.get(i));
		}
	}

	public void compareFichier() throws IOException {

		
	}
	
 // Comparateur de fichiers/lignes

	public void compareFichiers(Fichier F) throws IOException {
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
			reader2 = new BufferedReader(new FileReader(F.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String ligne;
		String ligne2 = null; 
		int nombreLignes = 1;
		while(((ligne = reader.readLine()) != null) && ((ligne2 = reader2.readLine())!= null)) {
			if(ligne.equals(ligne2)) {
				System.out.println("A la ligne "+ nombreLignes + ", il n'y a aucune différence \n");
			}
			else {
				System.out.println("A la ligne "+ nombreLignes + ", les fichiers sont différents : \n");
				System.out.println("Ligne " + nombreLignes + " de fichier 1 : " + ligne);
				System.out.println("Ligne " + nombreLignes + " de fichier 2 : " + ligne2 + "\n");
			}
			nombreLignes++;
		}
		
	}
	
}