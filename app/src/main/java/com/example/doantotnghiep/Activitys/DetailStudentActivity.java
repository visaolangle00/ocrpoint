package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.AdapterDetail;
import com.example.doantotnghiep.Models.DetailStudent;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_DETAIL;

public class DetailStudentActivity extends AppCompatActivity {

    SharedPreferences sharedetail;
    RecyclerView recyclerView;
    AdapterDetail adapterDetail;
    ArrayList<DetailStudent> arrayList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_student);
//        init();
//        loadData();

        getSupportActionBar().setTitle("Detail Student");

        recyclerView=findViewById(R.id.recycleview_detail);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList=new ArrayList<>();
        adapterDetail=new AdapterDetail(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapterDetail);
        adapterDetail.notifyDataSetChanged();

        //getDataDetail();
    }


    private void getDataDetail(){


        //String url = "http://192.168.1.193/studentpoint/listct2.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, URL_DETAIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("response",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("monhocs");

                            int totallvsche = jsonArray.length();
                            if (totallvsche > 0) {
                                arrayList.clear();

                                for (int i = 0; i < totallvsche; i++) {
                                    JSONObject scheduoject = jsonArray.getJSONObject(i);
                                    String SVID = scheduoject.getString("sv_id");
                                    String TENSV=scheduoject.getString("tensv");
                                    String LOPQL=scheduoject.getString("lopql");
                                    String LOPID=scheduoject.getString("lop_id");
                                    String DIEMGK=scheduoject.getString("diem_gk");



                                    DetailStudent viewSubject = new DetailStudent(SVID,TENSV,LOPQL,LOPID,DIEMGK);
                                    arrayList.add(viewSubject);
                                }
                                adapterDetail.notifyDataSetChanged();
                            }else{
                                //   Toast.makeText(LvScheduleActivity.this, "No tasks added yet", Toast.LENGTH_SHORT).show();
                            }


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
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                sharedetail =getSharedPreferences("UserInfox", Context.MODE_PRIVATE);

                String sv_id= sharedetail.getString(getResources().getString(R.string.prefLoginState),"");

                String sv_idspace=sv_id.replaceAll("\\s", "");

                Log.d("sv_id",sv_idspace);

                map.put("sv_id",sv_idspace);

                return map;
            }
        };
        queue.add(request);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getDataDetail();
    }

}


