package dti.g25.maitredesbillets.domaine.entité;

public class Tag {

    private String titre;
    private String couleur;
    private int tagId;

    //Constructeur vide


    public Tag() {
        this.titre = "";
        this.couleur = "";
        this.tagId = 1;
    }

    //Constructeur complet
    public Tag(String titre, String couleur, int tagId) {
        this.titre = titre;
        this.couleur = couleur;
        this.tagId = tagId;
    }

    //Getters
    public String getTitre() {
        return titre;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getTagId() {
        return tagId;
    }

    //Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
