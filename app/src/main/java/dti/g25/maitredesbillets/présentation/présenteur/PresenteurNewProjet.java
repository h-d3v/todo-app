package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;

import android.content.Intent;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurNewProjet;
import dti.g25.maitredesbillets.présentation.modèle.Modele;


public class PresenteurNewProjet implements ContratVuePresenteurNewProjet.IPresenteurNewProjet {
    Activity _activite;
    ContratVuePresenteurNewProjet.IVueNewProjet _vue;
    Modele _modele;


    public static final String EXTRA_TITRE_NEW_PROJET="dti.g25.maitre-des-tickets.titre_new_projet";

    public PresenteurNewProjet(Activity activite, ContratVuePresenteurNewProjet.IVueNewProjet vue, Modele modele) {
        _activite=activite;
        _vue=vue;
        _modele=modele;
    }
    @Override
    public void creationNouveauProjet() {
            Intent donneesRetour = new Intent();
            donneesRetour.putExtra(EXTRA_TITRE_NEW_PROJET, _vue.getTitre());
            _activite.setResult(_activite.RESULT_OK, donneesRetour);
            _activite.finish();
        }
}
