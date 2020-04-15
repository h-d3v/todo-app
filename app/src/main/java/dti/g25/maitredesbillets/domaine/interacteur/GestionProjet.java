package dti.g25.maitredesbillets.domaine.interacteur;

import java.util.List;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;

public class GestionProjet implements IGestionProjet {


    /**
     * Creer un projet
     * @param titre titre du projet
     * @return un Projet
     */
    @Override
    public Projet creerProjet(String titre) {
        return new Projet(titre);
    }


    /**
     * Rennomer un projet existant
     * @param unProjet le projet a rennomer
     * @param newTitre le nouveau titre de ce projet
     * @throws Exception si le projet est null ou son nouveau titre vide
     */
    @Override
    public void rennomerProjet(Projet unProjet, String newTitre) throws Exception {
        if (unProjet==null||newTitre.equals("")){
            throw new Exception("Le projet ne peut pas etre null et \n" +
                    "le nouveau titre doit contenir au moin un caractere");
        }
        unProjet.setTitre(newTitre);
    }

    /**
     * Ajouter un billet a un projet existant
     * @param unProjet le projet
     * @param unBillet le billet
     * @throws Exception si le projet ou le billet sont null
     */
    @Override
    public void addBillet(Projet unProjet, Billet unBillet) throws Exception {
        if (unProjet==null||unBillet==null){
            throw new Exception("Le projet ne peut pas etre null ni \n" +
                    "le billet");
        }
        List<Billet> listeBilletProjet=unProjet.getBillets();
        listeBilletProjet.add(unBillet);
        unProjet.setBillets(listeBilletProjet);
    }

    /**
     * Supprime un billet dans un projet
     * @param unProjet le projet
     * @param unBillet le billet
     * @throws Exception si le projet ou le billet sont null
     */
    @Override
    public void delBillet(Projet unProjet, Billet unBillet) throws Exception {
        if (unProjet==null||unBillet==null){
            throw new Exception("Le projet ne peut pas etre null ni \n" +
                    "le billet");
        }
        List<Billet> listeBilletProjet=unProjet.getBillets();
        listeBilletProjet.remove(unBillet);
        unProjet.setBillets(listeBilletProjet);
    }

}
