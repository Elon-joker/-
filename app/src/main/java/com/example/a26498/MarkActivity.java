package com.example.a26498;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MarkActivity extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;
    private TextView editText;

    private String classText="水电煤气";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        String dataText= ""+(Calendar.getInstance().get(Calendar.MONTH)+1)+"月"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"日";
        TextView textDate;
        RadioGroup radioGroup;
        textDate=this.findViewById(R.id.date);
        radioGroup=this.findViewById(R.id.multiRadioGroup);
        editText=this.findViewById(R.id.editText);
        textDate.setText(dataText);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton r=findViewById(checkedId);
                classText=String.valueOf(r.getText());
            }
        });

        dataBaseHelper=new DataBaseHelper(this,"AccountTotalBook.db",null,1);
        SQLiteDatabase database=dataBaseHelper.getWritableDatabase();
        Cursor c = database.rawQuery("select * from AccountTotalBook", null);
        if(c.getCount()==0)
        accountTotalBookInitialize();//数据库的初始化
        c.close();
    }

    public void onClickBtnSave(View view){
        //获取界面的支出信息
            SQLiteDatabase database=dataBaseHelper.getReadableDatabase();
            ContentValues values=new ContentValues();
            String outMoney=editText.getText().toString();
            Cursor cursor = database.query("AccountTotalBook", new String[]{"payment"}, "class=?", new String[]{classText}, null, null, null);
            cursor.moveToNext();//移动游标，开始读取
            int outTotal=Integer.valueOf(outMoney)+cursor.getInt(cursor.getColumnIndex("payment"));
            values.put("payment",outTotal);
            database.update("AccountTotalBook",values,"class=?",new String[]{classText});//将总的消费记录存到数据中去
            database.close();
            cursor.close();//关闭

        TextView remark=this.findViewById(R.id.editText2);
        TextView day=this.findViewById(R.id.date);
        insertOut(classText,Integer.valueOf(outMoney),day.getText().toString(),remark.getText().toString());

        Intent intent = new Intent(MarkActivity.this,MainActivity.class);
        int moneyOut;
        if("".equals(editText.getText().toString())){
            moneyOut=0;
        }
        else{
            moneyOut=Integer.valueOf(editText.getText().toString());
        }

        intent.putExtra("moneyOut",moneyOut);
        this.setResult(RESULT_OK, intent);
        finish();
    }
    /*一般方法*/

    public void accountTotalBookInitialize(){
        SQLiteDatabase database=dataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        //开始添加数据库的架构
        values.put("class","水电煤气");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第二条
        values.put("class","学习用品");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第四条
        values.put("class","中晚餐");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第五条
        values.put("class","礼物");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第六条
        values.put("class","公交卡");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第七条
        values.put("class","网购");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第八条
        values.put("class","水果零食");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第九条
        values.put("class","早餐");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
        //第十条
        values.put("class","其他");
        values.put("payment",0);
        database.replace("AccountTotalBook",null,values);//插入第一类消费
        values.clear();//清除存记录，开始下一条记录
    }

    public void insertOut(String className,int payment,String remark,String day){
        SQLiteDatabase database=dataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("class",className);
        values.put("payment",payment);
        values.put("remark",remark);
        values.put("day",day);
        database.insert("AccountBook",null,values);
        values.clear();
    }

}
