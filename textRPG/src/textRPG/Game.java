package textRPG;
import java.util.Scanner;

public class Game {

	static Scanner scanner = new Scanner (System.in);
	
	static Player player;
	public static int pourLeMenu;

	public static boolean enCours;
	
	//Random rencontres
	public static String[] rencontre = {"Battle","Battle","Battle","Rest","Rest"};
	
	//Random ennemies
	public static String[] ennemies = {"Ogre","Monstre","Gobelin","Chevalier noir","Loup noir"};
	//Elements de la story
	public static int place = 0, act = 1;
	public static String[] places = {"Montagnes","Les landlines","Chateau de l'empereur","La chambre de roi"};

	
	// methode pour obtenir l'entree de joueur de la console
	public static int readInt(String prompt, int choixU) {
		int input;
		do {
			System.out.println(prompt);
		try {
			
			input = Integer.parseInt(scanner.next());
			
		}catch (Exception e) {
			input = -1;
			System.out.println("-_- Veuillez rentrer un nombre !");
		}
		}while (input < 1 || input > choixU);
		return input;
	}
	
	// methode pour simuler une réinitialisation (100 lignes) // clearing the console
	public static void clear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	// methode pour imp un separateur n
	public static void separateur(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("-");
		
		}
	}
	
	// methode pour imprimer un titre
	public static void titre(String titre) {
		
		separateur(30);
		System.out.println("\n" + titre);
		separateur(30);
	}
	
	// methode pour arreter le jeu et laisser le temps à au joueur jusqu'à ce qu'il entre quelque chose
	public static void attendre() {
		System.out.println("\n Entrer quelque chose pour continuer.. ");
		scanner.next();
	}
	
	// method pour demarrer le jeu 
	public static void jouer() {

		boolean nomSet = false;
		String nom;
		separateur(40);
		System.out.println("\n RPG 667");
		separateur(40);
		System.out.println("\n TEXT-BASED RPG GAME BY YOUNES BAALI");
		separateur(40);
		attendre();
		
		// avoir le prenom de joueur
		clear();
		titre("C'est quoi votre nom ?");
		separateur(10);
		nom = scanner.next();
		clear();
		titre("Bienvenue " + nom );
		nomSet = true;
		
		Story.story();
		attendre();
		separateur(20);
		// le joueur faut qu'il choisit un perso
		System.out.println("\n Choisissez votre personnage");
		System.out.println("(1) Sorcier");
		System.out.println("(2) Elfe");
		System.out.println("(3) Chenzen");
		int input = Game.readInt("->", 3);
		
		
		
		// on cree l'object joueur avec le nom(argm)

		////   player = new Player(nom);
		
		// on imprime le act de story 1
		Story.oneIntro();
		attendre();
		
		// on met enCours true, pour pour que le loop continue
	////	enCours= true;
		// on commence le loop de jeu
	////	loop();
		
				
		
		
	}
	//method pour changer les values de jeu tout depandant de xp de joueur
	public static void checkAct() {
		// change act based on xp
		if (player.xp >= 5 &&  act == 1) {
			// increment act et place
			act = 2;
			place = 1;
			//story
			Story.oneOutro();
			// player level up
			player.choisirArme();
			// deuxieme story
			Story.secondIntro();
			// on donne des nvx values aux ennemies
			ennemies[0]="Ogre";
			ennemies[1]="Chien de Oldston";
			ennemies[2]="HungerGuy";
			ennemies[3]="Petit diable";
			ennemies[4]="Zombie";
			// on donne des nouveaux values aux rencontres
			rencontre[0]="Battle";
			rencontre[1]="Battle";
			rencontre[2]="Battle";
			rencontre[3]="Rest";
			rencontre[4]="Rest";
			
		}else if (player.xp >= 10 && act == 2) {
			// increment act et place
			act = 3;
			place = 2;
			//story
			Story.secondOutro();
			// player level up
			player.choisirArme();
			// troisieme story
			Story.thirdIntro();
			// on donne des nvx values aux ennemies
						ennemies[0]="Ogre";
						ennemies[1]="Goblin";
						ennemies[2]="Chevalier noir";
						ennemies[3]="Petit diable";
						ennemies[4]="Creede";
						// on donne des nouveaux values aux rencontres
						rencontre[0]="Battle";
						rencontre[1]="Battle";
						rencontre[2]="Rest";
						rencontre[3]="Battle";
						rencontre[4]="Rest";
						// on intialise le HP du joueur
						player.hp = player.maxHp;
		}else if (player.xp >= 15 && act == 3) {
			// increment act et place
			act = 4;
			place = 3;
			//story
			Story.thirdOutro();
			// player level up
			player.choisirArme();
			// deuxieme story
			Story.fourthIntro();
			
			// on intialise le HP du joueur
			player.hp = player.maxHp;
			//la battle finale
			finalBattle();
		}
	}
	
	//method pour calculer un random rencontre
	public static void randomRencontre() {
		// un nombre random entre 0 et la taille de 'rencontre'
		int rencontres =(int)(Math.random()* rencontre.length);
		// on appelle les methods
		if(rencontre[rencontres].equals("Battle")) {
			randomBattle();
		}else if(rencontre[rencontres].equals("Rest")){
			takeRest();
		}
	}
	
	// method pour prendre une sieste/rest
	public static void takeRest() {
		clear();
		if (player.restsleft >= 1) {
			titre("Veut tu prendre une sieste ? (" + player.restsleft + "sieste(s).");
			System.out.println("(1)oui\né2) Non, pas mnt");
			int input = readInt("->", 2);
			if (input == 1) {
				// utilisateur prend un sieste
				if (player.hp >player.maxHp) {
					int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
					player.hp += hpRestored;
					if (player.hp> player.maxHp) {
						player.hp = player.maxHp;
						System.out.println("t'as pris une sieste et ton hp est à" + player.hp +"/"+player.maxHp+ ".");
						player.restsleft--;
					}
				}else {
					System.out.println("t'as pas besoin , t'es au maximum HP");
					attendre();
				}
			}
		}
	}
	// method pour continuer le jeu
	public static void continuer() {
			checkAct();
		// on verifie si le jeu n'est pas dans le dernier act
			if (act != 4) {
				randomRencontre();
			}
	}
	
	// method pour informations de joueur 
	public static void informations() {
		clear();
		titre("Infos de personnage");
			System.out.println("THE PLAYER");
			System.out.println(player.nom + "\t HP:" + player.hp + "/"+ player.maxHp + "\t Argent:" + player.argent);
			separateur(20);
			System.out.println("XP: " + player.xp);
			
			// imprimer les weapons
			if (player.numArmeAttack >0) {
				System.out.println("Vos armes d'attack : " + player.armeAttack[player.numArmeAttack]);
			}
			if (player.numArmeDefend >0) {
				System.out.println("Vos armes de défense : " + player.armeDefend[player.numArmeDefend]);
			}
			attendre();
		
		
	}
	// on crer une battle random
	public static void randomBattle() {
		clear();
		titre("T'as croisé un monstre");
		attendre();
		battle(new Ennemi(ennemies[(int)(Math.random()*ennemies.length)], player.xp));
	}
	
	// main battle method
	public static void battle(Ennemi ennemi) {
		while (true) {
			clear();
			titre(ennemi.nom +"\nHP: " + ennemi.hp + "/" + ennemi.maxHp );
			titre("Vous" + "\nHP: " + player.hp + "/" + player.maxHp);
			System.out.println("Veuillez choisir une action :");
			separateur(20);
			System.out.println("\n(1) Fight\n(2) Run Awaaaay");
			int input = readInt("->", 3);
			// choix d'utilisateur
			if (input == 1) {
				// FIGHT
				//clc dmg
				int dmg = player.attack() - ennemi.defend();
				int dmgTook = ennemi.attack() - player.defend();
				// on verifie que le damage n'est pas negative
				if (dmgTook < 0) {
					System.out.println("dmgtook<0");
					// on ajoute de damage si l'utilisateur defend bieen
					dmg -= dmgTook/2;
					dmgTook = 0;
					
				}
				if(dmg <0) 
					dmg = 0;
					// damage aux deux parties
					player.hp -= dmgTook;
					ennemi.hp -= dmg;
					// on imprime l'info de bataille
					clear();
					titre("Battle");
					System.out.println("T'as pris " + dmg + " damage à " + ennemi.nom + ".");
					separateur(10);
					System.out.println("Le " + ennemi.nom + " a subi " + dmgTook + "à toi.");
					attendre();
					// on verifie si le joueur est toujours vivant
					if (player.hp <= 0) {
						mort();
						break;
					}else if(ennemi.hp <= 0) {
						// on dit au joueur qu'il a gagneé
						clear();
						titre("t'as gagné contre " + ennemi.nom);
						player.xp += ennemi.xp;
						System.out.println("T'as gagné "+ennemi.xp+ " XP!");
						attendre();
						break;
					}

					
				
			
			}else if (input == 2){
				// l'option de fuir , pourcentage de 35% qu'il va survivre
				clear();
				// verification si le joueur il est pas dans le dernier act
				if (act != 4) {
					if (Math.random()* 10 + 1 <= 3.5) {
						titre("t'as reussi à fuir de " + ennemi.nom);
						attendre();
						break;
					}else {
						titre("T'as pas pu malheuresement fuir, le monstre t'as rattrapé");
						// on calcul le damage fait au joueur
						int dmgTook = ennemi.attack();
						System.out.println("T'as reçu : " +dmgTook+ " damage !" );
						attendre();
						// verifier si le joueur est toujours vivant
						if(player.hp<= 0) {
							mort();
						}
					}
						
					}else {
						titre("Tu peux pas fuir l'empreur.. MAN UP !!");
						attendre();
				}
				
			}
		}
	}
	
	// battle final
	public static void finalBattle() {
		
		battle(new Ennemi("THE EVIL EMPEROR", 7));
		
	}
	// mort de joueur
	public static void mort() {
		clear();
		titre("T'es mort..");
		titre("T'as gagné " + player.xp + " XP dans ta journée. Bonne chance pour la prochaine fois!");
		System.out.println("Merci, et à bientot :)");
	}
	//method pour magasin
	public static void magasin() {
		clear();
		titre("Infos de personnage");
		
		
			Game.clear();
			Game.titre("Vous avez " +player.argent+ "$ ,Choisissez une arme ");
			System.out.println("\n Attack (1) : 100$= " + player.armeAttack[player.numArmeAttack]);
			System.out.println("\n Defense (2) : 85$=" + player.armeDefend[player.numArmeDefend]);
			//player choix
			int input = Game.readInt("->", 2);
			if(input == 1) {
				Game.titre("Vous avez choisi " + player.armeAttack[player.numArmeAttack] + " !");
				player.numArmeAttack++;
				player.argent -= 100;
				System.out.println("\n il vous reste :" + player.argent +"$");
			}else {
				Game.titre("Vous avez choisi " + player.armeDefend[player.numArmeDefend] + " !");
				player.numArmeDefend++;
				player.argent -= 85;
				System.out.println("\n il vous reste :" + player.argent +"$");
			}
			Game.attendre();
			attendre();
		
	
	}

	// method pour afficher le menu de choix 
		public static void menu() {
			clear();
			titre("Vou etes dans : " + places[place]);
			titre("MENU");
			System.out.println("Veuillez choisir :");
			separateur(20);
			System.out.println("(1) Continuer le jeu");
			System.out.println("(2) Voir mes infos");
			System.out.println("(3) Visiter le magasin");
			System.out.println("(4) Sortir de jeu");

		}
	
	public static void loop() {
		while(enCours) {
			menu();
			int input = readInt("->", 3);
			if(input ==1) {
				continuer();
			}else if(input ==2) {
				informations();
			}else if(input==3){
				magasin();
			}else {
				enCours = false;
		}
		}
	}
}
