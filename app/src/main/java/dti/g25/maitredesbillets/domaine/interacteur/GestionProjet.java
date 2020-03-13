package dti.g25.maitredesbillets.domaine.interacteur;

import java.util.LinkedList;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;

public class GestionProjet implements IGestionProjet {


    @Override
    public Projet creerProjet(String titre, int id) {
        return new Projet(titre, id);
    }

    @Override
    public void rennomerProjet(Projet unProjet, String newTitre) throws Exception {
        if (unProjet==null||newTitre.equals("")){
            throw new Exception("Le projet ne peut pas etre null et \n" +
                    "le nouveau titre doit contenir au moin un caractere");
        }
        unProjet.setTitre(newTitre);
    }

    public void addBillet(Projet unProjet, Billet unBillet) throws Exception {
        if (unProjet==null||unBillet==null){
            throw new Exception("Le projet ne peut pas etre null ni \n" +
                    "le billet");
        }
        LinkedList<Billet> listeBilletProjet=unProjet.getBillets();
        listeBilletProjet.add(unBillet);
        unProjet.setBillets(listeBilletProjet);
    }

    public void delBillet(Projet unProjet, Billet unBillet) throws Exception {
        if (unProjet==null||unBillet==null){
            throw new Exception("Le projet ne peut pas etre null ni \n" +
                    "le billet");
        }
        LinkedList<Billet> listeBilletProjet=unProjet.getBillets();
        listeBilletProjet.remove(unBillet);
        unProjet.setBillets(listeBilletProjet);
    }



}
