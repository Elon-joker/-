package com.example.a26498;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    //创建支出项的数据库
    public static final String CREATE_ACCOUNT_BOOK="create table AccountBook("
            +"class text primary key ,"
            +"payment integer,"
            +"remark text)";
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
             super(context,name,factory,version);

       }
    @Override
    public void onCreate(SQLiteDatabase SQLdb){
        SQLdb.execSQL(CREATE_ACCOUNT_BOOK);
        Log.i("456","161611");
       }
    @Override
    public void onUpgrade(SQLiteDatabase SQLdb,int oldVersion,int newVersion){

    }



}
