package lecteurFichier;

import java.io.IOException;

interface Fichiertype {
    public void lireLignes() throws IOException;
    public void lireLignesUpToDown() throws IOException;
    public void lecturePalindromique() throws IOException;
    public void compareFichiers(Fichier F) throws IOException;
 }