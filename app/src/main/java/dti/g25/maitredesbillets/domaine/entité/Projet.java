package dti.g25.maitredesbillets.domaine.entité;

import androidx.annotation.NonNull;
import java.util.LinkedList;

public class Projet {

    private LinkedList<Billet> billets;
    private String titre;
    private int id;

    /**
     * //Constructeur vide pour les tests
     */
    public Projet() {
        this.titre = "Test";
        this.id = 1;
        this.billets=new LinkedList<>();
    }

    /**
     * Constructeur minimum
     * @param titre le titre du projet
     * @param id l'id du projet
     */
    public Projet(String titre, int id) {
        this.titre = titre;
        this.id = id;
        this.billets=new LinkedList<>();
    }

    /**
     * Constructeur complet
     * @param titre le titre du projet
     * @param id l'id du projet
     * @param billets la liste des billets du projet,au cas elle existe deja
     */
    public Projet(String titre, int id, LinkedList<Billet> billets) {
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
    public LinkedList<Billet> getBillets() {
        return billets;
    }

    /**
     * @param billets liste de billets du projet
     */
    public void setBillets(LinkedList<Billet> billets) {
        this.billets = billets;
    }

    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return le toString, qui est le titre du projet
     */
    @NonNull
    @Override
    public String toString() {
        return this.titre;
    }


}
