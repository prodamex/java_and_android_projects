package textRPG;

public class Story {

		public static void story() {
			Game.clear();
			Game.separateur(20);
			Game.titre("Histoire");
			Game.separateur(20);
			System.out.println("\nVous êtes le dernier homme debout après que votre village a été attaqué par les hommes de main de l'empereur maléfique.");
			System.out.println("Chacun de vos amis, de votre famille et de vos voisins a été assassiné. Vous vous tenez dans les ruines brûlantes de cela une fois pour toutes.");
			System.out.println("Tout ce que vous voulez maintenant, c'est vous venger, alors vous commencez à planifier votre voyage pour vaincre l'empereur maléfique et libérer les terres.");
		}
		public static void oneIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("INTRO");
			Game.separateur(20);
			System.out.println("\nAu début de votre voyage, vous commencez à voyager à travers les bois voisins pour atteindre le palais maléfique.");
		}
		public static void oneOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 1 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu l'as fait ! tu es toujours en vie ! en descendant la colline, vous êtes plus qu'heureux de sentir à nouveau un sol dur sous vos pieds.");
		}
		public static void secondIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 2 - INTRO");
			Game.separateur(20);
			System.out.println("Vous commencez à voyager à travers les lignes fixes de cette campagne autrefois bien peuplée, vous savez exactement où se trouve le château de l'empereur maléfique, bonne chance à vous.");
		}
		public static void secondOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 2 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu as réussi à traverser ces terres maudites et tu es toujours en vie, vous n'êtes qu'à quelques heures de votre destination finale.");
		}
		public static void thirdIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 3 - INTRO");
			Game.separateur(20);
			System.out.println("Comme vous voyez l'immense château noir devant vous. alors que tu te tiens devant les portes, tu sais qu'il n'y a pas de retour en arrière.");
		}
		public static void thirdOutro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART 3 - OUTRO");
			Game.separateur(20);
			System.out.println("Tu es venu si loin, tu as vaincu tous les serviteurs et monstres de l'empereur maléfique.");
		}
		public static void fourthIntro() {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART FINAL - INTRO\n");
			Game.separateur(20);
			System.out.println("\nVous entrez dans la salle du trône de l'empereur maléfique. tout ce que vous pouvez faire maintenant est de vous battre pour votre vie et de prier pour sortir vainqueur.");
		}
		public static void fourthOutro(Player player) {
			Game.clear();
			Game.separateur(20);
			Game.titre("PART FINAL - OUTRO");
			Game.separateur(20);
			System.out.println("Toutes nos félicitations " +(player.nom)+ "! tu as vaincu l'empereur maléfique et sauvé le monde.");
		}
		
		
		
}
