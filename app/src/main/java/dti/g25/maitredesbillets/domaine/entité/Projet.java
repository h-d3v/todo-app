package dti.g25.maitredesbillets.domaine.entité;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.LinkedList;
import java.util.Objects;

public class Projet {

    private String titre;
    private LinkedList<Billet> billets;


    public Projet(String titre) {
        this.titre = titre;
        billets = new LinkedList<Billet>();
    }

    //Constructeur complet
    public Projet(String titre,  LinkedList<Billet> billets) {
        this.titre = titre;
        this.billets=billets;

    }

    //Getters
    public String getTitre() {
        return titre;
    }




    //Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }



    public LinkedList<Billet> getBillets() {
        return billets;
    }

    public void setBillets(LinkedList<Billet> billets) {
        this.billets = billets;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projet projet = (Projet) o;

        if (!Objects.equals(titre, projet.titre)) return false;
        return Objects.equals(billets, projet.billets);
    }

}
