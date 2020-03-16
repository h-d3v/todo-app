package dti.g25.maitredesbillets.présentation.modèle;

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
}
