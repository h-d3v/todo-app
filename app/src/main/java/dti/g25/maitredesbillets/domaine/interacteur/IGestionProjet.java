package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;

public interface IGestionProjet {
    Projet creerProjet(String titre);


    void rennomerProjet(Projet unProjet, String newTitre) throws Exception;

    void addBillet(Projet unProjet, Billet unBillet) throws Exception;


    void delBillet(Projet unProjet, Billet unBillet) throws Exception;
}
