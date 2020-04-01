package dti.g25.maitredesbillets.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/***
 *Classe qui creee une connection unique a la base de donnee de l'application
 */
public class SQLiteConnection {
    private static SQLiteDatabase sqLiteDatabaseEcriture;
    private static SQLiteDatabase sqLiteDatabaseLecture;

    /***
     * Constructeur par defaut
     * prive afin de ne pas l'utilliser
     */
    private SQLiteConnection(){}

    /***
     *
     * @param context
     * @return SQLiteDatabase la conection a la base de donnees en ecriture
     */
    public static SQLiteDatabase getSqLiteDatabaseEcriture(Context context){
        if(sqLiteDatabaseEcriture==null || !sqLiteDatabaseEcriture.isOpen()){
            sqLiteDatabaseEcriture= new SQLiteDatabaseHandler(context).getWritableDatabase();
        }
        return sqLiteDatabaseEcriture;
    }

    /***
     *
     * @param context
     * @return SQLDatabase la connection a la base de donnees en lecture
     */
    public static SQLiteDatabase getSqLiteDatabaseLecture(Context context){
        if(sqLiteDatabaseLecture==null || !sqLiteDatabaseLecture.isOpen()){
            sqLiteDatabaseLecture=new SQLiteDatabaseHandler(context).getReadableDatabase();
        }
        return sqLiteDatabaseLecture;
    }

    /***
     * Ferme la connection a la base de donnees
     */
    public static void close(){
        if(sqLiteDatabaseLecture!=null) {
            if (sqLiteDatabaseLecture.isOpen()) {
                sqLiteDatabaseLecture.close();
            }
        }
        if (sqLiteDatabaseEcriture!=null){
            if(sqLiteDatabaseEcriture.isOpen()){
                sqLiteDatabaseEcriture.close();
            }
        }
    }
}
