package com.example.a26498;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddMoneyActivity extends AppCompatActivity {
    private TextView textMoneyHave;
    private TextView textMoneyDay;
    private TextView textMoneyMoth;

    private int[] money=new int[3];
    private SharedPreferences sharedPreData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        sharedPreData=getSharedPreferences("data",MODE_PRIVATE);
        bindView();
    }
    public void  bindView(){
        textMoneyDay=this.findViewById(R.id.eTDay);
        textMoneyHave=this.findViewById(R.id.eTMoneyHave);
        textMoneyMoth=this.findViewById(R.id.eTMoth);
    }
    public void onClickBtn(View v){

        if(!"".equals(textMoneyDay.getText().toString())){
            money[0]=Integer.valueOf(textMoneyDay.getText().toString());
        }
        else
          money[0]=0;
        if(!"".equals(textMoneyMoth.getText().toString()))
            money[1]=Integer.valueOf(textMoneyMoth.getText().toString());
        else
            money[1]=0;
        if(!"".equals(textMoneyHave.getText().toString()))
            money[2]=Integer.valueOf(textMoneyHave.getText().toString());
        else
            money[2]=0;
        Intent intent=new Intent(AddMoneyActivity.this,MainActivity.class);
        intent.putExtra("money",money);
//        SharedPreferences.Editor editor = sharedPreData.edit();//获取Editor对象
//        editor.putInt("200", 200);//添加数据
//        editor.apply();//提交数据
        setResult(RESULT_OK,intent);
//        startActivity(intent);
        finish();
    }

}
