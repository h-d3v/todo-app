package dti.g25.maitredesbillets.présentation.modèle;


import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import java.util.LinkedList;
import java.util.ArrayList;

public class Modèle {
    LinkedList<Projet> projets;
    ArrayList<Billet> billets;

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

}
