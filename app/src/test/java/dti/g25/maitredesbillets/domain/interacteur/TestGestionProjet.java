package dti.g25.maitredesbillets.domain.interacteur;

import org.junit.Test;


import java.util.LinkedList;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.domaine.interacteur.GestionProjet;

import static org.junit.Assert.assertEquals;

public class TestGestionProjet {
    Billet billetDeTest = new Billet("le Titre", "Une courte description", 1, 1);
    Billet billetDeTest2 = new Billet("le Titre", "Une courte description", 2, 1);
    Projet projetTest=new Projet();
    GestionProjet gestionProjet= new GestionProjet();

    @Test  public void testRennomerProjet() throws Exception {
        String nouveauTitre="Un nouveau titre";
        gestionProjet.rennomerProjet(projetTest, nouveauTitre);
        assertEquals(projetTest.getTitre(), nouveauTitre);
    }

    @Test public void testAjoutBillet() throws Exception {
        LinkedList<Billet> nouvelleListe= new LinkedList<>();
        nouvelleListe.add(billetDeTest);
        gestionProjet.addBillet(projetTest, billetDeTest);
        assertEquals(projetTest.getBillets(),nouvelleListe);
    }

    @Test public void testEnleverBillet() throws Exception {
        LinkedList<Billet> nouvelleListe= new LinkedList<>();
        nouvelleListe.add(billetDeTest);
        nouvelleListe.add(billetDeTest2);
        nouvelleListe.remove(billetDeTest);

        gestionProjet.addBillet(projetTest, billetDeTest);
        gestionProjet.addBillet(projetTest, billetDeTest2);
        gestionProjet.delBillet(projetTest, billetDeTest);

        assertEquals(projetTest.getBillets(),nouvelleListe);
    }



}
