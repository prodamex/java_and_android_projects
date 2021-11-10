package textRPG;

public class Player extends Personnage{

	// integers pour sauvegarder le nombre de weapons pour calculer l'attack et la defense apress
	public int numArmeAttack, numArmeDefend;
	
	int restsleft;
	// Arrays des weapons
	public String[] armeAttack = {"la portion magique","Chapeau magique","zombies"};
	public String[] armeDefend = {"Buckler","Steel Shield","Tower Shield"};

	// Constructeur de joueur
	public Player(String nom) {
		super(nom, 100, 0, 600);
		//initialisation des armes à zero
		this.numArmeAttack = 0;
		this.numArmeDefend = 0;
		// choisir l'arme
		Game.titre("Vous etes le joueur ");
		choisirArme();
	}

	
	// Player specific methods (more in the next part)
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(xp/4 + numArmeAttack*3 + 3) + xp/10 + numArmeAttack*2 + numArmeDefend + 1);
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(xp/4 + numArmeAttack*3 + 3) + xp/10 + numArmeAttack*2 + numArmeDefend + 1);
	}
	//choisir Arme
	public void choisirArme() {
		Game.titre("Vous commencer le jeu. Allez choisissez votre arme :");
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
