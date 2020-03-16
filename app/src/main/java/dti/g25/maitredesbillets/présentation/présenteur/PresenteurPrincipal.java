package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;
import android.content.Intent;

import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.domaine.interacteur.GestionProjet;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurPrincipal;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.ui.activité.NouveauProjetActivity;

public  class PresenteurPrincipal implements ContratVuePresenteurPrincipal.IPresenteurPrincipal {
    public static final String EXTRA_TITRE_NEW_PROJET="dti.g25.maitre-des-tickets.titre_new_projet";
    public static final int NOUVEAU_PROJET=54;

    private ContratVuePresenteurPrincipal.IVuePrincipale _vue;
    private Modèle _modele;
    private Activity _activite;

    /**
     * Constructeur du presenteur
     * @param activite Activité dans laquelle le présenteur agis qui sera l'activité pricipale
     * @param vue La vue qui est relié au présenteur, qui sera la vue principale
     * @param modele le modele du MVP
     */
    public PresenteurPrincipal(Activity activite, ContratVuePresenteurPrincipal.IVuePrincipale vue, Modèle modele) {
        _activite=activite;
        _modele=modele;
        _vue=vue;
    }


    /**
     * Lorsque appelé, cette méthode crée l'intention pour
     * l'activité 'NouveauProjet' et débute cette activité
     */
    @Override
    public void requeteNouveauProjet() {
        Intent intentNewProjet=new Intent(_activite, NouveauProjetActivity.class);
        _activite.startActivityForResult(intentNewProjet, NOUVEAU_PROJET);
    }

    /**
     * Crée l'intention pour acceder à un projet
     * et débute l'activité
     */
    @Override
    public void requeteAccederProjet(int position) {
    }

    /**
     * Crée l'intention pour modifier un projet et débutel 'activité
     * @param position la position dans le rv du projet a modifier
     */
    @Override
    public void requeteModificationProjet(int position) {

    }

    /**
     * Supprime le projet du modele et raffraichis la vue
     * @param position position du projet dans le rv
     */
    @Override
    public void requeteSupprimerProjet(int position) {
        _modele.retirerProjetParPos(position);
        _vue.rafraichir();
    }

    /**
     * @return le nombre de projets dans le modele
     */
    @Override
    public int getNbItems() {
        return _modele.getProjets().size();
    }

    /**
     * @param position du projet
     * @return le titre du projet
     */
    @Override
    public String getItemString(int position){
        return _modele.getProjetParPos(position).toString();
    }


    /**
     * Réagis selon les activité qui ont été faite précèdemment et raffraichi la vue
     * @param requestCode code de l'activité précèdente qui est un numéro
     * @param resultCode chiffre qui indique l'état dans laquelle l'activité (exemple 0 si elle été annulé)
     * @param data les données de l'intention, ou il y aura le titre du nouveau projet
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        GestionProjet gestionProjet= new GestionProjet();
        if(requestCode== NOUVEAU_PROJET && resultCode==Activity.RESULT_OK){
            String titre=data.getStringExtra(EXTRA_TITRE_NEW_PROJET);
            assert titre != null;
            if(!titre.equals("")){
                double generationNombre= Math.floor(Math.random()*Math.floor(100005449));
                 Projet nouveauProjet=gestionProjet.creerProjet(titre, (int) generationNombre);
                _modele.ajouterUnProjet(nouveauProjet);
                _vue.rafraichir();
            }
        }
    }
}
