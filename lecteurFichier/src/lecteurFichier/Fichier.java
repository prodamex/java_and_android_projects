package lecteurFichier;

import java.io.IOException;



public abstract class Fichier implements Fichiertype {

		private String chemin, extension ;
	
		public Fichier(String a, String b) {
			super();
			this.chemin = a ;
			this.setExtension(b);
		}

		public String getChemin() {
			return chemin;
		}

		public String getExtension() {
			return extension;
		}

		public void setChemin(String chemin) {
			this.chemin = chemin;
		}
		
		public void setExtension(String extension) {
			this.extension = extension;
		}
		
		public abstract void lireLignes() throws IOException;
		 
		public abstract void lireLignesUpToDown() throws IOException;
		
		public abstract void lecturePalindromique() throws IOException;
		
		public abstract void compareFichiers(Fichier F) throws IOException;
		
}