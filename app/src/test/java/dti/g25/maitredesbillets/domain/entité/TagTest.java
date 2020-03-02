package dti.g25.maitredesbillets.domain.entité;

import org.junit.Test;

import dti.g25.maitredesbillets.domaine.entité.Tag;

import static org.junit.Assert.*;

public class TagTest {

    Tag tagDeTest = new Tag("le Titre", "Mauve", 1);

    @Test
    public void creation_fonctionne() {
        assertEquals(tagDeTest, new Tag("le Titre", "Mauve", 1));
    }

    @Test
    public void getTitre_fonctionne() {
        assertEquals(tagDeTest.getTitre(), "le Titre" );
    }

    @Test
    public void setTitre_fonctionne() {
        tagDeTest.setTitre("Titre modifié");
        assertEquals(tagDeTest.getTitre(), "Titre modifié" );
    }

    @Test
    public void getCouleur_fonctionne() {
        assertEquals(tagDeTest.getCouleur(), "Mauve" );
    }

    @Test
    public void setCouleur_fonctionne() {
        tagDeTest.setTitre("Blanco");
        assertEquals(tagDeTest.getCouleur(), "Blanco" );
    }
}
