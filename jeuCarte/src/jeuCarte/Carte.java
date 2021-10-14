package jeuCarte;

public class Carte {
// initialisation des valeurs des cartes
	private String valeurs [] = { "2", "3", "4", "5" , "6","7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	private int vals [] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
// initialisation des couleurs des cartes
	private String [] couleurs = {"trefle", "coeur", "carreaux", "pique"};
	
	private String valeur;
	private String couleur;
	private int val;
// creation une carte d'une couleur et d'une valeur
	//constructeur
	
	//math-pt1
	public Carte(int v, int c)
	{
		val=vals[v];
		
		valeur=valeurs[v];
		
		couleur = couleurs[c];
	}
	
	public String getValeur()
	{
		return this.valeur;
	}

	public String getCouleur()
	{
		return this.couleur;
	}
	
	public int getVal ()
	{
		return this.val;
	}
// comparateur de cartes - qui plus grande
	public boolean compareCarte(Carte c)
	{
		if(this.val > c.val)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
