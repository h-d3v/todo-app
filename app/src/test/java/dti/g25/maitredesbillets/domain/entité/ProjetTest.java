package dti.g25.maitredesbillets.domain.entité;

import org.junit.Test;

import dti.g25.maitredesbillets.domaine.entité.Projet;

import static org.junit.Assert.*;

public class ProjetTest {

    Projet projetDeTest = new Projet("le Titre");

    @Test
    public void creation_fonctionne() {
<<<<<<< HEAD
        assertEquals(projetDeTest.getTitre(), new Projet("le Titre").getTitre());
=======
        assertEquals(projetDeTest, new Projet("le Titre"));
>>>>>>> origin/16-supprimer-les-id-des-entites
    }

    @Test
    public void getTitre_fonctionne() {
        assertEquals(projetDeTest.getTitre(), "le Titre" );
    }

    @Test
    public void setTitre_fonctionne() {
        projetDeTest.setTitre("Titre modifié");
        assertEquals(projetDeTest.getTitre(), "Titre modifié" );
    }


}

