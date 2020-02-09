package com.example.a26498;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FragmentMain extends Fragment {
    private TextView textDayMoneyHope;
    private TextView textMothMoneyHope;
    private TextView textShowDayMassage;
    private TextView textShowMothMassage;
    private TextView textShowMoneyHave;
    private View view;
    private ProgressBar proBarDay,proBarMoth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null!=view)
        {
            ViewGroup parent=(ViewGroup)view.getParent();
            if(null!=parent){
                parent.removeView(view);
            }
        }
        else{
        view = inflater.inflate(R.layout.fragment_main,container,false);
        bindView(view);
        }

        return view;
    }
@Override
public void onStart(){
        super.onStart();
        MainActivity mainActivity=(MainActivity)getActivity();
        disPlay(mainActivity.getMoneyOutDay(),mainActivity.getMoneyOutMoth(),mainActivity.getUserClass(),mainActivity.getSharedPreDate());
}

    // 绑定控件,初始化
    public void bindView(View view){
        textShowDayMassage=view.findViewById(R.id.textShowDayMassage);
        textShowMothMassage=view.findViewById(R.id.textShowMothMassage);
        textShowMoneyHave=view.findViewById(R.id.textShowMoney);
        textDayMoneyHope=view.findViewById(R.id.textDayHP);
        textMothMoneyHope=view.findViewById(R.id.textMothHP);
        proBarDay = view.findViewById(R.id.proBarToday);
        proBarMoth = view.findViewById(R.id.proBarMoth);

    }

    /*get and set*/
    public TextView getTextShowDayMassage() {
        return textShowDayMassage;
    }

    public void setTextShowDayMassage(TextView textShowDayMassage) {
        this.textShowDayMassage = textShowDayMassage;
    }

    public TextView getTextShowMothMassage() {
        return textShowMothMassage;
    }

    public void setTextShowMothMassage(TextView textShowMothMassage) {
        this.textShowMothMassage = textShowMothMassage;
    }

    public ProgressBar getProBarMoth() {
        return proBarMoth;
    }

    public void setProBarMoth(ProgressBar proBarMoth) {
        this.proBarMoth = proBarMoth;
    }

    /*一般方法*/
    public void setPro(int moneyOutDay,int moneyOutMoth,int allDayMoney,int allMothMoney){
        if(allDayMoney!=0&&allMothMoney!=0){
            proBarDay.setProgress(moneyOutDay*100/allDayMoney);
            proBarMoth.setProgress(moneyOutMoth*100/allMothMoney);
        }
    }
    public void disPlay(int moneyOutDay,int moneyOutMoth,UserClass userClass,SharedPreferences sharedPreDate){
        String textPlayDay="今日已用￥"+sharedPreDate.getInt("moneyDayOut",0)+",还可用￥"+(userClass.getMoneyTotalDay()-sharedPreDate.getInt("moneyDayOut",0));
        String textPlayMoth="本月已用￥"+sharedPreDate.getInt("moneyMothOut",0)+",还可用￥"+(userClass.getMoneyTotalMoth()-sharedPreDate.getInt("moneyMothOut",0));
        String textDay="￥"+textPlayDay;
        String textMoth="￥"+textPlayMoth;
        textShowDayMassage.setText(textDay);
        textShowMothMassage.setText(textMoth);

        String textMH="￥"+(userClass.getMoneyHave()-sharedPreDate.getInt("moneyMothOut",0));
        textShowMoneyHave.setText(textMH);
        setPro(moneyOutDay,moneyOutMoth,userClass.getMoneyTotalDay(),userClass.getMoneyTotalMoth());

        String TM="￥"+(userClass.getMoneyTotalMoth());
        String TD="￥"+(userClass.getMoneyTotalDay());
        textMothMoneyHope.setText(TM);
        textDayMoneyHope.setText(TD);
    }

}
