package com.example.doantotnghiep.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;

import java.util.ArrayList;

public class ViewSubjectAdapter extends ArrayAdapter<ViewSubject> {

    Context context;
    ArrayList<ViewSubject> viewSubjectArrayList;

    public ViewSubjectAdapter (@NonNull Context context, ArrayList<ViewSubject> viewSubjectArrayList) {
        super(context, 0, viewSubjectArrayList);
        this.context=context;
        this.viewSubjectArrayList=viewSubjectArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final  ViewSubject sub = viewSubjectArrayList.get(position);
        if(convertView == null){
            LayoutInflater inflater =LayoutInflater.from(context);
            convertView =inflater.inflate(R.layout.row_mon,parent,false);
        }

        TextView tvTaskName =convertView.findViewById(R.id.tvTaskName);

        tvTaskName.setText(sub.getTenmon());


        return convertView;
    }
}
