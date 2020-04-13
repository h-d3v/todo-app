package dti.g25.maitredesbillets.dao;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BilletDAOSQLiteTest {
    String name ="";
    Projet projetCobaye;
    ProjetDAOSQLite projetDAOSQLiteCobaye;
    Billet billetCobaye1, billetCobaye2;
    BilletDAOSQLite billetDAOSQLiteCobaye1, billetDAOSQLiteCobaye2;
    Context context;
    @Before
    public void setUp() {
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        name= sqLiteDatabaseHandler.getDatabaseName();
        context.deleteDatabase(name);
        projetCobaye= new Projet("titre");
        projetDAOSQLiteCobaye= new ProjetDAOSQLite(context);
        projetDAOSQLiteCobaye.creer(projetCobaye);
        billetCobaye1= new Billet("titre1", "desc1");
        billetCobaye2= new Billet("titre2", "desc2");
        billetDAOSQLiteCobaye1= new BilletDAOSQLite(context, projetDAOSQLiteCobaye.getPK());
        billetDAOSQLiteCobaye2= new BilletDAOSQLite(context, projetDAOSQLiteCobaye.getPK());
    }

    @After
    public void tearDown() {
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        name= sqLiteDatabaseHandler.getDatabaseName();
        context.deleteDatabase(name);
        SQLiteConnection.close();
    }

    @Test
    public void creer() {
        assertEquals(billetCobaye1, billetDAOSQLiteCobaye1.creer(billetCobaye1));
    }

    @Test
    public void lire() {
        assertNull(billetDAOSQLiteCobaye1.lire());
        billetDAOSQLiteCobaye1.creer(billetCobaye1);
        assertEquals(billetCobaye1, billetDAOSQLiteCobaye1.lire());
    }

    @Test
    public void modifier() {
        billetDAOSQLiteCobaye1.creer(billetCobaye1);
        Billet billetModifie= billetDAOSQLiteCobaye1.modifier(billetCobaye2);
        assertEquals(billetCobaye2, billetModifie);
    }

    @Test
    public void supprimer() {
        assertNull(billetDAOSQLiteCobaye1.lire());
        billetDAOSQLiteCobaye1.creer(billetCobaye1);
        assertEquals(billetCobaye1, billetDAOSQLiteCobaye1.lire());
        assertTrue(billetDAOSQLiteCobaye1.supprimer());
        assertNull(billetDAOSQLiteCobaye1.lire());
    }

    @Test
    public void getPK() {
        assertEquals(-1, billetDAOSQLiteCobaye1.getPK());
        billetDAOSQLiteCobaye1.creer(billetCobaye1);
        assertEquals(1, billetDAOSQLiteCobaye1.getPK());
    }
}