package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;

import java.util.List;

public class AdapterSchedule2 extends RecyclerView.Adapter<AdapterSchedule2.MyViewHolder> {
    Context context;
    List<ViewSubject> subjectList;

    public AdapterSchedule2(Context context, List<ViewSubject> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_schedule,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txttenmon.setText(subjectList.get(position).getTenmon());
        holder.txtlich.setText(subjectList.get(position).getLich());
        holder.txtmonhocid.setText(subjectList.get(position).getMonhoc_id());
        holder.txttkb.setText(subjectList.get(position).getTkb());
                holder.txtsotinchi.setText(subjectList.get(position).getSotinchi());
                holder.txtgiaovienid.setText(subjectList.get(position).getGv_id());

    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txttenmon, txtlich,txtmonhocid,txttkb,txtsotinchi,txtgiaovienid;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenmon = itemView.findViewById(R.id.txttenmon);
            txtlich = itemView.findViewById(R.id.txtlich);
            txtmonhocid=itemView.findViewById(R.id.txtmonhocid);
            txttkb=itemView.findViewById(R.id.txttkb);
            txtsotinchi=itemView.findViewById(R.id.txtsotinchi);
            txtgiaovienid=itemView.findViewById(R.id.txtgiaovienid);
        }
    }
}
