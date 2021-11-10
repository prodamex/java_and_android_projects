package textRPG;

public class Chenzen extends Personnage{

	// integers pour sauvegarder le nombre de weapons pour calculer l'attack et la defense apress
	public int numArmeAttack, numArmeDefend;
	
	// Arrays des weapons
	public String[] armeAttack = {"AT4","Lampha","Panzerschreck"};
	public String[] armeDefend = {"Bazooka","Pistolet","ShieldX"};

	// Constructeur de joueur
	public Chenzen(String nom) {
		super(nom, 100, 0, 600);
		//initialisation des armes à zero
		this.numArmeAttack = 0;
		this.numArmeDefend = 0;
		// choisir l'arme
		choisirArme();
	}

	
	// Player specific methods (more in the next part)
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
		Game.clear();
		Game.titre("Vous avez " +argent+ "$ ,Choisissez une arme");
		System.out.println("\n Attack (1) : 100$= " + armeAttack[numArmeAttack]);
		System.out.println("\n Defense (2) : 85$=" + armeDefend[numArmeDefend]);
		//player choix
		int input = Game.readInt("->", 2);
		Game.clear();
		// choix du joueur selon attack ou defense
		if(input == 1) {
			Game.titre("Vous avez choisi " + armeAttack[numArmeAttack] + " !");
			numArmeAttack++;
			argent -= 100;
			System.out.println("\n il vous reste :" + argent +"$");
		}else {
			Game.titre("Vous avez choisi " + armeDefend[numArmeDefend] + " !");
			numArmeDefend++;
			argent -= 85;
			System.out.println("\n il vous reste :" + argent +"$");
		}
		Game.attendre();
	}
	
}
