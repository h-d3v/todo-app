package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public class CréationBillet {

    public Billet créerBillet(String titre, String description, int projetId){
        return new Billet(titre, description, projetId);
    }



    public static Billet créerBillet(String titre, String description){
        return new Billet(titre, description);
    }
    
}
