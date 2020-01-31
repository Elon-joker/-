package com.example.a26498;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);
    }

    public void onClickBtnSave(View view){
        Intent intent = new Intent(MarkActivity.this,MainActivity.class);
        TextView textView=findViewById(R.id.editText);
        int moneyOut=Integer.valueOf(textView.getText().toString());
        intent.putExtra("moneyOut",moneyOut);
        this.setResult(RESULT_OK, intent);
        finish();
      //  startActivity(intent);
    }
}
