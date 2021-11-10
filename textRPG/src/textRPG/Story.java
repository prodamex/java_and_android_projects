package textRPG;

public class Story {

		public static void story() {
			Game.clear();
			Game.separateur(20);
			Game.titre("Histoire");
			Game.separateur(20);
			System.out.println("\nVous �tes le dernier homme debout apr�s que votre village a �t� attaqu� par les hommes de main de l'empereur mal�fique.");
			System.out.println("Chacun de vos amis, de votre famille et de vos voisins a �t� assassin�. Vous vous tenez dans les ruines br�lantes de cela une fois pour toutes.");
			System.out.println("Tout ce que vous voulez maintenant, c'est vous venger, alors vous commencez � planifier votre voyage pour vaincre l'empereur mal�fique et lib�rer les terres.");
		}
		public static void oneIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("INTRO");
			Game.separateur(20);
			System.out.println("\nAu d�but de votre voyage, vous commencez � voyager � travers les bois voisins pour atteindre le palais mal�fique.");
		}
		public static void oneOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 1 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu l'as fait ! tu es toujours en vie ! en descendant la colline, vous �tes plus qu'heureux de sentir � nouveau un sol dur sous vos pieds.");
		}
		public static void secondIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 2 - INTRO");
			Game.separateur(20);
			System.out.println("Vous commencez � voyager � travers les lignes fixes de cette campagne autrefois bien peupl�e, vous savez exactement o� se trouve le ch�teau de l'empereur mal�fique, bonne chance � vous.");
		}
		public static void secondOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 2 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu as r�ussi � traverser ces terres maudites et tu es toujours en vie, vous n'�tes qu'� quelques heures de votre destination finale.");
		}
		public static void thirdIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 3 - INTRO");
			Game.separateur(20);
			System.out.println("Comme vous voyez l'immense ch�teau noir devant vous. alors que tu te tiens devant les portes, tu sais qu'il n'y a pas de retour en arri�re.");
		}
		public static void thirdOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 3 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu es venu si loin, tu as vaincu tous les serviteurs et monstres de l'empereur mal�fique.");
		}
		public static void fourthIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART FINAL - INTRO\n");
			Game.separateur(20);
			System.out.println("\nVous entrez dans la salle du tr�ne de l'empereur mal�fique. tout ce que vous pouvez faire maintenant est de vous battre pour votre vie et de prier pour sortir vainqueur.");
		}
		public static void fourthOutro(Player player) {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART FINAL - OUTRO");
			Game.separateur(20);
			System.out.println("Toutes nos f�licitations " +(player.nom)+ "! tu as vaincu l'empereur mal�fique et sauv� le monde.");
		}
		
		
		
}
