package jeuCarte;

import java.util.ArrayList;


public class Bataille {
	
	public static void main(String [] args )
	{
		ArrayList<Carte> paquetDeCartes = new ArrayList<Carte>();
		ArrayList<Carte> paquetDeCartesMelange = new ArrayList<Carte>();
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
		
		while(paquetDeCartes.size()>0)
		{
			int index = (int)(Math.random()*paquetDeCartes.size());
			paquetDeCartesMelange.add(paquetDeCartes.remove(index));
		}
		
		// Création du paquet de cartes du joueur 1 et joueur 2
		
		for(int i=0; i<52; i++) 
		{
			if(i%2==0)
			{
				paquetJoueur1.add(paquetDeCartesMelange.get(i)); 
			}
			else
			{
				paquetJoueur2.add(paquetDeCartesMelange.get(i)); 
			}
			
		}
		
		Joueur joueur1 = new Joueur(26, paquetJoueur1);
		Joueur joueur2 = new Joueur(26, paquetJoueur2);
		
		boolean jouer=true;
	
		while(jouer)
		{
			Carte carte1 = joueur1.tirerCarte();
			Carte carte2 = joueur2.tirerCarte();
			
			if(joueur1.getCompteurDePoints()==50)
			{
				System.out.println("le joueur 1 a gagné");
				jouer=false;
			}
			else if(joueur2.getCompteurDePoints()==50)
			{
				System.out.println("le joueur 2 a gagné");
				jouer=false;
			}
			
			if(carte1.compareCarte(carte2)==true)
			{
				joueur1.ajouterCarte(carte1);
				joueur1.ajouterCarte(carte2);
			}
			else if(carte1.compareCarte(carte2)==false)
			{
				joueur2.ajouterCarte(carte1);
				joueur2.ajouterCarte(carte2);
			}
			else
			{
				System.out.println("**** BATAILLE ****");
				

				if(joueur1.getCompteurDePoints()==2)
				{
					System.out.println("le joueur 1 a gagné");
					jouer=false;
					break;
				}
				else if(joueur2.getCompteurDePoints()==2)
				{
					System.out.println("le joueur 2 a gagné");
					jouer=false;
					break;
				}
				
				
				Carte c1 = joueur1.tirerCarte();
				Carte c2 = joueur2.tirerCarte();
				
				Carte b1 = joueur1.tirerCarte();
				Carte b2 = joueur2.tirerCarte();
				
			
				if(b1.compareCarte(b2)==true)
				{
					joueur1.ajouterCarte(carte1);
					joueur1.ajouterCarte(carte2);
					joueur1.ajouterCarte(c1);
					joueur1.ajouterCarte(c2);
					joueur1.ajouterCarte(b1);
					joueur1.ajouterCarte(b2);
				}
				else if(b1.compareCarte(b2)==false)
				{
					joueur2.ajouterCarte(carte1);
					joueur2.ajouterCarte(carte2);
					joueur2.ajouterCarte(c1);
					joueur2.ajouterCarte(c2);
					joueur2.ajouterCarte(b1);
					joueur2.ajouterCarte(b2);
				}
				else
				{
					System.out.println("****** EGAUX ******");
					joueur1.ajouterCarte(carte1);
					joueur2.ajouterCarte(carte2);
					joueur1.ajouterCarte(c1);
					joueur2.ajouterCarte(c2);
					joueur1.ajouterCarte(b1);
					joueur2.ajouterCarte(b2);
				}
				
			}
			
			

			System.out.println(" Score du joueur 1 " + joueur1.getCompteurDePoints());
			System.out.println(" Score du joueur 2 " + joueur2.getCompteurDePoints());
			
			System.out.println("*****************************");
			
			

		}
		
		
	}
	
}
