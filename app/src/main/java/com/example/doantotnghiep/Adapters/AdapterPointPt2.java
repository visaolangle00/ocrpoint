package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantotnghiep.Activitys.PointsHPActivity;
import com.example.doantotnghiep.Models.StudentPointPt;
import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;

import java.util.List;

public class AdapterPointPt2 extends RecyclerView.Adapter<AdapterPointPt2.MyViewHolder> {

    Context context;
    List<StudentPointPt> studentPointPts;

    public AdapterPointPt2(Context context, List<StudentPointPt> studentPointPts) {
        this.context = context;
        this.studentPointPts = studentPointPts;
    }

    //    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        AdapterPointPt2.ViewHolder holder;
//        if(convertView==null){
//            holder = new AdapterPointPt2.ViewHolder();
//            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(layout,null);
//            holder.TXTSTPOINT=(TextView)convertView.findViewById(R.id.et_stpoint);
//            holder.TXTCLASSMAN=(TextView)convertView.findViewById(R.id.et_namept);
//            holder.TXTNAMEPT=(TextView)convertView.findViewById(R.id.et_classman);
//            holder.TXTLOPIDPT=(TextView)convertView.findViewById(R.id.lopidpt);
//            holder.TXTDIEMPT=(TextView)convertView.findViewById(R.id.diempt);
//            holder.TXTCOUNTSD=(TextView)convertView.findViewById(R.id.stpt);
//
//            convertView.setTag(holder);
//        }else{
//            holder=(AdapterPointPt2.ViewHolder)convertView.getTag();
//        }
//      final StudentPointPt studentPointPt =arrayList.get(position);
//        holder.TXTSTPOINT.setText(studentPointPt.getStpoint());
//        holder.TXTCLASSMAN.setText(studentPointPt.getClassman());
//        holder.TXTNAMEPT.setText(studentPointPt.getNamept());
//        holder.TXTLOPIDPT.setText(studentPointPt.getLopidpt());
//        holder.TXTDIEMPT.setText(studentPointPt.getDiempt());
//        holder.TXTCOUNTSD.setText("Student "+ (position+1));
//
//        return convertView;
//
//
//    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.row_point_hp,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TXTSTPOINT.setText(studentPointPts.get(position).getStpoint());
        holder.TXTCLASSMAN.setText(studentPointPts.get(position).getNamept());
        holder.TXTNAMEPT.setText(studentPointPts.get(position).getClassman());
        holder.TXTLOPIDPT.setText(studentPointPts.get(position).getLopidpt());
        holder.TXTDIEMPT.setText(studentPointPts.get(position).getDiempt());
        holder.TXTCOUNTSD.setText("Student" +(position+1));

    }

    @Override
    public int getItemCount() {
        return studentPointPts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView TXTSTPOINT, TXTCLASSMAN, TXTNAMEPT, TXTLOPIDPT, TXTDIEMPT, TXTCOUNTSD;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TXTSTPOINT = itemView.findViewById(R.id.et_stpoint);
            TXTCLASSMAN = itemView.findViewById(R.id.et_classman);
            TXTNAMEPT=itemView.findViewById(R.id.et_namept);
            TXTLOPIDPT=itemView.findViewById(R.id.lopidpt);
            TXTDIEMPT=itemView.findViewById(R.id.diempt);
            TXTCOUNTSD=itemView.findViewById(R.id.stpt);
        }
    }
}
