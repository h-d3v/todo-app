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



    /***
     *  Constructeur + que minimum
     * @param titre
     * @param description
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

    /***
     *
     * @return le titre du billet
     */
    public String getTitre() {
        return titre;
    }

    /***
     *
     * @return  La description du billet
     */
    public String getDescription() {
        return description;
    }

    /***
     *
     * @return bollean le billet est en cours
     */
    public boolean estEnCours() {
        return enCours;
    }

    /***
     *
     * @return id du projet associe
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

    //Setters

    /***
     *
     * @param titre
     */
    public void setTitre(String titre) {
        if(titre == "" || titre == null){

        } else {
            this.titre = titre;
        }
    }

    /***
     *
     * @param description
     */
    public void setDescription(String description) {
        if(titre == "" || titre == null){

        } else {
            this.description = description;
        }
    }

    /***
     *
     * @param enCours
     */
    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    /***
     *
     * @param projetId
     */
    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    /***
     *
     * @param tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    //méthode

    /***
     * ferme le billet met enCours a false
     */
    public void fermer(){
        this.enCours = false;
    }

    /***
     * ouvre le billet met enCours a true
     */
    public void ouvrir(){
        this.enCours = true;
    }

    public void ajouterTag(Tag tag){
        tags.add(tag);
    }

    /**
     * supprime une etiquette
     * @param tag
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
