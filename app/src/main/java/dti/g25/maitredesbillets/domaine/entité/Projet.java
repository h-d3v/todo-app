package dti.g25.maitredesbillets.domaine.entité;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.LinkedList;
import java.util.Objects;

public class Projet {
    /**
     *
     */
    private LinkedList<Billet> billets;
    private String titre;
    private int id;

    //Constructeur vide pour les tests
    public Projet() {
        this.titre = "Test";
        this.id = 1;
        this.billets=new LinkedList<>();
    }

    //Constructeur minimum
    public Projet(String titre, int id) {
        this.titre = titre;
        this.id = id;
        this.billets=new LinkedList<>();
    }

    //Constructeur complet
    public Projet(String titre, int id, LinkedList<Billet> billets) {
        this.titre = titre;
        this.id = id;
        this.billets=billets;
    }


    //Getters
    public String getTitre() {
        return titre;
    }



    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }




    @NonNull
    @Override
    public String toString() {
        return this.titre;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projet projet = (Projet) o;
        return id == projet.id &&
                Objects.equals(billets, projet.billets) &&
                Objects.equals(titre, projet.titre);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(billets, titre, id);
    }
}
