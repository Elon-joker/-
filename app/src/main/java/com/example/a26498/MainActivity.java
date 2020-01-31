package com.example.a26498;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentMain fragmentMain = new FragmentMain();
    private FragmentShow fragmentShow = new FragmentShow();
    private FragmentUser fragmentUser = new FragmentUser();

    //private FrameLayout ly_content;

    private TextView textMain;
    private TextView textShow;
    private TextView textUser;

    private UserClass userClass=new UserClass(30,900,1500);
    private int moneyOutDay=0,moneyOutMoth=0;
    private boolean flage=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        onClick(textMain);
        }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(flage){//保证添加一次，到位展示
            transaction.add(R.id.fragmentContainer,fragmentMain);
            transaction.add(R.id.fragmentContainer,fragmentShow);
            transaction.add(R.id.fragmentContainer,fragmentUser);
            flage=false;
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
                textMain.setSelected(true);
                transaction.show(fragmentUser);
                break;
        }
        transaction.commit();
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
        //ly_content = this.findViewById(R.id.fragmentContainer);

        textMain.setOnClickListener(this);
        textShow.setOnClickListener(this);
        textUser.setOnClickListener(this);


    }
    public void hideFragment(FragmentTransaction transaction){
        if(fragmentMain!=null)
            transaction.hide(fragmentMain);
        if(fragmentShow!=null)
            transaction.hide(fragmentShow);
        if(fragmentUser!=null)
            transaction.hide(fragmentUser);
    }

    public void onClickBtn(View view){
        Intent intent = new Intent(MainActivity.this,MarkActivity.class);
        startActivityForResult(intent,1);
        //startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch(requestCode){
           case 1:
             if(resultCode==RESULT_OK){
                int moneyOut=data.getIntExtra("moneyOut",0);
                moneyOutDay+=moneyOut;
                moneyOutMoth+=moneyOut;
                String textPlayDay="今日已用￥"+moneyOutDay+",还可用￥"+(userClass.getMoneyTotalDay()-moneyOutDay);
                String textPlayMoth="本月已用￥"+moneyOutMoth+",还可用￥"+(userClass.getMoneyTotalMoth()-moneyOutMoth);
                fragmentMain.getTextShowDayMassage().setText(textPlayDay);
                fragmentMain.getTextShowMothMassage().setText(textPlayMoth);
                fragmentMain.getTextShowMoneyHave().setText(String.valueOf(userClass.getMoneyHave()-moneyOutMoth));
                fragmentMain.setPro(moneyOutDay,moneyOutMoth,userClass.getMoneyTotalDay(),userClass.getMoneyTotalMoth());
                 fragmentMain.getTextMothMoneyHope().setText(String.valueOf(userClass.getMoneyTotalMoth()));
                 fragmentMain.getTextDayMoneyHope().setText(String.valueOf(userClass.getMoneyTotalDay()));
             }
              break;
           default:
       }
    }


}
