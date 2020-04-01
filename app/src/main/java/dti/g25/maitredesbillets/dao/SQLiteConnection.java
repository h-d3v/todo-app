package dti.g25.maitredesbillets.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteConnection {
    private static SQLiteDatabase sqLiteDatabaseEcriture;
    private static SQLiteDatabase sqLiteDatabaseLecture;

    public static SQLiteDatabase getSqLiteDatabaseEcriture(Context context){
        if(sqLiteDatabaseEcriture==null || !sqLiteDatabaseEcriture.isOpen()){
            sqLiteDatabaseEcriture= new SQLiteDatabaseHandler(context).getWritableDatabase();
        }
        return sqLiteDatabaseEcriture;
    }

    public static SQLiteDatabase getSqLiteDatabaseLecture(Context context){
        if(sqLiteDatabaseLecture==null || !sqLiteDatabaseLecture.isOpen()){
            sqLiteDatabaseLecture=new SQLiteDatabaseHandler(context).getReadableDatabase();
        }
        return sqLiteDatabaseLecture;
    }

    public static void close(){
        if(sqLiteDatabaseLecture!=null || sqLiteDatabaseLecture.isOpen()){
            sqLiteDatabaseLecture.close();
            sqLiteDatabaseEcriture.close();
        }
    }

}
