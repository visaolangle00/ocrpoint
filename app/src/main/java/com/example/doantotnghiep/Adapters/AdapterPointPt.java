package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.doantotnghiep.Activitys.PointsHPActivity;
import com.example.doantotnghiep.Models.StudentPointPt;
import com.example.doantotnghiep.R;

import java.util.List;

public class AdapterPointPt extends BaseAdapter {

    private PointsHPActivity context;
    private int layout;
    private List<StudentPointPt> arrayList;

    public AdapterPointPt(PointsHPActivity context, int layout, List<StudentPointPt> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
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
        TextView TXTSTPOINT, TXTCLASSMAN, TXTNAMEPT, TXTLOPIDPT, TXTDIEMPT, TXTCOUNTSD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterPointPt.ViewHolder holder;
        if(convertView==null){
            holder = new AdapterPointPt.ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.TXTSTPOINT=(TextView)convertView.findViewById(R.id.et_stpoint);
            holder.TXTCLASSMAN=(TextView)convertView.findViewById(R.id.et_namept);
            holder.TXTNAMEPT=(TextView)convertView.findViewById(R.id.et_classman);
            holder.TXTLOPIDPT=(TextView)convertView.findViewById(R.id.lopidpt);
            holder.TXTDIEMPT=(TextView)convertView.findViewById(R.id.diempt);
            holder.TXTCOUNTSD=(TextView)convertView.findViewById(R.id.stpt);

            convertView.setTag(holder);
        }else{
            holder=(AdapterPointPt.ViewHolder)convertView.getTag();
        }
      final StudentPointPt studentPointPt =arrayList.get(position);
        holder.TXTSTPOINT.setText(studentPointPt.getStpoint());
        holder.TXTCLASSMAN.setText(studentPointPt.getClassman());
        holder.TXTNAMEPT.setText(studentPointPt.getNamept());
        holder.TXTLOPIDPT.setText(studentPointPt.getLopidpt());
        holder.TXTDIEMPT.setText(studentPointPt.getDiempt());
        holder.TXTCOUNTSD.setText("Student "+ (position+1));

        return convertView;


    }
}
