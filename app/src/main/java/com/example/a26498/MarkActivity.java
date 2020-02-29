package com.example.a26498;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    private TextView textDate;
    private RadioGroup radioGroup;
    private TextView editText;

    private String classText;
    private String outMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        String dataText= ""+(Calendar.getInstance().get(Calendar.MONTH)+1)+"月"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"日";
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
        accountTotalBookInitialize();//数据库的初始化
    }

    public void onClickBtnSave(View view){
        //获取界面的支出信息
        SQLiteDatabase database=dataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        outMoney=editText.getText().toString();
        int outTotal=100;
        values.put("payment",outTotal);
        database.update("AccountTotalBook",values,"name=?",new String[]{classText});

        Intent intent = new Intent(MarkActivity.this,MainActivity.class);
        TextView textView=findViewById(R.id.editText);
        int moneyOut;
        if("".equals(textView.getText().toString())){
            moneyOut=0;
        }
        else{
            moneyOut=Integer.valueOf(textView.getText().toString());
        }

        intent.putExtra("moneyOut",moneyOut);
        this.setResult(RESULT_OK, intent);
        finish();
    }
    /*一般方法*/

    public void accountTotalBookInitialize(){
        dataBaseHelper=new DataBaseHelper(this,"AccountTotalBook.db",null,1);
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
}
