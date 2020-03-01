package com.example.a26498;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    //MyAdapter的构造函数，一个Context类型的参数，也就是哪一个Activity
    //这里传进去的是 ListViewActivity,ListView所在的Activity
    public MyListAdapter(Context context){
        this.mContext=context;
        mLayoutInflater =LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //写一个静态的class,把layout_list_view的控件转移过来使用
    static class ViewHolder{
        //声明引用
        public TextView tvClass,tvTime,tvBZ,tvOut;
    }
    //重要的方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //实例化ViewHolder
        ViewHolder holder = null;
        //如果视图为空
        if (convertView == null){
            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_view这个布局文件
            convertView = mLayoutInflater.inflate(R.layout.layout_list_view,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //把layout_list_view对象转移过来，以便修改和赋值
            holder.tvClass= convertView.findViewById(R.id.className);
            holder.tvTime = convertView.findViewById(R.id.time);
            holder.tvBZ = convertView.findViewById(R.id.BZ);
            holder.tvOut = convertView.findViewById(R.id.money);
            //把这个holder传递进去
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTime.setText("时间");
        holder.tvClass.setText("显示内容！");
        holder.tvOut.setText("支出");
        holder.tvBZ.setText("备注");
        return convertView;
    }
}
