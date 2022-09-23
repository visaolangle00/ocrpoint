package com.example.doantotnghiep.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doantotnghiep.Activitys.LvCrudPointsActivity;
import com.example.doantotnghiep.Activitys.UpdateCruidActivity;
import com.example.doantotnghiep.Models.CrudStudentPoints;
import com.example.doantotnghiep.R;

import java.util.List;

public class CrudAdapter extends BaseAdapter {

    private LvCrudPointsActivity context;
    private int layout;
    private List<CrudStudentPoints> arrayList;

    public CrudAdapter(LvCrudPointsActivity context,int layout, List<CrudStudentPoints> arrayList){
        this.context =context;
        this.layout=layout;
        this.arrayList=arrayList;
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
        TextView txtID,txtDIEM, txtLOP_ID,txtSV_ID, txtRecord;
        ImageView imgdel, imgup;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CrudAdapter.ViewHolder holder;
        if(convertView==null){
            holder = new CrudAdapter.ViewHolder();
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);

            holder.txtID=(TextView)convertView.findViewById(R.id.txtid);

            holder.txtRecord=(TextView)convertView.findViewById(R.id.textcord);

            holder.txtDIEM=(TextView)convertView.findViewById(R.id.txtdiem);

            holder.txtSV_ID=(TextView)convertView.findViewById(R.id.txtsv_id);

            holder.txtLOP_ID=(TextView)convertView.findViewById(R.id.txtlop_id);


            holder.imgdel=(ImageView)convertView.findViewById(R.id.btndelete);
            holder.imgup=(ImageView)convertView.findViewById(R.id.btnupdate);


            convertView.setTag(holder);
        }else{
            holder=(CrudAdapter.ViewHolder) convertView.getTag();
        }

        final CrudStudentPoints crudStudentPoints=arrayList.get(position);
        holder.txtID.setText(String.valueOf(crudStudentPoints.getId()));
        holder.txtRecord.setText("Student"+ (position+1));
        if(crudStudentPoints.getDiem_Gk()==-1){
            holder.txtDIEM.setText("null");
        }else{
            holder.txtDIEM.setText(String.valueOf(crudStudentPoints.getDiem_Gk()));
        }

        holder.txtSV_ID.setText(crudStudentPoints.getSinhVienID());
        holder.txtLOP_ID.setText(String.valueOf(crudStudentPoints.getLopID()));

        holder.imgup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UpdateCruidActivity.class);
                i.putExtra("dataSinhVien",crudStudentPoints);
                context.startActivity(i);
            }
        });

        holder.imgdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(String.valueOf(crudStudentPoints.getLopID()),crudStudentPoints.getId());
            }
        });



        return convertView;
    }

    private void Delete(String lop_id, final int id){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Do you want to delete the student code "+id+" ?");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.deleteStudent(id);
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}
