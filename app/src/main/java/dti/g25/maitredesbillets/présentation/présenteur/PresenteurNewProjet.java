package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;

import android.content.Intent;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurNewProjet;
import dti.g25.maitredesbillets.présentation.modèle.Modele;


public class PresenteurNewProjet implements ContratVuePresenteurNewProjet.IPresenteurNewProjet {
    Activity _activite;
    ContratVuePresenteurNewProjet.IVueNewProjet _vue;
    Modele _modele;


    /**
     * extra our le titre du nouveau projet
     */
    public static final String EXTRA_TITRE_NEW_PROJET="dti.g25.maitre-des-tickets.titre_new_projet";

    /**
     * Constructeur du presenteur pour le nouveau projet
     * @param activite l'activite, qui sera l'activité du nouveau projet
     * @param vue la vue pour le nouveau projet
     * @param modele le modele MVP
     */
    public PresenteurNewProjet(Activity activite, ContratVuePresenteurNewProjet.IVueNewProjet vue, Modele modele) {
        _activite=activite;
        _vue=vue;
        _modele=modele;
    }

    /**
     * cree le nouveau projet à partir du titre qui est entré
     * par l'utilisateur dans la vue et termine l'activité
     */
    @Override
    public void creationNouveauProjet() {
            Intent donneesRetour = new Intent();
            donneesRetour.putExtra(EXTRA_TITRE_NEW_PROJET, _vue.getTitre());
            _activite.setResult(Activity.RESULT_OK, donneesRetour);
            _activite.finish();
        }
}
