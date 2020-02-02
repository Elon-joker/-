package com.example.a26498;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddMoneyActivity extends AppCompatActivity {
    private TextView textMoneyHave;
    private TextView textMoneyDay;
    private TextView textMoneyMoth;

    private int[] money=new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

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
        setResult(RESULT_OK,intent);
        finish();
    }

}
