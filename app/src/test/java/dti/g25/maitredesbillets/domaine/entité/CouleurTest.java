package dti.g25.maitredesbillets.domaine.entité;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CouleurTest {


    @Test
    public void getValeurHexadecimale() {
        assertEquals(Couleur.BLEU.getValeurHexadecimale(), "#0000FF");
    }

    @Test
    public void testToString() {
        assertEquals(Couleur.BLEU.toString(),"bleu");
    }
}