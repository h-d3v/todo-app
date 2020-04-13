package dti.g25.maitredesbillets.domain.entité;

import dti.g25.maitredesbillets.domaine.entité.Couleur;
import org.junit.Test;

import dti.g25.maitredesbillets.domaine.entité.Tag;

import static org.junit.Assert.*;

public class TagTest {

    Tag tagDeTest = new Tag("le Titre", Couleur.BLEU, 1);

    @Test
    public void creation_fonctionne() {
        assertEquals(tagDeTest, new Tag("le Titre", Couleur.BLEU, 1));
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
        assertEquals(tagDeTest.getCouleur(), Couleur.BLEU );
    }

    @Test
    public void setCouleur_fonctionne() {
        tagDeTest.setCouleur(Couleur.BLEU_CIEL);
        assertEquals(tagDeTest.getCouleur(), Couleur.BLEU_CIEL );
    }
}
