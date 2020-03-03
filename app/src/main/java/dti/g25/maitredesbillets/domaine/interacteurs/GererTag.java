package dti.g25.maitredesbillets.domaine.interacteurs;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Tag;

import java.util.ArrayList;

public class GererTag {

    public Tag creerTag(String titre, String couleur, int id){
        return new Tag(titre,couleur, id);
    }

    public void modifierCouleur(Tag unTag, String uneCouleur){
        unTag.setCouleur(uneCouleur);
    }

    public void modifierTitre(Tag unTag, String unTitre){
        unTag.setTitre(unTitre);
    }

    public void supprimerTag(Billet unBillet, String unTag){
        ArrayList<String> tags = unBillet.getTags();

        tags.remove(unTag);
    }
}
