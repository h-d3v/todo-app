package dti.g25.maitredesbillets.domain.interacteur;

import org.junit.Test;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;

import static org.junit.Assert.*;

public class TestCréationBillet {


    //Test de créeation D'un billet simple
    @Test
    public void créerBillet() throws Exception{
        Billet billetTest;
        Billet bonBillet = new Billet("unTitre", "uneDescritpion");
        billetTest = CréationBillet.créerBillet("unTitre", "uneDescritpion");
        assertEquals(billetTest, bonBillet);
    }


    //Test de céreation d'un billet sans descritpion ou sans titire
    @Test
    public void testCréerBillet() throws Exception{

        Billet billetTest;
        Billet bonBillet = null;
        billetTest = CréationBillet.créerBillet("", "");

        assertEquals(billetTest, bonBillet);
    }
}