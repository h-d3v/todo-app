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

    public Billet() {
        this.titre = "";
        this.description = "";
        this.enCours = true;
        this.projetId = 1;
        this.tags=new ArrayList<>();
    }



    /**
     * Constructeur de billet seulement avec un nom et une description
     * @param titre Le nom du billet
     * @param description La description detaillée  du billet
     */
    public Billet(String titre, String description){
        this.titre = titre;
        this.description = description;
        this.tags=new ArrayList<>();
    }

    /****
     * Constructeur minimum
     * @param titre
     * @param description
     * @param projetId
     */
    public Billet(String titre, String description, int projetId) {

    }
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
        this.titre = titre;
        this.description = description;
        this.enCours = true; //Un tickets sera toujours en cours juqu'à tant qu'il soit fermé
        this.projetId = projetId;
        this.tags=new ArrayList<>();
        // Il n'est pas impératif que le billet aie des tags
    }

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


    /**
     *
     * @return Nom du billet en String
     */
    public String getTitre() {
        return titre;
    }


    /**
     *
     * @return Descritopn du billet en String
     */
    public String getDescription() {
        return description;
    }


    /**
     *
     * @return État du billet en Boléen
     */
    public boolean estEnCours() {
        return enCours;
    }



    /**
     *
     * @return ID du Projet en int
     */
    public int getProjetId() {
        return projetId;
    }

    /***
     * Les tags associes au bilet
     * @return
     */
    public List<Tag> getTags() {
        return tags;
    }


    /**
     *
     * @param titre le nom du billet en String
     */
    public void setTitre(String titre) {
        if(titre == "" || titre == null){

        } else {
            this.titre = titre;
        }
    }

    /**
     *
     * @param description La description du billet en String
     */
    public void setDescription(String description) {
        if(titre == "" || titre == null){

        } else {
            this.description = description;
        }
    }

    /**
     *
     * @param enCours L'état du billet en boléen
     */
    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }


    /**
     *
     * @param projetId le ID du projet en int
     */
    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }


    /**
     * Ferme un billet (set le "estEnCours" à false)
     */
    public void fermer(){
        this.enCours = false;
    }

    /**
     * Ouvre le billet (set le "estEnCours" à true)
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
     * retire le tag spécifié en paramètre de l'ArrayList "tags"
     * @param tag Le tag a retirer de l'ArrayList "tags"
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
