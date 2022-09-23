package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantotnghiep.Models.DetailStudent;
import com.example.doantotnghiep.R;

import java.util.List;

public class AdapterDetail  extends RecyclerView.Adapter<AdapterDetail.MyViewHolder>{
    Context context;
    List<DetailStudent> studentList;

    public AdapterDetail(Context context, List<DetailStudent> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.svid_detail.setText(studentList.get(position).getSv_id());
        holder.tensv_detail.setText(studentList.get(position).getTensv());
        holder.lopql_detail.setText(studentList.get(position).getLopql());
        holder.lopid_detail.setText(studentList.get(position).getLop_id());
        holder.diemgk_detail.setText(studentList.get(position).getDiem_gk());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView svid_detail,tensv_detail,lopql_detail,lopid_detail,diemgk_detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            svid_detail=itemView.findViewById(R.id.svid_detail);
            tensv_detail=itemView.findViewById(R.id.tensv_detail);
            lopql_detail=itemView.findViewById(R.id.lopql_detail);
            lopid_detail=itemView.findViewById(R.id.lopid_detail);
            diemgk_detail=itemView.findViewById(R.id.diemgk_detail);


        }
    }
}
