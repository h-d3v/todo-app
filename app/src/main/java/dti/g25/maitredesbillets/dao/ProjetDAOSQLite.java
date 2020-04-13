package dti.g25.maitredesbillets.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAO;

/***
 * Classe objet d'acces aux donnees de type Projet fonctionnant avec la base de donnee SQLite cree par l'application
 */


public class ProjetDAOSQLite  implements DAO<Projet> {
    private long id=-1;
    private SQLiteDatabase sqLiteDatabaseLecture;
    private SQLiteDatabase sqLiteDatabaseEcriture;

    /***
     * Constructeur
     * @param context
     */
    public ProjetDAOSQLite(Context context){
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
    }

    /***
     *Constructeur
     * @param context
     * @param id id du projet
     */
    public ProjetDAOSQLite(Context context, long id){
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
        this.id=id;
    }

    /***
     *
     * @param projet l'objet a creer dans la base de donnee
     * @return projet  l'objet tel qui l'a ete cree dans la base de donnee, null si non cree
     */
    @Override
    public Projet creer(Projet projet) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_TITRE, projet.getTitre());
        id = sqLiteDatabaseEcriture.insert(SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE, null,contentValues);
        return lire();
    }

    /***
     *
     * @return l'objet tel qui l'est dans la base de donnee, null si non existant dans la base de donne
     *
     */
    @Override
    public Projet lire() {
        Projet unProjet = null;
        Cursor cursor = sqLiteDatabaseLecture.rawQuery("select * from "+ SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE+" where "+ SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_ID+"="+id, null);
        if (cursor.moveToFirst()){

            String titre= cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_TITRE));
            unProjet= new Projet(titre);
            cursor.close();
        }

        return unProjet;
    }

    /***
     *
     * @param projet  l'objet tel qui doit etre modifie
     * @return projet l'objet tel qui l'a ete modifie dans la base de donnee, null si l'objet est inexistant dans la BD
     *
     */
    @Override
    //@TODO
    public Projet modifier(Projet projet) {
        return null;
    }

    /***
     * supprime l'objet dans la base de donnee
     * @return boolean true si supprime, false sinon
     */
    @Override
    public boolean supprimer() {

        int nbSupp = sqLiteDatabaseEcriture.delete(SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE, SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_ID+" = ?",new String[]{String.valueOf(id)});
        return nbSupp >0;
    }

    /***
     *
     * @return la cle primaire de l'objet associe a la base de donnees
     */
    @Override
    public long getPK(){
        return id;
    }



}
