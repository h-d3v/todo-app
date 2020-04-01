package dti.g25.maitredesbillets.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/***
 * Classe permettant la creation d'une base de donnee SQLite liee a l'application
 */
public class SQLiteDatabaseHandler extends SQLiteOpenHelper {
    /***
     * Valeurs constantes par defaut
     * Toutes modifications du script de la base de donnee doit passer par la modification de ces constantes seulement
     */

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "maitredesbillets.db";

    public static class EntreesProjet {
        public static final String NOM_TABLE = "PROJET";
        public static final String NOM_COLONNE_TITRE = "TITRE";
        public static final String NOM_COLONNE_ID = "ID";
    }

    public static class EntreesBillet {
        public static final String NOM_TABLE = "BILLET";
        public static final String NOM_COLONNE_TITRE = "TITRE";
        public static final String NOM_COLONNE_ID = "ID";
        public static final String NOM_COLONNE_PROJET_ID = "PROJET_ID";
        public static final String NOM_COLONNE_DESC = "DESCRIPTION";
    }


    public static final String TABLE_NAME_TAG = "TAG";

    public static final String SQL_CREATE_TABLE_PROJET = "CREATE TABLE " + EntreesProjet.NOM_TABLE + "(" +
            EntreesProjet.NOM_COLONNE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EntreesProjet.NOM_COLONNE_TITRE + " TEXT NOT NULL );";

    public static final String SQL_CREATE_TABLE_BILLET = "CREATE TABLE " + EntreesBillet.NOM_TABLE + "(" +
            EntreesBillet.NOM_COLONNE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EntreesBillet.NOM_COLONNE_DESC + " TEXT, " +
            EntreesBillet.NOM_COLONNE_TITRE + " TEXT NOT NULL," +
            EntreesBillet.NOM_COLONNE_PROJET_ID + " INTEGER NOT NULL," +
            "CONSTRAINT projet_id_fk FOREIGN KEY (" + EntreesBillet.NOM_COLONNE_PROJET_ID + ") " +
            "REFERENCES " + EntreesProjet.NOM_TABLE + "(" + EntreesProjet.NOM_COLONNE_ID + "));";

    public static final String SQL_DROP_TABLE_BILLET = "DROP TABLE IF EXISTS " + EntreesBillet.NOM_TABLE + ";";

    public static final String SQL_DROP_TABLE_PROJET = "DROP TABLE IF EXISTS " + EntreesProjet.NOM_TABLE + ";";

    /***
     *Constructeur
     * @param context
     */
    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /***
     *Execution des scripts de creation de la base de donnee
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PROJET);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_BILLET);
    }

    /***
     *Execution des scripts de modification de la base de donnee en cas d'upgrade de version
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE_BILLET);
        sqLiteDatabase.execSQL(SQL_DROP_TABLE_PROJET);
        onCreate(sqLiteDatabase);
    }

    /***
     *Execution des scripts de modification de la base de donnee en cas de downgrade de version
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onUpgrade(sqLiteDatabase, i1, i);
    }
}