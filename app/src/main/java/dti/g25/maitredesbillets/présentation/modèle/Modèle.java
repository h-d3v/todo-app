package dti.g25.maitredesbillets.présentation.modèle;


import android.content.Context;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAO;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAOFactory;

import java.util.List;

public class Modèle {
    List<DAO<Projet>> projets;
    List<DAO<Billet>> billets;
    Context context;
    DAOFactory daoFactory;

    /**
     * permet d'ajouter un billet au DAO
     * @param projetPosition positon du projet actuel
     * @param billet le billet a ajouter
     */
    public void ajouterDAOBillet(int projetPosition, Billet billet){
        daoFactory.ajouterBilletAuProjet(context,getProjetDAOParPos(projetPosition), billet);
    }

    /**
     * Permet de modifier les paramêtre d'un billet
     * @param positionProjet La postion du projet actuel
     * @param positionBillet la postion du billet modifié
     * @param titre le nouveau titre du billet
     * @param description la nouvelle description du billet
     * @throws Exception
     */
    public void modifierBillets(int positionProjet, int positionBillet, String titre, String description) throws  Exception{
        Billet billet =  CréationBillet.créerBillet(titre, description);
        if(positionBillet > -1){
            getProjetParPos(positionProjet).getBillets().set(positionBillet, billet);
        }
    }


    public void modifierDAOBillets(int positionProjet, int positionBillet, String titre, String description) throws  Exception{
        Billet billet =  CréationBillet.créerBillet(titre, description);
        if(positionBillet > -1){
            getDAOBillets(positionProjet).get(positionBillet).modifier(billet);
        }
    }

    /**
     * permet de suprimmer  un billet de la lsite de billet
     * @param positionBillet la postion du billet à supprimer
     */
    public void supprimerBillet(int positionBillet){
        billets.get(positionBillet).supprimer();
    }

    /**
     * prmet d'obtenir tout les billet d'un projet
     * @param positionProjet
     * @return la lsite de billet
     */
    public List<Billet> getBillets(int positionProjet){
        return getProjetParPos(positionProjet).getBillets();
    }

    /**
     * Permet d'obtenir tout les billet du projet dans la BD
     * @param positionProjet positon du projet actuel
     * @return la liste de billets
     */
    public List<DAO<Billet>> getDAOBillets(int positionProjet){
        return daoFactory.creerListeDAOBilletParProjet(context, getProjetDAOParPos(positionProjet));
    }

    /**
     * Permet de cahnger les bilelt de la bd
     * @param positionProjet la postion du projet acutellement
     */
    public void setDaoBillets(int positionProjet){
        billets= daoFactory.creerListeDAOBilletParProjet(context, getProjetDAOParPos(positionProjet));
    }


    /**
     * Constructeur du modele
     */
    public Modèle(Context context, DAOFactory daoFactory){
        this.context=context;
        this.daoFactory=daoFactory;
        projets=daoFactory.creerListeDAOProjet(context);
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
        projetDAO.creer(projet);
    }

    /**
     * @param position la position du projet dans la liste projets
     * @return le projet à la position passée en param
     */
    public Projet getProjetParPos(int position){
        return projets.get(position).lire();
    }

    /**
     * Permet d'obtenir un projet par sa postion dnas la lsite
     * @param position la postion d'un Projet
     * @return le projet
     */
    public DAO<Projet> getProjetDAOParPos(int position){return projets.get(position);}

    /**
     * Retire un projet de la liste projets selon sa position
     * @param postion la position du projet à retirer
     */
    public boolean retirerProjetParPos(int postion){ return projets.get(postion).supprimer();}

    public void rafraichir(){
        projets=daoFactory.creerListeDAOProjet(context);
    }

}
