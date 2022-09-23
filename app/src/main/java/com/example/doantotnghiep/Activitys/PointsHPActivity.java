package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.AdapterPointPt;
import com.example.doantotnghiep.Adapters.AdapterPointPt2;
import com.example.doantotnghiep.Models.StudentPointPt;
import com.example.doantotnghiep.R;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_POINTMATCH;

public class PointsHPActivity extends AppCompatActivity {


    ListView listView;
    RecyclerView recyclerView;
    ArrayList<StudentPointPt> arrayList;
    AdapterPointPt2 adapterPointPt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_hp);
        getSupportActionBar().setTitle("Point Match");

        recyclerView = findViewById(R.id.recycleview_hp);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



       // listView = (ListView) findViewById(R.id.lvPointhp);
        arrayList = new ArrayList<>();
//        adapterPointPt = new AdapterPointPt(this, R.layout.row_point_hp, arrayList);
//        listView.setAdapter(adapterPointPt);

        adapterPointPt2= new AdapterPointPt2(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapterPointPt2);
        adapterPointPt2.notifyDataSetChanged();


        getDataPointpt();
    }

    private void getDataPointpt() {

        String link = "http://192.168.1.193/studentpoint/pointhp.php";

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        StringRequest request = new StringRequest(Request.Method.POST, URL_POINTMATCH,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        arrayList.clear();
                        Log.d("response", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("pointhocphan");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject pointpt = jsonArray.getJSONObject(i);

                                String sv_id = pointpt.getString("sv_id");
                                String tensv = pointpt.getString("tensv");
                                String lopql = pointpt.getString("lopql");
                                String lop_id = pointpt.getString("lop_id");
                                String diem_gk = pointpt.getString("diem_gk");

                                StudentPointPt studentPointPt = new StudentPointPt(sv_id, tensv, lopql, lop_id, diem_gk);
                                arrayList.add(studentPointPt);

                            }
                            adapterPointPt2.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }


        );


        requestQueue.add(request);


    }

}
