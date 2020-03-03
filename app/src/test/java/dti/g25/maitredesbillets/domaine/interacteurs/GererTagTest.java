package dti.g25.maitredesbillets.domaine.interacteurs;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Tag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GererTagTest {
    GererTag gererTag;
    Billet billetDeTest;
    Tag tagDeTest;
    @Before
    public void initialiser() {
        gererTag = new GererTag();
        billetDeTest = new Billet("le Titre", "Une courte description", 1, 1);
        tagDeTest = new Tag("le Titre", "Mauve", 1);
    }
    @Test
    public void creerTag() {
        Tag tagCree = gererTag.creerTag("le Titre", "Mauve", 1);
        assertEquals(tagCree, tagDeTest);
    }

    @Test
    public void modifierCouleur() {
        Tag tagCree = gererTag.creerTag("le Titre", "Bleu", 1);
        gererTag.modifierCouleur(tagCree,"Mauve");
        assertEquals(tagCree, tagDeTest);
    }

    @Test
    public void modifierTitre() {
        Tag tagCree = gererTag.creerTag("le mauvais Titre", "Mauve", 1);
        gererTag.modifierTitre(tagCree,"le Titre");

        assertEquals(tagCree, tagDeTest);
    }

    @Test
    public void supprimerTag() {

    }
}