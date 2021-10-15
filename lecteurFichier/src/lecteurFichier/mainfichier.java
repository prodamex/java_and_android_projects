package lecteurFichier;

import java.io.IOException;

public class mainfichier {
	public static void main(String[] args) throws IOException {
		// on get le premier fichier
		Fichier f1 = new LecteursFichiers("file1.txt"); 
		// on get le deuxieme fichier
		Fichier f2 = new LecteursFichiers("file2.txt"); 
		
		System.out.println("Lecture du fichier : \n");
		f1.lireLignes();
		
		System.out.println(" ");
		
		System.out.println("Lecteur à l'envers en terme de lignes:  \n");
		f1.lireLignesUpToDown();
		
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("Lecture Palindromique en terme de caractères:");
		f1.lecturePalindromique();
		
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println("Comparateur des deux fichiers : \n");
		f1.compareFichiers(f2);
	} 
}