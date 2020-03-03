package dti.g25.maitredesbillets.domaine.entité;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Projet {

    private String titre;
    private String description;
    private int id;
    private int column;
    private String userCourriel;
    private String chefProjet;

    //Constructeur vide
    public Projet() {
        this.titre = "Test";
        this.description = "";
        this.id = 1;
        this.userCourriel = "";
        this.chefProjet = "";
    }

    //Constructeur minimum
    public Projet(String titre, String description, int id, String chefProjet) {
        this.titre = titre;
        this.description = description;
        this.id = id;
        this.chefProjet = chefProjet;
    }

    //Constructeur complet
    public Projet(String titre, String description, int id, int column, String userCourriel, String chefProjet) {
        this.titre = titre;
        this.description = description;
        this.id = id;
        this.column = column;
        this.userCourriel = userCourriel;
        this.chefProjet = chefProjet;
    }

    //Getters
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getColumn() {
        return column;
    }

    public String getUserCourriel() {
        return userCourriel;
    }

    public String getChefProjet() {
        return chefProjet;
    }

    //Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setUserCourriel(String userCourriel) {
        this.userCourriel = userCourriel;
    }

    public void setChefProjet(String chefProjet) {
        this.chefProjet = chefProjet;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projet projet = (Projet) o;
        return id == projet.id &&
                column == projet.column &&
                Objects.equals(titre, projet.titre) &&
                Objects.equals(description, projet.description) &&
                Objects.equals(userCourriel, projet.userCourriel) &&
                Objects.equals(chefProjet, projet.chefProjet);
    }

}
