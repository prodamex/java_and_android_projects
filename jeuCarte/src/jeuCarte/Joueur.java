package jeuCarte;

import java.util.ArrayList;

public class Joueur {
	
	private int compteurDePoints;
//creation tableau dynamique de carte de joueur
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
// constructeur 
	public Joueur (int points, ArrayList<Carte> p)
	{
		compteurDePoints = points;
		paquet= p;
	}
	
	public int getCompteurDePoints()
	{
		return compteurDePoints;
	}
	
	public Carte tirerCarte()
	{
		Carte C = paquet.get(0);
		// qnd on tire on doit supprimer la carte qu'on a tiré
		paquet.remove(paquet.get(0));
		// compter combien de cartes on a a chaque fois - compteur de points
		
		return C;
	}
// method ajouter la carte gagner dans le pack de joueur'gangnt'
	public void ajouterCarte(Carte carteGagne)
	{
		paquet.add(carteGagne);
		compteurDePoints=this.paquet.size();
		
	}
}