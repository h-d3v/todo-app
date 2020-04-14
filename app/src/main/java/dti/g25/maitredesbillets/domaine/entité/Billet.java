package dti.g25.maitredesbillets.domaine.entité;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Billet {
    private String titre;  private String description;
    private boolean enCours;
    private int projetId;
    private List<Tag> tags;


<<<<<<< HEAD

    public Billet() {
        this.titre = "";
        this.description = "";
        this.enCours = true;
        this.projetId = 1;
        this.tags=new ArrayList<>();
    }



    /***
     *  Constructeur + que minimum
     * @param titre
     * @param description
=======
    /**
     * Constructeur de billet seulement avec un nom et une description
     * @param titre Le nom du billet
     * @param description La description detaillée  du billet
>>>>>>> 20-javadoc
     */
    public Billet(String titre, String description){
        this.titre = titre;
        this.description = description;
        this.tags=new ArrayList<>();
    }

<<<<<<< HEAD

    /****
     * Constructeur minimum
     * @param titre
     * @param description
     * @param projetId
     */
    public Billet(String titre, String description, int projetId) {
=======
    /**
     * Constructeur de billet complet
     *
     * @param titre Le nom du billet
     * @param description La description detaillée  du billet
     * @param ticketId le ID du ticket dans la base de données
     * @param projetId le ID du projet dans la base de données
     */
    //Constructeur Complet
    public Billet(String titre, String description, int ticketId, int projetId) {
>>>>>>> 20-javadoc
        this.titre = titre;
        this.description = description;
        this.enCours = true; //Un tickets sera toujours en cours juqu'à tant qu'il soit fermé
        this.projetId = projetId;
        this.tags=new ArrayList<>();
        // Il n'est pas impératif que le billet aie des tags
    }

<<<<<<< HEAD
    /***
     * /Constructeur complet
     * @param titre
     * @param description
     * @param enCours
     * @param ticketId
     * @param projetId
     * @param tags
     */
    public Billet(String titre, String description, boolean enCours, int ticketId, int projetId, List<Tag> tags) {
        this.titre = titre;
        this.description = description;
        this.enCours = enCours;
        this.projetId = projetId;
        this.tags = tags;
    }

    /***
     *
     * @return le titre du billet
=======
    /**
     *
     * @return Nom du billet en String
>>>>>>> 20-javadoc
     */
    public String getTitre() {
        return titre;
    }

<<<<<<< HEAD
    /***
     *
     * @return  La description du billet
=======
    /**
     *
     * @return Descritopn du billet en String
>>>>>>> 20-javadoc
     */
    public String getDescription() {
        return description;
    }

<<<<<<< HEAD
    /***
     *
     * @return bollean le billet est en cours
=======
    /**
     *
     * @return État du billet en Boléen
>>>>>>> 20-javadoc
     */
    public boolean estEnCours() {
        return enCours;
    }

<<<<<<< HEAD
    /***
     *
     * @return id du projet associe
=======
    /**
     *
     * @return ID du Billet en int
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     *
     * @return ID du Projet en int
>>>>>>> 20-javadoc
     */
    public int getProjetId() {
        return projetId;
    }

<<<<<<< HEAD
    /***
     * Les tags associes au bilet
     * @return
     */
    public List<Tag> getTags() {
        return tags;
    }

    //Setters

    /***
     *
     * @param titre
=======
    /**
     *
     * @return Les tags du billet en ArrayList
     */
    public ArrayList<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param titre le nom du billet en String
>>>>>>> 20-javadoc
     */
    public void setTitre(String titre) {
        if(titre == "" || titre == null){

        } else {
            this.titre = titre;
        }
    }

<<<<<<< HEAD
    /***
     *
     * @param description
=======
    /**
     *
     * @param description La description du billet en String
>>>>>>> 20-javadoc
     */
    public void setDescription(String description) {
        if(titre == "" || titre == null){

        } else {
            this.description = description;
        }
    }

<<<<<<< HEAD
    /***
     *
     * @param enCours
=======
    /**
     *
     * @param enCours L'état du billet en boléen
>>>>>>> 20-javadoc
     */
    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

<<<<<<< HEAD
    /***
     *
     * @param projetId
=======
    /**
     *
     * @param ticketId le ID du ticket en int
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     *
     * @param projetId le ID du projet en int
>>>>>>> 20-javadoc
     */
    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

<<<<<<< HEAD
    /***
     *
     * @param tags
     */
    public void setTags(List<Tag> tags) {
=======
    /**
     *
     * @param tags toutes les tags du billet en ArrayList
     */
    public void setTags(ArrayList<Tag> tags) {
>>>>>>> 20-javadoc
        this.tags = tags;
    }


<<<<<<< HEAD
    /***
     * ferme le billet met enCours a false
=======
    /**
     * Ferme un billet (set le "estEnCours" à false)
>>>>>>> 20-javadoc
     */
    public void fermer(){
        this.enCours = false;
    }

<<<<<<< HEAD
    /***
     * ouvre le billet met enCours a true
=======
    /**
     * Ouvre le billet (set le "estEnCours" à true)
>>>>>>> 20-javadoc
     */
    public void ouvrir(){
        this.enCours = true;
    }

    /**
     * ajoute le tag spécifié en paramètre à l'ArrayList "tags"
     * @param tag Le tag a ajouter a l'ArrayList "tags"
     */
    public void ajouterTag(Tag tag){
        tags.add(tag);
    }

    /**
<<<<<<< HEAD
     * supprime une etiquette
     * @param tag
=======
     * retire le tag spécifié en paramètre de l'ArrayList "tags"
     * @param tag Le tag a retirer de l'ArrayList "tags"
>>>>>>> 20-javadoc
     */
    public void retirerTag(Tag tag){
        if(tag == null){

        } else {
            for(Tag leTag : this.tags){
                if(leTag.getTagId() == tag.getTagId()){
                    tags.remove(leTag);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billet billet = (Billet) o;

        if (enCours != billet.enCours) return false;
        if (projetId != billet.projetId) return false;
        if (!titre.equals(billet.titre)) return false;
        if (!description.equals(billet.description)) return false;
        return tags.equals(billet.tags);
    }


}
