package com.example.a26498;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    static View view;
    private ProgressBar proBarDay,proBarMoth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null!=view)
        {
            ViewGroup parent=(ViewGroup)view.getParent();
            if(null!=parent){
                parent.removeView(view);
                bindView(view);
            }
            bindView(view);
        }
        else{
        view = inflater.inflate(R.layout.fragment_main,container,false);
            Log.i("谁先","onCreateView");
        bindView(view);
        }
        return view;
    }

    // 绑定控件,初始化
    private void bindView(View view){
        textShowDayMassage=view.findViewById(R.id.textShowDayMassage);
        textShowMothMassage=view.findViewById(R.id.textShowMothMassage);
        textShowMoneyHave=view.findViewById(R.id.textShowMoney);
        textDayMoneyHope=view.findViewById(R.id.textDayHP);
        textMothMoneyHope=view.findViewById(R.id.textMothHP);
        proBarDay = view.findViewById(R.id.proBarToday);
        proBarMoth = view.findViewById(R.id.proBarMoth);
    }

    /*get and set*/

    public TextView getTextDayMoneyHope() {
        return textDayMoneyHope;
    }

    public void setTextDayMoneyHope(TextView textDayMoneyHope) {
        this.textDayMoneyHope = textDayMoneyHope;
    }

    public TextView getTextMothMoneyHope() {
        return textMothMoneyHope;
    }

    public void setTextMothMoneyHope(TextView textMothMoneyHope) {
        this.textMothMoneyHope = textMothMoneyHope;
    }

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

    public ProgressBar getProBarDay() {
        return proBarDay;
    }

    public void setProBarDay(ProgressBar proBarDay) {
        this.proBarDay = proBarDay;
    }

    public ProgressBar getProBarMoth() {
        return proBarMoth;
    }

    public void setProBarMoth(ProgressBar proBarMoth) {
        this.proBarMoth = proBarMoth;
    }

    public TextView getTextShowMoneyHave() {
        return textShowMoneyHave;
    }

    public void setTextShowMoneyHave(TextView textShowMoneyHave) {
        this.textShowMoneyHave = textShowMoneyHave;
    }

    /*一般方法*/
    public void setPro(int moneyOutDay,int moneyOutMoth,int allDayMoney,int allMothMoney){
        if(allDayMoney!=0&&allMothMoney!=0){
            proBarDay.setProgress(moneyOutDay*100/allDayMoney);
            proBarMoth.setProgress(moneyOutMoth*100/allMothMoney);
        }
    }


}
