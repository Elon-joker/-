package com.example.a26498;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    //创建每一笔支出项的数据库
    public static final String CREATE_ACCOUNT_BOOK="create table AccountBook("
            +"class text primary key ,"
            +"day text,"
            +"payment integer,"
            +"remark text)";
    //创建总支出的数据库
    public static final String CREATE_ACCOUNT_TOTAL_BOOK="create table AccountTotalBook("
            +"class text primary key ,"
            +"payment integer)";
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
             super(context,name,factory,version);

       }
    @Override
    public void onCreate(SQLiteDatabase SQLdb){
        SQLdb.execSQL(CREATE_ACCOUNT_BOOK);
        SQLdb.execSQL(CREATE_ACCOUNT_TOTAL_BOOK);
        Log.i("456","161611");
       }
    @Override
    public void onUpgrade(SQLiteDatabase SQLdb,int oldVersion,int newVersion){

    }



}
