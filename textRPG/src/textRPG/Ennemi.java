package textRPG;


public class Ennemi extends Personnage{
	//variable pour sauvegarder le xp actuel
	int playerXp;
	public Ennemi(String nom, int playerXp) {
		super(nom, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*(playerXp/4 + 2)+1), playerXp ) ;
		// on assigne la variable
		this.playerXp = playerXp;
	}

	// Enemy specific attack et defense
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 3);
	}

	
	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 3);
	}

}
