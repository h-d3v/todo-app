package dti.g25.maitredesbillets.domaine.entité;

import java.util.ArrayList;

public class Billet {
    private String titre;  private String description;
    private boolean enCours;
    private int ticketId;
    private int projetId;
    private ArrayList<Tag> tags;

    /**
     * Constructeur de billet seulement avec un nom et une description
     * @param titre Le nom du billet
     * @param description La description detaillée  du billet
     */
    public Billet(String titre, String description){
        this.titre = titre;
        this.description = description;
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
        this.ticketId = ticketId;
        this.projetId = projetId;
        this.tags = new ArrayList();
        // Il n'est pas impératif que le billet aie des tags
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
     * @return ID du Billet en int
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     *
     * @return ID du Projet en int
     */
    public int getProjetId() {
        return projetId;
    }

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
     * @param ticketId le ID du ticket en int
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     *
     * @param projetId le ID du projet en int
     */
    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    /**
     *
     * @param tags toutes les tags du billet en ArrayList
     */
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
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
}
