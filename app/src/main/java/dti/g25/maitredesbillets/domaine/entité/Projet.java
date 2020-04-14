package dti.g25.maitredesbillets.domaine.entité;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projet {

    private List<Billet> billets;
    private String titre;
    private int id;

    /**
     * //Constructeur vide pour les tests
     */
    public Projet() {
        this.titre = "Test";
        this.id = 1;
        this.billets= new ArrayList<>();
    }

    /**
     * Constructeur minimum
     * @param titre le titre du projet
     */
    public Projet(String titre) {
        this.titre = titre;
        this.billets= new ArrayList<>();
    }

    /**
     * Constructeur complet
     * @param titre le titre du projet
     * @param id l'id du projet
     * @param billets la liste des billets du projet,au cas elle existe deja
     */
    public Projet(String titre, int id, List<Billet> billets) {
        this.titre = titre;
        this.id = id;
        this.billets=billets;
    }


    /**
     *
     * @return titre du projet
     */
    public String getTitre() {
        return titre;
    }


    /**
     *
     * @return id du projet
     */
    public int getId() {
        return id;
    }


    /**
     * Setter pour le titre du projet
     * @param titre du projet
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }


    /**
     * @return liste de billets du projet
     */
    public List<Billet> getBillets() {
        return billets;
    }

    /**
     * @param billets liste de billets du projet
     */
    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return le toString, qui est le titre du projet
     */
    @Override
    public String toString() {
        return this.titre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projet projet = (Projet) o;

        if (id != projet.id) return false;
        if (!billets.equals( projet.billets)) return false;
        return titre.equals(projet.titre);
    }


}
