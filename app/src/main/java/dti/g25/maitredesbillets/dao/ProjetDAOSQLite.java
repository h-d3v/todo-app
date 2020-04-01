package dti.g25.maitredesbillets.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import dti.g25.maitredesbillets.domaine.entité.Projet;
import dti.g25.maitredesbillets.modele.dao.DAO;




public class ProjetDAOSQLite  implements DAO<Projet> {
    private long id=-1;
    private SQLiteDatabase sqLiteDatabaseLecture;
    private SQLiteDatabase sqLiteDatabaseEcriture;


    public ProjetDAOSQLite(Context context){
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
    }

    public ProjetDAOSQLite(Context context, long id){
        sqLiteDatabaseEcriture= SQLiteConnection.getSqLiteDatabaseEcriture(context);
        sqLiteDatabaseLecture= SQLiteConnection.getSqLiteDatabaseLecture(context);
        this.id=id;
    }

    public Projet creer(Projet projet) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_TITRE, projet.getTitre());
        id = sqLiteDatabaseEcriture.insert(SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE, null,contentValues);
        return lire();
    }

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

    @Override
    //@TODO
    public Projet modifier(Projet projet) {
        return null;
    }

    @Override
    public boolean supprimer() {

        int nbSupp = sqLiteDatabaseEcriture.delete(SQLiteDatabaseHandler.EntreesProjet.NOM_TABLE, SQLiteDatabaseHandler.EntreesProjet.NOM_COLONNE_ID+" = ?",new String[]{String.valueOf(id)});
        return nbSupp >0;
    }
    @Override
    public long getPK(){
        return id;
    }



}
