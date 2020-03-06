package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public class CréationBillet {

    private Billet créerBillet(String titre, String description, int ticketId, int projetId){
        return new Billet(titre, description, ticketId, projetId);
    }
    
}
