package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;
import android.content.Intent;

import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.domaine.interacteur.GestionProjet;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurPrincipal;
import dti.g25.maitredesbillets.présentation.modèle.Modele;
import dti.g25.maitredesbillets.ui.activité.NouveauProjetActivity;

public  class PresenteurPrincipal implements ContratVuePresenteurPrincipal.IPresenteurPrincipal {
    public static final String EXTRA_TITRE_NEW_PROJET="dti.g25.maitre-des-tickets.titre_new_projet";
    public static final int NOUVEAU_PROJET=54;

    private ContratVuePresenteurPrincipal.IVuePrincipale _vue;
    private Modele _modele;
    private Activity _activite;

    public PresenteurPrincipal(Activity activite, ContratVuePresenteurPrincipal.IVuePrincipale vue, Modele modele) {
        _activite=activite;
        _modele=modele;
        _vue=vue;
    }


    @Override
    public void requeteNouveauProjet() {
        System.out.println("000000000000000");
        Intent intentNewProjet=new Intent(_activite, NouveauProjetActivity.class);
        _activite.startActivityForResult(intentNewProjet, NOUVEAU_PROJET);
    }

    @Override
    public void requeteAccederProjet(int position) {

    }

    @Override
    public void requeteModificationProjet(int position) {

    }

    @Override
    public int getNbItems() {
        return _modele.getProjets().size();
    }

    @Override

    public String getItemString(int position){
        return _modele.getProjetParPos(position).toString();
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        GestionProjet gestionProjet= new GestionProjet();
        if(requestCode== NOUVEAU_PROJET && resultCode==Activity.RESULT_OK){
            String titre=data.getStringExtra(EXTRA_TITRE_NEW_PROJET);

            if(titre!="Nouveau titre"){
                Double generationNombre= Math.floor(Math.random()*Math.floor(100005449));

                 Projet nouveauProjet=gestionProjet.creerProjet( titre,generationNombre.intValue());
                _modele.ajouterUnProjet(nouveauProjet);
                _vue.rafraichir();
            }
        }
    }
}
