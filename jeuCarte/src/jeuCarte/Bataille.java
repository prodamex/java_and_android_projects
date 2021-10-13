package jeuCarte;

import java.util.ArrayList;
import java.util.*;

public class Bataille {
	
	public static void main(String [] args )
	{
		List<Carte> paquetDeCartes = new ArrayList<Carte>();
		ArrayList<Carte> paquetJoueur1 = new ArrayList<Carte>();
		ArrayList<Carte> paquetJoueur2 = new ArrayList<Carte>();
		
		// Création du paquet de cartes
		
		for(int i=0; i<13; i++)
		{
			for(int j=0; j<4; j++)
			{
				paquetDeCartes.add(new Carte(i,j));
				
			}

		}
      
		

		// Création du paquet de cartes du joueur 1
		
		for(int i=0; i<26; i++) 
		{
			paquetJoueur1.add(paquetDeCartes.get(i)); 
		}
		
		// Création du paquet de cartes du joueur 2
		
		for(int i=26; i<52; i++) 
		{
			paquetJoueur2.add(paquetDeCartes.get(i)); 
		}
		
		Joueur joueur1 = new Joueur(26, paquetJoueur1);
		Joueur joueur2 = new Joueur(26, paquetJoueur2);
		
		boolean jouer=true;
		
	
		while(jouer)
		{
			Carte carte1 = joueur1.tirerCarte();
			Carte carte2 = joueur2.tirerCarte();
			
			if(carte1.compareCarte(carte2))
			{
				joueur1.ajouterCarte(carte1);
				joueur1.ajouterCarte(carte2);
			}
			else
			{
				joueur2.ajouterCarte(carte1);
				joueur2.ajouterCarte(carte2);
			}
			

			System.out.println(" Score du joueur 1 " + joueur1.getCompteurDePoints());
			System.out.println(" Score du joueur 2 " + joueur2.getCompteurDePoints());
			
			System.out.println("*****************************");
			
			if(joueur1.getCompteurDePoints()>50)
			{
				System.out.println("le joueur 1 a gagné");
				jouer=false;
				break;
			}
			else if(joueur2.getCompteurDePoints()>50)
			{
				System.out.println("le joueur 2 a gagné");
				jouer=false;
				break;
			}
			

		}
		
		
	}
	
}