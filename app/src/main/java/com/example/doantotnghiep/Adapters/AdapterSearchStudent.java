package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doantotnghiep.Activitys.DetailStudentActivity;
import com.example.doantotnghiep.Models.Student_Pt;
import com.example.doantotnghiep.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterSearchStudent extends RecyclerView.Adapter<AdapterSearchStudent.SearchViewHolder> {

    SharedPreferences sharedetail;

   Context context;
   List<Student_Pt> student_ptList;



   public AdapterSearchStudent(Context context, List<Student_Pt> student_ptList){
       this.context=context;
       this.student_ptList=student_ptList;
   }



    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_st,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchViewHolder, final int position) {
       searchViewHolder.tvMaSVgo.setText("ID: "+student_ptList.get(position).getMasv_pt());
       searchViewHolder.tvTenSVgo.setText(student_ptList.get(position).getTensv_pt());
       searchViewHolder.tvSVIDgo.setText(student_ptList.get(position).getSvid_pt());
        searchViewHolder.tvLopQLgo.setText(student_ptList.get(position).getLopql_pt());


        sharedetail =context.getSharedPreferences("UserInfox", Context.MODE_PRIVATE);

        // event
        searchViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Url.SV_ID = student_ptList.get(position).getSvid_pt();

              //  Intent detail = new Intent(context, DetailStudentActivity.class);
             //   detail.putExtra("svid",student_ptList.get(position).getSvid_pt() );
              //  context.startActivity(detail);



                SharedPreferences.Editor editordetail=sharedetail.edit();


                Intent detail=new Intent(context, DetailStudentActivity.class);

                editordetail.putString("",student_ptList.get(position).getSvid_pt());
                editordetail.apply();
                context.startActivity(detail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return student_ptList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

       TextView tvMaSVgo, tvTenSVgo, tvSVIDgo, tvLopQLgo;
       CardView cardView;



        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMaSVgo=itemView.findViewById(R.id.tvmasvgo);
            tvTenSVgo=itemView.findViewById(R.id.tvtensvgo);
            tvSVIDgo=itemView.findViewById(R.id.tvsvidgo);
            tvLopQLgo=itemView.findViewById(R.id.tvlopql);
            cardView = itemView.findViewById(R.id.card_search);
        }
    }

    public void Fitter(ArrayList<Student_Pt> fittersearch){
       this.student_ptList=fittersearch;
       notifyDataSetChanged();
    }
}
