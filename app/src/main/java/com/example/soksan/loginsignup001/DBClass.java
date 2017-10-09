package com.example.soksan.loginsignup001;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by Soksan on 08-Oct-17.
 */

public class DBClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME=("Customer.db");
    public static final String TABLE_NAME=("User_table");
    public static final String Col1=("name");
    public static final String Col2=("phone");
    public static final String Col3=("email");
    public static final String Col4=("password");

    public DBClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+TABLE_NAME+" ("+Col1+" text, "+Col2+" text, "+Col3+" text,"+Col4+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" drop table if exist "+DATABASE_NAME);
        onCreate(db);
    }
    public boolean insertData(String username,String phonenumber, String emailadd, String password)
    {
        SQLiteDatabase sd=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col1,username);
        cv.put(Col2,phonenumber);
        cv.put(Col3,emailadd);
        cv.put(Col4,password);

        long res=sd.insert(TABLE_NAME,null,cv);
        if(res==-1){
            return false;
        }
        else {
            return true;
        }
    }

}
