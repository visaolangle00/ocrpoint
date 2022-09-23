package com.example.doantotnghiep.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doantotnghiep.Activitys.LvScheduleActivity;
import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;

import java.util.List;

public class AdapterSchedule extends BaseAdapter {

    private LvScheduleActivity context;
    private int layout;
    private List<ViewSubject> arrayList;

    public AdapterSchedule (LvScheduleActivity context, int layout, List<ViewSubject> arrayList){
        this.context=context;
        this.layout=layout;
        this.arrayList =arrayList;

    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView TXTTENMON, TXTMONHOC_ID, TXTTKB, TXTSOTINCHI, TXTGV_ID, TXTLICH;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterSchedule.ViewHolder holder;
        if(convertView==null){
            holder = new AdapterSchedule.ViewHolder();
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.TXTTENMON=(TextView)convertView.findViewById(R.id.txttenmon);
            holder.TXTMONHOC_ID=(TextView)convertView.findViewById(R.id.txtmonhocid);
            holder.TXTTKB=(TextView)convertView.findViewById(R.id.txttkb);
            holder.TXTSOTINCHI=(TextView)convertView.findViewById(R.id.txtsotinchi);
            holder.TXTGV_ID=(TextView)convertView.findViewById(R.id.txtgiaovienid);
            holder.TXTLICH=(TextView)convertView.findViewById(R.id.txtlich);

            convertView.setTag(holder);
        }else{
            holder=(AdapterSchedule.ViewHolder)convertView.getTag();
        }
        final ViewSubject viewSubject = arrayList.get(position);
        holder.TXTTENMON.setText(viewSubject.getTenmon());
        holder.TXTMONHOC_ID.setText(viewSubject.getMonhoc_id());
        holder.TXTTKB.setText(viewSubject.getTkb());
        holder.TXTSOTINCHI.setText(viewSubject.getSotinchi());
        holder.TXTGV_ID.setText(viewSubject.getGv_id());
        holder.TXTLICH.setText(viewSubject.getLich());

        return  convertView;

    }



}
