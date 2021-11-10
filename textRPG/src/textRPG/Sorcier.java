package textRPG;

public class Sorcier extends Personnage{

	// integers pour sauvegarder le nombre de weapons pour calculer l'attack et la defense apress
	public int numArmeAttack, numArmeDefend;
	
	// Arrays des weapons
	public String[] armeAttack = {"la portion magique","Chapeau magique","zombies"};
	public String[] armeDefend = {"Buckler","Steel Shield","Tower Shield"};

	// Constructeur de joueur
	public Sorcier(String nom) {
		super(nom, 100, 0, 600);
		//initialisation des armes à zero
		this.numArmeAttack = 0;
		this.numArmeDefend = 0;
		// choisir l'arme
		Game.titre("Vous etes Sorcier !");
		choisirArme();
	}

	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}
	//choisir Arme
	public void choisirArme() {
		Game.titre("Choisissez votre arme ");
		System.out.println("\n Attack (1) : 115$= " + armeAttack[numArmeAttack]);
		System.out.println("\n Defense (2) : 55$=" + armeDefend[numArmeDefend]);
		//player choix
		int input = Game.readInt("->", 2);
		Game.clear();
		// choix du joueur selon attack ou defense
		if(input == 1) {
			Game.titre("Vous avez choisi " + armeAttack[numArmeAttack] + " !");
			numArmeAttack++;
			argent -= 115;
			System.out.println("\n il vous reste :" + argent +"$");
		}else {
			Game.titre("Vous avez choisi " + armeDefend[numArmeDefend] + " !");
			numArmeDefend++;
			argent -= 55;
			System.out.println("\n il vous reste :" + argent +"$");
		}
		Game.attendre();
	}
	
}
