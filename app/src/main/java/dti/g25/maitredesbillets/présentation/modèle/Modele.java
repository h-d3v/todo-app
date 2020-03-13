package dti.g25.maitredesbillets.présentation.modèle;

import dti.g25.maitredesbillets.domaine.entité.Projet;

import java.util.LinkedList;

public class Modele{
    private LinkedList<Projet> projets;

    public Modele(){
        projets=new LinkedList<>();
    }

    public LinkedList<Projet> getProjets() {
        return projets;
    }

    public void ajouterUnProjet(Projet projet){
        projets.add(projet);
    }

    public void ajouterUnProjetAvecPos(int position,Projet projet){
        projets.add(position, projet);
    }

    public Projet getProjetParPos(int position){
        return projets.get(position);
    }

}
