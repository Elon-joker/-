package com.example.a26498;

import android.app.AlertDialog;
import android.content.Intent;
//import android.content.SharedPreferences;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentMain fragmentMain = new FragmentMain();
    private FragmentShow fragmentShow = new FragmentShow();
    private FragmentUser fragmentUser = new FragmentUser();

    private TextView textMain;
    private TextView textShow;
    private TextView textUser;

    private UserClass userClass=new UserClass(30,900,1500);
    private int moneyOutDay=0,moneyOutMoth=0;
    private boolean flag=true;

    private SharedPreferences sharedPreDate;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreDate=getSharedPreferences("moneyData",MODE_PRIVATE);
        editor=sharedPreDate.edit();
        bindView();
        }
    @Override
     public void onStart(){
        super.onStart();
        onClick(textMain);
        }
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(flag){//保证添加一次，到位展示
            transaction.add(R.id.fragmentContainer,fragmentMain);
            transaction.add(R.id.fragmentContainer,fragmentShow);
            transaction.add(R.id.fragmentContainer,fragmentUser);
            flag=false;

        }
        hideFragment(transaction);
        switch(v.getId()){
            case R.id.textMain:
                setUnSelected();
                textMain.setSelected(true);
                transaction.show(fragmentMain);

                break;
            case R.id.textShow:
                setUnSelected();
                textShow.setSelected(true);
                    transaction.show(fragmentShow);
                break;
            case R.id.textUser:
                setUnSelected();
                textUser.setSelected(true);
                transaction.show(fragmentUser);
                    fragmentUser.getTextAbout().setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            //builder.setIcon(R.drawable.ic_launcher);
                            String aboutM="向晚工作室出品\n 美工监制 汪婉婉\t\t技术监制  占建\n意见反馈及联系QQ：2649853081";
                            String about="关于我们";
                            builder.setTitle(about);
                            builder.setMessage(aboutM);
                            builder.show();
                        }
                    });
                    fragmentUser.getTextAddMoney().setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            Intent intent=new Intent(MainActivity.this,AddMoneyActivity.class);
                            startActivityForResult(intent,2);
                        }

                    });

                break;
        }
        transaction.commit();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch(requestCode){
           case 1:
             if(resultCode==RESULT_OK){
                int moneyOut=data.getIntExtra("moneyOut",0);
                moneyOutDay+=moneyOut;
                moneyOutMoth+=moneyOut;
                 editor.putInt("moneyDayOut",moneyOutDay);
                 editor.putInt("moneyMothOut",moneyOutMoth);
                 editor.apply();
                 fragmentMain.disPlay(moneyOutDay,moneyOutMoth,userClass,sharedPreDate);
             }
              break;

           case 2:
               if(resultCode==RESULT_OK){
                   int[] money;
                   money=data.getIntArrayExtra("money");
                   editor.putInt("moneyDayHope",money[0]);
                   editor.putInt("moneyMothHope",money[1]);
                   editor.putInt("moneyHave",money[2]);
                   editor.apply();
                   userClass.setMoneyTotalDay(sharedPreDate.getInt("moneyDayHope",0));
                   userClass.setMoneyTotalMoth(sharedPreDate.getInt("moneyMothHope",0));
                   userClass.setMoneyHave(sharedPreDate.getInt("moneyHave",0));
                   fragmentMain.disPlay(moneyOutDay,moneyOutMoth,userClass,sharedPreDate);
           }
               break;
           default:
       }
    }
/*一般方法*/
    public void onClickBtn(View view){
        Intent intent = new Intent(MainActivity.this,MarkActivity.class);
        startActivityForResult(intent,1);
    }
    public void hideFragment(FragmentTransaction transaction){
        transaction.hide(fragmentMain);
        transaction.hide(fragmentShow);
        transaction.hide(fragmentUser);
    }
    public void setUnSelected(){
        textMain.setSelected(false);
        textShow.setSelected(false);
        textUser.setSelected(false);
    }
    public void bindView(){
        textMain=this.findViewById(R.id.textMain);
        textShow=this.findViewById(R.id.textShow);
        textUser=this.findViewById(R.id.textUser);

        textMain.setOnClickListener(this);
        textShow.setOnClickListener(this);
        textUser.setOnClickListener(this);
    }

/*get and set*/

    public UserClass getUserClass() {
        return userClass;
    }

    public int getMoneyOutDay() {
        return moneyOutDay;
    }
    public int getMoneyOutMoth() {
        return moneyOutMoth;
    }
    public SharedPreferences getSharedPreDate() {
        return sharedPreDate;
    }

}
