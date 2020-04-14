package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public class CréationBillet {


    /**
     * Contructeur d'un objet Billet juste avec un titre et sa description
     * @param titre Nom du Billet en string
     * @param description Nom du Billet en string
     * @return l'objet Billet qui a été crée
     */
    public static Billet créerBillet(String titre, String description){
        return new Billet(titre, description);
    }

}
