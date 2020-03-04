package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;

/**
 * Interacteur implémentant le cas d'usage "Creer"
 */

 public class BilletInteracteur {

     protected IPersistanceBillet persisteur;

     public BilletInteracteur(IPersistanceBillet persisteur) {
         this.persisteur=persisteur;
     }

     public void Creer(String titre, String description, int ticketId, int projetId) throws  PersistanceException{
         Billet billet = new Billet(titre, description, ticketId, projetId)
         persisteur.sauvegarder(billet);
     }

     public void modifier(String titre, String description) throws PersistanceException{
         Billet billet = persisteur.récupérer;
         billet.setTitre(titre);
         billet.setDescription(description);
     }
     public void fermer() throws PersistanceException{
        Billet billet = persisteur.récupérer();
        billet.fermer();
        persisteur.sauvegarder(billet);
     }

     public void ouvrir() throws PersistanceException{
        Billet billet = persisteur.récupérer();
        billet.ouvrir();
        persisteur.sauvegarder(billet);
     }

     public void getTicket() throws PersistanceExceptionq{
        return persisteur.récupérer();
     }

     public void assignerTag(Tag tag) throws PersistanceException{
         Billet billet = persisteur.récupérer();
         billet.ajouterTag(tag);
         persisteur.sauvegarder(billet)
     }

     public void retirerTag(Tag tag) throws PersistanceException{
         Billet billet = persisteur.récupérer();
         billet.retirerTag(tag);
         persisteur.sauvegarder(billet);
     }

 }
