package dti.g25.maitredesbillets.domaine.interacteurs;

import dti.g25.maitredesbillets.domaine.entité.Couleur;
import dti.g25.maitredesbillets.domaine.entité.Tag;

public interface IPersisteurTag {
    boolean supprimmerTag(Tag unTag) throws PersistanceException;
    boolean modifierNomTag(Tag unTag, String unNom) throws PersistanceException;
    boolean modifierCouleurTag(Tag unTag, Couleur uneCouleur ) throws PersistanceException;
    boolean ajouterTag(Tag unTag)throws PersistanceException;
    Tag recupererTag(Tag unTag)throws PersistanceException;

}
