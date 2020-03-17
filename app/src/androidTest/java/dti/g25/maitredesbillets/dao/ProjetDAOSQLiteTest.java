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
    String name ="";
    Projet projetCobaye;
    ProjetDAOSQLite projetDAOSQLiteCobaye;
    Context context;

    @Before
    public  void initSqlDbHandler(){
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        name= sqLiteDatabaseHandler.getDatabaseName();
        context.deleteDatabase(name);
        projetCobaye= new Projet("titre");
        projetDAOSQLiteCobaye = new ProjetDAOSQLite(context);

    }

    @After
    public void terminerTest(){
        context = ApplicationProvider.getApplicationContext();
        SQLiteDatabaseHandler sqLiteDatabaseHandler= new SQLiteDatabaseHandler(context);
        name= sqLiteDatabaseHandler.getDatabaseName();
        context.deleteDatabase(name);
    }


    @Test
    public void creer() {
        assertEquals(projetDAOSQLiteCobaye.creer(projetCobaye).getTitre(), projetCobaye.getTitre());
    }

    @Test
    public void lire() {

        ProjetDAOSQLite projetDAOSQLite2= new ProjetDAOSQLite(context);
        projetDAOSQLite2.creer(projetCobaye);
        assertEquals(projetDAOSQLite2.lire().getTitre(),projetCobaye.getTitre());
        assertEquals(projetDAOSQLite2.lire().getTitre(), "titre");

    }

    @Test
    public void modifier() {
        //Methode modifier retourne null A TESTER QUAND IMPLEMENTE

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
        assertEquals(projetDAOSQLiteCobaye.getPK(), 1);
    }
}