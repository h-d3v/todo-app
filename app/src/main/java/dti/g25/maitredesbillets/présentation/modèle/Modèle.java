package dti.g25.maitredesbillets.présentation.modèle;

<<<<<<< HEAD
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;

import java.util.ArrayList;

public class Modèle {
    ArrayList<Billet> billets;

    public Modèle(ArrayList<Billet> billets) {
        this.billets = billets;
    }

    public Modèle() {
        billets = new ArrayList<Billet>();
    }

    public void modifierBillets(int position, String titre, String description){
        Billet billet =  CréationBillet.créerBillet(titre, description);
        if(position > -1){
            billets.set(position, billet);
        } else {
            billets.add(billet);
        }
    }

    public void supprimerBillet(int position){
        billets.remove(billets.get(position));
    }

    public ArrayList<Billet> getBillets(){
        return this.billets;
    }

    public void setBillets(ArrayList<Billet> billets){
        this.billets = billets;
    }
=======
import dti.g25.maitredesbillets.domaine.entité.Projet;

import java.util.LinkedList;

/**
 * TODO: 3/13/2020 la persistance
 */
public class Modèle{
    private LinkedList<Projet> projets;

    /**
     * Constructeur du modele
     */
    public Modèle(){
        projets=new LinkedList<>();
    }

    /**
     * @return les projets dans le modele
     */
    public LinkedList<Projet> getProjets() {
        return projets;
    }

    /**
     * Ajoute un projet a la liste de projet
     * @param projet le projet a ajouter au modele
     */
    public void ajouterUnProjet(Projet projet){
        projets.add(projet);
    }

    /**
     * @param position la position du projet dans la liste projets
     * @return le projet à la position passée en param
     */
    public Projet getProjetParPos(int position){
        return projets.get(position);
    }

    /**
     * Retire un projet de la liste projets selon sa position
     * @param postion la position du projet à retirer
     */
    public void retirerProjetParPos(int postion){ projets.remove(postion);}

>>>>>>> 8-visualition-de-projet
}
