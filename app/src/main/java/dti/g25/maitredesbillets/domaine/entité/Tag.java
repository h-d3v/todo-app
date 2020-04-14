package dti.g25.maitredesbillets.domaine.entité;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Tag {

    private String titre;
    private Couleur couleur;
    private int tagId;


    /**
     * Constructeur d'un tag
     * @param titre le nom du tag en String
     * @param couleur la couleur du tag en String
     * @param tagId le ID du tag en int
     */
    public Tag(String titre, Couleur couleur, int tagId) {
        this.titre = titre;
        this.couleur = couleur;
        this.tagId = tagId;
    }

    /**
     * @return nom du tag en String
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @return Couleur du tag en objet Couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @return le ID du tag en int
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * @param titre nom du tag en String
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     *
     * @param couleur Couleur du tag en Objet Couleur
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     *
     * @param tagId ID du tag en int
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * Pour comparer la classe de l'objet en parametre a tag et son titre + description
     * @param o l'objet a comparer
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return tagId == tag.tagId &&
                Objects.equals(titre, tag.titre) &&
                Objects.equals(couleur, tag.couleur);
    }

}
