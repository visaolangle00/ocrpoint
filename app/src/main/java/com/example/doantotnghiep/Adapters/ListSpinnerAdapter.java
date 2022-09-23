package com.example.doantotnghiep.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.doantotnghiep.Activitys.ListSpinnerActivity;
import com.example.doantotnghiep.Models.MonHocIdSpinner;
import com.example.doantotnghiep.Models.Students;
import com.example.doantotnghiep.R;

import java.util.List;

public class ListSpinnerAdapter extends BaseAdapter {
    Activity activity;
    List<MonHocIdSpinner> studentsList;
    LayoutInflater inflater;

    RequestQueue requestQueue;

//    public ListSpinnerAdapter(Activity activity,List<Students> studentsList,RequestQueue requestQueue){
//        this.activity = activity;
//        this.studentsList = studentsList;
//        this.requestQueue = requestQueue;
//    }


    public ListSpinnerAdapter(Activity activity, List<MonHocIdSpinner> studentsList, RequestQueue requestQueue) {
        this.activity = activity;
        this.studentsList = studentsList;
        this.requestQueue = requestQueue;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentsList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        MonHocIdSpinner students =studentsList.get(position);



        TextView textView=(TextView) convertView.findViewById(R.id.spinnertensv);
        TextView textView1=(TextView) convertView.findViewById(R.id.spinnerlop_id);

        TextView textView2=(TextView) convertView.findViewById(R.id.spinnerdiemgk);


        //networkImageView.setImageUrl(restaurant.getImgUrl(),imageLoader);
        //Log.d("getImageUrl",restaurant.getImgUrl().toString());
        textView.setText(students.getSv_id());

        textView1.setText(students.getLop_id());

        textView2.setText(students.getDiem_gk());

        // Log.d("getRest_Name",restaurant.getRest_Name().toString());
        textView.setTextSize(22F);
        //textView.setTypeface(Typeface.createFromAsset(activity.getAssets(),"kfc.ttf"));
        return convertView;
    }
}
