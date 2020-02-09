package com.example.a26498;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentUser extends Fragment {
    private TextView  textAbout;
    private TextView  textAddMoney;
    static View view;
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
            view = inflater.inflate(R.layout.fragment_user,container,false);
            bindView(view);
        }
        return view;
    }

    public TextView getTextAbout() {
        return textAbout;
    }

    public void setTextAbout(TextView textAbout) {
        this.textAbout = textAbout;
    }

    public TextView getTextAddMoney() {
        return textAddMoney;
    }

    public void setTextAddMoney(TextView textAddMoney) {
        this.textAddMoney = textAddMoney;
    }

    // 绑定控件,初始化
    private void bindView(View view){
        textAbout=view.findViewById(R.id.textAbout);
        textAddMoney=view.findViewById(R.id.textAddMoney);

    }


}
