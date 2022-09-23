package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.CrudAdapter;
import com.example.doantotnghiep.Models.CrudStudentPoints;
import com.example.doantotnghiep.R;

import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_UPDATE;

public class UpdateCruidActivity extends AppCompatActivity {

    //String url="http://192.168.1.193/appocrchuan/update.php";

    String url="http://192.168.1.193/studentpoint/update_diem.php";

    TextView diemup;
    TextView masvidup;
    TextView malopup;

    int id=0;

    Button Suaup, Huyup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cruid);
        anhXa();

        getSupportActionBar().setTitle("Update Points");


        Intent intent =getIntent();
        CrudStudentPoints crudStudentPoints= (CrudStudentPoints) intent.getSerializableExtra("dataSinhVien");

        id =crudStudentPoints.getId();

        diemup.setText(String.valueOf(crudStudentPoints.getDiem_Gk()));
        masvidup.setText(crudStudentPoints.getSinhVienID());
        malopup.setText(crudStudentPoints.getLopID());

        final EditText editText =findViewById(R.id.edtDiemup);
        editText.setFilters(new InputFilter[]{new MinMaxFilter("0","10")});

//        Suaup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CapNhap(url);
//            }
//        });

        Suaup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diem010=diemup.getText().toString();

                if(TextUtils.isEmpty(diem010)){
                    Toast.makeText(UpdateCruidActivity.this, "All field requied", Toast.LENGTH_SHORT).show();
                }else{
                    CapNhap(URL_UPDATE);
                }
            }
        });


        Huyup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void CapNhap(String URL_UPDATE) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().contains("success")){
                    Toast.makeText(UpdateCruidActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateCruidActivity.this, LvCrudPointsActivity.class));

                }else {
                    Toast.makeText(UpdateCruidActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateCruidActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
                        Log.d("AAA", "Err!\n" + error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

//                object.getInt("id"),
//                        object.getInt("diem"),
//                        object.getString("tenmon"),
//                        object.getInt("malop"),
//                        object.getInt("masv"),
//                        object.getString("tensv")

                //param.put("id",String.valueOf(id));

                //     param.put("Diem",String.valueOf(diem));
                //param.put("diem_gk",diemup.getText().toString().trim());

                param.put("diem_gk",diemup.getText().toString().trim());
                param.put("sv_id",masvidup.getText().toString().trim());
                param.put("lop_id",malopup.getText().toString().trim());


                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void anhXa(){
        diemup=(EditText)findViewById(R.id.edtDiemup);

        masvidup=(TextView)findViewById(R.id.edtsvidup);

        malopup=(TextView)findViewById(R.id.edtlopidup);

        Suaup=(Button)findViewById(R.id.btnaddup);
        Huyup=(Button)findViewById(R.id.btncancelup);


    }
}
