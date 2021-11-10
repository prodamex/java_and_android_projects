package textRPG;

public abstract class Personnage {

	// variables / attributs que tous les personnages ont

	public static String nom;
	public int maxHp, hp, xp, argent;
	
	// constructeur pour le personnage
	public Personnage (String nom, int maxHp, int xp, int argent) {
		this.nom = nom;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.xp = xp;
		this.argent = argent;
	}
	
	// methods chaque personnage dispose / selon les personnages
	public abstract int attack();
	public abstract int defend();
}
