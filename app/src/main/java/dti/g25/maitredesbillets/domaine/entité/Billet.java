package dti.g25.maitredesbillets.domaine.entité;

import java.util.ArrayList;

public class Billet {
    private String titre;
    private String description;
    private boolean enCours;
    private int ticketId;
    private int projetId;
    private ArrayList<Tag> tags;


    //Constructeur vide
    public Billet() {
        this.titre = "";
        this.description = "";
        this.enCours = true;
        this.ticketId = 1;
        this.projetId = 1;
    }

    //Constructeur + que minimum
    public Billet(String titre, String description){
        this.titre = titre;
        this.description = description;
    }

    //Constructeur minimum
    public Billet(String titre, String description, int ticketId, int projetId) {
        this.titre = titre;
        this.description = description;
        this.enCours = true; //Un tickets sera toujours en cours juqu'à tant qu'il soit fermé
        this.ticketId = ticketId;
        this.projetId = projetId;
        this.tags = new ArrayList();
        // Il n'est pas impératif que le billet aie des tags
    }

    //Constructeur complet
    public Billet(String titre, String description, boolean enCours, int ticketId, int projetId, ArrayList<Tag> tags) {
        this.titre = titre;
        this.description = description;
        this.enCours = enCours;
        this.ticketId = ticketId;
        this.projetId = projetId;
        this.tags = tags;
    }

    //Getters
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public boolean estEnCours() {
        return enCours;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getProjetId() {
        return projetId;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    //Setters
    public void setTitre(String titre) {
        if(titre == "" || titre == null){

        } else {
            this.titre = titre;
        }
    }

    public void setDescription(String description) {
        if(titre == "" || titre == null){

        } else {
            this.description = description;
        }
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    //méthode

    public void fermer(){
        this.enCours = false;
    }

    public void ouvrir(){
        this.enCours = true;
    }

    public void ajouterTag(Tag tag){
        tags.add(tag);
    }

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
}
