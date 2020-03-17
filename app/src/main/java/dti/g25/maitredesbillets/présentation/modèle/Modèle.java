package dti.g25.maitredesbillets.présentation.modèle;


import android.content.Context;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.modele.dao.DAO;
import dti.g25.maitredesbillets.modele.dao.DAOFactory;

import java.util.ArrayList;
import java.util.List;

public class Modèle {
    List<DAO<Projet>> projets;
    ArrayList<Billet> billets;
    Context context;
    DAOFactory daoFactory;

    public void modifierBillets(int positionProjet, int positionBillet, String titre, String description){
        Billet billet =  CréationBillet.créerBillet(titre, description);
        if(positionBillet > -1){
            getProjetParPos(positionProjet).getBillets().set(positionBillet, billet);
        } else {
            getProjetParPos(positionProjet).getBillets().add(billet);
        }
    }

    public void supprimerBillet(int positionProjet, int positionBillet){
        getProjetParPos(positionProjet).getBillets().remove(getProjetParPos(positionProjet).getBillets().get(positionBillet));
    }

    public ArrayList<Billet> getBillets(int positionProjet){
        return getProjetParPos(positionProjet).getBillets();
    }

    public void setBillets(int positionProjet, ArrayList<Billet> billets){
         getProjetParPos(positionProjet).setBillets(billets);
    }

    /**
     * Constructeur du modele
     */
    public Modèle(Context context, DAOFactory daoFactory){
        this.context=context;
        this.daoFactory=daoFactory;
        projets=daoFactory.creerListeDAOProjet(context);
        ;
    }

    /**
     * @return les projets dans le modele
     */
    public List<DAO<Projet>> getDAOProjets() {
        return projets;
    }

    /**
     * Ajoute un projet a la liste de projet
     * @param projet le projet a ajouter au modele
     */
    public void ajouterUnProjet(Projet projet){
        DAO<Projet> projetDAO= daoFactory.creerDAOProjet(context);
        projetDAO.creer(projet);        ;
    }

    /**
     * @param position la position du projet dans la liste projets
     * @return le projet à la position passée en param
     */
    public Projet getProjetParPos(int position){
        return projets.get(position).lire();
    }

    /**
     * Retire un projet de la liste projets selon sa position
     * @param postion la position du projet à retirer
     */
    public boolean retirerProjetParPos(int postion){ return projets.get(postion).supprimer();}

    public void rafraichir(){
        projets=daoFactory.creerListeDAOProjet(context);
    }

}
