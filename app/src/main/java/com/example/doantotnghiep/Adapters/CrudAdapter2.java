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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Activitys.LvCrudPointsActivity;
import com.example.doantotnghiep.Activitys.UpdateCruidActivity;
import com.example.doantotnghiep.Models.CrudStudentPoints;
import com.example.doantotnghiep.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudAdapter2 extends RecyclerView.Adapter<CrudAdapter2.MyViewHolder> {

    Context context;
    List<CrudStudentPoints> crudStudentPoints;

    public CrudAdapter2(Context context, List<CrudStudentPoints> crudStudentPoints) {
        this.context = context;
        this.crudStudentPoints = crudStudentPoints;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.listcrud_pointst,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txtID.setText(String.valueOf(crudStudentPoints.get(position).getId()));
        holder.txtRecord.setText("Student"+ (position+1));
        if(crudStudentPoints.get(position).getDiem_Gk()==-1){
            holder.txtDIEM.setText("null");
        }else{
            holder.txtDIEM.setText(String.valueOf(crudStudentPoints.get(position).getDiem_Gk()));
        }

        holder.txtSV_ID.setText(crudStudentPoints.get(position).getSinhVienID());
        holder.txtLOP_ID.setText(String.valueOf(crudStudentPoints.get(position).getLopID()));

        holder.imgup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UpdateCruidActivity.class);
                i.putExtra("dataSinhVien",crudStudentPoints.get(position));
                context.startActivity(i);
            }
        });

        holder.imgdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(String.valueOf(crudStudentPoints.get(position).getLopID()),crudStudentPoints.get(position).getId(), position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return crudStudentPoints.size();
    }


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        CrudAdapter2.ViewHolder holder;
//        if(convertView==null){
//            holder = new CrudAdapter2.ViewHolder();
//            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(layout,null);
//
//            holder.txtID=(TextView)convertView.findViewById(R.id.txtid);
//
//            holder.txtRecord=(TextView)convertView.findViewById(R.id.textcord);
//
//            holder.txtDIEM=(TextView)convertView.findViewById(R.id.txtdiem);
//
//            holder.txtSV_ID=(TextView)convertView.findViewById(R.id.txtsv_id);
//
//            holder.txtLOP_ID=(TextView)convertView.findViewById(R.id.txtlop_id);
//
//
//            holder.imgdel=(ImageView)convertView.findViewById(R.id.btndelete);
//            holder.imgup=(ImageView)convertView.findViewById(R.id.btnupdate);
//
//
//            convertView.setTag(holder);
//        }else{
//            holder=(CrudAdapter2.ViewHolder) convertView.getTag();
//        }
//
//        final CrudStudentPoints crudStudentPoints=arrayList.get(position);
//        holder.txtID.setText(String.valueOf(crudStudentPoints.getId()));
//        holder.txtRecord.setText("Student"+ (position+1));
//        if(crudStudentPoints.getDiem_Gk()==-1){
//            holder.txtDIEM.setText("null");
//        }else{
//            holder.txtDIEM.setText(String.valueOf(crudStudentPoints.getDiem_Gk()));
//        }
//
//        holder.txtSV_ID.setText(crudStudentPoints.getSinhVienID());
//        holder.txtLOP_ID.setText(String.valueOf(crudStudentPoints.getLopID()));
//
//        holder.imgup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(context, UpdateCruidActivity.class);
//                i.putExtra("dataSinhVien",crudStudentPoints);
//                context.startActivity(i);
//            }
//        });
//
//        holder.imgdel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Delete(String.valueOf(crudStudentPoints.getLopID()),crudStudentPoints.getId());
//            }
//        });
//
//
//
//        return convertView;
//    }

    private void Delete(final String lop_id, final int id, final int positon){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Do you want to delete the student code "+id+" ?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               deleteStudent(id);
               crudStudentPoints.remove(positon);
               notifyDataSetChanged();

            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // context.deleteStudent(id);


            }
        });
        dialog.show();
    }

    public void deleteStudent(final int id){

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.193/studentpoint/delete.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(context, " Delete successful", Toast.LENGTH_SHORT).show();

                   // getData(url);
                }else{
                    Toast.makeText(context, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "An Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("id", String.valueOf(id));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }






    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView txtID,txtDIEM, txtLOP_ID,txtSV_ID, txtRecord;
        ImageView imgdel, imgup;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtID=itemView.findViewById(R.id.txtid);
            txtDIEM=itemView.findViewById(R.id.txtdiem);
            txtLOP_ID=itemView.findViewById(R.id.txtlop_id);
            txtSV_ID=itemView.findViewById(R.id.txtsv_id);
            txtRecord=itemView.findViewById(R.id.textcord);
            imgup = itemView.findViewById(R.id.btnupdate);
            imgdel = itemView.findViewById(R.id.btndelete);



        }
    }
}
