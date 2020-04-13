package dti.g25.maitredesbillets.domain.entité;

import org.junit.Test;

import dti.g25.maitredesbillets.domaine.entité.Billet;

import static org.junit.Assert.*;

public class BilletTest {

    Billet billetDeTest = new Billet("le Titre","Une courte description",1);

    @Test
    public void creation_fonctionne() {
        assertEquals(billetDeTest, new Billet("le Titre", "Une courte description", 1));
    }

    @Test
    public void getTitre_fonctionne() {
        assertEquals(billetDeTest.getTitre(), "le Titre" );
    }

    @Test
    public void setTitre_fonctionne() {
        billetDeTest.setTitre("Titre modifié");
        assertEquals(billetDeTest.getTitre(), "Titre modifié" );
    }
}

