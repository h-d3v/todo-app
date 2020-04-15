package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;
import android.content.Intent;


import dti.g25.maitredesbillets.présentation.ContratVuePresenteurVoirDescBillet;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;

public class PresenteurVoirDescBillet implements ContratVuePresenteurVoirDescBillet.IPresenteurVoirDescBillet {

    private ContratVuePresenteurVoirDescBillet.IVueVoirDescBillet _vue;
    private Modèle _modele;
    private Activity _activite;
    private int _positionBillet;
    private int _positionProjet;


    /**
     * Constructeur du presenteur
     * @param activite Activité dans laquelle le présenteur agis qui sera l'activité pricipale
     * @param vue La vue qui est relié au présenteur, qui sera la vue principale
     * @param modele le modele du MVP
     */
    public PresenteurVoirDescBillet(Activity activite, ContratVuePresenteurVoirDescBillet.IVueVoirDescBillet vue, Modèle modele, int positionBillet, int positionProjet ) {
        _positionBillet=positionBillet;
        _activite=activite;
        _modele=modele;
        _vue=vue;
        _positionProjet=positionProjet;
    }


    @Override
    public String getTitreBillet() {
        String titre=_modele.getDAOBillets(_positionProjet).get(_positionBillet).lire().getTitre();
        return titre;
    }

    @Override
    public String getDescBillet() {
        String desc=_modele.getDAOBillets(_positionProjet).get(_positionBillet).lire().getDescription();
        return desc;
    }




}
