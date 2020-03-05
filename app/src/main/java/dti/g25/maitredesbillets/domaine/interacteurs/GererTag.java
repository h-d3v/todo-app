package dti.g25.maitredesbillets.domaine.interacteurs;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Couleur;
import dti.g25.maitredesbillets.domaine.entité.Tag;

import java.sql.Connection;
import java.util.ArrayList;

public class GererTag  {
    private IPersisteurTag persisteurTag;
    public GererTag(IPersisteurTag unPersisteurTag){
        persisteurTag=unPersisteurTag;
    }
    public boolean creerTag(Tag unTag) throws PersistanceException{

            if(persisteurTag.recupererTag(unTag)==null){
                persisteurTag.ajouterTag(unTag);
                return true;
            }else return false;

    }

    public boolean modifierCouleur (Tag unTag, Couleur uneCouleur) throws PersistanceException{
        if(persisteurTag.recupererTag(unTag)==null){
            return false;
        }else{
            persisteurTag.modifierCouleurTag(unTag,uneCouleur);
            return true;
        }
    }

    public boolean modifierTitre (Tag unTag, String unTitre) throws PersistanceException{
        if(persisteurTag.recupererTag(unTag)==null){
            return false;
        }else{
            persisteurTag.modifierNomTag(unTag, unTitre);
            return true;
        }
    }

    public boolean spprimerTag(Tag unTag) throws PersistanceException {
        return persisteurTag.supprimmerTag(unTag);

    }
}
