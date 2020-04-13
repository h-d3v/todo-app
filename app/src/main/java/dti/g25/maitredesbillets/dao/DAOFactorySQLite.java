package dti.g25.maitredesbillets.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAO;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAOFactory;
import java.util.LinkedList;
import java.util.List;

/***
 *Factory permettant de creer des objets d'acces aux donnees avec SQLite
 */
public class DAOFactorySQLite extends DAOFactory {
    /***
     *
     * @param context
     * @return DAO<Projet>
     */
    @Override
    public DAO<Projet> creerDAOProjet(Context context) {
        return new ProjetDAOSQLite(context);
    }

    /***
     *
     * @param context
     * @return List<DAO<Projet>>
     */
    @Override
    public List<DAO<Projet>> creerListeDAOProjet(Context context) {

        SQLiteDatabase sqLiteDatabase = SQLiteConnection.getSqLiteDatabaseLecture(context);
        LinkedList<DAO<Projet>> projets= new LinkedList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from "+ SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE, null);
        while (cursor.moveToNext()){
            DAO<Projet> projetDAO = new ProjetDAOSQLite(context, cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_ID)));
            projets.add(projetDAO);
        }
        cursor.close();
        return projets;
    }

    /***
     *
     * @param context
     * @param projetDAO
     * @return List<DAO<Billet>> une liste de billet selon son projet associe
     */
    @Override
    public List<DAO<Billet>> creerListeDAOBilletParProjet(Context context, DAO<Projet> projetDAO){
        SQLiteDatabase sqLiteDatabase=  SQLiteConnection.getSqLiteDatabaseLecture(context);
        LinkedList<DAO<Billet>> billets= new LinkedList<DAO<Billet>>();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from "+ SQLiteDatabaseHandler.EntreesBillet.NOM_TABLE+" where "+ SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_PROJET_ID+" = " +projetDAO.getPK() , null );
        while(cursor.moveToNext()){
            DAO<Billet> billetDAO = new BilletDAOSQLite(context,cursor.getLong(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_ID)) ,projetDAO.getPK());
            billets.add(billetDAO);
        }
        cursor.close();
        return billets;
    }

    /***
     *
     * @param context
     * @param unProjet
     * @param unBillet
     * @return
     */
    @Override
    public Billet ajouterBilletAuProjet(Context context, DAO<Projet> unProjet, Billet unBillet) {
            BilletDAOSQLite billetDAOSQLite = new BilletDAOSQLite(context, unProjet.getPK());
            return billetDAOSQLite.creer(unBillet);

    }

}
