package com.example.a191132_saraalsaud;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "SURNAME";
    public static final String COL4 = "FATHER";
    public static final String COL5 = "NATIONAL";
    public static final String COL6 = "BDAY";
    public static final String COL7 = "GENDER";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY, " +
                " NAME TEXT, SURNAME TEXT, FATHER TEXT, NATIONAL TEXT, BDAY TEXT, GENDER TEXT)";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String id,String name,String sur, String father,String nation,String bday,String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, name);
        contentValues.put(COL3, sur);
        contentValues.put(COL4, father);
        contentValues.put(COL5, nation);
        contentValues.put(COL6, bday);
        contentValues.put(COL7, gender);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1) {return false;} else {return true;}
    }


    public Cursor View(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor x = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        return x;
    }


    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    public Integer update(String id,String name,String sur, String father,String nation,String bday,String gender){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, name);
        contentValues.put(COL3, sur);
        contentValues.put(COL4, father);
        contentValues.put(COL5, nation);
        contentValues.put(COL6, bday);
        contentValues.put(COL7, gender);

        return db.update(TABLE_NAME, contentValues,"ID=?",new String[] {id});}

}