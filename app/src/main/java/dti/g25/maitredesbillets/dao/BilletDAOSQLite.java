package dti.g25.maitredesbillets.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.présentation.modèle.dao.DAO;

/***
 * Classe objet d'acces aux donnees de type Billet fonctionnant avec la base de donnee SQLite cree par l'application
 */

public class BilletDAOSQLite implements DAO<Billet>{
    private long id=-1;
    private long idProjet;
    SQLiteDatabase sqLiteDatabaseEcriture;
    SQLiteDatabase sqLiteDatabaseLecture;

    /***
     * Constructeur
     *
     * @param context
     * @param idProjet
     */
    public BilletDAOSQLite(Context context, long idProjet){
        this.idProjet=idProjet;
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
    }

    /***
     *Constructeur
     *
     * @param context
     * @param id
     * @param idProjet
     */
    public BilletDAOSQLite(Context context, long id, long idProjet){
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
        this.id=id;
        this.idProjet=idProjet;
    }

    /***
     *
     * @param unBillet   l'oblet a creer dans la base de donnee
     * @return Billet l'objet tel qui l'a ete cree dans la base de donnee, null si non cree
     *
     */
    @Override
    public Billet creer(Billet unBillet) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_TITRE, unBillet.getTitre());
        contentValues.put(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_DESC, unBillet.getDescription());
        contentValues.put(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_PROJET_ID, idProjet);
        id = sqLiteDatabaseEcriture.insert(SQLiteDatabaseHandler.EntreesBillet.NOM_TABLE, null,contentValues);
        return lire();
    }

    /***
     *
     * @return Billet l'objet tel qui l'est dans la base de donnee, null si non existant dans la base de donne
     *
     */
    @Override
    public Billet lire() {
        Billet billet = null;
        Cursor cursor = sqLiteDatabaseLecture.rawQuery("select * from "+ SQLiteDatabaseHandler.EntreesBillet.NOM_TABLE+" where "+ SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_ID+"="+id, null);
        if (cursor.moveToFirst()){

            String titre= cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_TITRE));
            long idProjetTrouve = cursor.getInt(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_PROJET_ID));
            String desc = cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_DESC));
            if(idProjetTrouve==idProjet && idProjetTrouve<Integer.MAX_VALUE) {
                billet = new Billet(titre, desc);
            }
        }
        cursor.close();

        return billet;
    }

    /***
     *
     * @param billet l'objet tel qui doit etre modifie
     * @return Billet l'objet tel qui l'a ete modifie dans la base de donnee, null si l'objet est inexistant dans la BD
     *
     */
    @Override
    public Billet modifier(Billet billet) {

        ContentValues contentValues= new ContentValues();
        contentValues.put(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_DESC, billet.getDescription());
        contentValues.put(SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_TITRE, billet.getTitre());
        sqLiteDatabaseEcriture.update(SQLiteDatabaseHandler.EntreesBillet.NOM_TABLE, contentValues, " id=? ", new String[]{Long.toString(id)});
        return lire();
    }

    /***
     *supprime l'objet de la base de donnee
     * @return boolean true si supprime, false sinon
     */
    @Override
    public boolean supprimer() {
        int nbSupp = sqLiteDatabaseEcriture.delete(SQLiteDatabaseHandler.EntreesBillet.NOM_TABLE, SQLiteDatabaseHandler.EntreesBillet.NOM_COLONNE_ID+" = ?",new String[]{String.valueOf(id)});
        return nbSupp >0;
    }

    /***
     *
     * @return long la cle primaire de l'objet associe a la base de donnee
     *
     */
    @Override
    public long getPK() {
        return id;
    }


}

