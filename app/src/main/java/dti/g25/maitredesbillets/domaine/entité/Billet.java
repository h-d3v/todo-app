package dti.g25.maitredesbillets.domaine.entité;

import java.util.ArrayList;
import java.util.Objects;

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

    //Constructeur minimum
    public Billet(String titre, String description, int ticketId, int projetId) {
        this.titre = titre;
        this.description = description;
        this.enCours = true; //Un tickets sera toujours en cours juqu'à tant qu'il soit fermé
        this.ticketId = ticketId;
        this.projetId = projetId;
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
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billet billet = (Billet) o;
        return enCours == billet.enCours &&
                ticketId == billet.ticketId &&
                projetId == billet.projetId &&
                titre.equals(billet.titre) &&
                description.equals(billet.description);
    }



}