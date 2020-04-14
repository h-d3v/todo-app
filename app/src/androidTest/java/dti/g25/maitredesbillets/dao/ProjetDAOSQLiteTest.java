package dti.g25.maitredesbillets.dao;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class ProjetDAOSQLiteTest {
    String path ="";
    Projet projetCobaye;
    ProjetDAOSQLite projetDAOSQLiteCobaye;
    Context context;

    @Before
    public  void setUp(){
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        path= sqLiteDatabaseHandler.getWritableDatabase().getPath();
        context.deleteDatabase(path);
        projetCobaye= new Projet("titre");
        projetDAOSQLiteCobaye = new ProjetDAOSQLite(context);

    }

    @After
    public void tearDown(){
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        path= sqLiteDatabaseHandler.getWritableDatabase().getPath();
        context.deleteDatabase(path);
        SQLiteConnection.close();
    }


    @Test
    public void creer() {
        assertEquals(projetDAOSQLiteCobaye.creer(projetCobaye), projetCobaye);
    }

    @Test
    public void lire() {

        ProjetDAOSQLite projetDAOSQLite2= new ProjetDAOSQLite(context);
        projetDAOSQLite2.creer(projetCobaye);
        assertEquals(projetDAOSQLite2.lire(),projetCobaye);
        assertEquals(projetDAOSQLite2.lire().getTitre(), "titre");

    }

    @Test
    public void modifier() {
        //Methode modifier A TESTER QUAND IMPLEMENTE @TODO

    }

    @Test
    public void supprimer() {
        projetDAOSQLiteCobaye.creer(projetCobaye);
        assertTrue(projetDAOSQLiteCobaye.supprimer());
        assertNull(projetDAOSQLiteCobaye.lire());

    }

    @Test
    public void getPK() {

        projetDAOSQLiteCobaye.creer(new Projet("tittre"));
        assertEquals(1, projetDAOSQLiteCobaye.getPK());
    }
}