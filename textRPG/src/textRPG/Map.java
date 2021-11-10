package textRPG;

import java.util.Scanner;

public class Map {
	

	private char map[][]= {
	{'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', 'X', '-'},
    {'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', '.', '-'},
    {'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', '.', '-'},
    {'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', '.', '-'},
    {'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', 'M', '-'},
    {'-', '-','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', '.', '-'},
    {'-', '-','-', '-','-', '*','-', '.','M', '.','.', '.','.', '.', '.', '-'},
    {'-', '-','-', '-','-', '.','-', '.','-', '-','-', '-','-', '-', '-', '-'},
    {'-', 'M','-', '-','-', '.','-', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '.','.', '.','.', '.','-', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', 'M','.', '.','.', '.','*', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '-','.', '.','.', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '-','.', '.','.', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '-','.', '.','.', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '-','.', 'M','.', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '.','.', '.','.', '.','.', '-','-', '-','-', '-', '-', '-'},
    {'-', '.','.', '.','.', '.','.', '.','.', '.','.', '.','.', '-', '-', '-'},
    {'-', '.','.', '.','.', '.','.', '.','.', '.','.', '.','.', '-', '-', '-'},
    {'-', '.','-', '-','-', '-','-', '-','-', '-','-', '-','-', '-', '-', '-'}};

	private static int x,y;
	Map(int x, int y){
		
		this.x = x;
		this.y = y;
		/// declarartion / creation joueur / player
//Game.jouer();
		Game.jouer();
		Game.player = new Player(Player.nom);

		Scanner clavier = new Scanner(System.in);
		this.map[x][y]= '0';
		this.afficheMap();
		while (this.map[x][y] != 'x' ) {
			System.out.println("z: Haut || d: Droite || q: Gauche || s: Bas");
			String key = clavier.nextLine();
			
			switch(key) {
			case "z":
				
				this.moveUp();
				break;
			case "d":
				this.moveR();
				break;
			case "q":
				this.moveL();
				break;
			case "s":
				this.moveDown();
				break;
			}
			this.afficheMap();

		}
	}
	// 19
	// 16
	private void move() {
		char c= map[x][y];
	}
	
	private void afficheMap() {

		for (int i=0; i < this.map.length; i++) {
			System.out.println(this.map[i]);
		}
	}
	
	private void moveUp() {
		if (this.x != 0 && this.map[this.x-1][this.y] != '-' ) {
		char c= map[x][y];
		map[x][y] = '.';
		this.x -= 1;
		this.checkZone();
		map[this.x][this.y] = c;
	}else {
		System.out.println("vous ne pouver pas plus monter");
		
	}
	}
	
	private void moveR() {
		if (this.y != 15 && this.map[this.x][this.y+1] != '-' ) {
			char c= map[x][y];
			map[x][y] = '.';
			this.y += 1;
			this.checkZone();
			map[this.x][this.y] = c;
		}else {
			System.out.println("vous ne pouver pas plus a droite");
			
		}
	}
	
	private void moveL() {
		if (this.y != 0 && this.map[this.x][this.y-1] != '-' ) {
			char c= map[x][y];
			map[x][y] = '.';
			this.y -= 1; 
			this.checkZone();
			map[this.x][this.y] = c;
		}else {
			System.out.println("vous ne pouvez pas a gauche");
			
		}
	}
	private void moveDown() {
		if(this.x != 18 && this.map[this.x+1][this.y] != '-' ) {
			char c= map[x][y];
			map[x][y] = '.';
			this.x += 1;
			this.checkZone();
			map[this.x][this.y] = c;
		}else {
			System.out.println("vous ne pouvez pas a descendre");
			
		}
		
	}

	private void checkZone() {
		switch(map[x][y]) {
		case 'M':
			System.out.println("voici un monst");
			Game.randomBattle();
			break;
		case '*':
			System.out.println("voici un marchant");
			Game.magasin();
			break;
		case '.':
			System.out.println(" ");
			break;
		case 'X':
			
				System.out.println(" ");
				Game.titre("PART FINAL - INTRO");
				Game.separateur(20);
				System.out.println("Vous entrez dans la salle du trône de l'empereur maléfique. tout ce que vous pouvez faire maintenant est de vous battre pour votre vie et de prier pour sortir vainqueur.");
				Game.attendre();
				Game.finalBattle();
				System.out.println("Toutes nos félicitations ! tu as vaincu l'empereur maléfique et sauvé le monde.");
				Game.attendre();
				System.exit(0);
				
			
			
		}
	}
	
}

