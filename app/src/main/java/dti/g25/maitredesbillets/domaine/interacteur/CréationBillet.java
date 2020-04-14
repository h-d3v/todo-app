package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public class CréationBillet {

    /**
     * Créer un billet seulement avec un titre et une description
     * @param titre le titre du billet
     * @param description la description du billet
     * @throws Exception si le projet est null ou son nouveau titre vide
     */
    public static Billet créerBillet(String titre, String description) throws Exception{
        if(titre == "")
            throw new Exception("le titre doit contenir au moin deux caractere");
        if(description  == "")
            throw new Exception("Le description doit contenir au moin deux caractere");
        if(titre == null)
            throw new Exception("Titre inexistant");
        if(description == null)
            throw new Exception("Description inexistante");
        return new Billet(titre, description);
    }

}
